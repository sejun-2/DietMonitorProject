package com.app.dao.user.impl;

import java.util.HashMap; 
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.dao.user.UserDAO;
import com.app.dto.user.NutritionStandard;
import com.app.dto.user.User;

@Repository
public class UserDAOImpl implements UserDAO {

	//DB User 처리
	@Autowired				
	SqlSessionTemplate sqlSessionTemplate;	
	
	
	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		List<User> userList = sqlSessionTemplate.selectList("user_mapper.findUserList");		
		return userList;
	}
	
	public List<User> findUserListByUserType(String userType){
		
		List<User> userList = sqlSessionTemplate.selectList("user_mapper.findUserListByUserType", userType);
		
		return userList;
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = sqlSessionTemplate.selectOne("user_mapper.findUserByEmail", email);
		
		return user;
	}

	@Override
	public int modifyUser(User user) {
		int result = sqlSessionTemplate.update("user_mapper.modifyUser", user);
		
		return result;
	}

	@Override
	public int saveUser(User user) {

		int result = sqlSessionTemplate.insert("user_mapper.saveUser", user);
		
		return result;
	}

	@Override
	public User findLoginUser(User user) {
		// TODO Auto-generated method stub
		User loginUser = sqlSessionTemplate.selectOne("user_mapper.findLoginUser", user);
		
		return loginUser;
	}

	@Override
	public int getAgeByMemberInfo(int accountNo, int memberNo) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
	    params.put("accountNo", accountNo);
	    params.put("memberNo", memberNo);
	    
	    int result = sqlSessionTemplate.selectOne("user_mapper.getAgeByMemberInfo", params);
	    
		return result;
	}

	@Override
	public String getGenderNameByGenderId(int genderId) {
		// TODO Auto-generated method stub
		String result = sqlSessionTemplate.selectOne("user_mapper.getGenderNameByGenderId", genderId);
		
		return result;
	}

	@Override
	public User findUserByMemberInfo(int accountNo, int memberNo) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
	    params.put("accountNo", accountNo);
	    params.put("memberNo", memberNo);
	    
	    User user = sqlSessionTemplate.selectOne("user_mapper.findUserByMemberInfo", params);
	    
		return user;
	}

	@Override
	public List<NutritionStandard> getNutritionStandardByMemberInfo(Map<String, String> memberInfo) {
		// TODO Auto-generated method stub
		List<NutritionStandard> nutritionStandard = sqlSessionTemplate.selectList("user_mapper.getNutritionStandardByMemberInfo", memberInfo);
		
		return nutritionStandard;
	}

	@Override
	public int addProfile(User user) {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.insert("user_mapper.addProfile", user);

		return result;
	}

	@Override
	public List<User> findUserListByAccountNo(int accountNo) {
		// TODO Auto-generated method stub
		List<User> userList = sqlSessionTemplate.selectList("user_mapper.findUserListByAccountNo", accountNo);
		
		return userList;
	}

	@Override
	public int removeProfile(int accountNo, int memberNo) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
	    params.put("accountNo", accountNo);
	    params.put("memberNo", memberNo);
		int result = sqlSessionTemplate.delete("user_mapper.removeProfile", params);
		
		return result;
	}

	@Override
	public List<User> findMemberList(User user) {
		// TODO Auto-generated method stub
		
		List<User> userList = sqlSessionTemplate.selectList("user_mapper.findMemberList", user);
		
		return userList;
	}

	@Override
	public int getMemberCountByAccountNo(int accountNo) {
		// TODO Auto-generated method stub
		int result = sqlSessionTemplate.selectOne("user_mapper.getMemberCountByAccountNo", accountNo);
		
		return result;
	}


	
			
	
}
