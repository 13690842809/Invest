package org.cs.Service;

import org.cs.Dao.I_UserDao;
import org.cs.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2016/4/14.
 */
@Service("userService")
public class UserService implements I_UserService {

    private I_UserDao userDao;

    public I_UserDao getUserDao() {
        return userDao;
    }
    @Resource
    public void setUserDao(I_UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public User load(String id) {
        return userDao.load(id);
    }

    @Override
    public List<User> list() {
        String hql = "from User";
        return userDao.list(hql);
    }
}
