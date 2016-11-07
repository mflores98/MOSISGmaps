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
import javax.faces.component.html.HtmlCommandButton;
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

    public CtoZona getCtoZona() {
        return ctoZona;
    }

    public void setCtoZona(CtoZona ctoZona) {
        this.ctoZona = ctoZona;
    }

//    private HtmlCommandButton buttonModificar;
//    private HtmlCommandButton buttonEliminar;
//    private HtmlCommandButton buttonCancelar;
//    private HtmlCommandButton buttonRegistrar;

    public ZonaUI() {
        zonaHelper = new ZonaHelper();
    }

    public ZonaHelper getZonaHelper() {
        return zonaHelper;
    }

    public void setZonaHelper(ZonaHelper zonaHelper) {
        this.zonaHelper = zonaHelper;
    }

//    public HtmlCommandButton getButtonModificar() {
//        return buttonModificar;
//    }
//
//    public void setButtonModificar(HtmlCommandButton buttonModificar) {
//        this.buttonModificar = buttonModificar;
//    }
//
//    public HtmlCommandButton getButtonEliminar() {
//        return buttonEliminar;
//    }
//
//    public void setButtonEliminar(HtmlCommandButton buttonEliminar) {
//        this.buttonEliminar = buttonEliminar;
//    }
//
//    public HtmlCommandButton getButtonCancelar() {
//        return buttonCancelar;
//    }
//
//    public void setButtonCancelar(HtmlCommandButton buttonCancelar) {
//        this.buttonCancelar = buttonCancelar;
//    }
//
//    public HtmlCommandButton getButtonRegistrar() {
//        return buttonRegistrar;
//    }
//
//    public void setButtonRegistrar(HtmlCommandButton buttonRegistrar) {
//        this.buttonRegistrar = buttonRegistrar;
//    }

    public List<CtoZona> getListCtoZonas() {
        return ServiceFacadeLocator.getInstanceZonas().getListZonas();
    }
      public void registrarZonaConfirm() {
        zonaHelper.agredarZona();
//        //desabilita
//        this.buttonModificar.setDisabled(true);
//        this.buttonEliminar.setDisabled(true);
        this.zonaHelper.setCtoZona(new CtoZona());

    }

    public void stateChange(AjaxBehaviorEvent event) {
        if (ctoZona != null) {
//            //habilitar botones
//            this.buttonModificar.setDisabled(false);
//            this.buttonEliminar.setDisabled(false);
//            this.buttonCancelar.setDisabled(false);
//            //desabilitar
//            this.buttonRegistrar.setDisabled(true);

            System.out.println("Este es el ID: " + zonaHelper.getCtoZona().getIdCtoZona());
            zonaHelper.setCtoZona(ctoZona);
        }
    }

    public void editarZona() throws Exception {
        if (zonaHelper.getCtoZona().getIdCtoZona() != null) {
            ServiceFacadeLocator.getInstanceZonas().modificarZona(zonaHelper.getCtoZona().getIdCtoZona(), zonaHelper.getCtoZona().getZona());
//            //desabilita
//            buttonModificar.setDisabled(true);
//            buttonEliminar.setDisabled(true);
//            //hablilita
//            buttonRegistrar.setDisabled(false);
        } else {
            System.out.println("no hay zona selecccioando para editar");
        }
        this.zonaHelper.setCtoZona(new CtoZona());
    }

    public void elimanar() {
        System.out.println("metodo eliminar: " + zonaHelper.getCtoZona().getIdCtoZona());
        if (zonaHelper.getCtoZona().getIdCtoZona() != null) {
            if (zonaHelper.getCtoZona() != null) {
                ServiceFacadeLocator.getInstanceZonas().eliminar(zonaHelper.getCtoZona().getIdCtoZona());
                //desabilita
//                buttonModificar.setDisabled(true);
//                buttonEliminar.setDisabled(true);
//                buttonCancelar.setDisabled(true);
//                buttonRegistrar.setDisabled(false);

            }
        }
        this.zonaHelper.setCtoZona(new CtoZona());
    }
//
//    public void cancelar() {
//        //desabilita
////        buttonModificar.setDisabled(true);
////        buttonEliminar.setDisabled(true);
////        buttonRegistrar.setDisabled(false);
//
//        zonaHelper.cancelar();
//
//    }

}
