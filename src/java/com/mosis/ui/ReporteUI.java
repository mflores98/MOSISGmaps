/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mosis.ui;

import com.mosis.business.integration.ServiceFacadeLocator;
import com.mosis.entity.Empleado;
import com.mosis.entity.Persona;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author Miguel
 */
@ManagedBean
@RequestScoped
public class ReporteUI {

    private Empleado empleado;

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ReporteUI() {
        empleado = new Empleado();
        empleado.setFkIdPersona(new Persona());
    }

    public List<Empleado> getListaEmpleados() {
        return ServiceFacadeLocator.getInstanceEmpleado().getListEmpleados();
    }

    public void testReportePdf() {
        try {
            System.out.println("Test REsporte pdf");
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("numeroEmpleado", "numEmp");

           
             File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteEmpleado.jasper"));
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),
                    null,
                    new JRBeanCollectionDataSource(this.getListaEmpleados()));

            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.addHeader("Content-disposition", "attachment; filename=report.pdf");

            ServletOutputStream stream = response.getOutputStream();

            JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

            stream.flush();

            stream.close();

            FacesContext.getCurrentInstance().responseComplete();
        } catch (JRException ex) {
            Logger.getLogger(ReporteUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReporteUI.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void testReporteExcel() throws IOException, JRException {
        System.out.println("Test REsporte excel");
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("numeroEmpleado", "numEmp");

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteEmpleado.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(),
                null,
                new JRBeanCollectionDataSource(this.getListaEmpleados()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setHeader("Content-disposition", "attachment; jsfResporte.xls");

        ServletOutputStream stream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();

    }

    public void verPDf() throws IOException, JRException {
        System.out.println("ver pedf");
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reporteEmpleado.jasper"));//jasper que esta fuera
        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, new JRBeanCollectionDataSource(this.getListaEmpleados()));

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);

        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(bytes, 0, bytes.length);
        outputStream.flush();
        outputStream.close();
        FacesContext.getCurrentInstance().responseComplete();

    }

}
