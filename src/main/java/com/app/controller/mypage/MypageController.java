package com.app.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.dto.diet.Diet;
import com.app.dto.mypage.TotalDietSearchCondition;
import com.app.dto.user.User;
import com.app.dto.user.UserValidError;
import com.app.service.mypage.MypageService;
import com.app.service.user.UserService;
import com.app.util.SessionManager;
import com.app.validator.UserValidator;

@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/mypage/nutritionStandard")
	public String nutritionStandard(Model model) {
		
		TotalDietSearchCondition t1 = new TotalDietSearchCondition();
		
		t1.setAccountNo(22);
		t1.setMemberNo(1);
		t1.setStartDate("20240805");
		t1.setEndDate("20240813");

		System.out.println(t1);
		List<Diet> totalDietList = mypageService.findTotalDietByAvg(t1);
		List<Diet> totalDietListMonthSum = mypageService.findTotalDietByMonthSum(t1);
		
		System.out.println(totalDietList);
		model.addAttribute("totalDietList", totalDietList);
		model.addAttribute("totalDietListMonthSum", totalDietListMonthSum);
		
		return"/mypage/myInfo";
	}
	
	@GetMapping("/mypage/dietProgress")
	public String dietProgress() {
		return "/mypage/dietProgress";
	}
	
	@GetMapping("/mypage/dietHistory")
	public String dietHistory(Model model) {
		
		TotalDietSearchCondition t1 = new TotalDietSearchCondition();
		
		t1.setAccountNo(1);
		t1.setMemberNo(2);
		t1.setStartDate("20240805");
		t1.setEndDate("20240809");
		
		System.out.println(t1);
		List<Diet> totalDietList = mypageService.findTotalDietBySaveHistory(t1);
		List<Diet> totalDietListAvg = mypageService.findTotalDietBySaveHistoryAvg(t1);
		
		System.out.println(totalDietList);
		model.addAttribute("totalDietList", totalDietList);
		model.addAttribute("totalDietListAvg", totalDietListAvg);
		
		//return "/mypage/mySaveHistory";
		return "/mypage/test";
	}
	
	@GetMapping("/test")
	public String test() {
		return "mypage/test";
	}
	
	@GetMapping("/mypage/accountInfo")
	public String accountInfo(HttpSession session, Model model) {
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

			return "mypage/accountInfo";
		}

		return "redirect:/member/login";
	}
	
	@GetMapping("/mypage/modifyAccount")
	public String modifyAccount() {
		
		return "mypage/modifyAccount";
	}
	
	@PostMapping("/modifyAccount")
	public String modifyAccountAction(HttpSession session, User user, BindingResult br, Model model) {
		user.setAccountNo((int)session.getAttribute("accountNo"));
		user.setMemberNo((int)session.getAttribute("memberNo"));
		user.setGenderId((int)user.getGenderId());
		
		System.out.println(user);
		System.out.println(user.getGenderId());
		
		
		UserValidError userValidError = new UserValidError();
		boolean isValid = UserValidator.validate(user, userValidError);
		model.addAttribute("userValidError", userValidError);
		
		if(user.getPw().equals(user.getChkPw()) &&UserValidator.isBirth(user.getBirth())) {
			int result = userService.modifyUser(user);
			
			if(result > 0) {
				return "redirect:/mypage/accountInfo";
			} else {
				System.out.println("쿼리문 작동 안됨");
				return "mypage/modifyAccount";
			}
		}
		
		
	    return "redirect:/mypage/accountInfo";
	}

	@RequestMapping("/mypage/manageProfile")
	public String manageProfileAction(HttpSession session, Model model)  {
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
	   
			return "mypage/manageProfile";
		}

	
	@PostMapping("/addProfile")
	public String addProfile(User user, RedirectAttributes redirectAttributes, HttpSession session, HttpServletResponse response) throws IOException {
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
		
		User loginUser = userService.findUserByMemberInfo(accountNo, memberNo);
		User newProfile = new User();
		newProfile.setAccountNo(accountNo);
		newProfile.setNickname(user.getNickname());
		newProfile.setBirth(user.getBirth());
		newProfile.setGenderId(user.getGenderId());
		
		int profileCount = userService.getMemberCountByAccountNo(accountNo);
		
		if(profileCount < 5) {
			System.out.println(loginUser);
			int result = userService.addProfile(newProfile);
			System.out.println(result);
			
			if(result > 0) {
				return "redirect:/mypage/manageProfile";
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
		
		return "redirect:/mypage/manageProfile";
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
	    return "redirect:/mypage/manageProfile";
	}
	
	@PostMapping("/switchProfile")
	public String switchProfile(HttpSession session) {
		int accountNo = SessionManager.getAccountNo(session);
		int memberNo = SessionManager.getMemberNo(session);
	    
		User switchProfile = userService.findUserByMemberInfo(accountNo, memberNo);
	    
	    session.setAttribute("switchProfile", switchProfile);

	    
	    return "redirect:/main";
	}
	
	
	
}
