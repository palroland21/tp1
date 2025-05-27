package utcn.pt;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ManagerHR {
    private Map<Departament, List<ResursaUmana>> map;

    public ManagerHR() {
        map = new HashMap<>();
    }

    // O metodă generică adaugăResurse care acceptă o listă de resurse umane(folosind bounded wildcard pentru a permite subtipuri de ResursaUmană).
    public void addResurse(Departament dept, List<? extends ResursaUmana> lista){
        map.computeIfAbsent(dept, k -> new ArrayList<>()).addAll(lista);
    }

    //O metodă care folosește Reflection pentru a afișa toate câmpurile și metodele unei resurse umane primite ca parametru.
    public void afisareaCampuriAndMetode(ResursaUmana resursaUmana){

        Field fields[] = resursaUmana.getClass().getDeclaredFields();
        for(Field f: fields){
            f.setAccessible(true);
            try {
                System.out.println(Modifier.toString(f.getModifiers()) + " " + f.getType().getSimpleName() +  f.getName() + " " + f.get(resursaUmana) + ".");
            }catch(IllegalAccessException e){ }
        }

        System.out.println("Metodele:");
        Method methods[] = resursaUmana.getClass().getDeclaredMethods();
        for(Method m : methods){
            System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getReturnType().getSimpleName() + " " + m.getName());

            Parameter params[] = m.getParameters();
            for(int i=0; i<params.length; i++){
                if(i > 0) System.out.println(", ");
                System.out.println(params[i].getType().getSimpleName() + " " + params[i].getName());
            }
        }
    }

    // O metodă care folosește stream() și o expresie lambda pentru a filtra toți angajații cu salariul peste un prag dat.
    public List<Angajat> filtruAngajati(int pragSalar){
        return map.entrySet().stream()
                .flatMap(lista -> lista.getValue().stream())
                .filter(ang -> ang instanceof Angajat)
                .map(ang -> (Angajat) ang)
                .filter(a -> a.calculeazaSalar() > pragSalar)
                .collect(Collectors.toList());
    }

    // O metodă care calculează suma totală a salariilor pe departamente (folosind Collectors.groupingBy și Collectors.summingDouble).
    public void sumTotalPerDept(){
        map.forEach( (dept, resurse) -> {
            System.out.println("Departamentul " + dept.getNume());

            int total = resurse.stream()
                    .mapToInt(ResursaUmana::calculeazaSalar)
                    .sum();

            System.out.println("Salar total: " + total);
        });
    }
}
