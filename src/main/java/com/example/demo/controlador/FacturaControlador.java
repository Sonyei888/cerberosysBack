package com.example.demo.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repositorio.FacturaRepositorio;
import com.example.demo.exepciones.ResourceNotFoundException;
import com.example.demo.modelo.Factura;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class FacturaControlador {

	@Autowired
	private FacturaRepositorio repositorio;

	@GetMapping("/facturas")
	public List<Factura> listarTodasLasFacturas() {
		return repositorio.findAll();
	}
	
	@PostMapping("/facturas")
	public Factura guardarFactura(@RequestBody Factura factura) {
		return repositorio.save(factura);
	}
	
	@GetMapping("/facturas/{id}")
	public ResponseEntity<Factura> obtenerFacturaPorId(@PathVariable Long id){
		Factura factura = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la factura con el ID: " + id));
		return ResponseEntity.ok(factura);
	}
	
	@PutMapping("/facturas/{id}")
	public ResponseEntity<Factura> actualizarFactura(@PathVariable Long id, @RequestBody Factura detallesFactura){
		Factura factura = repositorio.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No existe la factura con el ID: " + id));
		
		factura.setNombreEmpresa(detallesFactura.getNombreEmpresa());
		factura.setNombreCliente(detallesFactura.getNombreCliente());
		factura.setTelefono(detallesFactura.getTelefono());
		factura.setFechaCompra(detallesFactura.getFechaCompra());
		factura.setPrecioProducto(detallesFactura.getPrecioProducto());
		factura.setNumeroFactura(detallesFactura.getNumeroFactura());
		factura.setNombreProducto(detallesFactura.getNombreProducto());
		factura.setPrecioTotal(detallesFactura.getPrecioTotal());
		
		Factura facturaActualizada = repositorio.save(factura);
		return ResponseEntity.ok(facturaActualizada);
	}
	
	@DeleteMapping("/facturas/{id}")
	public ResponseEntity<Map<String, Boolean>> eliminarFactura(@PathVariable Long id){
		Factura factura = repositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe la factura con el ID : " + id));
			
		repositorio.delete(factura);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
	}
}
