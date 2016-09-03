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
import javax.faces.context.FacesContext;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Polyline;

@ManagedBean
public class PolylinesView implements Serializable {

    private MapModel polylineModel;

    @PostConstruct
    public void init() {
        try {

            polylineModel = new DefaultMapModel();

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

            polylineModel.addOverlay(polyline);
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public MapModel getPolylineModel() {
        return polylineModel;
    }

    public void onPolylineSelect(OverlaySelectEvent event) {
      
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Polyline Selected", null));
    }
}
