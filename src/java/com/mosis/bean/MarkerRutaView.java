/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.model.map.MapModel;
import javax.annotation.PostConstruct;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.Polyline;

/**
 *
 * @author Owner
 */
@ManagedBean
@RequestScoped
public class MarkerRutaView implements Serializable {

    private MapModel mapModel;

    /**
     * Creates a new instance of MarkerRutaView
     */
    public MarkerRutaView() {
    }

    public MapModel getMapModel() {
        return mapModel;
    }

    public void setMapModel(MapModel mapModel) {
        this.mapModel = mapModel;
    }

    @PostConstruct
    public void init() {
        mapModel = new DefaultMapModel();
    }

    //ir creando los polylines
    public void addPolyline() {
        Polyline polyline = new Polyline();
        //polyline.getPaths().add(new LatLng(lat, lng));
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#FF9900");
        polyline.setStrokeOpacity(0.7);
        mapModel.addOverlay(polyline);

//        FacesContext.getCurrentInstance().addMessage( FacesContext.getCurrentInstance().addMessage(null null, , new new  FacesMessage(FacesMessage.SEVERITY_INFO, FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Added" "Marker Added", , "Lat:" "Lat:"  + lat + + lat + ", Lng:" ", Lng:"  + lng)); + lng));  
    }

}
