/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Empleado;
import com.mosis.entity.TipoEmpleado;
import com.mosis.helper.EmpleadoHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
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

    public EmpleadoUI() {
        empleadoHelper = new EmpleadoHelper();
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

    public List<Empleado> getListEmpleados() {
        return ServiceFacadeLocator.getInstanceEmpleado().getListEmpleados();
    }

    public List<TipoEmpleado> getListTipoEmpleado() {
        return ServiceFacadeLocator.getInstanceTipoEmpleado().getListTipoEmpleado();
    }

    public void registar() {
        empleadoHelper.registar();
    }

    public void modificar() {
        empleadoHelper.modificar();
    }

    public void eliminar() {
        empleadoHelper.eliminar();
    }

    public void cancelar() {
        empleadoHelper.setEmpleado(new Empleado());

    }

    public void stateChange(AjaxBehavior behavior) {
        System.err.println("Entre a este metodo");

        if (empleadoHelper.getEmpleado().getFkIdTipoEmpleado().getIdTipoEmpleado() != null) {
            //habilitar botones
//            this.buttonModificar.setDisabled(false);
//            this.buttonEliminar.setDisabled(false);
            System.err.println("ya Entre a metodo");
            empleadoHelper.setEmpleado(getEmpleadoHelper().getEmpleado());
        }

    }

}
