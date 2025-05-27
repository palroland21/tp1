package utcn.pt;

public class Departament {
    private int id;
    private String nume;

    public Departament(int id, String nume) {
        this.id = id;
        this.nume = nume;
    }

    public String getNume() {
        return nume;
    }
}
