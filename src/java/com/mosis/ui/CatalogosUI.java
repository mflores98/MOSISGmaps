/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.CtoZona;
import com.mosis.helper.CatalogosHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class CatalogosUI implements Serializable{

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

    public List<CtoServicio> getListaServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void stateChange(AjaxBehaviorEvent event) {
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            System.out.println("Este es el ID: " + catalogosHelper.getCtoZona().getIdCtoZona());
            System.out.println("esta seleccionado");
            catalogosHelper.setCtoZona(catalogosHelper.getCtoZona());
        } else if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
            System.out.println("en servicio");
            catalogosHelper.setCtoServicio(catalogosHelper.getCtoServicio());
        }
    }

    public void editarZona() throws Exception {

        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            ServiceFacadeLocator.getInstanceZonas().modificarZona(catalogosHelper.getCtoZona().getIdCtoZona(), catalogosHelper.getCtoZona().getZona());
        } else {
            System.out.println("no hay zona selecccioando para editar");
        }
    }

    public void editarServicio() {
        if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
            ServiceFacadeLocator.getInstanceServicio().editarServicio(
                    catalogosHelper.getCtoServicio().getIdCtoServicio(),
                    catalogosHelper.getCtoServicio().getClave(),
                    catalogosHelper.getCtoServicio().getServicio(),
                    catalogosHelper.getIdZonaSelected());
        } else {
            System.out.println("no esta seleccionado el servicio a editr");
        }
    }
}
