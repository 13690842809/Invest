package org.cs.Service;

import org.cs.Dao.I_InvestDao;
import org.cs.Dao.I_InvestTypeDao;
import org.cs.Dao.I_UserDao;
import org.cs.Dao.InvestTypeDao;
import org.cs.Model.Invest;
import org.cs.Model.InvestType;
import org.cs.Model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2016/4/15.
 */
@Service("investService")
public class InvestService implements I_InvestService {

    private I_InvestDao investDao;
    private I_UserDao userDao;
    private I_InvestTypeDao investTypeDao;

    public I_InvestDao getInvestDao() {
        return investDao;
    }
    @Resource
    public void setInvestDao(I_InvestDao investDao) {
        this.investDao = investDao;
    }

    public I_UserDao getUserDao() {
        return userDao;
    }
    @Resource
    public void setUserDao(I_UserDao userDao) {
        this.userDao = userDao;
    }

    public I_InvestTypeDao getInvestTypeDao() {
        return investTypeDao;
    }
    @Resource
    public void setInvestTypeDao(I_InvestTypeDao investTypeDao) {
        this.investTypeDao = investTypeDao;
    }

    @Override
    public void add(Invest invest, String uid , String tid) {
        User user = userDao.load(uid);
        InvestType investType = investTypeDao.load(tid);
        invest.setUid(user);
        invest.setTid(investType);
        investDao.add(invest);
    }

    @Override
    public void update(Invest invest) {
        investDao.update(invest);
    }

    @Override
    public void delete(String id) {
        investDao.delete(id);
    }

    @Override
    public Invest load(String id) {
        return investDao.load(id);
    }

    @Override
    public List<Invest> listAll() {
        String hql = "from Invest";
        return investDao.list(hql);
    }

    @Override
    public List<Invest> listByUser(String uid) {
        return investDao.list("from Invest where Invest.uid = ?",uid);
    }

    @Override
    public List<Invest> listByInvestType(String tid) {
        return investDao.list("from Invest where Invest.tid = ?",tid);
    }
}
