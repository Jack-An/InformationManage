package cn.jackan.dao;

import cn.jackan.domain.User;


import java.util.List;

public interface UserDao {
    User checkUserLoginDao(String uname, String pwd);
    boolean updateUserPwdDao(int uid, String newPwd);
    List<User> queryAllUserDao();
    boolean userRegisterDao(User user);
}
