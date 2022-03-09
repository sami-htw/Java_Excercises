package mitfahrzentrale;

/**
 * @author Osama
 */
public class Bus extends Transportmittel {
    public static final int BUS_MAX_PL = 20;

    public Bus() {
        super(BUS_MAX_PL);
    }

    @Override
    public String transportName() {
        return "Bus";
    }
}
