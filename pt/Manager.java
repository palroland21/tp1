package utcn.pt;

public class Manager extends ResursaUmana {
    private String nume;
    private String departament;
    private int salar;
    private int bonusPerformanta;

    public Manager(String nume, String departament, int salar, int bonusPerformanta) {
        this.nume = nume;
        this.departament = departament;
        this.salar = salar;
        this.bonusPerformanta = bonusPerformanta;
    }

    public int calculeazaSalar(){
        return this.salar * this.bonusPerformanta;
    }
}
