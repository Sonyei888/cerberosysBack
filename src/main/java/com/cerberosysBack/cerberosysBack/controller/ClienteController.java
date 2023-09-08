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
import com.cerberosysBack.cerberosysBack.model.payload.MensajeResponse;
import com.cerberosysBack.cerberosysBack.service.IClienteService;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	
	@PostMapping("cliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> create(@RequestBody ClienteDto clienteDto) {
		Cliente  clienteSave = null;
		try {
			clienteSave = clienteService.save(clienteDto);
			clienteDto = ClienteDto.builder()
					.idCliente(clienteSave.getIdCliente())
					.nombre(clienteSave.getNombre())
					.apellido(clienteSave.getApellido())
					.correo(clienteSave.getCorreo())
					.fechaRegistro(clienteSave.getFechaRegistro())
					.build();
			
		
			return new ResponseEntity<>(
					MensajeResponse.builder()
					.mensaje("Guardado correctamente")
					.object(clienteDto)
					.build()
					, HttpStatus.CREATED
			);
		}catch(DataAccessException exDt) {
			return new ResponseEntity<>(
					MensajeResponse.builder()
						.mensaje(exDt.getMessage())
						.object(null)
						.build()
					, HttpStatus.METHOD_NOT_ALLOWED);
		}
		
	} 
	
	@PutMapping("cliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@RequestBody ClienteDto clienteDto, @PathVariable Integer id){
		Cliente clienteupdate = null;
		try {
			
			if(clienteService.existsById(id)) {
				clienteDto.setIdCliente(id);
				clienteupdate = clienteService.save(clienteDto);
				clienteDto = ClienteDto.builder()
						.idCliente(clienteupdate.getIdCliente())
						.nombre(clienteupdate.getNombre())
						.apellido(clienteupdate.getApellido())
						.correo(clienteupdate.getCorreo())
						.fechaRegistro(clienteupdate.getFechaRegistro())
						.build();
					return new ResponseEntity<>(
						MensajeResponse.builder()
						.mensaje("Guardado correctamente")
						.object(clienteDto)
						.build()
						, HttpStatus.CREATED
				);
			}else {
				return new ResponseEntity<>(
						MensajeResponse.builder()
							.mensaje("El registro que intenta actualizar no se encuentra en la base de datos")
							.object(null)
							.build()
						, HttpStatus.NOT_FOUND);
				
			}
		}catch(DataAccessException exDt) {
			return new ResponseEntity<>(
					MensajeResponse.builder()
						.mensaje(exDt.getMessage())
						.object(null)
						.build()
					, HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@DeleteMapping("cliente/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		try {
			Cliente clienteDelete = clienteService.findById(id);
			clienteService.delete(clienteDelete);
			return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
		}catch(DataAccessException exDt) {
			
			return new ResponseEntity<>(
					MensajeResponse.builder()
						.mensaje(exDt.getMessage())
						.object(null)
						.build()
					, HttpStatus.METHOD_NOT_ALLOWED);
		}
	}
	
	@GetMapping("cliente/{id}")
	public ResponseEntity<?> showById(@PathVariable Integer id) {
		Cliente  cliente = clienteService.findById(id);
		
		if(cliente == null) {
			return new ResponseEntity<>(
					MensajeResponse.builder()
						.mensaje("El registro que intenta buscar, no existe!!! ")
						.object(null)
						.build()
					, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				MensajeResponse.builder()
					.mensaje("")
					.object(ClienteDto.builder()
							.idCliente(cliente.getIdCliente())
							.nombre(cliente.getNombre())
							.apellido(cliente.getApellido())
							.correo(cliente.getCorreo())
							.fechaRegistro(cliente.getFechaRegistro())
							.build())
					.build()
				, HttpStatus.OK);
	}
}
