/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Usuarios;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
@ManagedBean
@SessionScoped
public class UsuarioUILogin implements Serializable {

    private Usuarios usuario;
    private Usuarios login;

    /**
     * Creates a new instance of UsuarioUILogin
     */
    public UsuarioUILogin() {
        usuario = new Usuarios();
    }

    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        login = ServiceFacadeLocator.getInstanceUsuario().login(getUsuario().getUserName(), getUsuario().getPassword());
        String resultado = null;
        if (login != null) {
            if (this.getUsuario().getPassword().equals(login.getPassword()) && this.getUsuario().getUserName().equals(login.getUserName())) {
                System.err.println("Existes como usuario");
                if (("Admin").equals(login.getFkIdTipoUsuario().getTipoUsuario())) {
                    System.out.println("Eres el addmin");
                } else if (("Gerente").equals(login.getFkIdTipoUsuario().getTipoUsuario())) {
                    System.out.println("eres gerente");
                } else if (("Comun").equals(login.getFkIdTipoUsuario().getTipoUsuario())) {
                    System.out.println("eres comun");
                }
            }
            FacesContext.getCurrentInstance().
                    getExternalContext().getSessionMap().put("usuario", login);
            return "/bitacoraRondaConejillo?faces-redirect=true";

        } else {
            System.err.println("no eres usuario");
            FacesMessage message = new FacesMessage("Usuario o contraseña no valido");
            context.addMessage(null, message);
        }

        return null;
    }

    public boolean verificarSesion() {
        boolean estado;
        System.out.println("entra a verificar");
        if (FacesContext.getCurrentInstance().getExternalContext().
                getSessionMap().get("usuario") == null) {
            estado = false;
            System.out.println("esta en false: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        } else {
            System.out.println("ests en true: " + FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
            estado = true;
        }
        return estado;

    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/usuarioLogin?faces-redirect=true";
    }

    /**
     * @return the usuario
     */
    public Usuarios getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

}
