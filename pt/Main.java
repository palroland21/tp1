package utcn.pt;

// 1. Clase de Bază (OOP și Generice)
//Creați o clasă abstractă ResursaUmană cu o metodă abstractă calculeazăSalariu()
// și un câmp id (String).
//Creați subclasele Angajat (cu câmpuri: nume, departament) și Manager (cu câmp suplimentar bonusPerformanță).
//Creați o clasă Departament cu câmpurile numeDepartament și buget.
//
//2. Gestiune Resurse (Generice și Reflection)
//Creați o clasă ManagementHR care conține:
//Un Map<Departament, List<ResursaUmană>>.
//O metodă generică adaugăResurse care acceptă o listă de resurse umane
// (folosind bounded wildcard pentru a permite subtipuri de ResursaUmană).
//O metodă care folosește Reflection pentru a afișa toate câmpurile și
// metodele unei resurse umane primite ca parametru.
//
//3. Operații cu Streams și Lambda
//În ManagementHR, implementați:
//O metodă care folosește stream() și o expresie lambda pentru a filtra
// toți angajații cu salariul peste un prag dat.
//O metodă care calculează suma totală a salariilor pe departamente
// (folosind Collectors.groupingBy și Collectors.summingDouble).
//
//4. Testare (Main)
//În clasa Main:
//Creați 2 angajați și 1 manager, adăugați-i într-un departament folosind adaugăResurse.
//Testați metoda de filtrare cu lambda și cea de calcul salarial.
//Afișați structura unei resurse umane folosind Reflection.
//
//5. Cerințe Bonus (Opționale)
//Folosiți annotations pentru a marca resursele cu un @Role (e.g., "DEV", "HR").
//Creați un enum TipResursă (INTERN, FULL_TIME, CONTRACTOR) și adăugați-l ca câmp în ResursaUmană.

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){

        Angajat a1 = new Angajat("Ion", "Calculatoare", 3000);
        Angajat a2 = new Angajat("Ionica", "Dept de sus", 1582);

        Manager m1 = new Manager("Sef", "Calculatoare", 15000, 2);

        Departament dept = new Departament("Calculatoare", 250000);

        ManagerHR HR = new ManagerHR();

        List<Angajat> lista = new ArrayList<>();
        lista.add(a1);
        lista.add(a2);

        HR.addResurse(dept, lista);

        List<Angajat> listaNoua = new ArrayList<>();

        listaNoua = HR.filtruAngajati(2000);

        for(Angajat a : lista){
            System.out.println(a);
        }


        HR.sumTotalPerDept();


        HR.afisareaCampuriAndMetode(a1);

    }
}