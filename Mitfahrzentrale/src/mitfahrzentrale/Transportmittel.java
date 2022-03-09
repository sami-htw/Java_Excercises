package mitfahrzentrale;

/**
 * @author Osama Ahmad s0567074
 */
public abstract class Transportmittel implements ITransportmittel {
    Person[] personenArray;

    public Transportmittel(int anzahlSitzPlätze) {
        this.personenArray = new Person[anzahlSitzPlätze]; //initialisiere personenArray mit Sitzplätze aus den Klassen
    }

    @Override
    public int getFreieSitzPlätze() {
        int anzahl = 0;
        for (Person p : personenArray) {
            if (p == null) {
                anzahl++;
            }
        }
        return anzahl;
    }

    public boolean personSchonGebucht(Person person) {
        for (Person p : personenArray) {
            if (p == person) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean personBuchen(Person newPerson) {
        if (getFreieSitzPlätze() <= 0) {
            return false;
        }
        //check ob person schon gebucht um duplicate zu vermeiden
        if (personSchonGebucht(newPerson)) {
            return true;
        }

        for (int i = 0; i < personenArray.length; i++) {
            if (personenArray[i] == null) {
                personenArray[i] = newPerson;
                break;
            }
        }
        return true;
    }

    @Override
    public void personStornieren(Person newPerson) {
        for (int i = 0; i < personenArray.length; i++) {
            if (personenArray[i] == newPerson) {
                personenArray[i] = null;
                break;
            }
        }
    }


}
