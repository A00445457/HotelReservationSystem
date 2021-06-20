package com.wli.springassement.entities;

public enum Gender {
	MALE(1),FEMAL(2),NONIDENTIFIED(3);
	
	private int code;
	
	Gender(int code){
		this.code=code;
	}
	
	public int getCode() {
		return code;
	}
}
