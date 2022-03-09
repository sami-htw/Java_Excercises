package contactList;

/**
 *
 * @author Osama Ahmad  567074
 **/


public class ContactAdministration {

    private ContactMember[] members;


    public ContactAdministration(ContactMember[] members) {
        this.members = members;
    }


    public ContactMember[] searchPhoneNumbersViaPrefix(String prefix) {

        ContactMember[] result = new ContactMember[members.length];


        try {
            int count = 0;
            for (ContactMember cm : members) {
                if (cm.getTelefons().getPrefix().equals(prefix)) {
                    result[count++] = cm;
                }
            }
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
        return reduceArray(result);
    }


    // helping method to review numbers from Berlin
    public ContactMember[] getBerlinerPhones() {
        ContactMember[] savingResult = this.searchPhoneNumbersViaPrefix("030");
        for (ContactMember cm : savingResult) {
            System.out.println(cm.getTelefons());
        }
        return reduceArray(savingResult);
    }


    public ContactMember[] searchLastName(String lastName) {


        ContactMember[] result = new ContactMember[members.length];
        lastName = lastName.toLowerCase();
        int cursor = 0;
        for (ContactMember contactMember : members) {
            if (contactMember.getLastName().equalsIgnoreCase(lastName)) {
                result[cursor++] = contactMember;
            }
        }
        return reduceArray(result);
    }


    // to remove specific member from contactList
    public ContactMember[] deleteContact(String firstName) {

        int actualLength = members.length;
        ContactMember[] result = new ContactMember[actualLength];
        for (int i = 0; i < actualLength; i++) {
            if (members[i].getFirstName().equalsIgnoreCase(firstName)) {
                members[i] = result[actualLength - 1];
                actualLength--;
            }
        }
        return reduceArray(result);

    }


    /*
     * helping method, which will be used by other essential Methods
     */
    private static ContactMember[] reduceArray(ContactMember[] source) {
        int size = 0;

        int i = 0;
        while (i < source.length && source[i] != null) {
            i++;
        }
        size = i;

        ContactMember[] target = new ContactMember[size];
        for (int j = 0; j < size; j++) {
            target[j] = source[j];
        }
        return target; // return the target array of type ContactMember after editing the essential array
    }


}
