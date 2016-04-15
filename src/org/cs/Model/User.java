package org.cs.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by pc on 2016/4/13.
 */
@Entity
@Table(name = "tbl_user")
public class User {

    /*
    * 主键
    * 主键为 uuid （自动生成字符串）
    * */
    private String id;
    /*
    * 用户名
    * */
    private String userName;
    /*
    * 用户密码
    * */
    private String password;
    /*
    * 用户权限
    * */
    private String power;
    /*
    * 外键 (uid)--> Invest (投资表)
    * */
    private Set<Invest> invests;

    public User() {
    }

    public User(String id, String userName, String password, String power) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.power = power;
    }

    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(mappedBy = "uid")
    public Set<Invest> getInvests() {
        return invests;
    }

    public void setInvests(Set<Invest> invests) {
        this.invests = invests;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }
}
