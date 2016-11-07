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

//    private HtmlCommandButton buttonModificar;
//    private HtmlCommandButton buttonEliminar;
//    private HtmlCommandButton buttonRegistrar;
//    private HtmlCommandButton buttonCancelar;

//    public HtmlCommandButton getButtonCancelar() {
//        return buttonCancelar;
//    }
//
//    public void setButtonCancelar(HtmlCommandButton buttonCancelar) {
//        this.buttonCancelar = buttonCancelar;
//    }
//
//    public HtmlCommandButton getButtonRegistrar() {
//        return buttonRegistrar;
//    }
//
//    public void setButtonRegistrar(HtmlCommandButton buttonRegistrar) {
//        this.buttonRegistrar = buttonRegistrar;
//    }
//
//    public HtmlCommandButton getButtonModificar() {
//        return buttonModificar;
//    }
//
//    public void setButtonModificar(HtmlCommandButton buttonModificar) {
//        this.buttonModificar = buttonModificar;
//    }
//
//    public HtmlCommandButton getButtonEliminar() {
//        return buttonEliminar;
//    }
//
//    public void setButtonEliminar(HtmlCommandButton buttonEliminar) {
//        this.buttonEliminar = buttonEliminar;
//    }

    public EmpleadoUI2() {
        empleadoHelper = new EmpleadoHelper2();
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
            this.empleadoHelper.setEmpleado(new Empleado());
            this.empleadoHelper.setPersona(new Persona());
//            addMessage("Aviso", getEmpleadoHelper().getEmpleado().getNumeroEmpleado() + " se registro");

        } catch (MyException | MyException2 ex) {
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
          this.empleadoHelper.setEmpleado(new Empleado());
            this.empleadoHelper.setPersona(new Persona());
        //habilita
////        buttonRegistrar.setDisabled(false);
////        //desabilita
////        buttonModificar.setDisabled(true);
////        buttonEliminar.setDisabled(true);
    }

    public void eliminar() {
        empleadoHelper.eliminar();
          this.empleadoHelper.setEmpleado(new Empleado());
            this.empleadoHelper.setPersona(new Persona());
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
            empleadoHelper.setPersona(getEmpleadoHelper().getEmpleado().getFkIdPersona());
        }
        //            habilitar botones
//        this.buttonCancelar.setDisabled(false);
//        this.buttonModificar.setDisabled(false);
//        this.buttonEliminar.setDisabled(false);
//        this.buttonRegistrar.setDisabled(true);
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
