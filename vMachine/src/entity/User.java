package entity;

import common.CommonField;

public class User extends CommonField {
	private Long u_num;
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_tel;
	private int u_cash;
	private int u_sum;
	
	// getter setter
	public Long getU_num() {
		return u_num;
	}
	public void setU_num(Long u_num) {
		this.u_num = u_num;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	public String getU_pw() {
		return u_pw;
	}
	public void setU_pw(String u_pw) {
		this.u_pw = u_pw;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getU_tel() {
		return u_tel;
	}
	public void setU_tel(String u_tel) {
		this.u_tel = u_tel;
	}
	public int getU_cash() {
		return u_cash;
	}
	public void setU_cash(int u_cash) {
		this.u_cash = u_cash;
	}
	public int getU_sum() {
		return u_sum;
	}
	public void setU_sum(int u_sum) {
		this.u_sum = u_sum;
	}
	
	
}
