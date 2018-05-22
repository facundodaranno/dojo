package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class SolicitudAula {

    private Integer capacidadSolicitada;
    private Integer m2Solicitados;

    public SolicitudAula(Integer capacidad) {
        capacidadSolicitada = capacidad;
    }

    public SolicitudAula(Integer capacidad, Integer m2) {
        capacidadSolicitada = capacidad;
        m2Solicitados = m2;
    }

    public Aula cubreDisponibilidad(Integer capacidadDisponible, Aula aulaDisponible, Aula defaultAula) {
        return capacidadSolicitada.compareTo( capacidadDisponible ) <= 0  ? aulaDisponible : defaultAula;
    }

    public Aula cubreMetrosCuadrados(Integer m2Disponibles, Aula aulaDisponible, Aula defaultAula) {
        if( m2Solicitados != null ){
            return m2Solicitados.compareTo( m2Disponibles ) <= 0 ? aulaDisponible : defaultAula;
        }else{
            return defaultAula;
        }
    }
}
