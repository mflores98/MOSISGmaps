/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.CtoZona;
import com.mosis.helper.ServiciosHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class ServiciosUI implements Serializable {

    private ServiciosHelper serviciosHelper;

    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    @PostConstruct
    public void init() {
        serviciosHelper = new ServiciosHelper();

        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

    public void registrar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        serviciosHelper.agregarServicio();

    }

    public void actualizr() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        serviciosHelper.editarServicio();

//        if (serviciosHelper.getCtoServicio().getIdCtoServicio() != null) {
////            ServiceFacadeLocator.getInstanceServicio().editarServicio(
////                    serviciosHelper.getCtoServicio().getIdCtoServicio(),
////                    serviciosHelper.getCtoServicio().getClave(),
////                    serviciosHelper.getCtoServicio().getServicio(),
////                    //                    serviciosHelper.getIdZonaSelected()
////                    serviciosHelper.getCtoServicio().getIdCtoZona().getIdCtoZona()
////            );
//        } else {
//            System.out.println("no esta seleccionado el servicio a editr");
//        }
    }

    public void eliminar() {
        try {
            //btn regis esta habilitado
            btnRegistrar = false;
            //los demas btns desabilitados
            btnModificar = true;
            btnEliminar = true;
            btnCancelar = true;
//            ServiceFacadeLocator.getInstanceServicio().eliminar(serviciosHelper.getCtoServicio().getIdCtoServicio());
            serviciosHelper.eliminar();
        } catch (Exception ex) {
            Logger.getLogger(ServiciosUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void cancelar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        serviciosHelper.cancelar();
    }

    public void stateChangeServ(AjaxBehavior behavior) {

        if (serviciosHelper.getCtoServicio() != null) {

            System.err.println("Entre a metodo2");
            serviciosHelper.setCtoServicio(serviciosHelper.getCtoServicio());
//            serviciosHelper.setCtoZona(serviciosHelper.getCtoServicio().getIdCtoZona());
        }
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;

    }

    public List<CtoServicio> getListaServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public List<CtoZona> getListCtoZonas() {
        return ServiceFacadeLocator.getInstanceZonas().getListZonas();
    }

    public ServiciosHelper getServiciosHelper() {
        return serviciosHelper;
    }

    public void setServiciosHelper(ServiciosHelper serviciosHelper) {
        this.serviciosHelper = serviciosHelper;
    }

    public boolean isBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(boolean btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public boolean isBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(boolean btnModificar) {
        this.btnModificar = btnModificar;
    }

    public boolean isBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public boolean isBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(boolean btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

}
