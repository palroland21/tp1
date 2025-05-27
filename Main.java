package utcn.pt;

//1.  Creati o clasa abstracta Angajat cu o metoda abstracta calculeazaSalar().
// Creati Subclasele Programator si Manager, si clasa Departament.
//2.  Creati o clasa ManagementFirma ce contine Map<Departament, List<Angajat>> ce
// contine o metoda pentru adaugarea unui angajat la un departament si calcularea
// salariului total per departament.
//3.  Creati o clasa Main in care sa testati adaugarea a doi programatori si unui
// manager la un departament.
//4.  Creati semnatura unei metode generice care adauga o lista de angajati intr-un
// departament cu un bounded wildcard care sa te lase sa adaugi si subtipuri la angajat

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Programator p1 = new Programator(1, "Ion", 10522);
        Programator p2 = new Programator(2, "Ionel", 2522);

        Manager m1 = new Manager(1, "Sef", 5600);

        Departament dept = new Departament(1, "Firma");

        ManagementFirma m = new ManagementFirma();

        m.salarTotalPerDept(dept);

        List<Angajat> list = new ArrayList<>();

        list.add(p1);
        list.add(p2);

        m.adaugareListAngajat(dept, list);

        m.salarTotalPerDept(dept);

    }
}
