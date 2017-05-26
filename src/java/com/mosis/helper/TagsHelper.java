/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoAcciones;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Flujos;
import com.mosis.entity.Turno;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class TagsHelper implements Serializable {

    private Etiquetas etiqueta;
    private CtoAcciones ctoAccionSelected;
    private Turno turnoSelected;

    private boolean update;

    public TagsHelper() {
        etiqueta = new Etiquetas();
        ctoAccionSelected = new CtoAcciones();
        turnoSelected = new Turno();
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

    public Turno getTurnoSelected() {
        return turnoSelected;
    }

    public void setTurnoSelected(Turno turnoSelected) {
        this.turnoSelected = turnoSelected;
    }

}
