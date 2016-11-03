/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.excepciones.MyException;
import com.mosis.helper.EtiquetaHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class EtiquetasUI implements Serializable {

    private EtiquetaHelper etiquetaHelper;

    private HtmlCommandButton buttonModificar;
    private HtmlCommandButton buttonEliminar;
    private HtmlCommandButton buttonRegistrar;

    public HtmlCommandButton getButtonModificar() {
        return buttonModificar;
    }

    public void setButtonModificar(HtmlCommandButton buttonModificar) {
        this.buttonModificar = buttonModificar;
    }

    public HtmlCommandButton getButtonEliminar() {
        return buttonEliminar;
    }

    public void setButtonEliminar(HtmlCommandButton buttonEliminar) {
        this.buttonEliminar = buttonEliminar;
    }

    public EtiquetasUI() {
        etiquetaHelper = new EtiquetaHelper();

    }

    public EtiquetaHelper getEtiquetaHelper() {
        return etiquetaHelper;
    }

    public void setEtiquetaHelper(EtiquetaHelper etiquetaHelper) {
        this.etiquetaHelper = etiquetaHelper;
    }

    public List<CtoServicio> getListaServicio() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public List<Etiquetas> getListEtiquetas() {
        return ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
    }

    public void stateChange(AjaxBehavior behavior) {
        System.err.println("Entre a metodo");
        if (etiquetaHelper.getCurrentEtiqueta().getFkServicio() != null) {
            System.out.println("obteniendo servicio de etiqueta");
            System.err.println("Entre a metodo");
            //habilita botones
            this.buttonModificar.setDisabled(false);
            this.buttonEliminar.setDisabled(false);
            this.buttonRegistrar.setDisabled(true);
            //de etiqueta seleccionada obtengo el servicio
            etiquetaHelper.setServicioSelected(etiquetaHelper.getCurrentEtiqueta().getFkServicio());
            //y usuario
            etiquetaHelper.setUsuarioActual(etiquetaHelper.getCurrentEtiqueta().getFkIdUsuarioModifico());
        }
    }

    public void modificarEtiqueta() {

        //habilita
        buttonRegistrar.setDisabled(false);

        etiquetaHelper.modificarEtiqueta();
        //desabilita
        buttonModificar.setDisabled(true);
        buttonEliminar.setDisabled(true);
        this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());

    }

    public void registrar() {

        try {
            etiquetaHelper.registrarEtiqueta();
            //desabilita
            buttonModificar.setDisabled(true);
            buttonEliminar.setDisabled(true);
            this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());

        } catch (Exception ex) {
            addMessage("Ocurrio un problema", "");
        }

    }

    public void eliminar() {

        //desabilita
        buttonModificar.setDisabled(true);
        buttonEliminar.setDisabled(true);
//            etiquetaHelper.eliminar();
        if (etiquetaHelper.getCurrentEtiqueta() != null) {
            ServiceFacadeLocator.getInstanceEtiquetas().deleteEtiqueta(etiquetaHelper.getCurrentEtiqueta().getIdEtiqueta());
            this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());
            //habilita
            buttonRegistrar.setDisabled(false);
        } else {
            addMessage("No se elimino", "");
        }

    }

    public void cancelar() {
        //habilita
        buttonRegistrar.setDisabled(false);
        //desabilita
        buttonModificar.setDisabled(true);
        buttonEliminar.setDisabled(true);
        this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());

    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public HtmlCommandButton getButtonRegistrar() {
        return buttonRegistrar;
    }

    public void setButtonRegistrar(HtmlCommandButton buttonRegistrar) {
        this.buttonRegistrar = buttonRegistrar;
    }

}
