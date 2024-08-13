package com.app.controller.user;

import java.io.IOException; 
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.CustomerDupEmailCheckRequest;
import com.app.dto.user.NutritionStandard;
import com.app.dto.user.User;
import com.app.dto.user.UserValidError;
import com.app.service.user.UserService;
import com.app.util.SessionManager;
import com.app.validator.UserValidator;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/signup")
	public String signup() {
		return "user/signUp";
	}

	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute User user, BindingResult br, Model model) {
		System.out.println(UserValidator.isEmail(user.getEmail()));
		User targetUser = userService.findUserByEmail(user.getEmail());
		
		UserValidError userValidError = new UserValidError();
		boolean isValid = UserValidator.validate(user, userValidError);
		model.addAttribute("userValidError", userValidError);

		if(br.hasErrors()) { //유효성 검증에서 문제가 있다!

			List<ObjectError> errorList = br.getAllErrors();
			for(ObjectError er : errorList) {
				System.out.println(er.getObjectName());
				System.out.println(er.getDefaultMessage());
				System.out.println(er.getCode());
				System.out.println(er.getCodes()[0] );
				System.out.println("BindingResult에서 오류감지");
			}

			return "user/signUp";
		}
		
		if(user.getPw().equals(user.getChkPw()) &&UserValidator.isBirth(user.getBirth())
				&& targetUser == null) {
			int result = userService.saveUser(user);
			
			if(result > 0) {
				return "redirect:/login";
			} else {
				System.out.println("쿼리문 작동 안됨");
				return "user/signUp";
			}
		} else if ( targetUser != null ) {
			userValidError.setEmail("이미 가입된 이메일입니다.");
		}
		return "user/signUp";
	}

	@ResponseBody
	@RequestMapping("/customer/isDuplicatedEmail")
	public ApiResponse<String> isDuplicatedEmail(@Valid @RequestBody CustomerDupEmailCheckRequest customerDupEmailCheckRequest) {

		// JSONObject json-simple

		//System.out.println(id);
		System.out.println(customerDupEmailCheckRequest.getEmail());	//abcd

		//id 중복체크 
		// DB에 해당 id가 있는지 확인
		boolean result = userService.isDuplicatedEmail(customerDupEmailCheckRequest.getEmail());

		ApiResponse<String> response = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		response.setBody(customerDupEmailCheckRequest.getEmail());

		
		if(result) { //중복
			header.setResultCode("99");
			header.setResultMessage("중복된 이메일입니다.");
		} else { //아니다 사용가능하다
			header.setResultCode("200");
			header.setResultMessage("사용가능한 이메일입니다.");
		}

		response.setHeader(header);

		return response;
	}

	@GetMapping("/login")
	public String login() {
		
		return "user/login"; 
	}

	@PostMapping("/login")
	public String loginAction(User user, HttpSession session, Model model) {
		
		User loginUser = userService.isValidCustomerLogin(user);
		System.out.println(loginUser);
		
		if(loginUser == null) {
			System.out.println("null : " + loginUser);
			return "user/login";
		}
		session.setAttribute("user", loginUser);
		SessionManager.setSessionAccount(loginUser.getAccountNo(), loginUser.getMemberNo(), session);
		
		List<NutritionStandard> nc = userService.getNutritionStandardByMemberInfo(session);
		System.out.println(nc);
		
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);

	    user.setAccountNo(accountNo);
	    user.setMemberNo(memberNo);

	    List<User> profiles = userService.findUserListByAccountNo(accountNo);

	    for (User profile : profiles) {
	        int age = userService.getAgeByMemberInfo(profile.getAccountNo(), profile.getMemberNo());
	        String genderName = userService.getGenderNameByGenderId(profile.getGenderId());
	        profile.setAge(age);
	        profile.setGenderName(genderName);
	    }

//	    session.setAttribute("profiles", profiles);
	    model.addAttribute("profiles", profiles);

		return "redirect:/mypage/accountInfo"; 
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.invalidate();
		SessionManager.logout(session);

		return "redirect:/main";
	}

	
}
