package services;

import entities.Compte;
import entities.Role;
import repositories.CompteRepository;

public class CompteService {
    private CompteRepository compteRepository;

    public CompteService(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    public void creerCompte(String email, String password, Role role) {
        Compte compte = new Compte(email, password, role);
        compteRepository.ajouterCompte(compte);
        System.out.println("Compte créé avec succès.");
    }

    public void activerDesactiverCompte(String email) {
        compteRepository.activerDesactiverCompte(email);
        System.out.println("Compte modifié avec succès.");
    }

    public Compte rechercherCompteParEmail(String email) {
        return compteRepository.trouverCompteParEmail(email)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé pour l'email : " + email));
    }
}
