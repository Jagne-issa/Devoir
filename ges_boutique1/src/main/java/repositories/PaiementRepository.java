package repositories;

import entities.Paiement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PaiementRepository {
    private List<Paiement> paiements;

    public PaiementRepository() {
        this.paiements = new ArrayList<>();
    }

    // Ajouter un paiement
    public void ajouterPaiement(Paiement paiement) {
        paiements.add(paiement);
    }

    // Trouver un paiement par ID
    public Optional<Paiement> trouverPaiementParId(int id) {
        return paiements.stream()
                .filter(paiement -> paiement.getId() == id)
                .findFirst();
    }

    // Supprimer un paiement
    public void supprimerPaiement(int id) {
        paiements.removeIf(paiement -> paiement.getId() == id);
    }

    // Mettre à jour un paiement
    public void mettreAJourPaiement(Paiement paiement) {
        Optional<Paiement> paiementExist = trouverPaiementParId(paiement.getId());
        paiementExist.ifPresent(existingPaiement -> {
            int index = paiements.indexOf(existingPaiement);
            paiements.set(index, paiement);
        });
    }

    // Liste tous les paiements
    public List<Paiement> listerTousLesPaiements() {
        return new ArrayList<>(paiements);
    }
}
