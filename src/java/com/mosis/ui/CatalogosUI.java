/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoZona;
import com.mosis.helper.CatalogosHelper;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.Behavior;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class CatalogosUI {

    private CatalogosHelper catalogosHelper;
    private CtoZona ctoZona;

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

    public CatalogosUI() {
        catalogosHelper = new CatalogosHelper();
        ctoZona = new CtoZona();
    }

    /**
     * @return the catalogosHelper
     */
    public CatalogosHelper getCatalogosHelper() {
        return catalogosHelper;
    }

    /**
     * @param catalogosHelper the catalogosHelper to set
     */
    public void setCatalogosHelper(CatalogosHelper catalogosHelper) {
        this.catalogosHelper = catalogosHelper;
    }

    public List<CtoZona> getListCtoZonas() {
        return ServiceFacadeLocator.getInstanceZonas().getListZonas();
    }

    public void stateChange(AjaxBehaviorEvent event) {
        Behavior behavior = event.getBehavior();
        if (behavior != null) {
            catalogosHelper = new CatalogosHelper();
        }
    }

}
