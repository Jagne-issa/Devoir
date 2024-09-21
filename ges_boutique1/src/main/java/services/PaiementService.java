package services;

import entities.Dette;
import entities.Paiement;
import repositories.DetteRepository;
import repositories.PaiementRepository;

import java.util.Date;
import java.util.List;

public class PaiementService {
    private DetteRepository detteRepository;
    private PaiementRepository paiementRepository; // Ajouté si vous prévoyez d'utiliser un PaiementRepository

    public PaiementRepository getPaiementRepository() {
        return paiementRepository;
    }

    public void setPaiementRepository(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    // Constructeur avec DetteRepository
    public PaiementService(DetteRepository detteRepository) {
        this.detteRepository = detteRepository;
    }

    // Constructeur avec PaiementRepository (si nécessaire)
    public PaiementService(PaiementRepository paiementRepository) {
        this.paiementRepository = paiementRepository;
    }

    // Constructeur par défaut
    public PaiementService() {
    }

    // Getter pour DetteRepository
    public DetteRepository getDetteRepository() {
        return detteRepository;
    }

    // Setter pour DetteRepository
    public void setDetteRepository(DetteRepository detteRepository) {
        this.detteRepository = detteRepository;
    }

    // Enregistrer un paiement pour une dette
    public void enregistrerPaiement(Dette dette, double montantPaiement) {
        if (montantPaiement <= dette.getMontantRestant()) {
            // Créer un nouveau paiement
            Paiement paiement = new Paiement(new Date(), montantPaiement);
            dette.ajouterPaiement(paiement);
            // Mettre à jour le montant restant
            dette.setMontantRestant(dette.getMontantRestant() - montantPaiement);
        } else {
            System.out.println("Le montant du paiement dépasse le montant restant de la dette.");
        }
    }

    // Lister les paiements d'une dette
    public List<Paiement> listerPaiements(Dette dette) {
        return dette.getPaiements();
    }

    public void enregistrerPaiement(int idDette, double montant) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'enregistrerPaiement'");
    }
}
