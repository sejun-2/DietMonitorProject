package com.app.controller.customer;

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
public class CustomerController {

	@Autowired
	UserService userService;

	@GetMapping("/signup")
	public String signup() {
		return "signUp";
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

			return "signUp";
		}
		
		if(user.getPw().equals(user.getChkPw()) &&UserValidator.isBirth(user.getBirth())
				&& targetUser == null) {
			int result = userService.saveUser(user);
			
			if(result > 0) {
				return "redirect:/login";
			} else {
				System.out.println("쿼리문 작동 안됨");
				return "signUp";
			}
		} else if ( targetUser != null ) {
			userValidError.setEmail("이미 가입된 이메일입니다.");
		}
		return "signUp";
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
		
		return "login"; 
	}

	@PostMapping("/login")
	public String loginAction(User user, HttpSession session, Model model) {
		
		User loginUser = userService.isValidCustomerLogin(user);
		System.out.println(loginUser);
		
		if(loginUser == null) {
			System.out.println("null : " + loginUser);
			return "login";
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

		return "redirect:/myInfo"; 
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		//session.invalidate();
		SessionManager.logout(session);

		return "redirect:/main";
	}

	@GetMapping("/myInfo")
	public String myInfo(HttpSession session, Model model) {
		if (SessionManager.isLoginedAccount(session)) {
			// 세션에서 로그인된 사용자의 accountNo와 memberNo를 조회
			int accountNo = SessionManager.getAccountNo(session);
			int memberNo = SessionManager.getMemberNo(session);
			// 사용자 정보를 조회
			User user = userService.findUserByMemberInfo(accountNo, memberNo);
			// 사용자의 나이 계산
			int age = userService.getAgeByMemberInfo(accountNo, memberNo);
			System.out.println(age);
			int genderId = user.getGenderId();
			
			String genderName = userService.getGenderNameByGenderId(genderId);

			// 모델에 사용자 정보와 나이 추가
			model.addAttribute("user", user);
			model.addAttribute("age", age);
			model.addAttribute("genderName", genderName);
			model.addAttribute("accountNo", accountNo);
			model.addAttribute("memberNo", memberNo);

			return "myInfo";
		}

		return "redirect:/login";
	}
	
	@GetMapping("/myInfoModify")
	public String myInfoModify() {
			
		return "myInfoModify";
	}
	
	@PostMapping("/myInfoModify")
	public String myInfoModifyAction(HttpSession session, User user, BindingResult br, Model model) {
		user.setAccountNo((int)session.getAttribute("accountNo"));
		user.setMemberNo((int)session.getAttribute("memberNo"));
		user.setGenderId((int)user.getGenderId());
		
		System.out.println(user);
		System.out.println(user.getGenderId());
		
		
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

			return "myInfoModify";
		}
		
		if(user.getPw().equals(user.getChkPw()) &&UserValidator.isBirth(user.getBirth())) {
			int result = userService.modifyUser(user);
			
			if(result > 0) {
				return "redirect:/myInfo";
			} else {
				System.out.println("쿼리문 작동 안됨");
				return "myInfoModify";
			}
		}
		
		
	    return "redirect:/myInfo";
	}
	
	@GetMapping("/myIntakeFood")
	public String myIntakeFood() {

		return "myIntakeFood";
	}
	
	@PostMapping("/myIntakeFood")
	public String myIntakeFoodAction() {
		
		return "myIntakeFood";
	}
	

	@RequestMapping("/manageProfile")
	public String manageProfile(HttpSession session, Model model)  {
		System.out.println("controller");
		
		/*
		 * int accountNo = SessionManager.getAccountNo(session); int memberNo =
		 * SessionManager.getMemberNo(session);
		 */
		
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		User user = userService.findUserByMemberInfo(accountNo, memberNo);
	    
		System.out.println(user.getNickname());
		
	    user.setAccountNo(accountNo);
	    user.setMemberNo(memberNo);
	    
	    List<User> profiles = userService.findUserListByAccountNo(accountNo);
	    
	    for (User profile : profiles) {
	        int age = userService.getAgeByMemberInfo(profile.getAccountNo(), profile.getMemberNo());
	        String genderName = userService.getGenderNameByGenderId(profile.getGenderId());
	        profile.setAge(age);
	        profile.setGenderName(genderName);
	    }
	    
	    System.out.println("profiles");
	    System.out.println(profiles);
	    
//	    session.setAttribute("profiles", profiles);
	    model.addAttribute("profiles", profiles);
	   
			return "manageProfile";
		}

	
	@PostMapping("/addProfile")
	public String addProfile(User user, Model model, HttpSession session,  HttpServletResponse response) throws IOException {
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		User loginUser = userService.findUserByMemberInfo(accountNo, memberNo);
		User newProfile = new User();
		newProfile.setAccountNo(accountNo);
		newProfile.setNickname(user.getNickname());
		newProfile.setBirth(user.getBirth());
		newProfile.setGenderId(user.getGenderId());
		
		int profileCount = userService.getMemberCountByAccountNo(accountNo);
		
		model.addAttribute("profileCount", profileCount);
		if(profileCount < 5) {
			System.out.println(loginUser);
			int result = userService.addProfile(newProfile);
			System.out.println(result);
			
			if(result > 0) {
				return "redirect:/manageProfile";
			} else {
				PrintWriter out = response.getWriter();
				response.setCharacterEncoding("utf-8");
				response.setContentType("text/html; charset=utf-8");
				out.println("<script> alert('프로필 추가 중 오류가 발생했습니다.');");
				out.println("history.go(-1); </script>"); 
				out.close();
			}
		}else {
			System.out.println("5개 초과");
			PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			out.println("<script> alert('프로필 추가 개수는 5개까지입니다.');");
			out.println("history.go(-1); </script>"); 
			out.close();
		}
		
		return "redirect:/manageProfile";
	}
	
	@PostMapping("/removeProfile")
	public String removeProfile(HttpSession session,HttpServletResponse response) throws IOException {
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
	    int result = userService.removeProfile(accountNo, memberNo);
	    if(result == 0) {
	    	PrintWriter out = response.getWriter();
			response.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=utf-8");
			out.println("<script> alert('해당 계정은 삭제할 수 없는 계정입니다.');");
			out.println("history.go(-1); </script>"); 
			out.close();
	    }
	    return "redirect:/manageProfile";
	}
	
	@PostMapping("/switchProfile")
	public String switchProfile(HttpSession session) {
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
	    
		User switchProfile = userService.findUserByMemberInfo(accountNo, memberNo);
	    
	    session.setAttribute("switchProfile", switchProfile);

	    
	    return "redirect:/main";
	}
	
	@ResponseBody
	@PostMapping("/findMemberList")
	public List<User> findMemberList(User user) {
		
		List<User> userList = userService.findMemberList(user);
		
		System.out.println(userList);
		
		return userList;
	}
	
}
