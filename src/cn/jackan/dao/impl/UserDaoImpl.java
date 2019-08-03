package cn.jackan.dao.impl;

import cn.jackan.dao.UserDao;
import cn.jackan.domain.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDaoImpl implements UserDao {
    private final String queryUserSql = "select * from t_user where uname=? and pwd=?";
    private final String addUserSql = "insert into t_user values(default,?,?,?,?,?)";
    private final String updatePwdSql = "update t_user set pwd=? where uid=?";
    private final String queryAllUserSql = "select * from t_user";


    @Override
    public User checkUserLoginDao(String uname, String pwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2" + "?serverTimezone=GMT%2B8", "root", "1234");
            pstmt = conn.prepareStatement(queryUserSql);
            pstmt.setString(1, uname);
            pstmt.setString(2, pwd);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("pwd"));
                user.setSex(rs.getInt("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return user;
    }

    @Override
    public boolean updateUserPwdDao(int uid, String newPwd) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int status = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2" + "?serverTimezone=GMT%2B8", "root", "1234");
            pstmt = conn.prepareStatement(updatePwdSql);
            pstmt.setString(1, newPwd);
            pstmt.setInt(2, uid);
            status = pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status == 1;

    }

    @Override
    public ArrayList<User> queryAllUserDao() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2" + "?serverTimezone=GMT%2B8", "root", "1234");
            pstmt = conn.prepareStatement(queryAllUserSql);
            rs = pstmt.executeQuery();
            User user = null;
            while (rs.next()) {
                user = new User();
                user.setUid(rs.getInt("uid"));
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("pwd"));
                user.setSex(rs.getInt("sex"));
                user.setAge(rs.getInt("age"));
                user.setBirth(rs.getDate("birth"));
                users.add(user);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return users;
    }

    @Override
    public boolean userRegisterDao(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int status = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db2" + "?serverTimezone=GMT%2B8", "root", "1234");
            pstmt = conn.prepareStatement(addUserSql);
            pstmt.setString(1, user.getUname());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getSex());
            pstmt.setInt(4, user.getAge());
            pstmt.setDate(5, (Date) user.getBirth());
            status = pstmt.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return status == 1;
    }


}
