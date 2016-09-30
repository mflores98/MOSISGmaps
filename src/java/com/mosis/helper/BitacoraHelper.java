/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.entity.BitacoraRonda;
import java.io.Serializable;

/**
 *
 * @author Miguel
 */
public class BitacoraHelper implements Serializable {

    private BitacoraRonda bitacoraRonda;
    private int idServicioSelected;
    

    public BitacoraHelper() {
        bitacoraRonda = new BitacoraRonda();
    }

    public BitacoraRonda getBitacoraRonda() {
        return bitacoraRonda;
    }

    public void setBitacoraRonda(BitacoraRonda bitacoraRonda) {
        this.bitacoraRonda = bitacoraRonda;
    }

    public int getIdServicioSelected() {
        return idServicioSelected;
    }

    public void setIdServicioSelected(int idServicioSelected) {
        this.idServicioSelected = idServicioSelected;
    }
    

}
