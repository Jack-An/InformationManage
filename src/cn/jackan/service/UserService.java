package cn.jackan.service;

import cn.jackan.domain.User;

import java.util.List;

public interface UserService {
    User checkUserLoginService(String uname, String pwd);

    boolean  updateUserPwdService(int uid, String newPwd);

    List<User> queryAllUserService();

    boolean userRegisterService(User user);
}
