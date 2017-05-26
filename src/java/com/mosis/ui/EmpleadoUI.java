/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Empleado;
import com.mosis.entity.TipoEmpleado;
import com.mosis.helper.EmpleadoHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Owner
 */
@ManagedBean
@ViewScoped
public class EmpleadoUI implements Serializable {

    private EmpleadoHelper empleadoHelper;
    private Empleado empleado;

    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public EmpleadoUI() {
        empleadoHelper = new EmpleadoHelper();
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

    /**
     * @return the empleadoHelper
     */
    public EmpleadoHelper getEmpleadoHelper() {
        return empleadoHelper;
    }

    /**
     * @param empleadoHelper the empleadoHelper to set
     */
    public void setEmpleadoHelper(EmpleadoHelper empleadoHelper) {
        this.empleadoHelper = empleadoHelper;
    }

    /**
     * @return the empleado
     */
    public Empleado getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Empleado> getListEmpleados() {
        return this.empleadoHelper.getDelegateEmpleado().getListEmpleados();
    }

    public List<TipoEmpleado> getListTipoEmpleado() {
        return ServiceFacadeLocator.getInstanceTipoEmpleado().getListTipoEmpleado();
    }

    public List<CtoServicio> getListCtoServicio() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void stateChange(AjaxBehavior behavior) {
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;

        if (empleado != null) {
            System.err.println("Entre");
            empleadoHelper.setCurrentEmpleado(empleado);

        }

    }

    public void cancelar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        empleadoHelper.cancelar();
    }

    public void eliminar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        empleadoHelper.eliminar();
    }

    public void registrar() {
        try {
            empleadoHelper.insertPersonaEmpleado();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            empleadoHelper.actualizarPersonaEmpleado();
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoUI.class.getName()).log(Level.SEVERE, null, ex);
        }
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
