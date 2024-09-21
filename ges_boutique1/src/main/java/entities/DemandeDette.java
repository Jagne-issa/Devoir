package entities;

import java.util.Date;
import java.util.List;

public class DemandeDette {
    private Client client;
    private List<Article> articles;  // Liste des articles dans la demande
    private Date dateDemande;
    private double montantTotal;
    private EtatDemande etat;  // Etat de la demande (en cours, validée, annulée)

    public DemandeDette(Client client, List<Article> articles, double montantTotal) {
        this.client = client;
        this.articles = articles;
        this.montantTotal = montantTotal;
        this.dateDemande = new Date();  // Initialise la date de la demande avec la date actuelle
        this.etat = EtatDemande.EN_COURS;  // Par défaut, la demande est en cours
    }

    // Getters et setters
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Date getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(Date dateDemande) {
        this.dateDemande = dateDemande;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "DemandeDette{" +
                "client=" + client +
                ", articles=" + articles +
                ", dateDemande=" + dateDemande +
                ", montantTotal=" + montantTotal +
                ", etat=" + etat +
                '}';
    }

    public int getId() {
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void validerDemande() {
        throw new UnsupportedOperationException("Unimplemented method 'validerDemande'");
    }

    public void annulerDemande() {
        throw new UnsupportedOperationException("Unimplemented method 'annulerDemande'");
    }
}
