package tn.esprit.gestionEtudiant.entities;

import tn.esprit.gestionEtudiant.Exceptions.EcolePleineException;
import tn.esprit.gestionEtudiant.Exceptions.EtudiantExisteException;
import tn.esprit.gestionEtudiant.Exceptions.EtudiantIntrouvableException;

public class Ecole {
    public String nom;
    public Etudiant[] etudiants;
    public int nbrEtudiants;

    public Ecole(String nom) {
        this.nom = nom;
        this.etudiants = new  Etudiant[500];
        this.nbrEtudiants = 0;
    }

    public void ajouterEtudiant(Etudiant etudiant) throws EtudiantExisteException {
        if (rechercherEtudiant(etudiant) == -1) {
            if (nbrEtudiants < etudiants.length) {
                etudiants[nbrEtudiants] = etudiant;
                nbrEtudiants++;
                System.out.println("Étudiant ajouté");
            } else {
                System.out.println("L'école est pleine");
            }
        } else {
            throw new EtudiantExisteException ("Cet étudiant est déjà inscrit");
        }
    }

    public int rechercherEtudiant(Etudiant e) {
        for (int i = 0; i < nbrEtudiants; i++) {
            if (e.getNom().equals(etudiants[i].getNom())) {
                return i;
            }
        }
        return -1;
    }

    public float getMoyenneDes3A() {
        float sommeDesMoyennes = 0;
        int nombreEtudiants3A = 0;

        for (int i = 0; i < nbrEtudiants; i++) {
            if (etudiants[i] instanceof Etudiant3eme) {
                sommeDesMoyennes += etudiants[i].getMoyenne();
                nombreEtudiants3A++;
            }
        }

        if (nombreEtudiants3A == 0) {
            return 0;
        }

        return sommeDesMoyennes / nombreEtudiants3A;
    }

    public float moyenneSalaireAlternants() {
        float sommeDesSalaires = 0;
        int nombreAlternants = 0;

        for (int i = 0; i < nbrEtudiants; i++) {
            if (etudiants[i] instanceof EtudiantAlternance) {
                sommeDesSalaires += ((EtudiantAlternance) etudiants[i]).getSalaire();
                nombreAlternants++;
            }
        }

        if (nombreAlternants == 0) {
            return 0;
        }

        return sommeDesSalaires / nombreAlternants;
    }

    @Override
    public String toString(){
        StringBuilder sb= new StringBuilder();
        System.out.println("Nom de l'école:"+ nom) ;
        System.out.println("Liste des étudiants");
        for (int i = 0; i < nbrEtudiants; i++) {
            System.out.println(etudiants[i].toString());
        }

        return sb.toString();
    }

    public void changerEcole(Etudiant etd, Ecole nouvelleEcole) throws EtudiantExisteException {
        int indiceEtudiant = rechercherEtudiant(etd);

        if (indiceEtudiant != -1) {
            for (int i = indiceEtudiant; i < nbrEtudiants - 1; i++) {
                etudiants[i] = etudiants[i + 1];
            }
            nbrEtudiants--;

            try {
                nouvelleEcole.ajouterEtudiant(etd);
                System.out.println(etd.getNom() + " a changé d'école avec succès.");
            } catch (EtudiantExisteException ex) {
                System.out.println("Échec du changement d'école : " + ex.getMessage());
                etudiants[nbrEtudiants] = etd;
                nbrEtudiants++;
            }
        } else {
            try {
                throw new EtudiantIntrouvableException("Cet étudiant n'est pas inscrit à cette école.");
            } catch (EtudiantIntrouvableException e) {
                throw new RuntimeException(e);
            }
        }
    }












}
