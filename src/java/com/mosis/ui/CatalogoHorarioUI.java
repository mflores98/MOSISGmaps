/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Horarios;
import com.mosis.helper.CatalogoHorarioHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class CatalogoHorarioUI implements Serializable {

    private CatalogoHorarioHelper catalogoHorarioHelper;

    public CatalogoHorarioUI() {
        catalogoHorarioHelper = new CatalogoHorarioHelper();
    }

    public CatalogoHorarioHelper getCatalogoHorarioHelper() {
        return catalogoHorarioHelper;
    }

    public void setCatalogoHorarioHelper(CatalogoHorarioHelper catalogoHorarioHelper) {
        this.catalogoHorarioHelper = catalogoHorarioHelper;
    }

    public List<Horarios> getListaHorarios() {
        return ServiceFacadeLocator.getInstanceHorariosFacade().getListHorarios();
    }

    public void stateChange(AjaxBehaviorEvent event) {
        if (catalogoHorarioHelper.getHorario().getIdHorario() != null) {
            System.out.println("esta seleccionado id: " + catalogoHorarioHelper.getHorario().getIdHorario());

        } else {
            System.out.println("no seleccionado");
        }
    }

    public void guardar() {
        addMessage("Horario Almacenado: ", "");
        catalogoHorarioHelper.guardarHorario();
    }

    public void editar() {
        addMessage("Horario modificado: ", "");
        catalogoHorarioHelper.editarHorario();
    }
    public void cancelar(){
        System.out.println("cancelar");
    } 
    public void eliminar(){
        System.out.println("solo eliminar");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
