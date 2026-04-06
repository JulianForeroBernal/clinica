import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Patient> patients = new java.util.ArrayList<>();
        int option;
        do {
            String name;
            int id;
            int consultCost;
            int fidelityYears;
            String nameEPS;
            System.out.println("""
                    1. Registrar paciente particular
                    2. Registrar paciente EPS
                    3. Registrar paciente VIP
                    4. Buscar paciente por documento
                    5. Mostrar todos los pacientes
                    6. Mostrar pacientes por tipo
                    7. Calcular costo consultas
                    8. Mostrar consultas costosas
                    9. mostrar paciente que mas pagó
                    0. salir
                    """);
            option = scan.nextInt();

            switch (option){
                case 1:
                    System.out.println("nombre del paciente: ");
                    name = scan.next();
                    System.out.println("ID del paciente: ");
                    id = scan.nextInt();
                    System.out.println("Costo consulta del paciente: ");
                    consultCost = scan.nextInt();
                    ParticularPatient pP = new ParticularPatient(name, id, consultCost);
                    patients.add(pP);
                    break;
                case 2:
                    System.out.println("nombre del paciente: ");
                    name = scan.next();
                    System.out.println("ID del paciente: ");
                    id = scan.nextInt();
                    System.out.println("Costo consulta del paciente: ");
                    consultCost = scan.nextInt();
                    System.out.println("nombre EPS: ");
                    nameEPS = scan.next();
                    PatientEPS pE = new PatientEPS(name, id, consultCost, nameEPS);
                    patients.add(pE);
                    break;
                case 3:
                    System.out.println("nombre del paciente: ");
                    name = scan.next();
                    System.out.println("ID del paciente: ");
                    id = scan.nextInt();
                    System.out.println("Costo consulta del paciente: ");
                    consultCost = scan.nextInt();
                    System.out.println("años de fidelidad: ");
                    fidelityYears = scan.nextInt();
                    PatientVIP pV = new PatientVIP(name, id, consultCost, fidelityYears);
                    patients.add(pV);
                    break;
                case 4:
                    int search;
                    boolean found = false;
                    Patient paciente = null;
                    System.out.println("Documento del paciente: ");
                    search = scan.nextInt();
                    for (Patient p : patients){
                        if( p.id == search){
                            found = true;
                            paciente = p;
                        }
                    }
                    if (found){
                        System.out.println(paciente.showData());
                        boolean exit = true;
                        do {
                            int number;
                            System.out.println("""
                                    1. Calcular costo final
                                    2. Aplicar descuento
                                    3. Aplicar recargo
                                    4. Mostrar datos
                                    0. Salir
                                    """);
                            number = scan.nextInt();
                            int percent;
                            switch (number){
                                case 1:
                                    paciente.calculateFinalCost();
                                    System.out.println("costo original: " + paciente.getOriginalCost() +
                                            "\ncosto final: " + paciente.getConsultCost());
                                    break;
                                case 2:
                                    paciente.calculateFinalCost();
                                    System.out.println("costo actual: " + paciente.getConsultCost());
                                    System.out.println("porcentaje de descuento: ");
                                    percent = scan.nextInt();
                                    paciente.applyDiscount(percent);
                                    System.out.println("se aplico un descuento del: " + percent + "% al costo de la consulta\n costo actual: " + paciente.getConsultCost());
                                    System.out.println("tenga en cuenta que calcular de nuevo el valor de la consulta resetea los descuentos y recargos aplicados manualmente");
                                    break;
                                case 3:
                                    paciente.calculateFinalCost();
                                    System.out.println("costo actual: " + paciente.getConsultCost());
                                    System.out.println("porcentaje de recargo: ");
                                    percent = scan.nextInt();
                                    paciente.applySurcharge(percent);
                                    System.out.println("se aplico un recargo del: " + percent + "% al costo de la consulta\n costo actual: " + paciente.getConsultCost());
                                    System.out.println("tenga en cuenta que calcular de nuevo el valor de la consulta resetea los descuentos y recargos aplicados manualmente");
                                    break;
                                case 4:
                                    System.out.println(paciente.showData());
                                    break;
                                case 0:
                                    exit = false;
                                    break;
                            }
                        }while (!exit);
                    }else {
                        System.out.println("no se encontró ningún paciente con ese ID");
                    }
                    break;
                case 5:
                    for (Patient p : patients){
                        System.out.println(p.showData());
                    }
                    break;
                case 6:
                    int type;
                    boolean exit = false;
                    do {
                        System.out.println("""
                                Tipo de paciente:
                                1. Particular
                                2. Paciente EPS
                                3. Paciente VIP
                                0. Salir de la búsqueda
                               """);
                        type = scan.nextInt();
                        switch (type) {
                            case 1:
                                for (Patient p : patients){
                                    if (p instanceof ParticularPatient){
                                        System.out.println(p.showData());
                                    }
                                }
                                break;
                            case 2:
                                for (Patient p : patients){
                                    if (p instanceof PatientEPS){
                                        System.out.println(p.showData());
                                    }
                                }
                                break;
                            case 3:
                                for (Patient p : patients){
                                    if (p instanceof PatientVIP){
                                        System.out.println(p.showData());
                                    }
                                }
                                break;
                            case 0:
                                exit = true;
                        }
                    }while (!exit);
                    break;
                case 7:
                    for (Patient p : patients){
                        p.calculateFinalCost();
                    }
                    break;
                case 8:
                    for (Patient p : patients){
                        if (p.isExpensiveConsult()){
                            System.out.println(p.showData());
                        }
                    }
                    break;
                case 9:
                    Patient higher = patients.getFirst();
                    for (Patient p : patients){
                        if (p.getConsultCost() > higher.getConsultCost()){
                            higher = p;
                        }
                    }
                    System.out.println(higher.showData());
                    /*
                    recomendación de IA (con métodos que no conocía yo de la clase)

                    Patient higher = Collections.max(patients, Comparator.comparingInt(Patient::getConsultCost));
                    System.out.println(higher.showData());

                    para esto habría que importar java.util.collections y java.util.comparator
                    collections es una clase que se usa para trabajar con listas, el primer parámetro es la lista con la que trabaja
                    el segundo parámetro es un comparador (en este caso es una interfaz) que define como se compara
                    dentro del method comparingInt se recibe una "referencia method" (Patient::getConsultCost)
                    lo que quiere decir, cuan compare dos pacientes use el valor que retorna getConsultCost
                    de esta forma el código es más limpio reutilizable y menos propenso a errores
                    */
                    break;
                case 0:
                    break;
            }
        }while (option != 0);

    }
}
