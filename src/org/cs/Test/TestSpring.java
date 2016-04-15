package org.cs.Test;

import org.cs.Action.UserAction;
import org.cs.Dao.I_UserDao;
import org.cs.Dao.UserDao;
import org.cs.Model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by pc on 2016/4/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/beans.xml")
public class TestSpring {

    @Resource
    private I_UserDao userDao;

    @Test
    public void test01(){

        System.out.println("hello");

    }
}
