package org.cs.Service;

import org.cs.Dao.I_InvestTypeDao;
import org.cs.Model.InvestType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by pc on 2016/4/15.
 */
@Service("investTypeService")
public class InvestTypeService implements I_InvestTypeService {

    private I_InvestTypeDao investTypeDao;

    public I_InvestTypeDao getInvestTypeDao() {
        return investTypeDao;
    }
    @Resource
    public void setInvestTypeDao(I_InvestTypeDao investTypeDao) {
        this.investTypeDao = investTypeDao;
    }

    @Override
    public void add(InvestType investType) {
        investTypeDao.add(investType);
    }

    @Override
    public void update(InvestType investType) {
        investTypeDao.update(investType);
    }

    @Override
    public void delete(String id) {
        investTypeDao.delete(id);
    }

    @Override
    public InvestType load(String id) {
        return investTypeDao.load(id);
    }

    @Override
    public List<InvestType> list() {
        return investTypeDao.list("from InvestType");
    }
}
