package contactList;


/**
 * @author Osama Ahmad  567074
 **/
public class Telefon {
    private String prefix;
    private String number;

    public Telefon(String prefix, String number) {
        this.prefix = prefix;
        this.number = number;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return
                "(" + prefix + ")" + "-" +
                        number;

    }
}

