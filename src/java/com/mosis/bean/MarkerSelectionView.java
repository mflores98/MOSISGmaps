/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.bean;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Etiquetas;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.primefaces.component.gmap.GMap;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.Circle;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Polyline;

/**
 *
 * @author Owner
 */
@ManagedBean
@ViewScoped
public class MarkerSelectionView implements Serializable {

    private MapModel simpleModel;

    private Marker marker;

    public Marker getMarker() {
        return marker;
    }

    @PostConstruct
    public void init() {

        simpleModel = new DefaultMapModel();

        //Shared coordinates
        List<Etiquetas> datos = ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
        List<LatLng> puntos = new ArrayList<>();
        for (Etiquetas punto : datos) {
            LatLng latLng = new LatLng(punto.getLatitud(), punto.getLongitud());
            puntos.add(latLng);
            simpleModel.addOverlay(new Marker(latLng, punto.getNombre(), punto.getValorTag()));
        }

        Polyline polyline = new Polyline();
        polyline.getPaths().addAll(puntos);
        polyline.setStrokeColor("#ff0000");
        polyline.setStrokeOpacity(0.7);
        simpleModel.addOverlay(polyline);

    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onClicMarker(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
//        System.out.println("seleccionado" + marker.getLatlng());
//        lat = marker.getLatlng().getLat();
//        lng = marker.getLatlng().getLng();

//        Polyline polyline = new Polyline();
//        
//        polyline.setStrokeWeight(15);
//        polyline.setStrokeColor("#FF9900");
//        polyline.setStrokeOpacity(0.7);
//        
//        polyline.getPaths().add(new LatLng(32.62453889999999, -115.45226230000003));
//        polyline.getPaths().add(new LatLng(32.6348353, -115.4116032));
//
////        polyline.getPaths().add(new LatLng(lat, lng));
//        simpleModel.addOverlay(polyline);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "Polyline Added", "Lat:" + marker.getLatlng().getLat()
                + ", Lng:" + marker.getLatlng().getLng()
                + ", Nombre:" + marker.getTitle()
                + ", Valor Tag: " + marker.getData()));

    }
}
