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
    private HtmlCommandButton buttonCancelar;
    private HtmlCommandButton buttonRegistrar;

    public HtmlCommandButton getButtonCancelar() {
        return buttonCancelar;
    }

    public void setButtonCancelar(HtmlCommandButton buttonCancelar) {
        this.buttonCancelar = buttonCancelar;
    }

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

    public HtmlCommandButton getButtonRegistrar() {
        return buttonRegistrar;
    }

    public void setButtonRegistrar(HtmlCommandButton buttonRegistrar) {
        this.buttonRegistrar = buttonRegistrar;
    }

    public void stateChange(AjaxBehaviorEvent event) {
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            //habilitar botones
            this.buttonModificar.setDisabled(false);
            this.buttonEliminar.setDisabled(false);
            this.buttonCancelar.setDisabled(false);
            //desabilitar
            this.buttonRegistrar.setDisabled(true);

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
            this.buttonCancelar.setDisabled(false);

            System.err.println("Entre a metodo");
            catalogosHelper.setCtoZona(catalogosHelper.getCtoServicio().getIdCtoZona());
        }

    }

    public void registrarZonaConfirm() {
        catalogosHelper.agredarZona();
        //desabilita
        this.buttonModificar.setDisabled(true);
        this.buttonEliminar.setDisabled(true);
        this.catalogosHelper.setCtoZona(new CtoZona());

    }

    public void editarZona() throws Exception {
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null && catalogosHelper.getCtoZona().getZona().equals("")) {
            ServiceFacadeLocator.getInstanceZonas().modificarZona(catalogosHelper.getCtoZona().getIdCtoZona(), catalogosHelper.getCtoZona().getZona());
            //desabilita
            buttonModificar.setDisabled(true);
            buttonEliminar.setDisabled(true);
            //hablilita
            buttonRegistrar.setDisabled(false);
        } else {
            System.out.println("no hay zona selecccioando para editar");
        }
        this.catalogosHelper.setCtoZona(new CtoZona());
        

    }

    public void elimanar() {
        System.out.println("metodo eliminar: " + catalogosHelper.getCtoZona().getIdCtoZona());
        if (catalogosHelper.getCtoZona().getIdCtoZona() != null) {
            if (catalogosHelper.getCtoZona() != null) {
                ServiceFacadeLocator.getInstanceZonas().eliminar(catalogosHelper.getCtoZona().getIdCtoZona());
                //desabilita
                buttonModificar.setDisabled(true);
                buttonEliminar.setDisabled(true);
                buttonCancelar.setDisabled(true);
                buttonRegistrar.setDisabled(false);

            }
        }
        this.catalogosHelper.setCtoZona(new CtoZona());

    }

    public void eliminar() {
        System.out.println("id servicio a eliminar " + catalogosHelper.getCtoServicio().getIdCtoServicio());
        if (catalogosHelper.getCtoServicio().getIdCtoServicio() != null) {
            try {
                ServiceFacadeLocator.getInstanceServicio().eliminar(catalogosHelper.getCtoServicio().getIdCtoServicio());
                //desabilita
                buttonModificar.setDisabled(true);
                buttonEliminar.setDisabled(true);
                buttonRegistrar.setDisabled(false);

            } catch (Exception ex) {
                addMessage("Ocurrio un error", "");
            }
        }

    }

    public void cancelar() {
        //desabilita
        buttonModificar.setDisabled(true);
        buttonEliminar.setDisabled(true);
        buttonRegistrar.setDisabled(false);

        this.catalogosHelper.setCtoZona(new CtoZona());

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
            buttonRegistrar.setDisabled(false);
            this.catalogosHelper.setCtoZona(new CtoZona());
        } else {
            System.out.println("no esta seleccionado el servicio a editr");
        }
    }
}
