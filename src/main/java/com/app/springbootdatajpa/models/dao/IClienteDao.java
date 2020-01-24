package com.app.springbootdatajpa.models.dao;

import java.util.List;

import com.app.springbootdatajpa.models.entity.Cliente;

/**
 * IClienteDao
 */
public interface IClienteDao {

    public List<Cliente> findAll();

}