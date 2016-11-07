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
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Owner
 */
@ManagedBean
@ViewScoped
public class EmpleadoUI {
    
    private EmpleadoHelper empleadoHelper;
    private Empleado empleado;
    
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
    
    public void stateChange(AjaxBehavior behavior) {
        System.err.println("Entre a metodo");
        
        if (empleado != null) {
            System.err.println("Entre");
            empleadoHelper.setCurrentEmpleado(empleado);
            
        }
        
    }
    
}
