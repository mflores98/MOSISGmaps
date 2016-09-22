/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Miguel
 */
public class RondasHelper implements Serializable {

    private String nombre;
    private String tiempoEstimando;
    private boolean Status;
    private int fkIdUsuario;
    private int fkIdServicio;

    private int idHoraio;
    private Date hora_inicial;
    private Date hora_final;

public void agregarRonda() {
            System.out.println(getNombre());
            System.out.println(getTiempoEstimando());
            System.out.println(isStatus());
            System.out.println(getFkIdUsuario());
            System.out.println(getFkIdServicio());
                        System.out.println("clic");

        try {

            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//MMM dd, yyyy HH:mm:ss a 16:00:00
            Date d = df.parse(getTiempoEstimando());
            ServiceFacadeLocator.getInstanceRonda().agregarRonda(getNombre(), d, isStatus(), getFkIdUsuario(), getFkIdServicio());
            System.out.println("almacenado");
        } catch (Exception e) {
            System.out.println("Erroror");
            System.out.println("Error: " + e);
        }
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the tiempoEstimando
     */
    public String getTiempoEstimando() {
        return tiempoEstimando;
    }

    /**
     * @param tiempoEstimando the tiempoEstimando to set
     */
    public void setTiempoEstimando(String tiempoEstimando) {
        this.tiempoEstimando = tiempoEstimando;
    }

    /**
     * @return the Status
     */
    public boolean isStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    /**
     * @return the fkIdUsuario
     */
    public int getFkIdUsuario() {
        return fkIdUsuario;
    }

    /**
     * @param fkIdUsuario the fkIdUsuario to set
     */
    public void setFkIdUsuario(int fkIdUsuario) {
        this.fkIdUsuario = fkIdUsuario;
    }

    /**
     * @return the fkIdServicio
     */
    public int getFkIdServicio() {
        return fkIdServicio;
    }

    /**
     * @param fkIdServicio the fkIdServicio to set
     */
    public void setFkIdServicio(int fkIdServicio) {
        this.fkIdServicio = fkIdServicio;
    }

    /**
     * @return the idHoraio
     */
    public int getIdHoraio() {
        return idHoraio;
    }

    /**
     * @param idHoraio the idHoraio to set
     */
    public void setIdHoraio(int idHoraio) {
        this.idHoraio = idHoraio;
    }

    /**
     * @return the hora_inicial
     */
    public Date getHora_inicial() {
        return hora_inicial;
    }

    /**
     * @param hora_inicial the hora_inicial to set
     */
    public void setHora_inicial(Date hora_inicial) {
        this.hora_inicial = hora_inicial;
    }

    /**
     * @return the hora_final
     */
    public Date getHora_final() {
        return hora_final;
    }

    /**
     * @param hora_final the hora_final to set
     */
    public void setHora_final(Date hora_final) {
        this.hora_final = hora_final;
    }
}
