package org.cs.Action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.cs.Dao.I_UserDao;
import org.cs.Model.User;
import org.cs.Service.I_UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by pc on 2016/4/13.
 */
@Controller("userAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

    private User user;
    private I_UserService userService;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public I_UserService getUserService() {
        return userService;
    }
    @Resource
    public void setUserService(I_UserService userService) {
        this.userService = userService;
    }

    @Override
    public User getModel() {
        if (user == null) user = new User();
        return user;
    }

    public String list(){
        ActionContext.getContext().put("userList",userService.list());
        return "success";
    }
}
