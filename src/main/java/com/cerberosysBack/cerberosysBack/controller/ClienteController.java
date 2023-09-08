package com.cerberosysBack.cerberosysBack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


import com.cerberosysBack.cerberosysBack.model.entity.Cliente;
import com.cerberosysBack.cerberosysBack.service.ICliente;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private ICliente clienteService;
	
	
	@PostMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@PutMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente) {
		return clienteService.save(cliente);
	}
	
	@DeleteMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Cliente clienteDelete = clienteService.findById(id);
		clienteService.delete(clienteDelete);
	}
	
	@GetMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente showById(@PathVariable Integer id) {
		return clienteService.findById(id);
	}
}
