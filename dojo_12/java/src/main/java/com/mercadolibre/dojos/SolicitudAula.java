package com.mercadolibre.dojos;

/**
 * Created by fdaranno on 21/5/18.
 */
public class SolicitudAula {

    private Integer capacidadSolicitada;
    private Integer m2Solicitados;
    private Boolean poseeComputadoras;

    public SolicitudAula(Integer capacidad) {
        capacidadSolicitada = capacidad;
        poseeComputadoras = false;
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

    public Aula poseeComputadorasNecesarias(Boolean poseeComputadoras, AulaDisponible aulaDisponible, Aula defaultAula) {
        return this.poseeComputadoras && poseeComputadoras ? aulaDisponible : defaultAula;
    }

    public SolicitudAula necesitaComputadoras() {
        this.poseeComputadoras = true;
        return this;
    }

    public SolicitudAula agregarRestriccionM2(Integer m2) {
        m2Solicitados = m2;
        return this;
    }
}
