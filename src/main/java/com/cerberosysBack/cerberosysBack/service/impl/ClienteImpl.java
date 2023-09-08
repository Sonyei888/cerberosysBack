package com.cerberosysBack.cerberosysBack.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cerberosysBack.cerberosysBack.model.dao.ClienteDao;
import com.cerberosysBack.cerberosysBack.model.entity.Cliente;
import com.cerberosysBack.cerberosysBack.service.ICliente;


@Service
public class ClienteImpl implements ICliente{
	

	@Autowired
	private ClienteDao clienteDao;
	
	@Transactional
	@Override
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Transactional(readOnly = true)
	@Override
	public Cliente findById(Integer id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Transactional
	@Override
	public void delete(Cliente cliente) {
		clienteDao.delete(cliente);
	}
	
	
	

}
