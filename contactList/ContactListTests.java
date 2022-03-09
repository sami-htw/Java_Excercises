package contactList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Osama Ahmad  567074
 **/
public class ContactListTests {

    ContactMember[] members;

    Address address1;
    Address address2;
    Address address3;
    Address address4;
    Address address5;
    Address address6;
    Address address7;
    Address address8;


    Telefon t1;
    Telefon t2;
    Telefon t3;
    Telefon t4;
    Telefon t5;
    Telefon t6;
    Telefon t7;
    Telefon t8;

    ContactMember contact1;
    ContactMember contact2;
    ContactMember contact3;
    ContactMember contact4;
    ContactMember contact5;
    ContactMember contact6;
    ContactMember contact7;
    ContactMember contact8;
    ContactAdministration contactAdministration;

    @Before
    public void setUp() {
        address1 = new Address("Brunnenstr", 53, "13355", "Berlin");
        address2 = new Address("Goethestr", 03, "13158", "Berlin");
        address3 = new Address("Rigaerstr", 12, "16761", "Hrnnigsdorf");
        address4 = new Address("Detmolderstr", 06, "10715", "Berlin");
        address5 = new Address("Kanalstr", 70, "16515", "Oranienburg");
        address6 = new Address("Meiningerstr", 13, "10823", "Berlin");
        address7 = new Address("Blankenburgerstr", 66, "13156", "Berlin");
        address8 = new Address("Yorckstr", 17, "14467", "Potsdam");

        t1 = new Telefon("030", "1234567");
        t2 = new Telefon("030", "4632765");
        t3 = new Telefon("03302", "2654386");
        t4 = new Telefon("030", "1234567");
        t5 = new Telefon("03301", "5738811");
        t6 = new Telefon("030", "7554899");
        t7 = new Telefon("030", "7534223");
        t8 = new Telefon("0331", "3547892");

        contact1 = new ContactMember("Tom", "Müller", t1, address1);
        contact2 = new ContactMember("Jeff", "Johnson", t2, address2);
        contact3 = new ContactMember("Konrad", "Heike", t3, address3);
        contact4 = new ContactMember("Roger", "Thomas", t4, address4);
        contact5 = new ContactMember("Bernard", "Gieske", t5, address5);
        contact6 = new ContactMember("Julina", "Schenk", t6, address6);
        contact7 = new ContactMember("Lavinia", "Schneider", t7, address7);
        contact8 = new ContactMember("Toralf", "Mayer", t8, address8);


        members = new ContactMember[]{contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8};
        contactAdministration = new ContactAdministration(members);
    }


    @Test
    public void searchLastNameEmptyResult() {
        ContactAdministration cAdmin = new ContactAdministration(new ContactMember[]{});
        final ContactMember[] result = cAdmin.searchLastName("Schneider");

        Assert.assertEquals("Check if Array is Empty: ", 0, result.length);
    }

    @Test
    public void searchLastNameSingleResult() {
        final ContactMember[] result = contactAdministration.searchLastName("mayer");

        Assert.assertEquals(1, result.length);
    }

    @Test
    public void searchLastNameMultiResult() {
        ContactAdministration cAdmin = new ContactAdministration(new ContactMember[]{
                new ContactMember("Alex", "Fischer", t1, address1),
                new ContactMember("Mark", "Fischer", t2, address2)
        });
        final ContactMember[] result = cAdmin.searchLastName("Fischer");

        Assert.assertEquals(2, result.length);
    }

    @Test
    public void searchMultiPhoneNumbersViaPrefix() {

        ContactMember[] foundNumberFromBerlin = contactAdministration.getBerlinerPhones();


        ContactMember[] assumeSearchingResult = {contact1, contact2, contact4, contact6, contact7};

        Assert.assertArrayEquals("Found Number from Berlin: ", foundNumberFromBerlin, assumeSearchingResult);

    }


    @Test
    public void searchPhoneNumberViaPrefixButResultNotEqual() {

        ContactMember[] foundNumber = contactAdministration.getBerlinerPhones();


        ContactMember[] assumeSearchingResult = {contact3, contact5};

        Assert.assertFalse("AreNotEqual: ", foundNumber == assumeSearchingResult);

    }

    @Test
    public void searchPhoneNumberViaPrefixSingleResult() {

        ContactAdministration cAdmin = new ContactAdministration(new ContactMember[]{
                new ContactMember("Alex", "Fischer", t1, address1),
                new ContactMember("Mark", "Fischer", t5, address2)
        });
        final ContactMember[] result = cAdmin.searchPhoneNumbersViaPrefix("030");
        Assert.assertEquals(1, result.length);
    }

    @Test
    public void searchLastNameThatNotExist() {
        ContactMember[] searchLastNameResult = contactAdministration.searchLastName("Stayer");
        Assert.assertEquals(0, searchLastNameResult.length);
    }

    @Test
    public void deleteContactTestDependingOnFirstName() {


        Assert.assertEquals(8, members.length);
        contactAdministration.deleteContact("Tom");// Tom Müller is removed and his details are replaced with null
        Assert.assertTrue(members[0] == null);// checking if contact1 is really removed ?
        Assert.assertEquals(8, members.length); // Array length still fixed(8) members , although the first contact is removed, but it replaced with null

    }


}
