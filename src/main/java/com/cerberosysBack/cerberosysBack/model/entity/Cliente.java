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

    // Constructor privado
    private Cliente() {
    }

    // Getter para idCliente
    public Integer getIdCliente() {
        return idCliente;
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

 // Método estático para obtener un Builder
    public static Builder builder() {
        return new Builder();
    }

    // Inner class Builder
    public static class Builder {
        private Integer idCliente;
        private String nombre;
        private String apellido;
        private String correo;
        private Date fechaRegistro;

        public Builder idCliente(Integer idCliente) {
            this.idCliente = idCliente;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder correo(String correo) {
            this.correo = correo;
            return this;
        }

        public Builder fechaRegistro(Date fechaRegistro) {
            this.fechaRegistro = fechaRegistro;
            return this;
        }

        public Cliente build() {
            Cliente cliente = new Cliente();
            cliente.idCliente = this.idCliente;
            cliente.nombre = this.nombre;
            cliente.apellido = this.apellido;
            cliente.correo = this.correo;
            cliente.fechaRegistro = this.fechaRegistro;
            return cliente;
        }
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
