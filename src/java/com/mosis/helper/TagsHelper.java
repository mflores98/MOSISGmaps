/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.helper;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.delegate.DelegateEtiquetas;
import com.mosis.entity.CtoServicio;
import com.mosis.entity.Etiquetas;
import com.mosis.entity.Flujos;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Miguel
 */
public class TagsHelper implements Serializable {

    private DelegateEtiquetas delegateEtiquetas;

    private boolean update;

    public TagsHelper() {
        delegateEtiquetas = new DelegateEtiquetas();
    }

    public DelegateEtiquetas getDelegateEtiquetas() {
        return delegateEtiquetas;
    }

    public void setDelegateEtiquetas(DelegateEtiquetas delegateEtiquetas) {
        this.delegateEtiquetas = delegateEtiquetas;
    }

}
