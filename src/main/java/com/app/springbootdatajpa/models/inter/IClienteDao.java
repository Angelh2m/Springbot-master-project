
package com.app.springbootdatajpa.models.inter;

import java.util.List;

import com.app.springbootdatajpa.models.entity.Cliente;

/**
 * IClienteDao
 */
public interface IClienteDao {

    public List<Cliente> findAll();

}

