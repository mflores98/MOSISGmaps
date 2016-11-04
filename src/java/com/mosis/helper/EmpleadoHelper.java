/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Empleado;
import com.mosis.entity.Persona;
import com.mosis.entity.TipoEmpleado;
import java.io.Serializable;

/**
 *
 * @author Owner
 */
public class EmpleadoHelper implements Serializable {

    private Empleado empleado;

    public EmpleadoHelper() {
        empleado = new Empleado();
        empleado.setFkIdPersona(new Persona());
        empleado.setFkIdTipoEmpleado(new TipoEmpleado());
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public void registar() {
        ServiceFacadeLocator.getInstanceEmpleado().registrarEmpleado(empleado);
    }

    public void modificar() {
        ServiceFacadeLocator.getInstanceEmpleado().modificar(empleado);
    }

    public void eliminar() {
        ServiceFacadeLocator.getInstanceEmpleado().eliminar(empleado);
    }

}
