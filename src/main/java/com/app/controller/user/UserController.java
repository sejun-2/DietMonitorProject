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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.app.dto.api.ApiResponse;
import com.app.dto.api.ApiResponseHeader;
import com.app.dto.user.CustomerDupEmailCheckRequest;
import com.app.dto.user.User;
import com.app.dto.user.UserValidError;
import com.app.service.diet.DietService;
import com.app.service.user.UserService;
import com.app.util.SessionManager;
import com.app.validator.UserValidator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	DietService dietService;

	@GetMapping("/signup")
	public String signup() {
		log.info("회원가입 페이지로 이동합니다.");
		
		return "user/signUp";
	}

	 @PostMapping("/signup")
	    public String signupAction(@Valid @ModelAttribute User user, BindingResult br, HttpServletResponse response, Model model) throws IOException {

	        UserValidError userValidError = new UserValidError();

	        boolean isValid = UserValidator.validate(user, userValidError);

	        log.info("회원가입 요청이 들어왔습니다. 유효성 검사 결과: {}", isValid);
	        
	        model.addAttribute("userValidError", userValidError);
	        
	        if (isValid) {
	            int result = userService.saveUser(user);
	            log.info("유효성 검사를 통과하여 사용자 정보를 저장 시도 중입니다.");

	            if (result > 0) {
	            	log.info("회원가입 성공. 사용자 ID: {}", user.getAccountNo());
	                PrintWriter out = response.getWriter();
	                response.setCharacterEncoding("utf-8");
	                response.setContentType("text/html; charset=utf-8");
	                out.println("<script> alert('회원가입 완료되었습니다.'); </script>");
	                //out.println("location.href='login';</script>");
	                out.close();
	                return "redirect:/login";
	            } else {
	            	log.error("회원가입 실패: 사용자 저장 중 문제가 발생했습니다.");
	                return "user/signUp";
	            }
	        } else {
	        	log.warn("회원가입 유효성 검사를 통과하지 못했습니다. 오류: {}", userValidError);
	            return "user/signUp";
	        }
	    }
	

	@ResponseBody
	@RequestMapping("/user/isDuplicatedEmail")
	public ApiResponse<String> isDuplicatedEmail(@RequestBody CustomerDupEmailCheckRequest customerDupEmailCheckRequest) {
		log.info("이메일 중복 확인 요청. 이메일: {}", customerDupEmailCheckRequest.getEmail());
		boolean validResult = UserValidator.isEmail(customerDupEmailCheckRequest.getEmail());
		
		boolean dupResult = userService.isDuplicatedEmail(customerDupEmailCheckRequest.getEmail());
		
		ApiResponse<String> response = new ApiResponse<String>();
		ApiResponseHeader header = new ApiResponseHeader();
		response.setBody(customerDupEmailCheckRequest.getEmail());

		if(!validResult) {
			log.warn("잘못된 이메일 형식: {}", customerDupEmailCheckRequest.getEmail());
			header.setResultCode("10");
			header.setResultMessage("올바르지 않은 이메일 형식입니다.");
			response.setHeader(header);
			return response;
		}
		
		if(dupResult) {
			log.info("중복된 이메일입니다: {}", customerDupEmailCheckRequest.getEmail());
			header.setResultCode("99");
			header.setResultMessage("중복된 이메일입니다.");
		} else {
			log.info("사용 가능한 이메일입니다: {}", customerDupEmailCheckRequest.getEmail());
			header.setResultCode("200");
			header.setResultMessage("사용가능한 이메일입니다.");
		}

		response.setHeader(header);
		return response;
	}

	@GetMapping("/login")
	public String login() {
		log.info("로그인 페이지로 이동합니다.");
		return "user/login"; 
	}

	@PostMapping("/login")
	public String loginAction(User user, HttpSession session, Model model) {
		log.info("로그인 요청. 유저 ID: {}", user.getEmail());
		User loginUser = userService.isValidCustomerLogin(user);
		log.debug("로그인 유저 정보: {}", loginUser);
		
		if(loginUser == null) {
			log.warn("로그인 실패: 아이디 또는 패스워드 불일치.");
			model.addAttribute("logErrorMsg", "아이디 또는 패스워드가 일치하지 않습니다");
			return "user/login";
		}		
		
		log.info("로그인 성공. 세션 설정 중. 유저 ID: {}", loginUser.getAccountNo());
		SessionManager.setSessionAccount(loginUser.getAccountNo(), loginUser.getMemberNo(), session);
		
		int result = dietService.deleteAllExpectedDiet(loginUser);
		log.info("삭제된 예상 식단 데이터 개수: {}", result);
		
	    List<User> profiles = userService.findUserListByAccountNo(loginUser.getAccountNo());
	    log.debug("연결된 유저 프로필 개수: {}", profiles.size());

	    for (User profile : profiles) {
	        int age = userService.getMonthsByMemberInfo(profile.getAccountNo(), profile.getMemberNo());
	        String genderName = userService.getGenderNameByGenderId(profile.getGenderId());
	        profile.setAge(age);
	        profile.setGenderName(genderName);
	        log.debug("프로필 정보 업데이트 - 나이: {}, 성별: {}", age, genderName);
	    }
	    	    
	    session.setAttribute("profiles", profiles);
	    log.info("로그인 후 마이페이지로 리다이렉트됩니다.");

		return "redirect:/mypage/accountInfo"; 
	}	

	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		log.info("로그아웃 요청. 세션 종료 중.");
		SessionManager.logout(session);
		log.info("로그아웃 완료. 메인 페이지로 이동합니다.");
		return "redirect:/main";
	}

	
}
