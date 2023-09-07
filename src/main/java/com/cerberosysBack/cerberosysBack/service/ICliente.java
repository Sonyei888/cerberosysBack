package com.cerberosysBack.cerberosysBack.service;

import com.cerberosysBack.cerberosysBack.model.entity.Cliente;

public interface ICliente {
	
	
	Cliente save(Cliente cliente);
	
	Cliente findById(Integer id);
	
	void delete(Cliente cliente);

}
