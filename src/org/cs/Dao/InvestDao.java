package org.cs.Dao;

import org.cs.Model.Invest;
import org.springframework.stereotype.Repository;

/**
 * Created by pc on 2016/4/14.
 */
@Repository("investDao")
public class InvestDao extends BaseDao<Invest> implements I_InvestDao {

}
