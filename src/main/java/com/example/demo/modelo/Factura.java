package com.example.demo.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "facturas")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nombre_empresa", length = 100, nullable = false)
	private String nombreEmpresa;

	@Column(name = "nombre_cliente", length = 100, nullable = false)
	private String nombreCliente;

	@Column(name = "telefono", length = 15, nullable = false)
	private String telefono;

	@Column(name = "fecha_compra", nullable = false)
	private String fechaCompra;

	@Column(name = "precio_producto", nullable = false)
	private double precioProducto;

	@Column(name = "numero_factura", nullable = false)
	private String numeroFactura;

	@Column(name = "nombre_producto", length = 100, nullable = false)
	private String nombreProducto;

	@Column(name = "precio_total", nullable = false)
	private double precioTotal;

	public Factura() {
	}

	public Factura(Long id, String nombreEmpresa, String nombreCliente, String telefono, String fechaCompra,
			double precioProducto, String numeroFactura, String nombreProducto, double precioTotal) {
		this.id = id;
		this.nombreEmpresa = nombreEmpresa;
		this.nombreCliente = nombreCliente;
		this.telefono = telefono;
		this.fechaCompra = fechaCompra;
		this.precioProducto = precioProducto;
		this.numeroFactura = numeroFactura;
		this.nombreProducto = nombreProducto;
		this.precioTotal = precioTotal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(String fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

}
