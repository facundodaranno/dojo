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

		Aula aulaA = new AulaDisponible.Builder("Lab A", 5).build();
		Aula aulaB = new AulaDisponible.Builder("Lab B", 15).build();

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAulas( aulaA , aulaB );

		SolicitudAula solicitudAula = new SolicitudAula(10);
		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = aulaB;
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "Aula: Lab B");
	}

	@Test
	public void se_solicita_un_aula_para_30_personas_debe_indicar_no_hay_aula_disponibles() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new AulaDisponible.Builder("Lab A", 5).build();
		Aula aulaB = new AulaDisponible.Builder("Lab B", 15).build();

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAulas( aulaA , aulaB );

		SolicitudAula solicitudAula = new SolicitudAula(30);
		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = new AulaNoDisponible();
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "No hay aula disponible");
	}


	@Test
	public void se_solicita_un_aula_para_10_personas_con_30_m2_debe_indicar_lab_C() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new AulaDisponible.Builder("Lab A", 5)
				.m2(10)
				.build();

		Aula aulaB = new AulaDisponible.Builder("Lab B", 15)
				.m2(20)
				.build();

		Aula aulaC = new AulaDisponible.Builder("Lab C", 15)
				.m2(50)
				.build();

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAulas( aulaA, aulaB, aulaC );

		SolicitudAula solicitudAula = new SolicitudAula(10)
				.agregarRestriccionM2(30);

		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = aulaC;
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "Aula: Lab C");
	}


	@Test
	public void se_solicita_un_aula_para_10_personas_con_30_m2_y_computadoras_debe_indicar_lab_D() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]

		Aula aulaA = new AulaDisponible.Builder("Lab A", 5)
				.m2(10)
				.build();

		Aula aulaB = new AulaDisponible.Builder("Lab B", 15)
				.m2(20)
				.build();

		Aula aulaC = new AulaDisponible.Builder("Lab C", 15)
				.m2(50)
				.build();

		Aula aulaD = new AulaDisponible.Builder("Lab D", 15)
				.m2(50)
				.poseeComputadoras()
				.build();

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAula( aulaA );
		listadoAulas.agregarAula( aulaB );
		listadoAulas.agregarAula( aulaC );
		listadoAulas.agregarAula( aulaD );

		SolicitudAula solicitudAula = new SolicitudAula(10 )
				.agregarRestriccionM2(30)
				.necesitaComputadoras();

		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = aulaD;
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "Aula: Lab D");
	}

	@Test
	public void se_solicita_un_aula_para_10_personas_y_computadoras_debe_indicar_lab_D() {

		// Listado de aulas:  [{nombre:aula_a, capacidadSolicitada:5},{nombre:aula_b, capacidadSolicitada:15}]


		Aula aulaA = new AulaDisponible.Builder("Lab A", 5)
				.m2(10)
				.build();

		Aula aulaB = new AulaDisponible.Builder("Lab B", 15)
				.m2(20)
				.build();

		Aula aulaC = new AulaDisponible.Builder("Lab C", 15)
				.build();

		Aula aulaD = new AulaDisponible.Builder("Lab D", 15)
				.build();

		Aula aulaE = new AulaDisponible.Builder("Lab E", 15)
				.poseeComputadoras()
				.build();

		ListadoAulas listadoAulas = new ListadoAulas();
		listadoAulas.agregarAulas( aulaA , aulaB, aulaC, aulaD, aulaE );

		SolicitudAula solicitudAula = new SolicitudAula(10 )
				.necesitaComputadoras();

		Aula aulaDisponible = listadoAulas.realizarSolicitud( solicitudAula );

		Aula aulaEsperada = aulaE;
		Assert.assertTrue( aulaDisponible.equals( aulaEsperada ) );
		Assert.assertEquals( aulaDisponible.mostrarNombre() , "Aula: Lab E");
	}



}
