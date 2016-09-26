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
import com.mosis.helper.RondasHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Miguel
 */
@ManagedBean
@RequestScoped
public class RondasUI implements Serializable{

    private Rondas rondas;
    private RondasHelper rondasHelper;

    public RondasUI() {
        rondasHelper = new RondasHelper();
    }

    /**
     * @return the rondas
     */
    public Rondas getRondas() {
        return rondas;
    }

    /**
     * @param rondas the rondas to set
     */
    public void setRondas(Rondas rondas) {
        this.rondas = rondas;
    }

    /**
     * @return the rondasHelper
     */
    public RondasHelper getRondasHelper() {
        return rondasHelper;
    }

    /**
     * @param rondasHelper the rondasHelper to set
     */
    public void setRondasHelper(RondasHelper rondasHelper) {
        this.rondasHelper = rondasHelper;
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
