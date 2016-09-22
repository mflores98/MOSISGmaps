/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.TipoEmpleado;
import java.io.Serializable;

/**
 *
 * @author Owner
 */
public class EmpleadoHelper implements Serializable {

    //private DelegateEmpleado delegateEmpleado;

    private String numero;
    private String nombre;
    private String ap;
    private String am;
    private String fecha;
    private int fkIdTipoEmpleado;

    public EmpleadoHelper() {
    }

    public void insertPersonaEmpleado() throws Exception {
        TipoEmpleado tr = ServiceFacadeLocator.getInstanceTipoEmpleado().getTipoEmpleadoID(fkIdTipoEmpleado);
        if (tr != null) {
            try {
                ServiceFacadeLocator.getInstanceEmpleado().insertPersona(numero, nombre, ap, am, fecha, tr);
            } catch (Exception e) {
                System.out.println("Error");
                System.out.println(e.getLocalizedMessage());
            }
        } else {
            throw new Exception();
        }
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

}
