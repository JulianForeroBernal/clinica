import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        List<Patient> patients = new java.util.ArrayList<>();
        int option;
        do {
            String name;
            int id;
            int consultCost;
            System.out.println("""
                    1. Registrar paciente particular\s
                    2. Registrar paciente EPS\s
                    3. Registrar paciente VIP\s
                    4. Buscar paciente por documento\s
                    5. Mostrar todos los pacientes\s
                    6. Mostrar pacientes por tipo\s
                    7. Calcular costo consulta\s
                    8. Mostrar consulatas costosas\s
                    9. mostrar paciente que mas pago\s
                    0. salir\s
                    """);
            option = scan.nextInt();

            switch (option){
                case 1:
                    System.out.println("nombre del paciente: ");
                    name = scan.next();
                    System.out.println("nombre del paciente: ");
                    id = scan.nextInt();
                    System.out.println("nombre del paciente: ");
                    consultCost = scan.nextInt();
                    ParticularPatient pP = new ParticularPatient(name, id, consultCost);
                    patients.add(pP);
                    break;
                case 2:
                    System.out.println("nombre del paciente: ");
                    name = scan.next();
                    System.out.println("nombre del paciente: ");
                    id = scan.nextInt();
                    System.out.println("nombre del paciente: ");
                    consultCost = scan.nextInt();
                    PatientEPS pE = new PatientEPS(name, id, consultCost);
                    patients.add(pE);
                    break;
                case 3:
                    System.out.println("nombre del paciente: ");
                    name = scan.next();
                    System.out.println("nombre del paciente: ");
                    id = scan.nextInt();
                    System.out.println("nombre del paciente: ");
                    consultCost = scan.nextInt();
                    PatientVIP pV = new PatientVIP(name, id, consultCost);
                    patients.add(pV);
                    break;
                case 4:
                    int search;
                    System.out.println("Documento del paciente: ");
                    search = scan.nextInt();
                    for (Patient p : patients){

                    }

                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 0:
                    break;

            }
        }while (option != 0);

    }
}
