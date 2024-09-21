package services;

import entities.Dette;
import entities.Paiement;
import entities.Client;
import repositories.DetteRepository;
import java.util.List;

public class DetteService {
    private DetteRepository detteRepository;

    // Constructeur avec le repository Dette
    public DetteService(DetteRepository detteRepository) {
        this.detteRepository = detteRepository;
    }

    // Constructeur par défaut si tu souhaites l'utiliser plus tard
    public DetteService() {
        this.detteRepository = new DetteRepository(); // initialisation de DetteRepository
    }

    // Méthode pour créer une nouvelle dette pour un client
    public void creerDette(Client client, double montant, double montantVerser) {
        Dette dette = new Dette(client, montant, montantVerser);
        detteRepository.ajouterDette(dette);
    }

    // Méthode pour lister les dettes non soldées d'un client
    public List<Dette> listerDettesNonSoldees(Client client) {
        return detteRepository.getDettesNonSoldees(client);
    }

    // Enregistrement d'un paiement pour une dette
    public void enregistrerPaiement(Dette dette, Paiement montant) {
        dette.ajouterPaiement(montant);
        detteRepository.mettreAJourDette(dette);
    }

    // Méthode pour récupérer le repository Dette
    public DetteRepository getDetteRepository() {
        return detteRepository;
    }

    public List<Dette> listerDettesNonSoldees() {
        throw new UnsupportedOperationException("Unimplemented method 'listerDettesNonSoldees'");
    }

    public void creerDemandeDette(double montant, double montantVerser) {
        throw new UnsupportedOperationException("Unimplemented method 'creerDemandeDette'");
    }

    public List<Dette> listerDemandesDette() {
        throw new UnsupportedOperationException("Unimplemented method 'listerDemandesDette'");
    }
}
