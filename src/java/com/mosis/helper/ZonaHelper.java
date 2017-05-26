/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoZona;
import com.mosis.entity.Etiquetas;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class ZonaHelper implements Serializable {

    private CtoZona ctoZona;

    public ZonaHelper() {
        ctoZona = new CtoZona();
    }

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

    public void agredarZona() {
//        System.out.println("catt");
        if (ctoZona != null) {
//            addMessage("Se registro", "");
            ServiceFacadeLocator.getInstanceZonas().agregarZona(new CtoZona(0, getCtoZona().getZona()));
//            System.out.println("almacenado");
//        } else {
//            System.out.println("faltan campos.no lamacenadp");
        }
    }

    public static void main(String[] args) {
        List<Etiquetas> d = ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
        for (Etiquetas e : d) {
            System.out.println("e: "+e.getNombre());            
        }
    }
}
