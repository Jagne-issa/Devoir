package views;

import services.ClientService;
import services.ArticleService;
import services.DetteService;
import services.PaiementService;
import services.CompteService;
import services.DemandeDetteService;
import repositories.ClientRepository;
import repositories.ArticleRepository;
import repositories.DetteRepository;
import repositories.PaiementRepository;
import repositories.CompteRepository;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // les instances des repositories
        ClientRepository clientRepository = new ClientRepository();
        ArticleRepository articleRepository = new ArticleRepository();
        DetteRepository detteRepository = new DetteRepository();
        PaiementRepository paiementRepository = new PaiementRepository();
        CompteRepository compteRepository = new CompteRepository();

        // les instances des services
        ClientService clientService = new ClientService(clientRepository);
        ArticleService articleService = new ArticleService(articleRepository);
        DetteService detteService = new DetteService(detteRepository);
        PaiementService paiementService = new PaiementService(paiementRepository);
        CompteService compteService = new CompteService(compteRepository);
        DemandeDetteService demandeDetteService = new DemandeDetteService();

        System.out.println("Bienvenue dans l'application de gestion du cahier de dette d'une boutique !");

        // Choisir un rôle pour la session
        while (!exit) {
            System.out.println("Veuillez sélectionner votre rôle : ");
            System.out.println("1. Admin");
            System.out.println("2. Boutiquier");
            System.out.println("3. Client");
            System.out.println("4. Quitter");

            int choix = -1;
            try {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour de ligne
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Consommer l'entrée invalide
                continue; // Revenir au début de la boucle
            }

            switch (choix) {
                case 1:
                    AdminView adminView = new AdminView(compteService, articleService);
                    adminView.afficherMenu(); // Appel de la méthode correcte
                    break;
                case 2:
                    BoutiquierView boutiquierView = new BoutiquierView(clientService, detteService, articleService, paiementService);
                    boutiquierView.afficherMenu(); // Appel de la méthode correcte
                    break;
                case 3:
                    ClientView clientView = new ClientView(clientService, demandeDetteService, detteService);
                    clientView.afficherMenu(); // Appel de la méthode correcte
                    break;
                case 4:
                    System.out.println("Merci d'avoir utilisé l'application. À bientôt !");
                    exit = true;
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }
}
