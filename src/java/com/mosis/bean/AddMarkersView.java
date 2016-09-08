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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.Polyline;

/**
 *
 * @author Owner
 */
@ManagedBean
@ViewScoped
public class AddMarkersView implements Serializable {

    private MapModel emptyModel;
    private Marker marker;

    private String title;

    private double lat;

    private double lng;

    @PostConstruct
    public void init() {
        emptyModel = new DefaultMapModel();
        System.out.println("Entra denuevo");
        List<Etiquetas> datos = ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
        List<LatLng> puntos = new ArrayList<>();
        for (Etiquetas punto : datos) {
            LatLng latLng = new LatLng(punto.getLatitud(), punto.getLongitud());
            puntos.add(latLng);
            emptyModel.addOverlay(new Marker(latLng, punto.getNombre(), punto.getValorTag()));
        }

    }

    public MapModel getEmptyModel() {
        return emptyModel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    /**
     * @param event
     */
    public void clicMarker(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        System.out.println("clic: " + marker.getLatlng());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Clic en Marker", "Nombre:" + marker.getTitle()));
    }

    public void addMarker() {
        Marker marker = new Marker(new LatLng(lat, lng), title);
        emptyModel.addOverlay(marker);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added", "Lat:" + lat + ", Lng:" + lng));
        /*
         clic: Lat:32.62453889999999, Lng:-115.45226230000003
         clic: Lat:32.62, Lng:-115.452262
         */
        Polyline polyline = new Polyline();
//        polyline.getPaths().add(marker.getLatlng());
        polyline.getPaths().add(new LatLng(32.62453889999999, -115.45226230000003));
        polyline.getPaths().add(new LatLng(32.62, -115.452262));

        
        polyline.setStrokeWeight(15);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);

        emptyModel.addOverlay(polyline);

    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
