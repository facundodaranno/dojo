package com.mercadolibre.dojos;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {
	}
	
	@Test
	public void test_should_get_rendered_congrats_for_efecty() throws IOException {

		String expectedResponse = 	"{" +
									"\"status\": \"success\"," +
									"\"substatus\": null," +
									"\"heading\": \"¡Apúrate a pagar!\"," +
									"\"title\": \"Paga ${price} en ${paymentMethodName} para reservar tu compra\"," +
									"}";

		OrderWrapperResponse orderWrapperResponse = new OrderWrapperResponse();

		Order order = new Order( orderWrapperResponse.efectyResponse() );
		Congrats congrats = new Congrats(order);

		Assert.assertEquals(  expectedResponse, congrats.asJson() );
	}
	
	@Test
	public void test_should_render_congrats_for_orders_paid_by_credit_cards_shipped_customly() throws IOException {

		String expectedResponse = 	"{" +
									"\"status\": \"success\"," +
									"\"substatus\": null," +
									"\"heading\": \"¡Tu pago está aprobado!\"," +
									"\"title\": \"Coordina con el vendedor el envío\"," +
									"}";

		OrderWrapperResponse orderWrapperResponse = new OrderWrapperResponse();

		Order order = new Order( orderWrapperResponse.creditCardAndShippedCustomlyResponse() );
		Congrats congrats = new Congrats(order);

		Assert.assertEquals(  expectedResponse, congrats.asJson() );
	}
	

	@Test
	public void test_should_render_congrats_for_orders_paid_by_credit_cards_shipped_with_ME() throws IOException {

		String expectedResponse = 	"{" +
				"\"status\": \"success\"," +
				"\"substatus\": null," +
				"\"heading\": \"¡Excelente compra!\"," +
				"\"title\": \"El jueves 2017-05-18T00:00:00.000-05:00. te llegará el producto\"," +
				"}";

		OrderWrapperResponse orderWrapperResponse = new OrderWrapperResponse();

		Order order = new Order( orderWrapperResponse.creditCardAndShippedME() );
		Congrats congrats = new Congrats(order);

		Assert.assertEquals(  expectedResponse, congrats.asJson() );

	}
	
	
}
