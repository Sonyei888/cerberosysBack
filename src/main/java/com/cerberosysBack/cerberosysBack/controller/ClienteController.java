package com.cerberosysBack.cerberosysBack.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
import org.springframework.http.ResponseEntity;

import com.cerberosysBack.cerberosysBack.model.dto.ClienteDto;
import com.cerberosysBack.cerberosysBack.model.entity.Cliente;
import com.cerberosysBack.cerberosysBack.service.ICliente;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private ICliente clienteService;
	
	
	@PostMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto create(@RequestBody ClienteDto clienteDto) {
		Cliente  clienteSave = clienteService.save(clienteDto);
		return ClienteDto.builder()
		.idCliente(clienteSave.getIdCliente())
		.nombre(clienteSave.getNombre())
		.apellido(clienteSave.getApellido())
		.correo(clienteSave.getCorreo())
		.fechaRegistro(clienteSave.getFechaRegistro())
		.build();
	}
	
	@PutMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteDto update(@RequestBody ClienteDto clienteDto) {
		Cliente  clienteuptade = clienteService.save(clienteDto);
		return ClienteDto.builder()
		.idCliente(clienteuptade.getIdCliente())
		.nombre(clienteuptade.getNombre())
		.apellido(clienteuptade.getApellido())
		.correo(clienteuptade.getCorreo())
		.fechaRegistro(clienteuptade.getFechaRegistro())
		.build();
	}
	
	@DeleteMapping("cliente/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		Map<String, Object> response = new HashMap<>();
		try {
			Cliente clienteDelete = clienteService.findById(id);
			clienteService.delete(clienteDelete);
			return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
		}catch(DataAccessException exDt) {
			response.put("mensaje", exDt.getMessage());
			response.put("cliente", null);
			
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ClienteDto showById(@PathVariable Integer id) {
		Cliente  cliente = clienteService.findById(id);
		return ClienteDto.builder()
				.idCliente(cliente.getIdCliente())
				.nombre(cliente.getNombre())
				.apellido(cliente.getApellido())
				.correo(cliente.getCorreo())
				.fechaRegistro(cliente.getFechaRegistro())
				.build();
	}
}
