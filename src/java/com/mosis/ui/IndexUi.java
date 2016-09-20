/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.bean.MarkerSelectionView;
import com.mosis.helper.EmpleadoHelper;
import com.mosis.helper.EtiquetaHelper;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author
 */
@ManagedBean
public class IndexUi implements Serializable {

    private EtiquetaHelper ayudante;
    private EmpleadoHelper ayudanteEmpleado;
//    private MarkerSelectionView markerSelectionView;

    public IndexUi() {
        //ayudante = new EtiquetaHelper();
        // markerSelectionView = new MarkerSelectionView();
        ayudanteEmpleado = new EmpleadoHelper();
    }

    public EtiquetaHelper getAyudante() {
        return ayudante;
    }

    public void setAyudante(EtiquetaHelper ayudante) {
        this.ayudante = ayudante;
    }

//    public MarkerSelectionView getMarkerSelectionView() {
//        return markerSelectionView;
//    }
//    public void setMsv(MarkerSelectionView markerSelectionView) {
//        this.markerSelectionView = markerSelectionView;
//    }
    public EmpleadoHelper getAyudanteEmpleado() {
        return ayudanteEmpleado;
    }

    public void setAyudanteEmpleado(EmpleadoHelper ayudanteEmpleado) {
        this.ayudanteEmpleado = ayudanteEmpleado;
    }

    public void clicButton() {
        System.out.println("clic en boton");
    }

}
