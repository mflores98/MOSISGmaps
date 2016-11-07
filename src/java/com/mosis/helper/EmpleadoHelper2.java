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
import com.mosis.excepciones.MyException;
import com.mosis.excepciones.MyException2;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Owner
 */
public class EmpleadoHelper2 implements Serializable {

    private Empleado empleado;
    private Persona persona;
    private int tipoEmpleadoInt;

    public int getTipoEmpleadoInt() {
        return tipoEmpleadoInt;
    }

    public void setTipoEmpleadoInt(int tipoEmpleadoInt) {
        this.tipoEmpleadoInt = tipoEmpleadoInt;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public EmpleadoHelper2() {
        empleado = new Empleado();
        persona = new Persona();
//        empleado.setFkIdPersona(new Persona());
//        empleado.setFkIdTipoEmpleado(new TipoEmpleado());
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

//    public void registar() {
//        ServiceFacadeLocator.getInstanceEmpleado().registrarEmpleado(empleado);
//        this.empleado = new Empleado();
//        this.empleado.setFkIdPersona(new Persona());
//    }
    public void registar() throws MyException, MyException2 {
//            ServiceFacadeLocator.getInstanceEmpleado().insertPersona(empleado.getNumeroEmpleado(), persona.getNombre(), persona.getApellidoPaterno(), persona.getApellidoMaterno(), "", tipoEmpleadoID);
        ServiceFacadeLocator.getInstanceEmpleado().registrarEmpleado(getEmpleado(), getPersona(), getTipoEmpleadoInt());

    }

    public void modificar() {
        ServiceFacadeLocator.getInstanceEmpleado().modificar(empleado);
    }

    public void eliminar() {
        ServiceFacadeLocator.getInstanceEmpleado().eliminar(empleado);
    }
    public void cancelar() {
        empleado = new Empleado();
        empleado.setFkIdPersona(new Persona());
    }

}
