package com.cerberosysBack.cerberosysBack.service;

import com.cerberosysBack.cerberosysBack.model.dto.ClienteDto;
import com.cerberosysBack.cerberosysBack.model.entity.Cliente;

public interface IClienteService {
	
	
	Cliente save(ClienteDto cliente);
	
	Cliente findById(Integer id);
	
	void delete(Cliente cliente);
	
	boolean existsById(Integer id);

}
