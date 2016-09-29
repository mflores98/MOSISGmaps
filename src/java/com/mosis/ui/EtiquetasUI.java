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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.behavior.AjaxBehavior;
import javax.faces.event.ActionEvent;

/**
 *
 * @author Miguel
 */
@ManagedBean
@ViewScoped
public class EtiquetasUI implements Serializable {

    private EtiquetaHelper etiquetaHelper;
    private Etiquetas etiqueta;
    private CtoServicio servicio;

    public EtiquetasUI() {
        etiquetaHelper = new EtiquetaHelper();
        etiqueta = new Etiquetas();
        servicio = new CtoServicio();
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
        System.out.println("fkServicio: " + etiquetaHelper.getCurrentEtiqueta().getFkServicio().getServicio());
        System.out.println("Pass: " + etiquetaHelper.getCurrentEtiqueta().getFkIdUsuarioModifico().getPassword());

        if (etiquetaHelper.getCurrentEtiqueta().getFkServicio() != null && etiquetaHelper.getCurrentEtiqueta().getFkIdUsuarioModifico() != null) {
            System.out.println("obteniendo servicio de etiqueta");
            System.err.println("Entre a metodo");
            //de etiqueta seleccionada obtengo el servicio
            etiquetaHelper.setServicioSelected(etiquetaHelper.getCurrentEtiqueta().getFkServicio());
            //y usuario
            etiquetaHelper.setUsuarioActual(etiquetaHelper.getCurrentEtiqueta().getFkIdUsuarioModifico());
        }
    }

    public void regist() {
        System.out.println("servicio" + servicio.getServicio());
        System.out.println("etiueq: " + etiqueta.getNombre());
    }

    public void saveAction(ActionEvent actionEvent) {

        System.out.println("fkServicio: " + etiquetaHelper.getCurrentEtiqueta().getFkServicio().getServicio());
        System.out.println("Pass: " + etiquetaHelper.getCurrentEtiqueta().getFkIdUsuarioModifico().getPassword());
////        if (etiquetaHelper.getCurrentEtiqueta().getFkServicio() != null) {
////            System.out.println("guardar aqui");
////            etiquetaHelper.registrarEtiqueta();
////        } else {
////            System.out.println("Se requiere campos");
////        }
    }

    public void updateAction(ActionEvent actionEvent) {
        System.out.println("metodo updateAction");
        if (etiquetaHelper.getCurrentEtiqueta().getFkServicio() != null && etiquetaHelper.getCurrentEtiqueta().getNombre() != null) {
            etiquetaHelper.modificarEtiqueta();
        } else {
            System.out.println("No hay nada que editar");
        }

    }

    public Etiquetas getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiquetas etiqueta) {
        this.etiqueta = etiqueta;
    }

    public CtoServicio getServicio() {
        return servicio;
    }

    public void setServicio(CtoServicio servicio) {
        this.servicio = servicio;
    }

}
