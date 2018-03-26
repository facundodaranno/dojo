/**
 * Created by fdaranno on 14/3/18.
 */
public class Ios810 implements DeviceInterface {

    private CongratsService congratsService;

    public Ios810(CongratsService congratsService) {
        this.congratsService = congratsService;
    }

    public Congrats renderCongrats() {
        Congrats congrats = congratsService.getResponseAsCongratsObject();
        return congrats.renderFor(this);
    }
}
