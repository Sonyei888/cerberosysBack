package com.example.demo.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositorio.ClienteRepositorio;
import com.example.demo.exepciones.ResourceNotFoundException;
import com.example.demo.modelo.Cliente;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ClienteControlador {

	@Autowired
	private ClienteRepositorio repositorio;

	@GetMapping("/clientes")
	public List<Cliente> listarTodosLosClientes() {
		return repositorio.findAll();
	}
	
	//guardar empleado
	@PostMapping("/clientes")
	public Cliente guardarCliente(@RequestBody Cliente cliente) {
		return repositorio.save(cliente);
	}
	
	//Buscar un empleado por id
	@GetMapping("/clientes/{id}")
	public ResponseEntity<Cliente> obtenerClientePorId(@RequestBody Long id){
		Cliente cliente = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID: " + id));
		return ResponseEntity.ok(cliente);
	}
	
	
	@PutMapping("/clientes/{id}")
	public ResponseEntity<Cliente> actualizarCliente(@RequestBody Long id, @RequestBody Cliente detallesCliente){
		Cliente cliente = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe el cliente con el ID: " + id));
		
		cliente.setNombre(detallesCliente.getNombre());
		cliente.setApellido(detallesCliente.getApellido());
		cliente.setEmail(detallesCliente.getEmail());
		cliente.setFecha_registro(detallesCliente.getFecha_registro());
		
		Cliente clienteActualizado = repositorio.save(cliente);
		return ResponseEntity.ok(clienteActualizado);
	}
}
