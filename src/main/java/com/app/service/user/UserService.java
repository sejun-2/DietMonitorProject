package com.app.service.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.app.dto.user.NutritionStandard;
import com.app.dto.user.Profile;
import com.app.dto.user.User;

public interface UserService {

	public List<User> findUserList();
	
	public User findUserByEmail(String email);
	
	public int modifyUser(int accountNo, int memberNo);
	
	public int saveUser(User user);
	
	public boolean isDuplicatedEmail(String email);
	
	public User isValidCustomerLogin(User user);

	public int getAgeByMemberInfo(int accountNo, int memberNo);

	public String getGenderNameByGenderId(int genderId);

	public User findUserByMemberInfo(int accountNo, int memberNo);
	
	public List<NutritionStandard> getNutritionStandardByMemberInfo(HttpSession session);

	public int addProfile(User user);

	public int getMemberCount(User user);

	public List<User> findUserListByAccountNo(int accountNo);

	public int removeProfile(int accountNo, int memberNo);





	
	//public User findLoginUser(User user);
	
}
