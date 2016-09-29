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

public class EtiquetaHelper implements Serializable {

    private Etiquetas currentEtiqueta;
    private CtoServicio servicioSelected;
    private Usuarios usuarioActual;
    private int servicioIDint;

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

    public List<CtoServicio> getLsitaSer() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void setUsuarioActual(Usuarios usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    public void registrarEtiqueta() {
        if (getCurrentEtiqueta().getNombre() != null && !currentEtiqueta.getNombre().isEmpty()&&!currentEtiqueta.getValorTag().isEmpty()) {
            try {
                ServiceFacadeLocator.getInstanceEtiquetas().registrarEtiqueta(currentEtiqueta, servicioIDint, 9);//usuario 9
            } catch (Exception ex) {
                System.out.println("error: " + ex.getLocalizedMessage());
            }
        } else {
            System.err.println("getCurrent Etiqeta es null");
        }
    }

    public void modificarEtiqueta() {
        System.out.println("id etiquetaa editar: " + currentEtiqueta.getIdEtiqueta());
        System.out.println("serviio: " + servicioSelected.getIdCtoServicio());
        if (currentEtiqueta!= null) {
            try {
                ServiceFacadeLocator.getInstanceEtiquetas().actualizarEtiqueta(currentEtiqueta.getIdEtiqueta(), currentEtiqueta, servicioSelected.getIdCtoServicio(), 9);//usuario 9 
            } catch (Exception e) {
                System.out.println("Algo salio mal: " + e);
            }
        } else {
            System.out.println("completar");
        }

    }

    public int getServicioIDint() {
        return servicioIDint;
    }

    public void setServicioIDint(int servicioIDint) {
        this.servicioIDint = servicioIDint;
    }

}
