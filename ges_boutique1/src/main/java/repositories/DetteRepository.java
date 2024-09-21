package repositories;

import java.util.ArrayList;
import java.util.List;

import entities.Client;
import entities.Dette;

public class DetteRepository {
    private List<Dette> dettes = new ArrayList<>();

    // Méthode pour ajouter une dette pour des fins de démonstration
    public void ajouterDette(Dette dette) {
        dettes.add(dette);
    }

    // Implémentation de la méthode pour trouver les dettes non soldées par téléphone du client
    public List<Dette> findNonSoldeesByClientTelephone(String clientTelephone) {
        List<Dette> dettesNonSoldees = new ArrayList<>();
        for (Dette dette : dettes) {
            if (dette.getClientTelephone().equals(clientTelephone) && !dette.isSoldee()) {
                dettesNonSoldees.add(dette);
            }
        }
        return dettesNonSoldees;
    }

    // Méthode pour rechercher une dette par montant
    public Dette findByMontant(double montant) {
        for (Dette dette : dettes) {
            if (dette.getMontant() == montant) {
                return dette;
            }
        }
        return null;
    }

    // Méthode pour rechercher une dette par téléphone du client
    public Dette findByClientTelephone(String telephone) {
        for (Dette dette : dettes) {
            if (dette.getClientTelephone().equals(telephone)) {
                return dette;
            }
        }
        return null;
    }

    public void mettreAJourDette(Dette dette) {
        throw new UnsupportedOperationException("Unimplemented method 'mettreAJourDette'");
    }

    public List<Dette> getDettesNonSoldees(Client client) {
        throw new UnsupportedOperationException("Unimplemented method 'getDettesNonSoldees'");
    }
}
