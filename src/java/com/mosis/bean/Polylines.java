/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.bean;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Rutas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import org.primefaces.model.map.MapModel;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

/**
 *
 * @author Owner
 */
@ManagedBean
public class Polylines implements Serializable {

    private MapModel simpleModel;
    private Marker marker;

    @PostConstruct
    public void init() {

        try {
            simpleModel = new DefaultMapModel();

            List<LatLng> puntosA = new ArrayList<>();
            List<LatLng> puntosB = new ArrayList<>();
            List<Rutas> rutas = ServiceFacadeLocator.getInstanceRuta().getListaRutas();

            for (Rutas ruta : rutas) {
                //punto a
                LatLng latLngA = new LatLng(ruta.getFkIdEtiquetaA().getLatitud(), ruta.getFkIdEtiquetaA().getLongitud());
                //punto b
                LatLng latLngB = new LatLng(ruta.getFkIdEtiquetaB().getLatitud(), ruta.getFkIdEtiquetaB().getLongitud());
                puntosA.add(latLngA);
                puntosB.add(latLngB);
                simpleModel.addOverlay(new Marker(latLngA, "A"));
                simpleModel.addOverlay(new Marker(latLngB, "B"));
            }

            Polyline polyline = new Polyline();
            polyline.getPaths().addAll(puntosA);
            polyline.getPaths().addAll(puntosB);
            simpleModel.addOverlay(polyline);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void clicMarker(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        System.out.println("" + marker.getLatlng());
        
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "punto: lat: " + marker.getLatlng().getLat(), ", lng" + marker.getLatlng().getLng() + " " + marker.getTitle()));
    }

//    public static void main(String[] args) {
//        List<Rutas> rutas = ServiceFacadeLocator.getInstanceRuta().getListaRutas();
//        for (Rutas ruta : rutas) {
//            //punto a
//            System.out.println("lat A: " + ruta.getFkIdEtiquetaA().getLatitud() + " A lng: " + ruta.getFkIdEtiquetaA().getLongitud());
//            //punto b
//            System.out.println("lat B: " + ruta.getFkIdEtiquetaB().getLatitud() + " B lng: " + ruta.getFkIdEtiquetaB().getLongitud());
//        }
//    }
    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
