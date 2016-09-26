/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Miguel
 */
public class RondasHelper2 implements Serializable {

    private int idRonda;
    private String nombreRonda;
    private Date tiempoEstimado;
    private boolean status;
    private int fkIdHorario;
    private int fkIdServicio;

    public RondasHelper2() {
    }

    public void insertarRonda() throws Exception {
        try {
//            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//MMM dd, yyyy HH:mm:ss a 16:00:00
//            Date d = df.parse(tiempoEstimado);
            ServiceFacadeLocator.getInstanceRonda().agregarRonda(nombreRonda, tiempoEstimado, status, fkIdHorario, fkIdServicio);
        } catch (ParseException ex) {
            Logger.getLogger(RondasHelper2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarRonda(int id) throws Exception {
        try {
//            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//MMM dd, yyyy HH:mm:ss a 16:00:00
//            Date d = df.parse(tiempoEstimado);
            ServiceFacadeLocator.getInstanceRonda().editarRonda(id, nombreRonda, tiempoEstimado, status, fkIdHorario, fkIdServicio);
        } catch (Exception ex) {
            System.out.println("Editado");
            Logger.getLogger(RondasHelper2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarRonda(int id) {
        try {
            ServiceFacadeLocator.getInstanceRonda().eliminarRonda(id);
        } catch (Exception ex) {
            //Logger.getLogger(RondasHelper2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNombreRonda() {
        return nombreRonda;
    }

    public void setNombreRonda(String nombreRonda) {
        this.nombreRonda = nombreRonda;
    }

    public Date getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setTiempoEstimado(Date tiempoEstimado) {
        this.tiempoEstimado = tiempoEstimado;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getFkIdHorario() {
        return fkIdHorario;
    }

    public void setFkIdHorario(int fkIdHorario) {
        this.fkIdHorario = fkIdHorario;
    }

    public int getFkIdServicio() {
        return fkIdServicio;
    }

    public void setFkIdServicio(int fkIdServicio) {
        this.fkIdServicio = fkIdServicio;
    }

}
