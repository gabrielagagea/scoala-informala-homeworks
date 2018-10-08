package com.si.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OrganizationController {

    public OrganizationController() {
    }
    @RequestMapping(
            value = "/home",
            method = RequestMethod.GET
    )
    public String getHome(Model model, HttpServletRequest request) {
        System.out.println("Get home");
        return "home";
    }
}
