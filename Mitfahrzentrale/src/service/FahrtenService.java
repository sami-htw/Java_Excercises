package service;

import mitfahrzentrale.Person;

/**
 * @author Osama Ahmad 567074
 */
public interface FahrtenService {
    /**
     * zeigt fahrten Details z,B. zwischenstopps mit freie Plätze jeweils , mit welchem transportmittel wird gefahren
     */
    void zeigeFahrten();


    /**
     * leitet an methode fahrtBuchen in klasse Fahrten weiter, dann an abstrakte Klasse Transportmittel durch methode getFreieSitzPlätze
     * um erstmal zu überprüfen ob freie plätze gibt.
     *
     * @param fahrtNummer
     * @param person
     */
    void fahrtBuchen(int fahrtNummer, Person person);

    /**
     * leitet an methode fahrtStornieren in klasse Fahrten weiter, dann an die abstrakte klasse Transportmittel via methode personStornieren
     *
     * @param fahrtNummer
     * @param person
     */
    void fahrtStornieren(int fahrtNummer, Person person);

    /**
     * liefert Bestätigungsnachricht mit kosten
     *
     * @param kosten
     */
    void buchungBestätigen(double kosten);


    /**
     * liefert die Mitteilung zurück, dass Buchung abgelehnt wurde.
     */
    void buchungAblehnen();

    /**
     * leitet an die funktion schonGebucht in klasse Fahrten weiter, dann überprüft ob person schon gebucht hat durch funktion personSchonGebucht
     * in Abstrakte klasse Transportmittel
     *
     * @param fahrtNummer
     * @param person
     * @return
     */
    boolean schonGebucht(int fahrtNummer, Person person);
}
