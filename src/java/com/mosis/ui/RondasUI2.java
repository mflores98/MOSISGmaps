/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Horarios;
import com.mosis.entity.Rondas;
import com.mosis.helper.RondasHelper2;
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
public class RondasUI2 {
    
    private RondasHelper2 rondasHelper2;
    
    public RondasUI2() {
        rondasHelper2 = new RondasHelper2();
    }
    
    public RondasHelper2 getRondasHelper2() {
        return rondasHelper2;
    }
    
    public void setRondasHelper2(RondasHelper2 rondasHelper2) {
        this.rondasHelper2 = rondasHelper2;
    }
   
    public void stateChange(AjaxBehaviorEvent event) {
        if (rondasHelper2.getRondas().getIdRonda() != null) {
            System.err.println("ronda con id: "+rondasHelper2.getRondas().getIdRonda());
           rondasHelper2.setRondas(rondasHelper2.getRondas());
        }
//        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
//            System.out.println("Este es el ID: " + catalogosHelper.getCtoZona().getIdCtoZona());
//            System.out.println("esta seleccionado");
//            catalogosHelper.setCtoZona(catalogosHelper.getCtoZona());
//        } else if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
//            System.out.println("en servicio");
//            catalogosHelper.setCtoServicio(catalogosHelper.getCtoServicio());
//        }
    }
    
    public List<CtoServicio> getListCtoServicio() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }
    
    public List<Horarios> getListCtoHorarios() {
        return ServiceFacadeLocator.getInstanceHorariosFacade().getListHorarios();
    }
    
    public List<Rondas> getListRondas() {
        return ServiceFacadeLocator.getInstanceRonda().getListRondas();
    }
    
}
