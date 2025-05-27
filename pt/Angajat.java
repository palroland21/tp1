package utcn.pt;

public class Angajat extends ResursaUmana {
    private String nume;
    private String departament;
    private int salar;

    public Angajat(String nume, String departament, int salar) {
        this.nume = nume;
        this.departament = departament;
        this.salar = salar;
    }

    public int calculeazaSalar(){
        return this.salar;
    }


    public String toString(){
        return this.nume + " " + this.departament + " " + this.salar;
    }
}
