package org.cs.Test;

import org.cs.Dao.I_InvestDao;
import org.cs.Dao.I_InvestTypeDao;
import org.cs.Dao.I_UserDao;
import org.cs.Model.Invest;
import org.cs.Model.InvestType;
import org.cs.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

/**
 * Created by pc on 2016/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestHibernate {

    @Resource(name = "userDao")
    private I_UserDao userDao;
    @Resource(name = "investTypeDao")
    private I_InvestTypeDao investTypeDao;
    @Resource(name = "investDao")
    private I_InvestDao investDao;


    /*
    * 随机数
    * */
    Random ran = new Random();


    @Test
    public void testHibernate(){
        System.out.println("success hibernate !");
    }

    @Test
    public void testAddUser(){
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setUserName(getUserName());
            user.setPassword(getPassword());
            user.setPower("游客");
            userDao.add(user);
        }
    }

    @Test
    public void testAddInvest(){
        for (int i = 0; i < 50; i++) {
            Invest invest = new Invest();
            invest.setType(getTypeInvest());
            invest.setCapital(getCatipal());
            invest.setNow(new Date());
            invest.setYear(2);
            investDao.add(invest);
        }
    }

    @Test
    public void testAddInvestType(){
        for (int i = 0; i < 50; i++) {
            InvestType it = new InvestType();
            it.setInvestName(getInvestName());
            it.setInterestRate(0.5);
            it.setType(getType());
            investTypeDao.add(it);
        }
    }
    @Test
    public void add(){

        /*
        * 添加 50 名 用户
        * 并为每位用户添加 30 条投资信息
        * 并添加 30 条 投资类型信息（方便调试）
        *
        * */
        for (int i = 0;i<50 ; i++){
            User user = new User();
            user.setUserName(getUserName());
            user.setPassword(getPassword());
            user.setPower("游客");
            userDao.add(user);

            for (int j = 0;j < 30;j++){
                Invest invest = new Invest();
                invest.setType(getTypeInvest());
                invest.setCapital(getCatipal());
                invest.setNow(new Date());
                invest.setUid(user);
                invest.setYear(2);

                InvestType it = new InvestType();
                it.setInvestName(getInvestName());
                it.setInterestRate(ran.nextDouble());
                it.setType(getType());

                investTypeDao.add(it);
                invest.setTid(it);
                investDao.add(invest);
            }
        }
    }

    @Test
    public void testRan(){
        for (int i = 0; i < 20; i++) {
            System.out.println(ran.nextDouble());
        }

    }

    /*
    * 测试添加 password
    * */
    private String getPassword(){
        return getUserName();
    }

    /*
    * 测试添加 userName
    * */
    private String getUserName(){
        String[] word = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l",
                "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        String[] math = new String[]{"0","1","2","3","4","5","6","7","8","9"};

        if (ran.nextInt(10)<5){
            String w1 = word[ran.nextInt(word.length)] + word[ran.nextInt(word.length)] + word[ran.nextInt(word.length)];
            String m1 = math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
            return w1 + m1;
        }else {
            return word[ran.nextInt(word.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                    math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                    math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
        }
    }

    /*
    * 测试添加 InvestName
    * */
    private String getInvestName(){
        String[] math = new String[]{"0","1","2","3","4","5","6","7","8","9"};

        return "编号" + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
    }

    /*
    * 测试添加 TypeInvest
    * */
    private String getTypeInvest(){
        String[] word = new String[]{"卖出","买入"};

        return word[ran.nextInt(word.length)];
    }

    /*
    * 测试添加 Type
    * */
    private String getType(){
        String[] word = new String[]{"基金","股票"};

        return word[ran.nextInt(word.length)];
    }

    /*
    * 测试添加 Catipal
    * */
    private String getCatipal(){
        String[] math = new String[]{"0","1","2","3","4","5","6","7","8","9"};
        String catipal =  math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] +
                math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)] + math[ran.nextInt(math.length)];
        return catipal;
    }


}
