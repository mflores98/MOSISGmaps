/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.CtoTelefonos;
import com.mosis.entity.CtoZona;
import com.mosis.helper.CtoTelefonoHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class CtoTelefonoUI implements Serializable {

    private CtoTelefonoHelper contactosHelper;

    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    /**
     * Creates a new instance of ContactosUI
     */
    public CtoTelefonoUI() {
        contactosHelper = new CtoTelefonoHelper();
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

    public CtoTelefonoHelper getContactosHelper() {
        return contactosHelper;
    }

    public void setContactosHelper(CtoTelefonoHelper contactosHelper) {
        this.contactosHelper = contactosHelper;
    }

    public List<CtoTelefonos> getListaTelefonos() {
        return ServiceFacadeLocator.getInstanceCtoTefefonos().getListCtoTelefonos();
    }

    public List<CtoServicio> getListaServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void stateChange(AjaxBehaviorEvent event) {

        //btn regis esta desab
        btnRegistrar = true;
        //los demas btns habi
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;
        if (contactosHelper.getCtoTelefono().getIdCtoTelefono() != null) {
            System.out.println("esta seleccionado id: " + contactosHelper.getCtoTelefono().getIdCtoTelefono());

        } else {
            System.out.println("no seleccionado");
        }
    }

    public void guardar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            addMessage("Se registro: ", contactosHelper.getCtoTelefono().getTelefono());
            contactosHelper.registrarContacto();
        } catch (Exception ex) {
            Logger.getLogger(CtoTelefonoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            addMessage("Se modifico: ", contactosHelper.getCtoTelefono().getTelefono());
            contactosHelper.editarContacto();
        } catch (Exception ex) {
            Logger.getLogger(CtoTelefonoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            contactosHelper.eliminar();
        } catch (Exception ex) {
            Logger.getLogger(CtoTelefonoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar() {
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        this.contactosHelper.setCtoTelefono(new CtoTelefonos());
        // contactosHelper.cancelar();

    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
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
