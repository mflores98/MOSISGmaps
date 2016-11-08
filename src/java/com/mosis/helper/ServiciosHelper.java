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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class ServiciosHelper implements Serializable {

    private CtoServicio ctoServicio;
//    private int idZonaSelected;

    public ServiciosHelper() {
        ctoServicio = new CtoServicio();
        ctoServicio.setIdCtoZona(new CtoZona());
    }

    public void agregarServicio() {
        try {
            System.out.println("id zona: " + ctoServicio.getIdCtoZona().getIdCtoZona());
            System.out.println("clave: " + ctoServicio.getClave());
            System.out.println("nombre servicio: " + ctoServicio.getServicio());

            if (!ctoServicio.getServicio().isEmpty() && !ctoServicio.getClave().isEmpty()) {
                try {
//                    ServiceFacadeLocator.getInstanceServicio().registrarServicio(ctoServicio, idZonaSelected);
                    ServiceFacadeLocator.getInstanceServicio().registrarServicio(ctoServicio, ctoServicio.getIdCtoZona().getIdCtoZona());
                } catch (Exception ex) {
                    System.err.println("error: " + ex.getLocalizedMessage());
                    Logger.getLogger(CatalogosHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                System.out.println("campos incompletos");
            }
        } catch (Exception e) {
            System.out.println("Erroror");
        }
        ctoServicio = new CtoServicio();
        ctoServicio.setIdCtoZona(new CtoZona());
    }

    public void editarServicio() {
        ServiceFacadeLocator.getInstanceServicio().editarServicio(ctoServicio.getIdCtoServicio(), ctoServicio.getClave(), ctoServicio.getServicio(), ctoServicio.getIdCtoZona().getIdCtoZona());

        ctoServicio = new CtoServicio();
        ctoServicio.setIdCtoZona(new CtoZona());
    }

    public void eliminar() throws Exception {
        ServiceFacadeLocator.getInstanceServicio().eliminar(ctoServicio.getIdCtoServicio());
        ctoServicio = new CtoServicio();
        ctoServicio.setIdCtoZona(new CtoZona());
    }

    public void cancelar() {
        ctoServicio = new CtoServicio();
        ctoServicio.setIdCtoZona(new CtoZona());
    }

    public CtoServicio getCtoServicio() {
        return ctoServicio;
    }

    public void setCtoServicio(CtoServicio ctoServicio) {
        this.ctoServicio = ctoServicio;
    }

}
