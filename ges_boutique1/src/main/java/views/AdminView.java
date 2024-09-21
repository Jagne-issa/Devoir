package views;

import services.ArticleService;
import services.CompteService;

import java.util.InputMismatchException;
import java.util.Scanner;

import entities.Compte;
import entities.Role;

public class AdminView {
    private CompteService compteService;
    private ArticleService articleService;
    private Scanner scanner;

    // Constructeur principal
    public AdminView(CompteService compteService, ArticleService articleService) {
        this.compteService = compteService;
        this.articleService = articleService;
        this.scanner = new Scanner(System.in);
    }

    public void afficherMenu() {
        int choix = -1;
        while (choix != 0) {
            System.out.println("===== Menu Admin =====");
            System.out.println("1. Créer un compte utilisateur");
            System.out.println("2. Désactiver/Activer un compte utilisateur");
            System.out.println("3. Créer un article");
            System.out.println("4. Mettre à jour le stock d'un article");
            System.out.println("0. Quitter");

            System.out.print("Entrez votre choix : ");
            try {
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour de ligne

                switch (choix) {
                    case 1:
                        creerCompte();
                        break;
                    case 2:
                        activerDesactiverCompte();
                        break;
                    case 3:
                        creerArticle();
                        break;
                    case 4:
                        mettreAJourStockArticle();
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide, réessayez.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer un nombre.");
                scanner.next(); // Consommer l'entrée invalide
            }
        }
    }

    private void creerCompte() {
        System.out.print("Entrez l'email : ");
        String email = scanner.nextLine();
        System.out.print("Entrez le mot de passe : ");
        String password = scanner.nextLine();
        System.out.print("Entrez le rôle (ADMIN, BOUTIQUIER, CLIENT) : ");
        String roleInput = scanner.nextLine();

        // Valider le rôle
        Role role;
        try {
            role = Role.valueOf(roleInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Rôle invalide.");
            return;
        }

        // Créer le compte utilisateur
        compteService.creerCompte(email, password, role);
        System.out.println("Compte créé avec succès.");
    }

    private void activerDesactiverCompte() {
        System.out.print("Entrez l'email du compte à modifier : ");
        String email = scanner.nextLine();
        Compte compte = compteService.rechercherCompteParEmail(email);
        if (compte == null) {
            System.out.println("Compte non trouvé.");
            return;
        }

        System.out.println("Le compte est actuellement " + (compte.isActif() ? "actif" : "inactif"));
        System.out.print("Voulez-vous changer l'état du compte ? (oui/non) : ");
        String confirmation = scanner.nextLine();
        if (confirmation.equalsIgnoreCase("oui")) {
            compteService.activerDesactiverCompte(email); // Passe l'email au lieu de l'objet Compte
            System.out.println("Le statut du compte a été modifié.");
        } else {
            System.out.println("Aucune modification effectuée.");
        }
    }

    private void creerArticle() {
        System.out.print("Entrez le nom de l'article : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez la quantité en stock : ");
        int quantite = lireEntierPositif();
        System.out.print("Entrez le prix de l'article : ");
        double prix = lireDoublePositif();

        articleService.creerArticle(nom, quantite, prix);
        System.out.println("Article créé avec succès.");
    }

    private void mettreAJourStockArticle() {
        System.out.print("Entrez le nom de l'article à modifier : ");
        String nom = scanner.nextLine();
        System.out.print("Entrez la nouvelle quantité en stock : ");
        int nouvelleQuantite = lireEntierPositif();

        articleService.mettreAJourStock(nom, nouvelleQuantite);
        System.out.println("Le stock de l'article a été mis à jour.");
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
