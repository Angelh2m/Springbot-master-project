
package com.app.springbootdatajpa.models.inter;

import java.util.List;

import com.app.springbootdatajpa.models.entity.Cliente;

/**
 * IClienteDao
 *  *  *  ------------------ EXPLANATION ----------------------
 *  Interface is just the contract
 */
public interface IClienteDao {

    public List<Cliente> findAll();

    public void save(Cliente cliente);

    public Cliente findOne(Long id);

    public void delete(Long id);

}

