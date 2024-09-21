package services;

import entities.Client;
import entities.DemandeDette;
import entities.Article;
import repositories.DemandeDetteRepository;
import java.util.List;

public class DemandeDetteService {
    private DemandeDetteRepository demandeRepository;

    public DemandeDetteService(DemandeDetteRepository demandeRepository) {
        this.demandeRepository = demandeRepository;
    }

    public DemandeDetteService() {
        this.demandeRepository = new DemandeDetteRepository(); // initialisation par défaut
    }

    public void creerDemandeDette(Client client, List<Article> articles, double montantTotal) {
        DemandeDette demande = new DemandeDette(client, articles, montantTotal);
        demandeRepository.ajouterDemande(demande);
    }

    public List<DemandeDette> listerDemandesEnCours() {
        return demandeRepository.getDemandesEnCours();
    }

    public void validerDemande(DemandeDette demande) {
        demande.validerDemande();
        demandeRepository.mettreAJourDemande(demande);
    }

    public void annulerDemande(DemandeDette demande) {
        demande.annulerDemande();
        demandeRepository.mettreAJourDemande(demande);
    }

    public void creerDemandeDette(Client client, double montant) {
        throw new UnsupportedOperationException("Unimplemented method 'creerDemandeDette'");
    }

    public List<DemandeDette> listerDemandesDette(Client client) {
        throw new UnsupportedOperationException("Unimplemented method 'listerDemandesDette'");
    }
}
