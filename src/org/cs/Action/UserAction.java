package org.cs.Action;

import org.cs.Dao.I_UserDao;
import org.cs.Model.User;
import org.cs.Service.I_UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by pc on 2016/4/13.
 */
//@Controller("userAction")
public class UserAction {
    private I_UserService userService;

    public I_UserService getUserService() {
        return userService;
    }
//    @Resource
    public void setUserService(I_UserService userService) {
        this.userService = userService;
    }

    public void add(User user){
        userService.add(user);
    }
}
