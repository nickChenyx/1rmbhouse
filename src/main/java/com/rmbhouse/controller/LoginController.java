package com.rmbhouse.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by nickChenyx on 2017/4/14.
 */
public class LoginController implements Controller {
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response){
        String passToken = request.getParameter("passToken");
        if ("pass".equals(passToken)){
            request.getSession().setAttribute("passToken","passToken123");
            ModelAndView modelAndView = new ModelAndView("index");
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }
    }
}
