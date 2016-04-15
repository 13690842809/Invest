package org.cs.Dao;

import org.cs.Model.InvestType;
import org.springframework.stereotype.Repository;

/**
 * Created by pc on 2016/4/14.
 */
@Repository("investTypeDao")
public class InvestTypeDao extends BaseDao<InvestType> implements I_InvestTypeDao {
}
