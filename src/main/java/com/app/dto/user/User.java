package com.app.dto.user;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class User {
	
	int accountNo;
	int memberNo;
	String email;
	String gender;

	@NotBlank
	@Size(min = 8, max = 16)
	String pw;
	String chkPw;
	
	@NotBlank //defaultMessage
	@Size(min = 2, max  = 4)
	String name;
	
	@NotBlank
	@Size(min = 11, max = 11, message = "-를 제외한 전화번호 11자리를 입력해주세요")
	String tel;
	
	@NotBlank
	@Size(min = 6, max = 6, message = "생년월일 6자리를 입력해주세요")
	String birth;

	
}

