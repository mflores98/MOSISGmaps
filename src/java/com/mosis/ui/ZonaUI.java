/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoZona;
import com.mosis.helper.ZonaHelper;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class ZonaUI implements Serializable {

    private ZonaHelper zonaHelper;
    private CtoZona ctoZona;
    private boolean btnRegistrar;
    private boolean btnModificar;
    private boolean btnEliminar;
    private boolean btnCancelar;

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

    public ZonaUI() {
        zonaHelper = new ZonaHelper();
        //btn regis esta habilitado
        btnRegistrar = false;
        //los demas btns desabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;
    }

    public void registrarZonaConfirm() {
        zonaHelper.agredarZona();

        this.zonaHelper.setCtoZona(new CtoZona());

    }

    public void stateChange(AjaxBehaviorEvent event) {
        //btn regis esta inabi
        btnRegistrar = true;
        //los demas btns habilitados
        btnModificar = false;
        btnEliminar = false;
        btnCancelar = false;

        if (ctoZona != null) {

            System.out.println("Este es el ID: " + zonaHelper.getCtoZona().getIdCtoZona());
            zonaHelper.setCtoZona(ctoZona);

        }
    }

    public void editarZona() throws Exception {
        if (zonaHelper.getCtoZona().getIdCtoZona() != null) {
            ServiceFacadeLocator.getInstanceZonas().modificarZona(zonaHelper.getCtoZona().getIdCtoZona(), zonaHelper.getCtoZona().getZona());
        } else {
            System.out.println("no hay zona selecccioando para editar");
        }
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        this.zonaHelper.setCtoZona(new CtoZona());
    }

    public void elimanar() {
        System.out.println("metodo eliminar: " + zonaHelper.getCtoZona().getIdCtoZona());
        if (zonaHelper.getCtoZona().getIdCtoZona() != null) {
            if (zonaHelper.getCtoZona() != null) {
                ServiceFacadeLocator.getInstanceZonas().eliminar(zonaHelper.getCtoZona().getIdCtoZona());
            }
        }
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        this.zonaHelper.setCtoZona(new CtoZona());
    }

    public void cancelar() {
        //btn regis esta habi
        btnRegistrar = false;
        //los demas btns desahabilitados
        btnModificar = true;
        btnEliminar = true;
        btnCancelar = true;

        this.zonaHelper.setCtoZona(new CtoZona());

    }

    public boolean isBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(boolean btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    public boolean isBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(boolean btnModificar) {
        this.btnModificar = btnModificar;
    }

    public boolean isBtnEliminar() {
        return btnEliminar;
    }

    public void setBtnEliminar(boolean btnEliminar) {
        this.btnEliminar = btnEliminar;
    }

    public boolean isBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(boolean btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public ZonaHelper getZonaHelper() {
        return zonaHelper;
    }

    public void setZonaHelper(ZonaHelper zonaHelper) {
        this.zonaHelper = zonaHelper;
    }

    public List<CtoZona> getListCtoZonas() {
        return ServiceFacadeLocator.getInstanceZonas().getListZonas();
    }

}
