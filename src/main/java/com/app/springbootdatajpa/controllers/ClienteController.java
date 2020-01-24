package com.app.springbootdatajpa.controllers;

import java.util.Map;

import javax.validation.Valid;

import com.app.springbootdatajpa.models.entity.Cliente;
import com.app.springbootdatajpa.models.inter.IClienteDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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

         /**
         *  *  *  ------------------ STEPS ----------------------
         *  1 .- INTERFACE -- blueprint
         *  2.- DAO -- Create the EntityManager ==> DB ACTION 
         *  3.- ENTITY -- Serilize to save in DB
         */
        model.addAttribute("title", "listado de clientes");
        model.addAttribute("clientes", clienteDao.findAll());

        System.out.println( clienteDao.findAll());

        return "listar";
    }

    @RequestMapping(value="/form")
    public String crear(Map<String, Object> model) {
        
        Cliente cliente = new Cliente();

        model.put("cliente", cliente);
        model.put("titulo", "Formulario del cliente");
        
        return "form";
    }


    @RequestMapping(value="/form", method=RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model) {

        
        if (result.hasErrors()) {
            model.addAttribute("titulo", "Formulario del cliente");
            return "form";
        }

        clienteDao.save(cliente);
        return "redirect:listar";
    }


    @RequestMapping(value="/form/{id}")
    public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {

        Cliente cliente =  null;

        if (id>0) {
            cliente = clienteDao.findOne(id);
        }else{
            return "redirect:/listar";
        }
         
        model.put("cliente", cliente);
        model.put("titulo", "Editar cliente");


        return "form";
    }

    @RequestMapping(value="/eliminar/{id}")
    public String eliminar(@PathVariable(value="id") Long id) {

        if (id>0) {
            clienteDao.delete(id);
        }
        return "redirect:/listar";
    }
    
}