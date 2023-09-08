package com.cerberosysBack.cerberosysBack.model.payload;

import java.io.Serializable;

import com.cerberosysBack.cerberosysBack.model.dto.ClienteDto.Builder;

import java.io.Serializable;

public class MensajeResponse implements Serializable {
    private String mensaje;
    private Object object;

    public MensajeResponse() {
    }

    public MensajeResponse(String mensaje, Object object) {
        this.mensaje = mensaje;
        this.object = object;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public String toString() {
        return "MensajeResponse{" +
                "mensaje='" + mensaje + '\'' +
                ", object=" + object +
                '}';
    }

    public static MensajeResponseBuilder builder() {
        return new MensajeResponseBuilder();
    }

    public static class MensajeResponseBuilder {
        private String mensaje;
        private Object object;
        
     

        MensajeResponseBuilder() {
        }

        public MensajeResponseBuilder mensaje(String mensaje) {
            this.mensaje = mensaje;
            return this;
        }

        public MensajeResponseBuilder object(Object object) {
            this.object = object;
            return this;
        }

        public MensajeResponse build() {
            return new MensajeResponse(mensaje, object);
        }
    }
}
