/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Etiquetas;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author grafo
 */
public class EtiquetaHelper implements Serializable {

    public EtiquetaHelper() {

    }

    public List<Etiquetas> getEtiquetas() {
        return ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
    }
//    public Etiquetas selectAlumno(int id) {
//        return ServiceFacadeLocator.getFacadeAlumno().getAlumno(id);
//    }
}
