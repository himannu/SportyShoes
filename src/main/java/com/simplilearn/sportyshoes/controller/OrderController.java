package com.simplilearn.sportyshoes.controller;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.simplilearn.sportyshoes.entity.Address;
import com.simplilearn.sportyshoes.entity.Order;
import com.simplilearn.sportyshoes.entity.OrderProduct;
import com.simplilearn.sportyshoes.entity.Product;
import com.simplilearn.sportyshoes.entity.User;
import com.simplilearn.sportyshoes.exception.SSException;
import com.simplilearn.sportyshoes.service.OrderServiceImpl;
import com.simplilearn.sportyshoes.service.ShoesService;
import com.simplilearn.sportyshoes.service.UserDetailsServiceImpl;

@Controller
public class OrderController {
	
	@Autowired
	private ShoesService<Product> productService;
	
	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	private ShoesService<Order> orderService; 
	
	/*
	 * @PostMapping("/user/addCart/{productId}") public String
	 * addCart(@PathVariable("productId") Integer productId,
	 * 
	 * @RequestParam("quantity") Long quantity, Authentication authentication,
	 * HttpSession session) throws SSException {
	 * 
	 * Order order = getOrder(session);
	 * 
	 * order.setUser(getUser(session, authentication));
	 * 
	 * if (productId == null) { throw new
	 * SSException("Cannot add To Cart: Product could not be found!"); }
	 * 
	 * Product product = productService.getById(productId);
	 * 
	 * OrderProduct orderProduct = new OrderProduct(order, product, quantity);
	 * order.getOrderProducts().add(orderProduct); session.setAttribute("cart",
	 * order); session.setAttribute("cartItems", order.getNumberOfProducts());
	 * return ("redirect:/user/products"); }
	 */
	
	@PostMapping("/user/addCart/{productId}")
	public String addCart(@PathVariable("productId") Integer productId,
			@RequestParam("quantity") Long quantity, 
			Authentication authentication,
			HttpSession session) throws SSException {
		
		if (productId == null) {
			throw new SSException("Cannot add To Cart: Product could not be found!");
		}
		
		Product product = productService.getById(productId);
		
		OrderProduct orderProduct = new OrderProduct(new Order(), product, quantity);	
		
		Map<Integer, OrderProduct> cartMap = getCartMap(session);
		cartMap.put(productId, orderProduct);
		session.setAttribute("cartMap",cartMap); 
		session.setAttribute("cartItems", getNumberOfProducts(cartMap.values()));
		return ("redirect:/user/products");
	}
	
	private Map<Integer, OrderProduct> getCartMap(HttpSession session) {
		Object mapObj =  session.getAttribute("cartMap");
		Map<Integer, OrderProduct> cartMap;
		if (mapObj == null) {
			cartMap = new HashMap<>();
		}
		else {
			cartMap = (Map<Integer, OrderProduct>) mapObj;
		}
		return cartMap;
	}

	private Order getOrder(HttpSession session) {
		Object orderObj =  session.getAttribute("cart");
		Order order;
		if (orderObj == null) {
			order = new Order();
		}
		else {
			order = (Order) orderObj;
		}
		return order;
	}
	
	private User getUser(HttpSession session, Authentication authentication) throws SSException {
		Object userObj = session.getAttribute("user");
		User user = null;
		
		if (userObj == null) {
			String userName = authentication.getName();
			
			if (userName == null) {
				throw new SSException("Cannot Add to Cart: Invalid User!");
			}
			user = ((UserDetailsServiceImpl)userService).getUserByUserName(userName);
			session.setAttribute("user", user);
		}
		else {
			user = (User)userObj;
		}
		return user;
	}
	
	@GetMapping("/user/checkout")
	public ModelAndView showCheckoutPage(HttpSession session) {
		Object cartObj = session.getAttribute("cartMap");
		ModelAndView mv = new ModelAndView("checkout");
		Map<Integer, OrderProduct> cartMap;
		if (cartObj != null) {
			cartMap = (Map) cartObj;		
			mv.addObject("orderProducts", cartMap.values());
			mv.addObject("totalPrice", getTotalOrderPrice(cartMap.values()));
		} else {
			
			mv.addObject("orderProducts", new ArrayList<>());
			mv.addObject("totalPrice", 0.0);
		}
		
		return mv;
	}

