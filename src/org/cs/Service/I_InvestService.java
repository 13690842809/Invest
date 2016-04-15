package org.cs.Service;

import org.cs.Model.Invest;
import org.cs.Model.InvestType;
import org.cs.Model.User;

import java.util.List;

/**
 * Created by pc on 2016/4/14.
 */
public interface I_InvestService {

    public void add(Invest invest , String uid , String tid);

    public void update(Invest invest);

    public void delete(String id);

    public Invest load(String id);

    public List<Invest> listAll();

    public List<Invest> listByUser(String uid);

    public List<Invest> listByInvestType(String tid);


}
