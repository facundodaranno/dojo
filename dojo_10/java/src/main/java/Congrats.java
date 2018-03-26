/**
 * Created by fdaranno on 14/3/18.
 */
public class Congrats {
    protected String sectionType;

    Congrats(){
        this.sectionType = "offline_payment";
    }

    public Congrats renderFor(Ios810 ios810) {
        this.sectionType = "mlu_offline_payment";
        return this;
    }

    public Congrats renderFor(Android712 android712) {
        return this;
    }

    @Override
    public boolean equals(Object object) {
        Congrats congratsToCompare = (Congrats) object;

        return sectionType != null ? sectionType.equals(congratsToCompare.sectionType) : congratsToCompare.sectionType == null;
    }
}
