package utcn.pt;

public class Departament {
    private String numeDept;
    private int buget;

    public Departament(String numeDept, int buget) {
        this.numeDept = numeDept;
        this.buget = buget;
    }

    public String getNume() {
        return numeDept;
    }
}
