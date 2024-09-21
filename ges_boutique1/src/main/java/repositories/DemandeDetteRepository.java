package repositories;

import entities.DemandeDette;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DemandeDetteRepository {
    private List<DemandeDette> demandes;

    public DemandeDetteRepository() {
        this.demandes = new ArrayList<>();
    }

    // Ajouter une demande
    public void ajouterDemande(DemandeDette demande) {
        demandes.add(demande);
    }

    // Trouver une demande par ID
    public Optional<DemandeDette> trouverDemandeParId(int id) {
        return demandes.stream()
                .filter(demande -> demande.getId() == id)
                .findFirst();
    }

    // Mettre à jour une demande
    public void mettreAJourDemande(DemandeDette demande) {
        Optional<DemandeDette> demandeExist = trouverDemandeParId(demande.getId());
        demandeExist.ifPresent(existingDemande -> {
            int index = demandes.indexOf(existingDemande);
            demandes.set(index, demande);
        });
    }

    // Liste toutes les demandes
    public List<DemandeDette> listerToutesLesDemandes() {
        return new ArrayList<>(demandes);
    }

    public List<DemandeDette> getDemandesEnCours() {
        throw new UnsupportedOperationException("Unimplemented method 'getDemandesEnCours'");
    }
}
