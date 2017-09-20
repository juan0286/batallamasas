/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javapointers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author TiranoJuan
 */
@Controller
public class LoginController {

    @RequestMapping("loguear")
    public ModelAndView onSubmit(){
        ModelAndView mv = new ModelAndView();
        
        mv.setViewName("home");
        mv.addObject("", "");
        return mv;
    }

    
    
}

