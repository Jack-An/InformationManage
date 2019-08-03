package cn.jackan.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    private int uid;
    private String uname;
    private String password;
    private int sex;
    private int age;
    private Date birth;


    public User() {
    }

    public int getUid() {
        return uid;
    }

    public User(int uid, String uname, String password, int sex, int age, Date birth) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.birth = birth;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return uid == user.uid &&
                sex == user.sex &&
                age == user.age &&
                Objects.equals(uname, user.uname) &&
                Objects.equals(password, user.password) &&
                Objects.equals(birth, user.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, password, sex, age, birth);
    }
}
