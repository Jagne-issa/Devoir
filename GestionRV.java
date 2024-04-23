import java.util.ArrayList;
import java.util.List;

class Patient {
    String nom;
    String prenom;
    String telephone;
    String numero;

    public Patient(String nom, String prenom, String telephone) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
    }
}

class RendezVous {
    Patient patient;
    String specialite;
    String etat;

    public RendezVous(Patient patient, String specialite, String etat) {
        this.patient = patient;
        this.specialite = specialite;
        this.etat = etat;
    }
}

public class GestionRV {
    List<Patient> patients;
    List<RendezVous> rendezvous;
    int numPatient;

    public GestionRV() {
        patients = new ArrayList<>();
        rendezvous = new ArrayList<>();
        numPatient = 0;
    }

    public void ajouterPatient(String nom, String prenom, String telephone) {
        numPatient++;
        String numeroPatient = String.format("PAT%04d", numPatient);
        Patient patient = new Patient(nom, prenom, telephone);
        patient.numero = numeroPatient;
        patients.add(patient);
    }

    public void listerPatients() {
        for (Patient patient : patients) {
            System.out.println("Patient " + patient.numero + ": " + patient.nom + " " + patient.prenom + " - Téléphone: " + patient.telephone);
        }
    }

    public void enregistrerRV(String telephonePatient, String specialite, String etat) {
        Patient patient = null;
        for (Patient p : patients) {
            if (p.telephone.equals(telephonePatient)) {
                patient = p;
                break;
            }
        }
        if (patient != null) {
            RendezVous rv = new RendezVous(patient, specialite, etat);
            rendezvous.add(rv);
        } else {
            System.out.println("Patient non trouvé.");
        }
    }

    public void listerRVParEtat(String etat) {
        for (RendezVous rv : rendezvous) {
            if (rv.etat.equals(etat)) {
                System.out.println("Rendez-vous pour " + rv.patient.nom + " " + rv.patient.prenom + " - Spécialité: " + rv.specialite);
            }
        }
    }

    public void listerRVParSpecialite(String specialite) {
        for (RendezVous rv : rendezvous) {
            if (rv.specialite.equals(specialite)) {
                System.out.println("Rendez-vous pour " + rv.patient.nom + " " + rv.patient.prenom + " - Etat: " + rv.etat);
            }
        }
    }

    public static void main(String[] args) {
        GestionRV gestionRV = new GestionRV();
        gestionRV.ajouterPatient("Diagne", "Issa", "772887445");
        gestionRV.ajouterPatient("Sow", "Anna", "770906394");
        gestionRV.ajouterPatient("Fall", "Babacar", "771446702");
        gestionRV.enregistrerRV("772887445", "Cardiologie", "En cours");
        gestionRV.enregistrerRV("771446702", "Ophtalmologie", "En cours");
        gestionRV.listerPatients();
        System.out.println("\nRendez-vous en cours:");
        gestionRV.listerRVParEtat("En cours");
        System.out.println("\nRendez-vous de Cardiologie:");
        gestionRV.listerRVParSpecialite("Cardiologie");
    }
}
