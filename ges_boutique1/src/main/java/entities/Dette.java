package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Dette {
    private Date date;
    private double montant;
    private double montantVerser;
    private double montantRestant;
    private List<Article> articles; // Liste des articles associés à la dette
    private List<Paiement> paiements; // Liste des paiements pour cette dette
    private Client client; // Client associé à la dette

    public Dette(Client client, Date date, double montant, double montantVerser, double montantRestant) {
        this.client = client;
        this.date = date;
        this.montant = montant;
        this.montantVerser = montantVerser;
        this.montantRestant = montantRestant;
        this.articles = new ArrayList<>();
        this.paiements = new ArrayList<>();
    }

    // Constructeur simplifié pour l'ajout d'une dette avec un montant et un montant versé
    public Dette(Client client, double montant, double montantVerser) {
        this(client, new Date(), montant, montantVerser, montant - montantVerser);
    }

    // Getters et setters
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getMontantVerser() {
        return montantVerser;
    }

    public void setMontantVerser(double montantVerser) {
        this.montantVerser = montantVerser;
    }

    public double getMontantRestant() {
        return montantRestant;
    }

    public void setMontantRestant(double montantRestant) {
        this.montantRestant = montantRestant;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Méthode pour ajouter un article
    public void ajouterArticle(Article article) {
        this.articles.add(article);
    }

    // Méthode pour ajouter un paiement
    public void ajouterPaiement(Paiement paiement) {
        this.paiements.add(paiement);
        this.montantVerser += paiement.getMontant();
        this.montantRestant -= paiement.getMontant();
    }

    @Override
    public String toString() {
        return "Dette{" +
                "date=" + date +
                ", montant=" + montant +
                ", montantVerser=" + montantVerser +
                ", montantRestant=" + montantRestant +
                ", articles=" + articles +
                ", paiements=" + paiements +
                ", client=" + client +
                '}';
    }

    public Object getClientTelephone() {
        throw new UnsupportedOperationException("Unimplemented method 'getClientTelephone'");
    }

    public boolean isSoldee() {
        throw new UnsupportedOperationException("Unimplemented method 'isSoldee'");
    }
}
