package org.cs.Service;


import org.cs.Model.User;

import java.util.List;

/**
 * Created by pc on 2016/4/13.
 */
public interface I_UserService {

    public void add(User user);

    public void update(User user);

    public void delete(String id);

    public User load(String id);

    public List<User> list();

}
