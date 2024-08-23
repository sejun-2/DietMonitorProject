package com.app.service.user.impl;

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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Override
    public int modifyUser(User user) {
        try {
            int result = userDAO.modifyUser(user);
            log.debug("UserServiceImpl modifyUser : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl modifyUser : {}", e.toString());
        }
        return 0;
    }

    @Override
    public int saveUser(User user) {
        try {
            int result = userDAO.saveUser(user);
            log.debug("UserServiceImpl saveUser : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl saveUser : {}", e.toString());
        }
        return 0;
    }

    @Override
    public boolean isDuplicatedEmail(String email) {
        try {
            User user = userDAO.findUserByEmail(email);
            log.debug("UserServiceImpl isDuplicatedEmail : {}", user != null);
            return user != null;
        } catch (Exception e) {
            log.error("UserServiceImpl isDuplicatedEmail : {}", e.toString());
        }
        return false;
    }

    @Override
    public User isValidCustomerLogin(User user) {
        try {
            User loginUser = userDAO.findLoginUser(user);
            log.debug("UserServiceImpl isValidCustomerLogin : {}", loginUser);
            return loginUser;
        } catch (Exception e) {
            log.error("UserServiceImpl isValidCustomerLogin : {}", e.toString());
        }
        return null;
    }

    @Override
    public int getMonthsByMemberInfo(int accountNo, int memberNo) {
        try {
            int result = userDAO.getMonthsByMemberInfo(accountNo, memberNo);
            log.debug("UserServiceImpl getMonthsByMemberInfo : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl getMonthsByMemberInfo : {}", e.toString());
        }
        return 0;
    }

    @Override
    public String getGenderNameByGenderId(int genderId) {
        try {
            String result = userDAO.getGenderNameByGenderId(genderId);
            log.debug("UserServiceImpl getGenderNameByGenderId : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl getGenderNameByGenderId : {}", e.toString());
        }
        return null;
    }

    @Override
    public User findUserByMemberInfo(int accountNo, int memberNo) {
        try {
            User user = userDAO.findUserByMemberInfo(accountNo, memberNo);
            log.debug("UserServiceImpl findUserByMemberInfo : {}", user);
            return user;
        } catch (Exception e) {
            log.error("UserServiceImpl findUserByMemberInfo : {}", e.toString());
        }
        return null;
    }

    @Override
    public List<NutritionStandard> getNutritionStandardByMemberInfo(HttpSession session) {
        try {
            Map<String, String> memberInfo = new HashMap<>();
            memberInfo.put("accountNo", session.getAttribute("accountNo").toString());
            memberInfo.put("memberNo", session.getAttribute("memberNo").toString());

            List<NutritionStandard> nutritionStandard = userDAO.getNutritionStandardByMemberInfo(memberInfo);
            log.debug("UserServiceImpl getNutritionStandardByMemberInfo : {}", nutritionStandard);
            return nutritionStandard;
        } catch (Exception e) {
            log.error("UserServiceImpl getNutritionStandardByMemberInfo : {}", e.toString());
        }
        return null;
    }

    @Override
    public int addProfile(User user) {
        try {
            int result = userDAO.addProfile(user);
            log.debug("UserServiceImpl addProfile : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl addProfile : {}", e.toString());
        }
        return 0;
    }

    @Override
    public List<User> findUserListByAccountNo(int accountNo) {
        try {
            List<User> userList = userDAO.findUserListByAccountNo(accountNo);
            log.debug("UserServiceImpl findUserListByAccountNo : {}", userList);
            return userList;
        } catch (Exception e) {
            log.error("UserServiceImpl findUserListByAccountNo : {}", e.toString());
        }
        return null;
    }

    @Override
    public int removeProfile(int accountNo, int memberNo) {
        try {
            if (memberNo == 1) {
                log.warn("UserServiceImpl removeProfile : 주인 계정임.");
                return 0;
            }
            int result = userDAO.removeProfile(accountNo, memberNo);
            log.debug("UserServiceImpl removeProfile : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl removeProfile : {}", e.toString());
        }
        return 0;
    }

    @Override
    public List<User> findMemberList(User user) {
        try {
            List<User> userList = userDAO.findMemberList(user);
            log.debug("UserServiceImpl findMemberList : {}", userList);
            return userList;
        } catch (Exception e) {
            log.error("UserServiceImpl findMemberList : {}", e.toString());
        }
        return null;
    }

    @Override
    public int getMemberCountByAccountNo(int accountNo) {
        try {
            int result = userDAO.getMemberCountByAccountNo(accountNo);
            log.debug("UserServiceImpl getMemberCountByAccountNo : {}", result);
            return result;
        } catch (Exception e) {
            log.error("UserServiceImpl getMemberCountByAccountNo : {}", e.toString());
        }
        return 0;
    }
}
