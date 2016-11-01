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
import com.mosis.helper.ContactosHelper;
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
public class ContactosUI implements Serializable {

    private ContactosHelper contactosHelper;

    /**
     * Creates a new instance of ContactosUI
     */
    public ContactosUI() {
        contactosHelper = new ContactosHelper();
    }

    public ContactosHelper getContactosHelper() {
        return contactosHelper;
    }

    public void setContactosHelper(ContactosHelper contactosHelper) {
        this.contactosHelper = contactosHelper;
    }

    public List<CtoTelefonos> getListaTelefonos() {
        return ServiceFacadeLocator.getInstanceCtoTefefonos().getListCtoTelefonos();
    }

    public List<CtoServicio> getListaServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void stateChange(AjaxBehaviorEvent event) {
        if (contactosHelper.getCtoTelefono().getIdCtoTelefono() != null) {
            System.out.println("esta seleccionado id: " + contactosHelper.getCtoTelefono().getIdCtoTelefono());

        } else {
            System.out.println("no seleccionado");
        }
    }

    public void guardar() {
        try {
            addMessage("Se registro: ", contactosHelper.getCtoTelefono().getTelefono());
            contactosHelper.registrarContacto();
        } catch (Exception ex) {
            Logger.getLogger(ContactosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editar() {
        try {
            addMessage("Se modifico: ", contactosHelper.getCtoTelefono().getTelefono());
            contactosHelper.editarContacto();
        } catch (Exception ex) {
            Logger.getLogger(ContactosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar() {
        try {
            contactosHelper.eliminar();
        } catch (Exception ex) {
            Logger.getLogger(ContactosUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void cancelar() {
        System.out.println("cancelar");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
