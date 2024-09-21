package repositories;

import entities.Compte;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CompteRepository {
    private List<Compte> comptes;

    public CompteRepository() {
        this.comptes = new ArrayList<>();
    }

    public void ajouterCompte(Compte compte) {
        comptes.add(compte);
    }

    public void activerDesactiverCompte(String email) {
        Optional<Compte> optionalCompte = comptes.stream()
            .filter(c -> c.getEmail().equals(email))
            .findFirst();
        
        if (optionalCompte.isPresent()) {
            Compte existingCompte = optionalCompte.get();
            existingCompte.setActif(!existingCompte.isActif());
        } else {
            throw new RuntimeException("Compte non trouvé pour l'email : " + email);
        }
    }

    public Optional<Compte> trouverCompteParEmail(String email) {
        return comptes.stream()
                .filter(c -> c.getEmail().equals(email))
                .findFirst();
    }

    public List<Compte> listerComptes() {
        return new ArrayList<>(comptes);
    }
}
