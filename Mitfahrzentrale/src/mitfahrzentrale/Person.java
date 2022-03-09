package mitfahrzentrale;

/**
 * @author Osama
 */
public class Person {
    private String vorname;
    private String familienname;

    public Person(String vorname, String familienname) {
        this.vorname = vorname;
        this.familienname = familienname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getFamilienname() {
        return familienname;
    }

    public void setFamilienname(String familienname) {
        this.familienname = familienname;
    }


}
