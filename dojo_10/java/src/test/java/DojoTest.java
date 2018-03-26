import harnesses.ResourceLoader;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Tests for the dojo.
 */
public class DojoTest {
	
	@Before
	public void setup() {
	}

    @Test
    public void test_congrats_order_paid_off_for_ios_8_10_0() throws IOException {
        Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_ios_8_10_0.json"),
                Map.class
        );

        assertEquals(
                ((List<Map>)congrats.get("sections")).get(0).get("type"),
                "mlu_offline_payment"
        );

    }

    @Test
    public void test_congrats_order_paid_off_for_android_7_12_0() throws IOException {
        Map congrats = JSONMapper.toObject(
                ResourceLoader.getFileAsString("congrats/congrats/congrats_order_paid_off_for_android_7_12_0.json"),
                Map.class
        );

        assertEquals(
                ((List<Map>)congrats.get("sections")).get(0).get("type"),
                "offline_payment"
        );
    }

    @Test
    public void test_congrats_order_paid_off_for_android_7_12_0_with_entities() throws IOException {
        CongratsService congratsService = new FakeCongratsService();
        Congrats expectedCongrats = new Congrats();

	    DeviceInterface android712 = new Android712(congratsService);

        Congrats congrats = android712.renderCongrats();

        assertEquals(
                expectedCongrats,
                congrats
        );
    }

    //@Smell("El assert conoce la implementación de congrats y esto viola el encapsulamiento")
    @Test
    public void test_congrats_order_paid_off_for_ios_8_10_0_with_entities() throws IOException {
        CongratsService congratsService = new FakeCongratsService();
        Congrats expectedCongrats = new CongratsExpectedForIOs810( "mlu_offline_payment" );

        Ios810 ios810 = new Ios810( congratsService );

        Congrats congrats = ios810.renderCongrats();

        assertEquals(
                expectedCongrats,
                congrats
        );
    }

}
