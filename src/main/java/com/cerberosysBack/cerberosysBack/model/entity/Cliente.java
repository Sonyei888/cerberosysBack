package com.cerberosysBack.cerberosysBack.model.entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {
    @Id
    @Column(name = "id_cliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "fecha_registro")
    private Date fechaRegistro;

    // Constructor sin argumentos
    public Cliente() {
    }

	// Constructor con argumentos
    public Cliente(Integer idCliente, String nombre, String apellido, String correo, Date fechaRegistro) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaRegistro = fechaRegistro;
    }

    // Getter para idCliente
    public Integer getIdCliente() {
        return idCliente;
    }

    // Setter para idCliente
    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    // Getter para nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter para apellido
    public String getApellido() {
        return apellido;
    }

    // Setter para apellido
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    // Getter para correo
    public String getCorreo() {
        return correo;
    }

    // Setter para correo
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Getter para fechaRegistro
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    // Setter para fechaRegistro
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
