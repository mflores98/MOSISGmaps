/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.helper.EtiquetaHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class EtiquetasUI implements Serializable {

    private EtiquetaHelper etiquetaHelper;

    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public EtiquetasUI() {
        etiquetaHelper = new EtiquetaHelper();

        btnRegistrar = false;
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

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
        btnRegistrar = true;
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;
        if (etiquetaHelper.getCurrentEtiqueta().getFkServicio() != null) {

            System.err.println("Entre a metodo");
            //de etiqueta seleccionada obtengo el servicio
            etiquetaHelper.setServicioSelected(etiquetaHelper.getCurrentEtiqueta().getFkServicio());
            //y usuario
            etiquetaHelper.setUsuarioActual(etiquetaHelper.getCurrentEtiqueta().getFkIdUsuarioModifico());
        }
    }

    public void modificarEtiqueta() {
        btnRegistrar = false;
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        etiquetaHelper.modificarEtiqueta();

        this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());

    }

    public void registrar() {
        btnRegistrar = false;
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        try {
            etiquetaHelper.registrarEtiqueta();

            this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());

        } catch (Exception ex) {
            addMessage("Ocurrio un problema", "");
        }

    }

    public void eliminar() {

        btnRegistrar = false;
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
//            etiquetaHelper.eliminar();
        if (etiquetaHelper.getCurrentEtiqueta() != null) {
            ServiceFacadeLocator.getInstanceEtiquetas().deleteEtiqueta(etiquetaHelper.getCurrentEtiqueta().getIdEtiqueta());
            this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());
            //habilita
        } else {
            addMessage("No se elimino", "");
        }

    }

    public void cancelar() {
        btnRegistrar = false;
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
        this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas());//limpiar campos
//        lim();
//        this.etiquetaHelper.setCurrentEtiqueta(new Etiquetas(null, null, null, null, null, null, null, null, null, null, null, null));

    }

//    public void lim() {
//        System.out.println("limpia");
//        Etiquetas e = new Etiquetas();
//        e.setValorTag("");
//        e.setNombre("");
//        this.etiquetaHelper.setCurrentEtiqueta(e);
//
//    }
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     * @return the btnRegistrar
     */
    public boolean isBtnRegistrar() {
        return btnRegistrar;
    }

    /**
     * @param btnRegistrar the btnRegistrar to set
     */
    public void setBtnRegistrar(boolean btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * @return the btnModificar
     */
    public boolean isBtnModificar() {
        return btnModificar;
    }

    /**
     * @param btnModificar the btnModificar to set
     */
    public void setBtnModificar(boolean btnModificar) {
        this.btnModificar = btnModificar;
    }

    /**
     * @return the btnEliminar
     */
    public boolean isBtnEliminar() {
        return btnEliminar;
    }

    /**
     * @param btnEliminar the btnEliminar to set
     */
    public void setBtnEliminar(boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    /**
     * @return the btnCancelar
     */
    public boolean isBtnCancelar() {
        return btnCancelar;
    }

    /**
     * @param btnCancelar the btnCancelar to set
     */
    public void setBtnCancelar(boolean btnCancelar) {
        this.btnCancelar = btnCancelar;
    }
}
