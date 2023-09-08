package com.cerberosysBack.cerberosysBack.model.dto;

import java.io.Serializable;
import java.sql.Date;

public class ClienteDto implements Serializable {

    private Integer idCliente;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fechaRegistro;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    // Método estático para obtener un Builder
    public static Builder builder() {
        return new Builder();
    }

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

        public ClienteDto build() {
            ClienteDto clienteDto = new ClienteDto();
            clienteDto.idCliente = this.idCliente;
            clienteDto.nombre = this.nombre;
            clienteDto.apellido = this.apellido;
            clienteDto.correo = this.correo;
            clienteDto.fechaRegistro = this.fechaRegistro;
            return clienteDto;
        }
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                "idCliente=" + idCliente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", fechaRegistro=" + fechaRegistro +
                '}';
    }
}
