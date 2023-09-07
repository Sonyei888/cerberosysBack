package com.cerberosysBack.cerberosysBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cerberosysBack.cerberosysBack.model.entity.Cliente;
import com.cerberosysBack.cerberosysBack.service.ICliente;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private ICliente clienteService;
	
	public Cliente create(Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	public Cliente update(Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	public void delete(Integer id) {
		Cliente clienteDelete = clienteService.findById(id);
		clienteService.delete(clienteDelete);
	}
	
	public Cliente showById(Integer id) {
		return clienteService.findById(id);
	}
}
