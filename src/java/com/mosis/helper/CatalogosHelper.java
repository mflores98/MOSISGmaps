/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.CtoZona;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class CatalogosHelper implements Serializable {

    private int idZ;//lo utilizo para selector de zonas
    private CtoZona ctoZona;
    private CtoServicio ctoServicio;

    public int getIdZ() {
        return idZ;
    }

    public void setId(int id) {
        this.idZ = id;
    }

    public CatalogosHelper() {
        ctoZona = new CtoZona();
        ctoServicio=new CtoServicio();
    }

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

    public void agredarZona() {
        if (getCtoZona() != null) {
            ServiceFacadeLocator.getInstanceZonas().agregarZona(new CtoZona(0, ctoZona.getZona()));
            System.out.println("almacenado");
        } else {
            System.out.println("no lamacenadp");
        }
    }

    public CtoServicio getCtoServicio() {
        return ctoServicio;
    }

    public void setCtoServicio(CtoServicio ctoServicio) {
        this.ctoServicio = ctoServicio;
    }

  
}
