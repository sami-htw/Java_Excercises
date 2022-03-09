package contactList;

/**
 * @author Osama Ahmad  567074
 **/
public class ContactMember {
    private String firstName;
    private String lastName;
    private Telefon telefons;
    private Address address;


    public ContactMember(String firstName, String lastName, Telefon telefons, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telefons = telefons;
        this.address = address;

    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Telefon getTelefons() {
        return telefons;
    }

    public void setTelefons(Telefon telefons) {
        this.telefons = telefons;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "ContatctMember{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", telefons=" + telefons +
                ", address=" + address +
                '}';
    }
}
