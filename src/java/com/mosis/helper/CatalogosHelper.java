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
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
public class CatalogosHelper implements Serializable {

    private CtoZona ctoZona;
    private CtoServicio ctoServicio;
    private int idZonaSelected;

    public CatalogosHelper() {
        ctoZona = new CtoZona();
        ctoServicio = new CtoServicio();
    }

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

    public void agredarZona() {
//        System.out.println("catt");
//        if (getCtoZona() != null) {
//            addMessage("Se registro", "");
        ServiceFacadeLocator.getInstanceZonas().agregarZona(new CtoZona(0, ctoZona.getZona()));
//            System.out.println("almacenado");
//        } else {
//            System.out.println("faltan campos.no lamacenadp");
//        }
    }

//    public void addMessage(String summary, String detail) {
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
//        FacesContext.getCurrentInstance().addMessage(null, message);
//    }
    public void agregarServicio() {
        try {
            System.out.println("id zona: " + idZonaSelected);
            System.out.println("clave: " + ctoServicio.getClave());
            System.out.println("nombre servicio: " + ctoServicio.getServicio());

            if (!ctoServicio.getServicio().isEmpty() && !ctoServicio.getClave().isEmpty()) {
                try {
                    ServiceFacadeLocator.getInstanceServicio().registrarServicio(ctoServicio, idZonaSelected);
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
    }

    public CtoServicio getCtoServicio() {
        return ctoServicio;
    }

    public void setCtoServicio(CtoServicio ctoServicio) {
        this.ctoServicio = ctoServicio;
    }

    public int getIdZonaSelected() {
        return idZonaSelected;
    }

    public void setIdZonaSelected(int idZonaSelected) {
        this.idZonaSelected = idZonaSelected;
    }

}
