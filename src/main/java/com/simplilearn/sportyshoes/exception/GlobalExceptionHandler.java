package com.simplilearn.sportyshoes.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	Logger logger ;
	
	 public GlobalExceptionHandler() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
	
	 @ExceptionHandler(SSException.class) 
	 public ModelAndView handleSSException(SSException exp) {
		 logger.error(exp.getMessage());
		 return new ModelAndView("error-page","err", exp.getMessage());
	 }
	 
	 @ExceptionHandler(Exception.class) 
	 public ModelAndView handleGenericException(Exception exp) {
		 logger.error(exp.getMessage());
		 return new ModelAndView("error-page","err", exp.getMessage());
	 }
	 
	
}
