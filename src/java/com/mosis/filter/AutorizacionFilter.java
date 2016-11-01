///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.mosis.filter;
//
//import com.mosis.entity.Usuarios;
//import com.mosis.ui.UsuarioUILogin;
//import java.io.IOException;
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// *
// * @author Miguel
// */
//@WebFilter("*.xhtml")
//public class AutorizacionFilter implements Filter {
//
//////    private UsuarioUILogin uuil;
//    private Usuarios usuario;
//
//    public AutorizacionFilter() {
//    }
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        //usuario.getUserName() != null && 
//        if (usuario.getUserName().isEmpty()
//                && !request.getRequestURI().endsWith("/usuarioLogin.xhtml")
//                && !request.getRequestURI().contains("/javax.faces.resource/")) {
//            response.sendRedirect(request.getContextPath() + "/usuarioLogin.xhtml");
//        } else {
//            //si esta logeado 
//            chain.doFilter(req, resp);
//        }
//    }
//    @Override
//    public void destroy() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
