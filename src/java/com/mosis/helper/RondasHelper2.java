/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Rondas;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Miguel
 */
public class RondasHelper2 implements Serializable {

    private int fkIdHorarioSelected;
    private int fkIdServicioSelected;
    private Rondas rondas;

    public RondasHelper2() {
        rondas = new Rondas();
    }

    public void insertarRonda() throws Exception {

//        ServiceFacadeLocator.getInstanceRonda().agregarRonda(
//                rondas.getRombre(), rondas.getTiempoEstimado(), rondas.getStatus(), fkIdHorarioSelected, fkIdServicioSelected);
    }

    public void editarRonda() throws Exception {
        System.out.println("rondaId: " + rondas.getIdRonda());
//        try {
//            ServiceFacadeLocator.getInstanceRonda().editarRonda(
////                    rondas.getIdRonda(), rondas.getRombre(), rondas.getTiempoEstimado(), rondas.getStatus(), fkIdHorarioSelected, fkIdServicioSelected);
////            System.out.println("Editado");
//        } catch (Exception ex) {
//            Logger.getLogger(RondasHelper2.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void eliminarRonda() {
        try {
            addMessage("Ronda Eliminada", "");
            ServiceFacadeLocator.getInstanceRonda().eliminarRonda(rondas.getIdRonda());
        } catch (Exception ex) {
        }
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getFkIdHorarioSelected() {
        return fkIdHorarioSelected;
    }

    public void setFkIdHorarioSelected(int fkIdHorarioSelected) {
        this.fkIdHorarioSelected = fkIdHorarioSelected;
    }

    public int getFkIdServicioSelected() {
        return fkIdServicioSelected;
    }

    public void setFkIdServicioSelected(int fkIdServicioSelected) {
        this.fkIdServicioSelected = fkIdServicioSelected;
    }

    public Rondas getRondas() {
        return rondas;
    }

    public void setRondas(Rondas rondas) {
        this.rondas = rondas;
    }

}
