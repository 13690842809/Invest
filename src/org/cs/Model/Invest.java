package org.cs.Model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by pc on 2016/4/13.
 */
@Entity
@Table(name = "tbl_invest")
public class Invest {

    /*
    * 主键
    * 主键为 uuid （自动生成字符串）
    * */
    private String id;
    /*
    * 投资资金
    * */
    private String capital;
    /*
    * 年限
    * */
    private int year;
    /*
    * 投资类型
    * */
    private String type;
    /*
    * 外键 (tid) --> InvestType
    * */
    private InvestType tid;
    /*
    * 外键 (uid) --> User
    * */
    private User uid;
    /*
    * 投资时间
    * */
    private Date now;

    public Invest() {
    }

    public Invest(String id, String capital, int year, InvestType tid, User uid, Date now) {
        this.id = id;
        this.capital = capital;
        this.year = year;
        this.tid = tid;
        this.uid = uid;
        this.now = now;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid")
    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tid")
    public InvestType getTid() {
        return tid;
    }

    public void setTid(InvestType tid) {
        this.tid = tid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
