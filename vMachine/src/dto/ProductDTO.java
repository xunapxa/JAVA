package dto;

import common.CommonField;

public class ProductDTO extends CommonField {
	private Long p_num;
	private String p_name;
	private int p_price;
	private int p_stock;
	private int p_sel_count;
	private int p_sel_sum;
	
	// getter setter
	public Long getP_num() {
		return p_num;
	}
	public void setP_num(Long p_num) {
		this.p_num = p_num;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_price() {
		return p_price;
	}
	public void setP_price(int p_price) {
		this.p_price = p_price;
	}
	public int getP_stock() {
		return p_stock;
	}
	public void setP_stock(int p_stock) {
		this.p_stock = p_stock;
	}
	public int getP_sel_count() {
		return p_sel_count;
	}
	public void setP_sel_count(int p_sel_count) {
		this.p_sel_count = p_sel_count;
	}
	public int getP_sel_sum() {
		return p_sel_sum;
	}
	public void setP_sel_sum(int p_sel_sum) {
		this.p_sel_sum = p_sel_sum;
	}
}
