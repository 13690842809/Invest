package org.cs.Action;

import org.cs.Service.I_CalculateService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Created by pc on 2016/4/13.
 */
//@Controller("CalculateAction")
public class CalculateAction {

    private I_CalculateService calculateService;

    public I_CalculateService getCalculateService() {
        return calculateService;
    }
//    @Resource
    public void setCalculateService(I_CalculateService calculateService) {
        this.calculateService = calculateService;
    }
}
