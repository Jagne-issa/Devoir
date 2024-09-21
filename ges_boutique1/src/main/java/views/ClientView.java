package views;

import entities.Client;
import entities.Dette;
import services.ClientService;
import services.DemandeDetteService;
import services.DetteService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ClientView {
    private ClientService clientService;
    public ClientService getClientService() {
        return clientService;
    }


    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    private DetteService detteService;
    private Scanner scanner;

    public ClientView(ClientService clientService, DemandeDetteService demandeDetteService, DetteService detteService) {
        this.clientService = clientService;
        this.detteService = detteService;
        this.scanner = new Scanner(System.in);
    }


    public void afficherMenu() {
        int choix = -1;
        while (choix != 0) {
            System.out.println("===== Menu Client =====");
            System.out.println("1. Lister les dettes non soldées");
            System.out.println("2. Faire une demande de dette");
            System.out.println("3. Lister les demandes de dette");
            System.out.println("0. Quitter");

            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour de ligne

            switch (choix) {
                case 1:
                    listerDettesNonSoldees();
                    break;
                case 2:
                    faireDemandeDette();
                    break;
                case 3:
                    listerDemandesDette();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        }
    }

    private void listerDettesNonSoldees() {
        List<Dette> dettes = detteService.listerDettesNonSoldees();
        System.out.println("Liste des dettes non soldées :");
        for (Dette dette : dettes) {
            System.out.println(dette);
        }
    }

    private void faireDemandeDette() {
        System.out.print("Entrez le montant de la dette : ");
        double montant = lireDoublePositif();
        System.out.print("Entrez le montant versé : ");
        double montantVerser = lireDoublePositif();

        // Assumer que l'utilisateur est identifié par un ID ou un autre moyen
        // Pour simplifier, utiliser une méthode de demande de dette générique
        detteService.creerDemandeDette(montant, montantVerser);
        System.out.println("Demande de dette effectuée.");
    }

    private void listerDemandesDette() {
        List<Dette> demandes = detteService.listerDemandesDette();
        System.out.println("Liste des demandes de dette :");
        for (Dette demande : demandes) {
            System.out.println(demande);
        }
    }

    private double lireDoublePositif() {
        double valeur = -1;
        while (valeur < 0) {
            try {
                valeur = scanner.nextDouble();
                if (valeur < 0) {
                    System.out.println("La valeur ne peut pas être négative. Réessayez.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Consommer l'entrée invalide
            }
        }
        scanner.nextLine(); // Consommer le retour de ligne
        return valeur;
    }
}
