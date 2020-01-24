package com.app.springbootdatajpa.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.app.springbootdatajpa.models.entity.Cliente;
import com.app.springbootdatajpa.models.inter.IClienteDao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClienteDaoImpl
 */
@Repository("clienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly=true)
    @Override
    public List<Cliente> findAll() {
        // TODO Auto-generated method stub
        return em.createQuery("from Cliente").getResultList();
    }

    
}