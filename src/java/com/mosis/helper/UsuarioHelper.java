/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Persona;
import com.mosis.entity.Usuarios;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
public class UsuarioHelper implements Serializable {

    private Usuarios usuario;
    private Persona persona;
    private Date fechaN;

    private int idTipoUsuarioSelected;

    public UsuarioHelper() {
        usuario = new Usuarios();
        persona = new Persona();
        fechaN = new Date();
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public int getIdTipoUsuarioSelected() {
        return idTipoUsuarioSelected;
    }

    public void setIdTipoUsuarioSelected(int idTipoUsuarioSelected) {
        this.idTipoUsuarioSelected = idTipoUsuarioSelected;
    }

    public Date getFechaN() {
        return fechaN;
    }

    public void setFechaN(Date fechaN) {
        this.fechaN = fechaN;
    }
    public void registrarUsaurio() throws Exception {
        System.out.println("Password: "+usuario.getPassword());
        ServiceFacadeLocator.getInstanceUsuario().registrarUsaurio(usuario, persona, idTipoUsuarioSelected);
    }
  
}
