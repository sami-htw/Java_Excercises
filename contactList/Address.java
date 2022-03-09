package contactList;


/**
 *
 * @author Osama Ahmad  567074
 **/
public class Address {

    private String street;
    private int streetNumber;
    private String plz;
    private String city;

    public Address(String street, int streetNumber, String plz, String city) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.plz = plz;
        this.city = city;
    }

    @Override
    public String toString() {
        return
                "street='" + street + "." + streetNumber + " | " +
                        plz + " " +
                        city;
    }
}