	@PostMapping("/user/updateCart/{productId}")
	public String updateCart(@PathVariable("productId") Integer productId,
			@RequestParam("quantity") Long quantity, 
			HttpSession session) throws SSException {
		
		if (productId == null) {
			throw new SSException("Cannot add To Cart: Product could not be found!");
		}
		
		Product product = productService.getById(productId);
		
		Map<Integer, OrderProduct> cartMap = getCartMap(session);
		
		OrderProduct orderProduct = cartMap.get(productId);
		if (orderProduct == null) {
			orderProduct = new OrderProduct(new Order(), product, quantity);	
		} else {
			if (quantity == 0) {
				cartMap.remove(productId);
			} else {
				orderProduct.setQuantity(quantity);
				cartMap.put(productId, orderProduct);
			}
		}
		Long numberOfProducts = getNumberOfProducts(cartMap.values());
		session.setAttribute("cartMap",cartMap); 
		session.setAttribute("cartItems", numberOfProducts);
		String view = "";
		if (numberOfProducts == 0) {
			view = "redirect:/user/products";
		} else {
			view = "redirect:/user/checkout";
		}
		return (view);
	}

	@GetMapping("/user/removeCart/{productId}")
	public String removeFromCart(@PathVariable("productId") Integer productId,
			HttpSession session) throws SSException {
		
		if (productId == null) {
			throw new SSException("Cannot add To Cart: Product could not be found!");
		}
		
		Product product = productService.getById(productId);
		
		Map<Integer, OrderProduct> cartMap = getCartMap(session);
		
		cartMap.remove(productId);
		Long numberOfProducts = getNumberOfProducts(cartMap.values());
		session.setAttribute("cartMap",cartMap); 
		session.setAttribute("cartItems", numberOfProducts);
		
		String view = "";
		if (numberOfProducts == 0) {
			view = "redirect:/user/products";
		} else {
			view = "redirect:/user/checkout";
		}
		return (view);
	}
	
	@PostMapping("/user/saveCart")
	public String saveCart(@ModelAttribute("address") Address address, HttpSession session, Authentication authentication) throws SSException {
		
		Map<Integer, OrderProduct> cartMap = getCartMap(session);
		User user = getUser(session, authentication);
		Order order = new Order();
		order.setOrderDate(LocalDate.now());
		order.setStatus("CREATED");
		user.setAddress(address);
		order.setUser(user);
		Collection<OrderProduct> orderProducts = cartMap.values();
		cartMap.values().forEach(orderProd-> orderProd.getOrderProductId().setOrder(order));
		
		order.setOrderProducts(new ArrayList<OrderProduct>(orderProducts));
		cartMap.values().stream().forEach(System.out::println);
		order.getOrderProducts().stream().forEach(System.out::println);

		orderService.add(order);
		
		session.setAttribute("cartItems", 0);
		session.setAttribute("cartMap", new HashMap<Integer, OrderProduct>());
		//return "redirect:/user/products";
		return "orders/order-success";
		
	}

	@GetMapping("/admin/showPurchaseReport")
	public ModelAndView showPurchaseReport() {
		List<Order> orders = orderService.getAll();
		
		ModelAndView mv = new ModelAndView("orders/list-orders");
		mv.addObject("orderProducts", getOrderProducts(orders));
		return mv;
	}
	
	@PostMapping("/admin/searchOrders")
	public ModelAndView purchaseReportByCriteria(@RequestParam("orderDate") String orderDate, @RequestParam("category") String category) {
		System.out.println("************ Order Date: " + orderDate);
		List<OrderProduct> orderProducts ;
		if (orderDate.isBlank() && category.isBlank()) {
			orderProducts = getOrderProducts(orderService.getAll());
		} else {
			orderProducts = getOrderProducts(((OrderServiceImpl)orderService).getOrdersByCriteria(getOrderDate(orderDate), category));
		}
		return new ModelAndView("orders/list-orders","orderProducts",orderProducts);
	}
	
	private LocalDate getOrderDate(String orderDate) {
		LocalDate date;
		if (orderDate.isBlank()) {
			date = LocalDate.now();
		} else {
			DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			 date = LocalDate.parse(orderDate, ofPattern);
		}
		return  date;
	}
	
	private List<OrderProduct> getOrderProducts(List<Order> orders) {
		List<OrderProduct> orderProducts = new ArrayList<>();
		for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
			Order order = (Order) iterator.next();
			orderProducts.addAll(order.getOrderProducts());
		}
		return orderProducts;
	}
	
	public Long getNumberOfProducts(Collection<OrderProduct> orderProducts) {
		return orderProducts.stream().collect(Collectors.summingLong(orderProduct -> orderProduct.getQuantity())); 
	}
	
	public Double getTotalOrderPrice(Collection<OrderProduct> orderProducts) {
		return orderProducts.stream().collect(Collectors.summingDouble(orderProduct -> orderProduct.getPricePerProduct())); 
	}
}
