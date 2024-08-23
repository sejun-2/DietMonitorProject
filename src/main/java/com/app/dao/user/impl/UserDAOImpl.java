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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class UserDAOImpl implements UserDAO {

	//DB User 처리
	@Autowired				
	SqlSessionTemplate sqlSessionTemplate;	
	

	@Override
	public User findUserByEmail(String email) {
		
		try {
			User user = sqlSessionTemplate.selectOne("user_mapper.findUserByEmail", email);	
			log.debug("UserDAOImpl findUserByEmail : {}", user);
			return user;
		} catch (Exception e) {
			log.error("UserDAOImpl findUserByEmail : {}", e.toString());
		}
		
		return null;		
	}

	@Override
	public int modifyUser(User user) {
		
		try {
			int result = sqlSessionTemplate.update("user_mapper.modifyUser", user);	
			log.debug("UserDAOImpl modifyUser : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl modifyUser : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public int saveUser(User user) {
		
		try {
			int result = sqlSessionTemplate.insert("user_mapper.saveUser", user);	
			log.debug("UserDAOImpl saveUser : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl saveUser : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public User findLoginUser(User user) {
		
		try {
			User loginUser = sqlSessionTemplate.selectOne("user_mapper.findLoginUser", user);	
			log.debug("UserDAOImpl findLoginUser : {}", loginUser);
			return loginUser;
		} catch (Exception e) {
			log.error("UserDAOImpl findLoginUser : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public int getMonthsByMemberInfo(int accountNo, int memberNo) {
		
		try {
			Map<String, Object> params = new HashMap<>();
		    params.put("accountNo", accountNo);
		    params.put("memberNo", memberNo);
		    
		    int result = sqlSessionTemplate.selectOne("user_mapper.getMonthsByMemberInfo", params);	
			log.debug("UserDAOImpl getMonthsByMemberInfo : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl getMonthsByMemberInfo : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public String getGenderNameByGenderId(int genderId) {
		
		try {
			String result = sqlSessionTemplate.selectOne("user_mapper.getGenderNameByGenderId", genderId);	
			log.debug("UserDAOImpl getGenderNameByGenderId : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl getGenderNameByGenderId : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public User findUserByMemberInfo(int accountNo, int memberNo) {
		
		try {
			Map<String, Object> params = new HashMap<>();
		    params.put("accountNo", accountNo);
		    params.put("memberNo", memberNo);
		    
		    User user = sqlSessionTemplate.selectOne("user_mapper.findUserByMemberInfo", params);	
			log.debug("UserDAOImpl findUserByMemberInfo : {}", user);
			return user;
		} catch (Exception e) {
			log.error("UserDAOImpl findUserByMemberInfo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public List<NutritionStandard> getNutritionStandardByMemberInfo(Map<String, String> memberInfo) {
		
		try {
			List<NutritionStandard> nutritionStandard = sqlSessionTemplate.selectList("user_mapper.getNutritionStandardByMemberInfo", memberInfo);	
			log.debug("UserDAOImpl getNutritionStandardByMemberInfo : {}", nutritionStandard);
			return nutritionStandard;
		} catch (Exception e) {
			log.error("UserDAOImpl getNutritionStandardByMemberInfo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public int addProfile(User user) {
		
		try {
			int result = sqlSessionTemplate.insert("user_mapper.addProfile", user);	
			log.debug("UserDAOImpl addProfile : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl addProfile : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public List<User> findUserListByAccountNo(int accountNo) {
		
		try {
			List<User> userList = sqlSessionTemplate.selectList("user_mapper.findUserListByAccountNo", accountNo);	
			log.debug("UserDAOImpl findUserListByAccountNo : {}", userList);
			return userList;
		} catch (Exception e) {
			log.error("UserDAOImpl findUserListByAccountNo : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public int removeProfile(int accountNo, int memberNo) {
		
		try {
			Map<String, Object> params = new HashMap<>();
		    params.put("accountNo", accountNo);
		    params.put("memberNo", memberNo);
			int result = sqlSessionTemplate.delete("user_mapper.removeProfile", params);	
			log.debug("UserDAOImpl removeProfile : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl removeProfile : {}", e.toString());
		}
		
		return 0;
	}

	@Override
	public List<User> findMemberList(User user) {
		
		try {
			List<User> userList = sqlSessionTemplate.selectList("user_mapper.findMemberList", user);	
			log.debug("UserDAOImpl findMemberList : {}", userList);
			return userList;
		} catch (Exception e) {
			log.error("UserDAOImpl findMemberList : {}", e.toString());
		}
		
		return null;
	}

	@Override
	public int getMemberCountByAccountNo(int accountNo) {
		
		try {
			int result = sqlSessionTemplate.selectOne("user_mapper.getMemberCountByAccountNo", accountNo);	
			log.debug("UserDAOImpl getMemberCountByAccountNo : {}", result);
			return result;
		} catch (Exception e) {
			log.error("UserDAOImpl getMemberCountByAccountNo : {}", e.toString());
		}
		
		return 0;
	}

	
}
