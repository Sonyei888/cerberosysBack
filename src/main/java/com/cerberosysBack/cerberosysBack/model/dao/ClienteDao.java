package com.cerberosysBack.cerberosysBack.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.cerberosysBack.cerberosysBack.model.entity.Cliente;

public interface ClienteDao extends CrudRepository<Cliente, Integer>{
}
