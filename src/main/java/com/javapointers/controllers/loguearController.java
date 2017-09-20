/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javapointers.controllers;

import com.websystique.spring.HibernateDao;
import com.websystique.spring.model.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TiranoJuan
 */
@SessionAttributes("usuarioLogueado")
@Controller
public class loguearController {
    
//    @Autowired
//    private AlumnoDao dao;
    
//    @RequestMapping(method = RequestMethod.GET)
//    public String mostrarAlumno(){     
//        return "buscar";   
//    }

    
//    @RequestMapping("loguear")
//    public ModelAndView onSubmit(){
//        ModelAndView mv = new ModelAndView();
//        
//        mv.setViewName("home");
//        mv.addObject("", "");
//        return mv;
//    }
    
    @RequestMapping(value="/ingresar", method = {RequestMethod.GET, RequestMethod.POST})    
    public ModelAndView validarLogin(      
            @RequestParam("username") String usuario,
            @RequestParam("password") String password ){
            
            ModelAndView model = null;
            String vacio = "Escriba un nombre de usuario y contraseña.";
            String incorrecto = "El usuario y/o la contraseña introducida no es correcta.";           
            
            
            if (usuario.trim().equals("")) {
                model = new ModelAndView("login");
                model.addObject("errorDetail", vacio);
                        //.addAttribute("errorDetail", vacio);
                model.setViewName("errorLogin");
            }
            
            Jugador j = HibernateDao.obtenerPersonajePorUsuario(usuario);
            if (j.equals(null)){
                model = new ModelAndView("login");
                model.addObject("errorDetail", incorrecto);
                model.setViewName("errorLogin");
            }
            
            if (!j.getPassword().equals(password)){
                model.addObject("errorDetail", incorrecto);
                model.setViewName("errorLogin");
            } else {
                model = new ModelAndView("home");                
                model.addObject("usuarioLogueado",j);
                //request.setAttribute("loggedInUser", j.getNombre_usuario());
            }
            
                
            model.setViewName("home");
            return model;  
    }
    
    
}
