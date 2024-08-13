package com.app.dto.user;

import lombok.Data;

@Data
public class UserValidError {
	
	String email;
	String pw;
	String chkPw;
	String name;
	String tel;
	String birth;
	int genderCode;
}
