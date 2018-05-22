package com.mercadolibre.dojos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Tests for the dojo.
 */
public class DojoTest {

	
	@Before
	public void setup() {
	}
	
	@Test
	public void se_solicita_un_aula_para_10_personas_debe_indicar_aula_b() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new AulaDisponible("Lab A", 5);
		Aula aulaB = new AulaDisponible("Lab B", 15);

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAula( aulaA );
		listadoAulas.agregarAula( aulaB );

		SolicitudAula solicitudAula = new SolicitudAula(10);
		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = new AulaDisponible("Lab B", 15);
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "Aula: Lab B");
	}

	@Test
	public void se_solicita_un_aula_para_30_personas_debe_indicar_no_hay_aula_disponibles() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new AulaDisponible("Lab A", 5);
		Aula aulaB = new AulaDisponible("Lab B", 15);

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAula( aulaA );
		listadoAulas.agregarAula( aulaB );

		SolicitudAula solicitudAula = new SolicitudAula(30);
		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = new AulaNoDisponible();
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "No hay aula disponible");
	}


	@Test
	public void se_solicita_un_aula_para_10_personas_con_30_m2_debe_indicar_lab_C() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new AulaDisponible("Lab A", 5  , 10);
		Aula aulaB = new AulaDisponible("Lab B", 15 , 20);
		Aula aulaC = new AulaDisponible("Lab C", 15 , 50);

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAula( aulaA );
		listadoAulas.agregarAula( aulaB );
		listadoAulas.agregarAula( aulaC );

		SolicitudAula solicitudAula = new SolicitudAula(10 , 30);
		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = new AulaDisponible("Lab C", 15 , 50);
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "Aula: Lab C");
	}



}
