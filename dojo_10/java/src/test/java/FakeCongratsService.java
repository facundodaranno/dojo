/**
 * Created by fdaranno on 14/3/18.
 */
public class FakeCongratsService implements CongratsService {

    @Override
    public Congrats renderCongrats() {
        return new Congrats();
    }
}

