package com.app.springbootdatajpa.controllers;

import com.app.springbootdatajpa.models.dao.IClienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClienteController
 */
@Controller
public class ClienteController {

    @Autowired
    @Qualifier("clienteDaoJPA")
    private IClienteDao clienteDao;


    @RequestMapping(value = "/listar", method=RequestMethod.GET)
    public String listar(Model model) {

        model.addAttribute("title", "listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());

        System.out.println( clienteDao.findAll());

        return "listar";
    }
    
}