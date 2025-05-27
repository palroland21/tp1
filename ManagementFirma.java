package utcn.pt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagementFirma {
    private Map<Departament, List<Angajat>> map;

    public ManagementFirma(){
        map = new HashMap<>();
    }

    public void addAngajat(Departament dept, Angajat ang){
        map.computeIfAbsent(dept, k -> new ArrayList<>()).add(ang);
    }

    public void salarTotalPerDept(Departament dept){
        map.entrySet().stream()
                .filter(d -> d.getKey() == dept)
                .forEach( entry -> {
                    System.out.println("Dept: " + entry.getKey().getNume());

                    int total = entry.getValue().stream()
                            .mapToInt(Angajat::calculareSalar)
                            .sum();

                    System.out.println("Total salar: " + total);
                });
    }

    public void adaugareListAngajat(Departament dept, List<? extends Angajat> lista){
        map.computeIfAbsent(dept, k -> new ArrayList<>()).addAll(lista);
    }
}
