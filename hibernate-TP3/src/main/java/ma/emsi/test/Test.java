package ma.emsi.test;

import ma.emsi.entities.Machine;
import ma.emsi.entities.Salle;
import ma.emsi.services.MachineService;
import ma.emsi.services.SalleService;

import java.util.Date;

public class Test {

    public static void main(String[] args) {
        SalleService salleService = new SalleService();
        MachineService machineService = new MachineService();

        // Création et insertion de salles
        Salle salle1 = new Salle("A1");
        Salle salle2 = new Salle("B2");
        salleService.create(salle1);
        salleService.create(salle2);

        // Création et insertion de machines
        Machine machine1 = new Machine("M123", new Date(), salleService.findById(1));
        Machine machine2 = new Machine("M124", new Date(), salleService.findById(2));
        machineService.create(machine1);
        machineService.create(machine2);

        // Affichage des salles et leurs machines
        for (Salle salle : salleService.findAll()) {
            System.out.println("Salle: " + salle.getCode());
            for (Machine machine : salle.getMachines()) {
                System.out.println("  Machine: " + machine.getRef());
            }
        }

        // Utilisation de la méthode findBetweenDate
        Date d1 = new Date(110, 0, 1); // 1er janvier 2010
        Date d2 = new Date(); // Date actuelle
        System.out.println("Machines achetées entre " + d1 + " et " + d2 + ":");
        for (Machine machine : machineService.findBetweenDate(d1, d2)) {
            System.out.println("  " + machine.getRef() + " achetée le " + machine.getDateAchat());
        }
    }
}
