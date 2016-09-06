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
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.eclipse.jdt.internal.compiler.lookup.TypeConstants;
import org.primefaces.component.gmap.GMap;
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
//    private MapModel polylineModel;

//    public MapModel getPolylineModel() {
//        return polylineModel;
//    }
//
//    public void setPolylineModel(MapModel polylineModel) {
//        this.polylineModel = polylineModel;
//    }

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
        }

        for (LatLng punto : puntos) {
            simpleModel.addOverlay(new Marker(punto));
        }
    }

    public MapModel getSimpleModel() {
        return simpleModel;
    }
    private LinkedList linkedList;

    public void trazarPoly() {
        try {
            simpleModel = new DefaultMapModel();

            List<Etiquetas> datos = ServiceFacadeLocator.getInstanceEtiquetas().getAllEtiquetas();

            List<LatLng> puntos = new ArrayList<>();
            for (Etiquetas dato : datos) {
                LatLng latLng = new LatLng(dato.getLatitud(), dato.getLongitud());
                puntos.add(latLng);
            }

            //Polyline
            Polyline polyline = new Polyline();

            polyline.getPaths().addAll(puntos);

            polyline.setStrokeWeight(10);
            polyline.setStrokeColor("#FF9900");
            polyline.setStrokeOpacity(0.7);

            simpleModel.addOverlay(polyline);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        Etiquetas etiquetas = new Etiquetas();
        LinkedList list = new LinkedList();

        marker = (Marker) event.getOverlay();
        try {
            if (marker != null) {
                linkedList = new LinkedList();
                linkedList.add(marker.getLatlng());
                list.add(linkedList);
            }
            System.out.println(list.poll());

//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Marker Selected: ", marker.getTitle()));
///////////////////////////////////////////
//            try {
//                polylineModel = new DefaultMapModel();
//                Polyline polyline = new Polyline();
//                if (marker != null) {
//                    LatLng latLng = new LatLng(marker.getLatlng().getLat(), marker.getLatlng().getLng());
//                    polyline.getPaths().add(latLng);
//                    polyline.setStrokeWeight(10);
//                    polyline.setStrokeColor("#FF9900");
//                    polyline.setStrokeOpacity(0.7);
//                    polylineModel.addOverlay(polyline);
//                    System.out.println("marker");
//                }
//            } catch (Exception e) {
//                System.out.println("error");
//            }

///////////////////////////////////////////
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
            e.getStackTrace();
        }
    }

}
