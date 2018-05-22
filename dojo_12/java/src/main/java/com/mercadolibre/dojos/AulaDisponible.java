package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class AulaDisponible implements Aula {

    private String nombre;
    private Integer capacidad;
    private Integer m2;
    private Boolean poseeComputadoras;

    private AulaDisponible(String nombre, Integer capacidad, Integer m2, Boolean poseeComputadoras) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.m2 = m2;
        this.poseeComputadoras = poseeComputadoras;
    }

    public String mostrarNombre() {
        return "Aula: " + nombre;
    }

    public boolean equals(Object object) {
        if ( object.getClass().equals( this.getClass() ) ){
            AulaDisponible aula = (AulaDisponible) object;
            return nombre.equals( aula.nombre ) && capacidad.equals(aula.capacidad );
        }
        return false;
    }

    public Aula respondeASolicitudOrDefault(SolicitudAula solicitudAula, Aula defaultAula) {
        Aula aulaADevolver = defaultAula;

        aulaADevolver = solicitudAula.cubreDisponibilidad(capacidad, this, aulaADevolver);
        aulaADevolver = solicitudAula.cubreMetrosCuadrados(m2, this, aulaADevolver);
        aulaADevolver = solicitudAula.poseeComputadorasNecesarias(poseeComputadoras,this, aulaADevolver);

        return aulaADevolver;
    }

    public static class Builder{
        private final String nombre;
        private final Integer capacidad;
        private Integer m2 = 0;
        private Boolean poseeComputadoras = false;

        public Builder(String nombre, Integer capacidad){
            this.nombre = nombre;
            this.capacidad = capacidad;
        }

        public Builder m2(Integer m2){
            this.m2 = m2;
            return this;
        }

        public Builder poseeComputadoras(){
            this.poseeComputadoras = true;
            return  this;
        }

        public AulaDisponible build(){
            return new AulaDisponible( nombre, capacidad,  m2,  poseeComputadoras);
        }
    }
}
