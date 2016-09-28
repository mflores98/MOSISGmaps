/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Usuarios;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EtiquetaHelper implements Serializable {

    private Etiquetas currentEtiqueta;
    private CtoServicio servicioSelected;
    private Usuarios usuarioActual;

    public EtiquetaHelper() {
        currentEtiqueta = new Etiquetas();
        servicioSelected = new CtoServicio();
        usuarioActual = new Usuarios();
    }

    public List<Etiquetas> getEtiquetas() {
        return ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
    }

    public Etiquetas getCurrentEtiqueta() {
        return currentEtiqueta;
    }

    public void setCurrentEtiqueta(Etiquetas currentEtiqueta) {
        this.currentEtiqueta = currentEtiqueta;
    }

    public CtoServicio getServicioSelected() {
        return servicioSelected;
    }

    public void setServicioSelected(CtoServicio servicioSelected) {
        this.servicioSelected = servicioSelected;
    }

    public Usuarios getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuarios usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * presentando error de resgistrar
     */
    public void registrarEtiqueta() {
        System.out.println("entro a registrar etiqueta");
        System.out.println("curentEtiqueta: " + currentEtiqueta.getNombre());
        System.out.println("servicio: " + servicioSelected.getServicio());
        System.out.println("usuario: " + usuarioActual.getUserName());
        System.out.println("idServicio: " + servicioSelected.getIdCtoServicio());
        try {
            ServiceFacadeLocator.getInstanceEtiquetas().registrarEtiqueta(currentEtiqueta, servicioSelected.getIdCtoServicio(), 9);
        } catch (Exception ex) {
            Logger.getLogger(EtiquetaHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
