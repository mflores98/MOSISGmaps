/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.delegate.DelegateEmpleado;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Owner
 */
public class EmpleadoHelper {

    private DelegateEmpleado delegateEmpleado;

    public EmpleadoHelper() {
        delegateEmpleado = new DelegateEmpleado();
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
    
    
    
}
