package com.app.service.user.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.user.UserDAO;
import com.app.dto.user.NutritionStandard;
import com.app.dto.user.User;
import com.app.service.user.UserService;


// @Component
@Service	// 서비스 Bean 등록
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		List<User> userList = userDAO.findUserList();
		
		return userList;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userDAO.findUserByEmail(email);
		
		return user;
	}

	@Override
	public int modifyUser(User user) {
		int result = userDAO.modifyUser(user);
		
		return result;
	}

	@Override
	public int saveUser(User user) {
		
		int result = userDAO.saveUser(user);
		
		return result;
	}

	@Override
	public boolean isDuplicatedEmail(String email) {
		
		User user = userDAO.findUserByEmail(email);
		
		if(user == null) {	//중복X 사용가능
			return false;
		} else { //존재O 중복O 
			return true;
		}
	}

	@Override
	public User isValidCustomerLogin(User user) {
		
		User loginUser = userDAO.findLoginUser(user);
			
		return loginUser;
	}

	@Override
	public int getAgeByMemberInfo(int accountNo, int memberNo) {
		// TODO Auto-generated method stub
		int result = userDAO.getAgeByMemberInfo(accountNo, memberNo);
			
		return result;
	}

	@Override
	public String getGenderNameByGenderId(int genderId) {
		// TODO Auto-generated method stub
		
		String result = userDAO.getGenderNameByGenderId(genderId);
		return result;
	}

	@Override
	public User findUserByMemberInfo(int accountNo, int memberNo) {
		// TODO Auto-generated method stub
		User user = userDAO.findUserByMemberInfo(accountNo, memberNo);
		
		return user;
	}
	
	@Override
	public List<NutritionStandard> getNutritionStandardByMemberInfo(HttpSession session){
		
	    Map<String, String> memberInfo = new HashMap<>();
	    memberInfo.put("accountNo", session.getAttribute("accountNo").toString());
	    memberInfo.put("memberNo", session.getAttribute("memberNo").toString());

	    List<NutritionStandard> nutritionStandard = userDAO.getNutritionStandardByMemberInfo(memberInfo);

	    return nutritionStandard;
	}

	




}
