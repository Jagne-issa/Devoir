Définir une Structure Patient:
    nom : chaîne de caractères
    prénom : chaîne de caractères
    téléphone : chaîne de caractères
    numéro : chaîne de caractères

Définir une Structure RendezVous:
    patient : Patient
    spécialité : chaîne de caractères
    état : chaîne de caractères

Définir une Structure GestionRV:
    patients : tableau de Patient
    rendezvous : tableau de RendezVous
    num_patient : entier

Procédure ajouter_patient(nom, prenom, telephone):
    num_patient <- num_patient + 1
    numero_patient <- "PAT" concaténer avec formater(num_patient, "0000")
    patient <- Créer une nouvelle instance de Patient avec nom, prenom, telephone et numero_patient
    Ajouter patient à patients

Procédure lister_patients():
    Pour chaque patient dans patients:
        Afficher "Patient " concaténer avec patient.numero concaténer avec ": " concaténer avec patient.nom concaténer avec " " concaténer avec patient.prenom concaténer avec " - Téléphone: " concaténer avec patient.telephone

Procédure enregistrer_rv(patient_telephone, specialite, etat):
    patient <- Chercher le patient dans patients avec le téléphone patient_telephone
    Si patient est différent de None:
        rv <- Créer une nouvelle instance de RendezVous avec patient, specialite et etat
        Ajouter rv à rendezvous
    Sinon:
        Afficher "Patient non trouvé."

Procédure lister_rv_par_etat(etat):
    Pour chaque rv dans rendezvous:
        Si rv.etat est égal à etat:
            Afficher "Rendez-vous pour " concaténer avec rv.patient.nom concaténer avec " " concaténer avec rv.patient.prenom concaténer avec " - Spécialité: " concaténer avec rv.specialite

Procédure lister_rv_par_specialite(specialite):
    Pour chaque rv dans rendezvous:
        Si rv.specialite est égal à specialite:
            Afficher "Rendez-vous pour " concaténer avec rv.patient.nom concaténer avec " " concaténer avec rv.patient.prenom concaténer avec " - Etat: " concaténer avec rv.etat

// Exemple d'utilisation
Déclarer gestion_rv de type GestionRV
Initialiser gestion_rv.patients à un tableau vide
Initialiser gestion_rv.rendezvous à un tableau vide
Initialiser gestion_rv.num_patient à 0

Appeler ajouterPatient avec("Diagne", "Issa", "772887445");
Appeler ajouterPatient avec("Sow", "Anna", "770906394");
Appeler ajouterPatient avec("Fall", "Babacar", "771446702");
Appeler enregistrerRV avec("772887445", "Cardiologie", "En cours");
Appeler enregistrerRV avec("771446702", "Ophtalmologie", "En cours");
Appeler listerPatients avec();
Afficher "Rendez-vous en cours:"
Appeler lister_rv_par_etat avec "En cours"
Afficher "Rendez-vous de Cardiologie:"
Appeler lister_rv_par_specialite avec "Cardiologie"
