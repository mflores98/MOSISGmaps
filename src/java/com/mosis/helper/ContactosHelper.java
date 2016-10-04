/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoTelefonos;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class ContactosHelper implements Serializable {
    
    private CtoTelefonos ctoTelefono;
    
    private int idServicioSelected;
    
    public ContactosHelper() {
        ctoTelefono = new CtoTelefonos();
    }
    
    public CtoTelefonos getCtoTelefono() {
        return ctoTelefono;
    }
    
    public void setCtoTelefono(CtoTelefonos ctoTelefono) {
        this.ctoTelefono = ctoTelefono;
    }
    
    public int getIdServicioSelected() {
        return idServicioSelected;
    }
    
    public void setIdServicioSelected(int idServicioSelected) {
        this.idServicioSelected = idServicioSelected;
    }
    
    public void registrarContacto() throws Exception {
        ServiceFacadeLocator.getInstanceCtoTefefonos().addCtoTelefono(ctoTelefono.getTelefono(), ctoTelefono.getPrioridad(), idServicioSelected);
    }
    
    public void editarContacto() throws Exception {
        ServiceFacadeLocator.getInstanceCtoTefefonos().update(ctoTelefono.getIdCtoTelefono(), idServicioSelected, ctoTelefono.getTelefono(), ctoTelefono.getPrioridad());
    }

    public void eliminar() throws Exception {
        System.out.println(""+ctoTelefono.getIdCtoTelefono());
        ServiceFacadeLocator.getInstanceCtoTefefonos().eliminar(ctoTelefono.getIdCtoTelefono());
    }
}
