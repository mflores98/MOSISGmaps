/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.CtoServicio;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class RondasHelper implements Serializable {

    private String nombre;
    private Date tiempoEstimando;
    private Boolean Status;
    private int fkIdUsuario;
    private int fkIdServicio;

    private int idHoraio;
    private Date hora_inicial;
    private Date hora_final;

    public int getIdHoraio() {
        return idHoraio;
    }

    public void setIdHoraio(int idHoraio) {
        this.idHoraio = idHoraio;
    }

    public Date getHora_inicial() {
        return hora_inicial;
    }

    public void setHora_inicial(Date hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    public Date getHora_final() {
        return hora_final;
    }

    public void setHora_final(Date hora_final) {
        this.hora_final = hora_final;
    }

    public RondasHelper() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getTiempoEstimando() {
        return tiempoEstimando;
    }

    public void setTiempoEstimando(Date tiempoEstimando) {
        this.tiempoEstimando = tiempoEstimando;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean Status) {
        this.Status = Status;
    }

    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    public int getFkIdServicio() {
        return fkIdServicio;
    }

    public void setFkIdServicio(int fkIdServicio) {
        this.fkIdServicio = fkIdServicio;
    }

    public void agregarRonda() throws Exception {
        try {
            ServiceFacadeLocator.getInstanceRonda().agregarRonda(nombre, tiempoEstimando, Status, fkIdUsuario, fkIdServicio);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

}
