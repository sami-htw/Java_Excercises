package service;

import mitfahrzentrale.Transportmittel;

/**
 * @author Osama
 */
public class TeilFahrt {
    String stationName;
    double fahrtKosten;
    Transportmittel transport;
    TeilFahrt next;

    public TeilFahrt(String stationName, double fahrtKosten, Transportmittel transport) {
        this.stationName = stationName;
        this.fahrtKosten = fahrtKosten;
        this.transport = transport;
        next = null;
    }
}

