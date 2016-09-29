/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.BitacoraRonda;
import com.mosis.entity.CtoServicio;
import com.mosis.helper.BitacoraHelper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class BitacoraUI implements Serializable {

    private BitacoraHelper bitacoraHelper;
    private int idServicioSelected;

   

    /**
     * Creates a new instance of BitacoraUI
     */
    public BitacoraUI() {
        bitacoraHelper = new BitacoraHelper();
    }

    public List<BitacoraRonda> lts() {
        System.out.println("ServicioSelecte: "+idServicioSelected);
        return ServiceFacadeLocator.getInstanceBitacora().getListaBitacoraRondasByIdServicio(idServicioSelected);
    }

//    public void v() {
//        System.out.println("Entrando a lista");
//        lista= ServiceFacadeLocator.getInstanceBitacora().listaBitacoraRondas();
//    }

    public List<CtoServicio> getListServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public BitacoraHelper getBitacoraHelper() {
        return bitacoraHelper;
    }

    public void setBitacoraHelper(BitacoraHelper bitacoraHelper) {
        this.bitacoraHelper = bitacoraHelper;
    }

    public int getIdServicioSelected() {
        return idServicioSelected;
    }

    public void setIdServicioSelected(int idServicioSelected) {
        this.idServicioSelected = idServicioSelected;
    }

}
