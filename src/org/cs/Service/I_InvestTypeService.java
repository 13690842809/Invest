package org.cs.Service;

import org.cs.Model.InvestType;

import java.util.List;

/**
 * Created by pc on 2016/4/14.
 */
public interface I_InvestTypeService {

    public void add(InvestType investType);

    public void update(InvestType investType);

    public void delete(String id);

    public InvestType load(String id);

    public List<InvestType> list();
}
