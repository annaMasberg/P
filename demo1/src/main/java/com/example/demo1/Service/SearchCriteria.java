package com.example.demo1.Service;

public class SearchCriteria {

	
	private String key;
	private Object value;
	private String operation;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}
	
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public SearchCriteria(String key, Object value, String operation) {
		this.key = key;
		this.value = value;
		this.operation = operation;
	}
	
	
}
