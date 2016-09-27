/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.delegate.DelegateEtiquetas;
import com.mosis.entity.CtoAcciones;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Flujos;
import com.mosis.entity.Turnos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class TagsHelper implements Serializable {

    private DelegateEtiquetas delegateEtiquetas;
    private Etiquetas etiqueta;
    private CtoAcciones ctoAccionSelected;
    private Turnos turnoSelected;

    private boolean update;

    public TagsHelper() {
        delegateEtiquetas = new DelegateEtiquetas();
        etiqueta = new Etiquetas();
        ctoAccionSelected = new CtoAcciones();
        turnoSelected = new Turnos();
    }

    public DelegateEtiquetas getDelegateEtiquetas() {
        return delegateEtiquetas;
    }

    public void setDelegateEtiquetas(DelegateEtiquetas delegateEtiquetas) {
        this.delegateEtiquetas = delegateEtiquetas;
    }

    public Etiquetas getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(Etiquetas etiqueta) {
        this.etiqueta = etiqueta;
    }

    public CtoAcciones getCtoAccionSelected() {
        return ctoAccionSelected;
    }

    public void setCtoAccionSelected(CtoAcciones ctoAccionSelected) {
        this.ctoAccionSelected = ctoAccionSelected;
    }

    public Turnos getTurnoSelected() {
        return turnoSelected;
    }

    public void setTurnoSelected(Turnos turnoSelected) {
        this.turnoSelected = turnoSelected;
    }

}
