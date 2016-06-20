package com.cool.stay.server.dto;

public class User {
	private String id;
	private String name;
	private String password;
	private String roleName;

	public User(String id, String name, String password, String roleName) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.roleName = roleName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
