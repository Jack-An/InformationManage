package cn.jackan.service.impl;

import cn.jackan.dao.UserDao;
import cn.jackan.dao.impl.UserDaoImpl;
import cn.jackan.domain.User;
import cn.jackan.service.UserService;
import org.apache.log4j.Logger;


import java.util.List;


public class UserServiceImpl implements UserService {
    private UserDao ud = new UserDaoImpl();
    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    /**
     * 使用用户名+ 密码校验登录请求
     *
     * @param uname
     * @param pwd
     * @return
     */
    @Override
    public User checkUserLoginService(String uname, String pwd) {
        logger.debug(uname + "发起登录请求");
        User user = ud.checkUserLoginDao(uname, pwd);
        // 判断
        if (user != null) {
            logger.debug(uname + "登陆成功");
        } else {
            logger.debug(uname + "登陆失败");
        }
        return user;
    }


    /**
     * 修改用户密码
     *
     * @param uid
     * @param newPwd
     * @return
     */
    @Override
    public boolean updateUserPwdService(int uid, String newPwd) {
        logger.debug(uid + "发起修改密码请求");
        boolean status = ud.updateUserPwdDao(uid, newPwd);
        if (status) {
            logger.debug(uid + "  修改密码成功");
        } else {
            logger.debug(uid + "  修改密码失败");
        }
        return status;
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    @Override
    public List<User> queryAllUserService() {
        List<User> users = ud.queryAllUserDao();
        if (!users.isEmpty()) {
            logger.debug("查询所有用户信息成功");
        } else {
            logger.debug("查询所有用户信息失败");
        }
        return users;
    }

    @Override
    public boolean userRegisterService(User user) {
        boolean status = ud.userRegisterDao(user);
        if (status) {
            logger.debug(user + " 注册成功");
        } else {
            logger.debug(user + " 注册失败");
        }
        return status;
    }


}
