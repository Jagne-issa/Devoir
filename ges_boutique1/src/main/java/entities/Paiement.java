package entities;

import java.util.Date;

public class Paiement {
    private int id; // Identifiant unique du paiement
    private Date date;
    private double montant;

    // Constructeur complet
    public Paiement(int id, Date date, double montant) {
        this.id = id;
        this.date = date;
        this.montant = montant;
    }

    // Constructeur avec date et montant seulement (ID géré autrement)
    public Paiement(Date date, double montant) {
        this.date = date;
        this.montant = montant;
        this.id = 0; // Placeholder ID, devrait être généré ailleurs
    }

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }
}
