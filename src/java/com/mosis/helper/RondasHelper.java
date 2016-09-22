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
            System.out.println(nombre);
            System.out.println(tiempoEstimando);
            System.out.println(Status);
            System.out.println(fkIdUsuario);
            System.out.println(fkIdServicio);
                        System.out.println("clic");

        try {

            SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//MMM dd, yyyy HH:mm:ss a 16:00:00
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM dd,  HH:mm:ss");
            Date d = df.parse(tiempoEstimando);
            ServiceFacadeLocator.getInstanceRonda().agregarRonda(nombre, d, Status, fkIdUsuario, fkIdServicio);
            System.out.println("almacenado");
        } catch (Exception e) {
            System.out.println("Erroror");
            System.out.println("Error: " + e);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempoEstimando() {
        return tiempoEstimando;
    }

    public void setTiempoEstimando(String tiempoEstimando) {
        this.tiempoEstimando = tiempoEstimando;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
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

}
