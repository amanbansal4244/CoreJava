package com.aman;


public class Multithreding {
	private int id;
	private String firstName;
	private String status;

	public Multithreding() {}

	public Multithreding(int id, String firstName, String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}

