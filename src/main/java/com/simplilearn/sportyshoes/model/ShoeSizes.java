package com.simplilearn.sportyshoes.model;

public enum ShoeSizes {
	SIX(6),
	SEVEN(7),
	EIGHT(8),
	NINE(9),
	TEN(10),
	ELEVEN(11);

	private Integer shoeSize;
	
	ShoeSizes(Integer shoeSize) {
		this.shoeSize = shoeSize;
	}

	public Integer getShoeSize() {
		return shoeSize;
	}

	public void setShoeSize(Integer shoeSize) {
		this.shoeSize = shoeSize;
	}
	
	
}
