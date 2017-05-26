/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.CtoTelefonos;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class CtoTelefonoHelper implements Serializable {
    
    private CtoTelefonos ctoTelefono;
    
    private int idServicioSelected;
    
    public CtoTelefonoHelper() {
        ctoTelefono = new CtoTelefonos();
    }
    
    public void registrarContacto() throws Exception {
        ServiceFacadeLocator.getInstanceCtoTefefonos().addCtoTelefono(getCtoTelefono().getTelefono(), getCtoTelefono().getNombre(), getCtoTelefono().getPrioridad(), getIdServicioSelected());
        setCtoTelefono(new CtoTelefonos());
        getCtoTelefono().setFkIdCtoServicio(new CtoServicio());
        
    }
    
    public void editarContacto() throws Exception {
        ServiceFacadeLocator.getInstanceCtoTefefonos().update(getCtoTelefono().getIdCtoTelefono(), getIdServicioSelected(), getCtoTelefono().getTelefono(), getCtoTelefono().getNombre(), getCtoTelefono().getPrioridad());
        setCtoTelefono(new CtoTelefonos());
        getCtoTelefono().setFkIdCtoServicio(new CtoServicio());
    }
    
    public void eliminar() throws Exception {
        ServiceFacadeLocator.getInstanceCtoTefefonos().eliminar(getCtoTelefono().getIdCtoTelefono());
        setCtoTelefono(new CtoTelefonos());
        getCtoTelefono().setFkIdCtoServicio(new CtoServicio());
    }
    
    public void cancelar() {
        ctoTelefono = new CtoTelefonos();
        ctoTelefono.setFkIdCtoServicio(new CtoServicio());
    }

    /**
     * @return the ctoTelefono
     */
    public CtoTelefonos getCtoTelefono() {
        return ctoTelefono;
    }

    /**
     * @param ctoTelefono the ctoTelefono to set
     */
    public void setCtoTelefono(CtoTelefonos ctoTelefono) {
        this.ctoTelefono = ctoTelefono;
    }

    /**
     * @return the idServicioSelected
     */
    public int getIdServicioSelected() {
        return idServicioSelected;
    }

    /**
     * @param idServicioSelected the idServicioSelected to set
     */
    public void setIdServicioSelected(int idServicioSelected) {
        this.idServicioSelected = idServicioSelected;
    }
    
}
