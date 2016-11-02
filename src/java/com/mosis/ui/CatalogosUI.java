/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.CtoZona;
import com.mosis.helper.CatalogosHelper;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.component.behavior.AjaxBehavior;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class CatalogosUI implements Serializable {

    private CatalogosHelper catalogosHelper;

    private HtmlCommandButton buttonModificar;
    private HtmlCommandButton buttonEliminar;

    public HtmlCommandButton getButtonEliminar() {
        return buttonEliminar;
    }

    public void setButtonEliminar(HtmlCommandButton buttonEliminar) {
        this.buttonEliminar = buttonEliminar;
    }

    public HtmlCommandButton getButtonModificar() {
        return buttonModificar;
    }

    public void setButtonModificar(HtmlCommandButton buttonModificar) {
        this.buttonModificar = buttonModificar;
    }

    public CatalogosUI() {
        catalogosHelper = new CatalogosHelper();

    }

    /**
     * @return the catalogosHelper
     */
    public CatalogosHelper getCatalogosHelper() {
        return catalogosHelper;
    }

    /**
     * @param catalogosHelper the catalogosHelper to set
     */
    public void setCatalogosHelper(CatalogosHelper catalogosHelper) {
        this.catalogosHelper = catalogosHelper;
    }

    public List<CtoZona> getListCtoZonas() {
        return ServiceFacadeLocator.getInstanceZonas().getListZonas();
    }

    public List<CtoServicio> getListaServicios() {
        return ServiceFacadeLocator.getInstanceServicio().getListCtoServicios();
    }

    public void stateChange(AjaxBehaviorEvent event) {
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            //habilitar botones
            this.buttonModificar.setDisabled(false);
            this.buttonEliminar.setDisabled(false);
            System.out.println("Este es el ID: " + catalogosHelper.getCtoZona().getIdCtoZona());
            catalogosHelper.setCtoZona(catalogosHelper.getCtoZona());
        } else if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
            System.out.println("en servicio");

            catalogosHelper.setCtoServicio(catalogosHelper.getCtoServicio());
        }
    }

    public void stateChangeServ(AjaxBehavior behavior) {
        System.err.println("Entre a metodo");

        if (catalogosHelper.getCtoServicio().getIdCtoZona() != null) {
            //habilitar botones
            this.buttonModificar.setDisabled(false);
            this.buttonEliminar.setDisabled(false);
            System.err.println("Entre a metodo");
            catalogosHelper.setCtoZona(catalogosHelper.getCtoServicio().getIdCtoZona());
        }

    }

    public void registrarZonaConfirm() {
        catalogosHelper.agredarZona();
    }

    public void agregarZona() {

        addMessage("Se registro", "");
        catalogosHelper.agredarZona();
    }

    public void editarZona() throws Exception {
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            ServiceFacadeLocator.getInstanceZonas().modificarZona(catalogosHelper.getCtoZona().getIdCtoZona(), catalogosHelper.getCtoZona().getZona());
            //desabilita
            buttonModificar.setDisabled(true);
            buttonEliminar.setDisabled(true);
        } else {
            System.out.println("no hay zona selecccioando para editar");
        }
    }

    public void elimanar() {
        System.out.println("metodo eliminar: " + catalogosHelper.getCtoZona().getIdCtoZona());
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            if (catalogosHelper.getCtoZona() != null) {
                ServiceFacadeLocator.getInstanceZonas().eliminar(catalogosHelper.getCtoZona().getIdCtoZona());
                //desabilita
                buttonModificar.setDisabled(true);
                buttonEliminar.setDisabled(true);
            }
        }
    }

    public void eliminar() {
        System.out.println("id servicio a eliminar "+catalogosHelper.getCtoServicio().getIdCtoServicio());
        if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
            try {
                ServiceFacadeLocator.getInstanceServicio().eliminar(catalogosHelper.getCtoServicio().getIdCtoServicio());
                //desabilita
                buttonModificar.setDisabled(true);
                buttonEliminar.setDisabled(true);
            } catch (Exception ex) {
                addMessage("Ocurrio un error", "");
            }
        }

    }

    public void cancelar() {
        //desabilita
        buttonModificar.setDisabled(true);
        buttonEliminar.setDisabled(true);

    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void editarServicio() {
        if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
            ServiceFacadeLocator.getInstanceServicio().editarServicio(
                    catalogosHelper.getCtoServicio().getIdCtoServicio(),
                    catalogosHelper.getCtoServicio().getClave(),
                    catalogosHelper.getCtoServicio().getServicio(),
                    catalogosHelper.getIdZonaSelected());
            buttonModificar.setDisabled(true);
            buttonEliminar.setDisabled(true);
        } else {
            System.out.println("no esta seleccionado el servicio a editr");
        }
    }
}
