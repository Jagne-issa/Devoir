package entities;

public class Client {
    private String surname;
    private String telephone;
    private String adresse;
    private Compte compte; // Peut être null si le client n'a pas de compte

    public Client(String surname, String telephone, String adresse) {
        this.surname = surname;
        this.telephone = telephone;
        this.adresse = adresse;
        this.compte = null; // Par défaut, pas de compte
    }

    public Client(String surname, String telephone, String adresse, Compte compte) {
        this.surname = surname;
        this.telephone = telephone;
        this.adresse = adresse;
        this.compte = compte;
    }

    // Getters et setters
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    // Méthode toString pour afficher les informations du client
    @Override
    public String toString() {
        return "Client{" +
                "surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", adresse='" + adresse + '\'' +
                (compte != null ? ", compte=" + compte.toString() : ", pas de compte associé") +
                '}';
    }
}
