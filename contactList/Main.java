package contactList;

import java.util.Arrays;

/**
 * @author Osama Ahmad  567074
 **/


public class Main {
    public static ContactMember[] members;
    public static Telefon[] telefons;

    public static void main(String[] args) {

        Address address1 = new Address("Brunnenstr", 53, "13355", "Berlin");
        Address address2 = new Address("Goethestr", 03, "13158", "Berlin");
        Address address3 = new Address("Rigaerstr", 12, "16761", "Hrnnigsdorf");
        Address address4 = new Address("Detmolderstr", 06, "10715", "Berlin");
        Address address5 = new Address("Kanalstr", 70, "16515", "Oranienburg");
        Address address6 = new Address("Meiningerstr", 13, "10823", "Berlin");
        Address address7 = new Address("Blankenburgerstr", 66, "13156", "Berlin");
        Address address8 = new Address("Yorckstr", 17, "14467", "Potsdam");

        Telefon t1 = new Telefon("030", "1234567");
        Telefon t2 = new Telefon("030", "4632765");
        Telefon t3 = new Telefon("03302", "2654386");
        Telefon t4 = new Telefon("030", "1234567");
        Telefon t5 = new Telefon("03301", "5738811");
        Telefon t6 = new Telefon("030", "7554899");
        Telefon t7 = new Telefon("030", "7534223");
        Telefon t8 = new Telefon("0331", "3547892");


        telefons = new Telefon[]{t1, t2, t3, t4, t5, t6, t7, t8};

        ContactMember contact1 = new ContactMember("Tom", "Müller", t1, address1);
        ContactMember contact2 = new ContactMember("Jeff", "Johnson", t2, address2);
        ContactMember contact3 = new ContactMember("Konrad", "Heike", t3, address3);
        ContactMember contact4 = new ContactMember("Roger", "Thomas", t4, address4);
        ContactMember contact5 = new ContactMember("Bernard", "Gieske", t5, address5);
        ContactMember contact6 = new ContactMember("Julina", "Schenk", t6, address6);
        ContactMember contact7 = new ContactMember("Lavinia", "Schneider", t7, address7);
        ContactMember contact8 = new ContactMember("Toralf", "Mayer", t8, address8);
        members = new ContactMember[]{contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8};

        ContactAdministration contactAdministration = new ContactAdministration(members);

        System.out.println("Contacts before Editing: ");
        for (int i = 0; i < members.length; i++) {
            System.out.println((i + 1) + " " + members[i].toString());
        }


        System.out.println("\nTelefon Numbers from Berlin: ");

        contactAdministration.getBerlinerPhones();


        ContactMember[] resultContact = contactAdministration.searchLastName("mayer");

        System.out.println("\nFound contact: \n" + Arrays.toString(resultContact));

        System.out.println("\nAfter removing contact:");
        contactAdministration.deleteContact("Roger");

        // iterate member after removing, to check which member is removed
        for (ContactMember cm : members) {
            System.out.println(cm);
        }


    }
}
