package cn.jackan.servlet;

import cn.jackan.domain.User;
import cn.jackan.service.UserService;
import cn.jackan.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private UserService us = new UserServiceImpl();


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String oper = req.getParameter("oper");
        if ("login".equals(oper)) {
            //调用登陆处理方法
            checkUserLogin(req, resp);
        } else if ("reg".equals(oper)) {
            // 调用注册功能
            userRegister(req, resp);
        } else if ("out".equals(oper)) {
            //退出
            userOut(req, resp);
        } else if ("modifyPwd".equals(oper)) {
            modifyPwd(req, resp);
        } else if ("query".equals(oper)) {
            queryUser(req, resp);
        } else {
            System.out.println("没有找到相应的操作符:" + oper);
        }

    }

    private void userRegister(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        int sex = Integer.parseInt(req.getParameter("sex"));
        int age = req.getParameter("age").equals("") ? 0 : Integer.parseInt(req.getParameter("age"));
        String birth = req.getParameter("birth");
        DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;
        try {
            date = fmt.parse(birth);
        } catch (ParseException ignored) {}
        User u = new User(0, uname, pwd, sex, age, date);
        boolean status = us.userRegisterService(u);
        if(status){
            //注册成功
            req.getSession().setAttribute("msg2", "");
            resp.sendRedirect("/login.jsp");
        }


    }

    private void queryUser(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> users = us.queryAllUserService();
        req.getSession().setAttribute("users", users);
        resp.sendRedirect("/user/allUser.jsp");
    }


    private void modifyPwd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // to do
        User user = (User) req.getSession().getAttribute("user");
        String newPwd = req.getParameter("newPwd");
        boolean status = us.updateUserPwdService(user.getUid(), newPwd);
        if (status) {
            req.getSession().setAttribute("msg", "modifyPwd");
            resp.sendRedirect("/login.jsp");
        }

    }

    private void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect("/login.jsp");
    }


    private void checkUserLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uname = req.getParameter("uname");
        String pwd = req.getParameter("pwd");
        //处理请求信息
        //获取Service层对象
        User u = us.checkUserLoginService(uname, pwd);
        if (u != null) {
            HttpSession session = req.getSession();
            session.setAttribute("user", u);
            //最前面的/表示服务器根目录（一般要使用绝对路径，不然urlPattern是个路径的时候会出错）
            // 没有/的时候表示相对路径
            resp.sendRedirect("/main/main.jsp");
        } else {
            req.setAttribute("flag", 0);
            //请求转发
            //在请求转发的时候/表示项目根目录
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }


    }
}
