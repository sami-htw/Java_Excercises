package mitfahrzentrale;

/**
 * @author Osama Ahmad 567074
 */
public interface ITransportmittel {
    /**
     * liefert die freie Sitzplätze zurück
     *
     * @return anzahl der freien Plätze von jedem Transportmittel
     */
    int getFreieSitzPlätze();


    /**
     * @param newPerson wird hinzugefügt und beim vorherigen buchen liefert auch true um duplikate zu vermeiden
     * @return false wenn keine freie Platze da sind, true mit freien plätzen
     */
    boolean personBuchen(Person newPerson);

    /**
     * Falls die angegebene Person in personenArray existiert wird das gefundene person Objekt auf null gesetzt
     *
     * @param newPerson
     */
    void personStornieren(Person newPerson);

    /**
     * toString methode, die von klassen Pkw und Bus überschrieben wird.
     *
     * @return Name des Transportmittel
     */
    String transportName();
}
