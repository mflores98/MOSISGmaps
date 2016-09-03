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
import org.primefaces.event.map.OverlaySelectEvent;
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
    private MapModel polylineModel;

    public MapModel getPolylineModel() {
        return polylineModel;
    }

    public void setPolylineModel(MapModel polylineModel) {
        this.polylineModel = polylineModel;
    }

    private Marker marker;

    @PostConstruct
    public void init() {

        simpleModel = new DefaultMapModel();

        //Shared coordinates
        List<Etiquetas> datos = ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();
        List<LatLng> puntos = new ArrayList<>();

        for (Etiquetas punto : datos) {
            LatLng latLng = new LatLng(punto.getLatitud(), punto.getLongitud());
            puntos.add(latLng);
        }

        for (LatLng punto : puntos) {
            simpleModel.addOverlay(new Marker(punto));
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        try {

            marker = (Marker) event.getOverlay();

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected", marker.getTitle()));
            System.out.println("seleccionado: " + marker.getLatlng());

            polylineModel = new DefaultMapModel();
            Polyline polyline = new Polyline();
            LatLng latLng = new LatLng(marker.getLatlng().getLat(), marker.getLatlng().getLng());
            polyline.getPaths().add(latLng);
            polyline.setStrokeWeight(10);
            polyline.setStrokeColor("#FF9900");
            polyline.setStrokeOpacity(0.7);

            polylineModel.addOverlay(polyline);

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            e.getStackTrace();
        }
    }

    public Marker getMarker() {
        return marker;
    }
}
