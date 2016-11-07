/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.delegate.DelegateEmpleado;
import com.mosis.entity.Empleado;
import com.mosis.entity.Persona;
import com.mosis.entity.TipoEmpleado;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Owner
 */
public class EmpleadoHelper implements Serializable {

    private DelegateEmpleado delegateEmpleado;

    private String numero;
    private String nombre;
    private String ap;
    private String am;
    private String fecha;
    private int fkIdTipoEmpleado;
    private boolean update;
    private Empleado currentEmpleado;

    public EmpleadoHelper() {
        delegateEmpleado = new DelegateEmpleado();
        currentEmpleado = new Empleado();
        currentEmpleado.setFkIdPersona(new Persona());
    }

    /**
     * @return the delegateEmpleado
     */
    public DelegateEmpleado getDelegateEmpleado() {
        return delegateEmpleado;
    }

    /**
     * @param delegateEmpleado the delegateEmpleado to set
     */
    public void setDelegateEmpleado(DelegateEmpleado delegateEmpleado) {
        this.delegateEmpleado = delegateEmpleado;
    }

    public void insertPersonaEmpleado() throws Exception {
        try {
            ServiceFacadeLocator.getInstanceEmpleado().insertPersona(currentEmpleado.getNumeroEmpleado(), currentEmpleado.getFkIdPersona().getNombre(),
                    currentEmpleado.getFkIdPersona().getApellidoPaterno(), currentEmpleado.getFkIdPersona().getApellidoMaterno(), fecha, fkIdTipoEmpleado);
        } catch (Exception e) {
            addMessage("Numero ya existe", "");
            System.out.println("Error o  numero ya esta registrado");
            System.out.println(e.getLocalizedMessage());
        }
        currentEmpleado = new Empleado();
        currentEmpleado.setFkIdPersona(new Persona());

    }

    public void actualizarPersonaEmpleado() throws Exception {
        TipoEmpleado tr = ServiceFacadeLocator.getInstanceTipoEmpleado().getTipoEmpleadoID(fkIdTipoEmpleado);
        if (tr != null) {
            try {
//                ServiceFacadeLocator.getInstanceEmpleado().updatePersona(currentEmpleado, tr);
                currentEmpleado.setFkIdTipoEmpleado(tr);
                ServiceFacadeLocator.getInstanceEmpleado().modificar(currentEmpleado);
            } catch (Exception e) {
                System.out.println("Error");
                System.out.println(e.getLocalizedMessage());
            }
        } else {
            throw new Exception();
        }
        currentEmpleado = new Empleado();
        currentEmpleado.setFkIdPersona(new Persona());
    }

    public void eliminar() {
        ServiceFacadeLocator.getInstanceEmpleado().eliminar(currentEmpleado);
        currentEmpleado = new Empleado();
        currentEmpleado.setFkIdPersona(new Persona());
    }

    public void cancelar() {
        currentEmpleado = new Empleado();
        currentEmpleado.setFkIdPersona(new Persona());
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTe() {
        return fkIdTipoEmpleado;
    }

    public void setTe(int te) {
        this.fkIdTipoEmpleado = te;
    }

    /**
     * @return the update
     */
    public boolean isUpdate() {
        return update;
    }

    /**
     * @param update the update to set
     */
    public void setUpdate(boolean update) {
        this.update = update;
    }

    /**
     * @return the currentEmpleado
     */
    public Empleado getCurrentEmpleado() {
        return currentEmpleado;
    }

    /**
     * @param currentEmpleado the currentEmpleado to set
     */
    public void setCurrentEmpleado(Empleado currentEmpleado) {
        this.currentEmpleado = currentEmpleado;
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
