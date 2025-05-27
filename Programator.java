package utcn.pt;

public class Programator extends Angajat {
    private int id;
    private String nume;
    private int salar;

    public Programator(int id, String nume, int salar){
        this.id = id;
        this.nume = nume;
        this.salar = salar;
    }

    public int calculareSalar(){
        return this.salar;
    }
}
