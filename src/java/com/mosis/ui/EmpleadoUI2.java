/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Empleado;
import com.mosis.entity.Persona;
import com.mosis.entity.TipoEmpleado;
import com.mosis.excepciones.MyException;
import com.mosis.excepciones.MyException2;
import com.mosis.helper.EmpleadoHelper2;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 *
 * @author Owner
 */
@ManagedBean
@ViewScoped
public class EmpleadoUI2 implements Serializable {

    private EmpleadoHelper2 empleadoHelper;
    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public EmpleadoUI2() {
        empleadoHelper = new EmpleadoHelper2();
        //btn registrar habilitado
        btnRegistrar = false;
        //los de mas desabilitdos
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

    }

    /**
     * @return the empleadoHelper
     */
    public EmpleadoHelper2 getEmpleadoHelper() {
        return empleadoHelper;
    }

    /**
     * @param empleadoHelper the empleadoHelper to set
     */
    public void setEmpleadoHelper(EmpleadoHelper2 empleadoHelper) {
        this.empleadoHelper = empleadoHelper;
    }

    public List<Empleado> getListEmpleados() {
        return ServiceFacadeLocator.getInstanceEmpleado().getListEmpleados();
    }

    public List<TipoEmpleado> getListTipoEmpleado() {
        return ServiceFacadeLocator.getInstanceTipoEmpleado().getListTipoEmpleado();
    }

    public void registar() {
        try {

            empleadoHelper.registar();
//            this.buttonModificar.setDisabled(true);
//            this.buttonEliminar.setDisabled(true);

//            addMessage("Aviso", getEmpleadoHelper().getEmpleado().getNumeroEmpleado() + " se registro");
        } catch (Exception ex) {
//            Logger.getLogger(EmpleadoUI.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ya esta registrado");
//            addMessage("Advertencia", getEmpleadoHelper().getEmpleado().getNumeroEmpleado() + " ya se encuentra registrado");
        }

    }

//    public void saveAction() {
//        try {
//            empleadoHelper.registar();
//        } catch (MyException ex) {
//            Logger.getLogger(EmpleadoUI.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (MyException2 ex) {
//            Logger.getLogger(EmpleadoUI.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
    public void modificar() {
        empleadoHelper.modificar();

        //habilita
////        buttonRegistrar.setDisabled(false);
////        //desabilita
////        buttonModificar.setDisabled(true);
////        buttonEliminar.setDisabled(true);
    }

    public void eliminar() {
        empleadoHelper.eliminar();

    }

    public void cancelar() {
        //habilita
//        buttonRegistrar.setDisabled(false);
//        //desabilita
//        buttonModificar.setDisabled(true);
//        buttonEliminar.setDisabled(true);
//        buttonCancelar.setDisabled(false);

    }

    public void stateChange(AjaxBehavior behavior) {
        System.err.println("Entre a este metodo");

        if (empleadoHelper.getEmpleado().getFkIdTipoEmpleado().getIdTipoEmpleado() != null) {

            System.err.println("ya Entre a metodo");
            empleadoHelper.setEmpleado(getEmpleadoHelper().getEmpleado());
        }
        //            habilitar botones
//        this.buttonCancelar.setDisabled(false);
//        this.buttonModificar.setDisabled(false);
//        this.buttonEliminar.setDisabled(false);
//        this.buttonRegistrar.setDisabled(true);
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;

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
