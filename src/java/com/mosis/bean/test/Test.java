/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.bean.test;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Rutas;

/**
 *
 * @author Owner
 */
public class Test {
    public static void main(String[] args) {
        Rutas ruta=ServiceFacadeLocator.getInstanceRuta().getRuta(1);
        
        System.out.println("latitud: "+ruta.getFkIdEtiquetaA().getLatitud());
        System.out.println("longitud: "+ruta.getFkIdEtiquetaA().getLongitud());
        
        System.out.println("latitud: "+ruta.getFkIdEtiquetaB().getLatitud());
        System.out.println("longitud: "+ruta.getFkIdEtiquetaB().getLongitud());
    }
}
