package views;

import entities.Client;
import entities.Dette;
import services.ArticleService;
import services.ClientService;
import services.DetteService;
import services.PaiementService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BoutiquierView {
    private ClientService clientService;
    private DetteService detteService;
    private ArticleService articleService;
    public ArticleService getArticleService() {
        return articleService;
    }

    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    private PaiementService paiementService;
    private Scanner scanner;

    public BoutiquierView(ClientService clientService, DetteService detteService, ArticleService articleService, PaiementService paiementService) {
        this.clientService = clientService;
        this.detteService = detteService;
        this.articleService = articleService;
        this.paiementService = paiementService;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = -1;
        while (choix != 0) {
            System.out.println("===== Menu Boutiquier =====");
            System.out.println("1. Créer un client");
            System.out.println("2. Lister les clients");
            System.out.println("3. Rechercher un client par téléphone");
            System.out.println("4. Créer une dette pour un client");
            System.out.println("5. Enregistrer un paiement pour une dette");
            System.out.println("6. Lister les dettes non soldées d'un client");
            System.out.println("0. Quitter");

            System.out.print("Entrez votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour de ligne

            switch (choix) {
                case 1:
                    creerClient();
                    break;
                case 2:
                    listerClients();
                    break;
                case 3:
                    rechercherClientParTelephone();
                    break;
                case 4:
                    creerDette();
                    break;
                case 5:
                    enregistrerPaiement();
                    break;
                case 6:
                    listerDettesNonSoldees();
                    break;
                case 0:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        }
    }

    private void creerClient() {
        System.out.print("Entrez le nom du client : ");
        String surname = scanner.nextLine();
        System.out.print("Entrez le téléphone du client : ");
        String telephone = scanner.nextLine();
        System.out.print("Entrez l'adresse du client : ");
        String adresse = scanner.nextLine();

        clientService.creerClient(surname, telephone, adresse);
        System.out.println("Client créé avec succès.");
    }

    private void listerClients() {
        List<Client> clients = clientService.listerClients();
        System.out.println("Liste des clients :");
        for (Client client : clients) {
            System.out.println(client);
        }
    }

    private void rechercherClientParTelephone() {
        System.out.print("Entrez le numéro de téléphone : ");
        String telephone = scanner.nextLine();
        Client client = clientService.rechercherClientParTelephone(telephone);
        if (client != null) {
            System.out.println("Client trouvé : " + client);
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private void creerDette() {
        System.out.print("Entrez le numéro de téléphone du client : ");
        String telephone = scanner.nextLine();
        Client client = clientService.rechercherClientParTelephone(telephone);
        if (client != null) {
            System.out.print("Entrez le montant de la dette : ");
            double montant = lireDoublePositif();
            System.out.print("Entrez le montant versé : ");
            double montantVerser = lireDoublePositif();

            detteService.creerDette(client, montant, montantVerser);
            System.out.println("Dette créée avec succès.");
        } else {
            System.out.println("Client non trouvé.");
        }
    }

    private void enregistrerPaiement() {
        System.out.print("Entrez le telephone  : ");
        int idDette = lireEntierPositif();
        System.out.print("Entrez le montant du paiement : ");
        double montant = lireDoublePositif();

        paiementService.enregistrerPaiement(idDette, montant);
        System.out.println("Paiement enregistré avec succès.");
    }

    private void listerDettesNonSoldees() {
        List<Dette> dettes = detteService.listerDettesNonSoldees();
        System.out.println("Liste des dettes non soldées :");
        for (Dette dette : dettes) {
            System.out.println(dette);
        }
    }

    private int lireEntierPositif() {
        int valeur = -1;
        while (valeur < 0) {
            try {
                valeur = scanner.nextInt();
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
