package net.javaguides.login.bean;

import java.io.Serializable;

public class LoginBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Emp_ID;
	private String Password;

	public String getEmp_ID() {
		return Emp_ID;
	}

	public void setUsername(String Emp_ID) {
		this.Emp_ID = Emp_ID;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}
}