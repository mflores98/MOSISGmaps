/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoZona;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class CatalogosHelper implements Serializable {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private CtoZona ctoZona;

    public CatalogosHelper() {
        ctoZona = new CtoZona();
    }

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

    public void agredarZona() {
        ServiceFacadeLocator.getInstanceZonas().agregarZona(new CtoZona(0, ctoZona.getZona()));
    }

    public void modificarZona(int id) throws Exception {
        ServiceFacadeLocator.getInstanceZonas().modificarZona(id, ctoZona.getZona());
    }

}
