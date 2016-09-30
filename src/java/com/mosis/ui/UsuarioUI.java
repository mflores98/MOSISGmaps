/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.TipoUsuario;
import com.mosis.excepciones.MyException;
import com.mosis.excepciones.MyException2;
import com.mosis.helper.UsuarioHelper;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class UsuarioUI {

    private UsuarioHelper usuarioHelper;

    /**
     * Creates a new instance of UsuarioUI
     */
    public UsuarioUI() {
        usuarioHelper = new UsuarioHelper();
    }

    public UsuarioHelper getUsuarioHelper() {
        return usuarioHelper;
    }

    public void setUsuarioHelper(UsuarioHelper usuarioHelper) {
        this.usuarioHelper = usuarioHelper;
    }

    public void destroyWorld()  {
        try {
            addMessage("Se registro", getUsuarioHelper().getUsuario().getUserName());
            usuarioHelper.registrarUsaurio();
        } catch (MyException | MyException2 ex) {
            addMessage("Advertencia", getUsuarioHelper().getUsuario().getUserName()+" ya se encuentra registrado");

        }
    }
    public List<TipoUsuario> getLista(){
       return ServiceFacadeLocator.getInstanceUsuario().getListTipoUsuario();
    }
    
    
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

 
}
