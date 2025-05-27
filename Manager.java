package utcn.pt;

public class Manager extends Angajat {
    private int id;
    private String nume;
    private int salar;

    public Manager(int id, String nume, int salar) {
        this.id = id;
        this.nume = nume;
        this.salar = salar;
    }

    public int calculareSalar(){
        return this.salar;
    }
}
