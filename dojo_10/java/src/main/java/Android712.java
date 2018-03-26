/**
 * Created by fdaranno on 14/3/18.
 */
public class Android712 implements DeviceInterface{

    private CongratsService congratsService;

    public Android712(CongratsService congratsService) {
        this.congratsService = congratsService;
    }

    public Congrats renderCongrats() {
        Congrats congrats = congratsService.renderCongrats();
        return congrats.renderFor(this);
    }
}
