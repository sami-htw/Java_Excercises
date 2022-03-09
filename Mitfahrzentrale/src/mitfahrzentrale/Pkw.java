package mitfahrzentrale;

/**
 * @author Osama Ahmad 567074
 */
public class Pkw extends Transportmittel {
    public static final int PKW_MAX_PL = 4;

    public Pkw() {
        super(PKW_MAX_PL);
    }


    @Override
    public String transportName() {
        return "PKW";
    }
}
