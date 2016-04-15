package org.cs.Model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.persistence.Entity;

/**
 * Created by pc on 2016/4/14.
 */
@Entity
@Table(name = "tbl_invest_type")
public class InvestType {

    /*
    * 主键
    * */
    private String id;
    /*
    * 投资类型
    * */
    private String Type;
    /*
    * 投资名称
    * */
    private String investName;
    /*
    * 投资利率
    * */
    private Double interestRate;

    public InvestType() {
    }

    public InvestType(String id, String type, String investName, Double interestRate) {
        this.id = id;
        Type = type;
        this.investName = investName;
        this.interestRate = interestRate;
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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getInvestName() {
        return investName;
    }

    public void setInvestName(String investName) {
        this.investName = investName;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

}
