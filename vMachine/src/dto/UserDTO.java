package dto;

import java.time.LocalDateTime;

import common.CommonField;
import entity.User;

public class UserDTO extends CommonField {
	private Long u_num;
	private String u_id;
	private String u_pw;
	private String u_name;
	private String u_tel;
	private int u_cash;
	private int u_sum;
	

	
	// 입력받은 자료를 DTO로 변환
	public static UserDTO makeUserDto(Long u_num, String u_id, String u_pw, String u_name, String u_tel
			,int u_cash, int u_sum) {
		return new UserDTO(u_num, u_id, u_pw, u_name, u_tel, u_cash, u_sum);
		
	}

	// DTO를 entity로 변환
	public static User fromEntity(UserDTO dto) {
		User user = new User();
		user.setU_num(dto.getU_num());
		user.setU_id(dto.getU_id());
		user.setU_pw(dto.getU_pw());
		user.setU_name(dto.getU_name());
		user.setU_tel(dto.getU_tel());
		user.setU_cash(0);
		user.setU_sum(0);
		
		if (dto.getInsertedDate() == null) {
			user.setInsertedDate(LocalDateTime.now());
		} else {
			user.setInsertedDate(dto.getInsertedDate());
		}
		if (dto.getUpdatedDate() != null) {
			user.setUpdatedDate(dto.getUpdatedDate());
		} else {
			user.setUpdatedDate(null);
		}
		return user;
	}

	public UserDTO() {}
	
	public UserDTO(Long u_num, String u_id, String u_pw, String u_name, String u_tel, int u_cash, int u_sum) {
		this.u_num = u_num;
		this.u_id = u_id;
		this.u_pw = u_pw;
		this.u_name = u_name;
		this.u_tel = u_tel;
		this.u_cash = u_cash;
		this.u_sum = u_sum;
	}
	
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
