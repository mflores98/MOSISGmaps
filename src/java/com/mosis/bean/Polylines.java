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
    private int idRonda;

    public int getIdRonda() {
        return idRonda;
    }

    public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public void marcar() {

        simpleModel = new DefaultMapModel();

        List<LatLng> puntosA = new ArrayList<>();
        List<LatLng> puntosB = new ArrayList<>();

        // List<Rutas> rutas = ServiceFacadeLocator.getInstanceRuta().getListaRutas();
        //  List<Rutas> rutas = ServiceFacadeLocator.getInstanceRuta().getRutasByRondaID(idRonda);//rutas por id Ronda
        List<Rutas> rutas = ServiceFacadeLocator.getInstanceRuta().getRutasByRonda(idRonda);

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
        polyline.setStrokeWeight(10);
        polyline.setStrokeColor("#ff0000");
        polyline.setStrokeOpacity(0.7);
        simpleModel.addOverlay(polyline);
    }

//    @PostConstruct
//    public void init() {
//
//        
//
//////            Rutas r = ServiceFacadeLocator.getInstanceRuta().getRuta(1);
////            List<Rutas> rutas = ServiceFacadeLocator.getInstanceRuta().getRutasByRondaID(1);//rutas por id Ronda    
////            Polyline polyline = null;
////
////            for (Rutas r : rutas) {
////                simpleModel.addOverlay(new Marker(new LatLng(r.getFkIdEtiquetaA().getLatitud(), r.getFkIdEtiquetaA().getLongitud())));
////                simpleModel.addOverlay(new Marker(new LatLng(r.getFkIdEtiquetaB().getLatitud(), r.getFkIdEtiquetaB().getLongitud())));
////                polyline = new Polyline();
////                polyline.getPaths().add(new LatLng(r.getFkIdEtiquetaA().getLatitud(), r.getFkIdEtiquetaA().getLongitud()));
////                polyline.getPaths().add(new LatLng(r.getFkIdEtiquetaB().getLatitud(), r.getFkIdEtiquetaB().getLongitud()));
//// 
////            }
//////            simpleModel.addOverlay(new Marker(new LatLng(rutas.getFkIdEtiquetaA().getLatitud(), rutas.getFkIdEtiquetaA().getLongitud()), "A"));
//////            simpleModel.addOverlay(new Marker(new LatLng(rutas.getFkIdEtiquetaB().getLatitud(), rutas.getFkIdEtiquetaB().getLongitud()), "B"));
////
////            polyline.setStrokeWeight(10);
////            polyline.setStrokeColor("#ff0000");
////            polyline.setStrokeOpacity(0.7);
////            simpleModel.addOverlay(polyline);
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//        }
//    }
    public MapModel getSimpleModel() {
        return simpleModel;
    }

    public void clicMarker(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
        System.out.println("" + marker.getLatlng());

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
                "punto: lat: " + marker.getLatlng().getLat(), ", lng" + marker.getLatlng().getLng() + " " + marker.getTitle()));
    }

    public Marker getMarker() {
        return marker;
    }

    public void setMarker(Marker marker) {
        this.marker = marker;
    }
}
