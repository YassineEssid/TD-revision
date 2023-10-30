package tn.esprit.gestionEtudiant.entities;
public abstract class Etudiant {

    public int identifiant;
    public String nom, prenom;
    public float moyenne;

    public Etudiant(int identifiant, String nom, String prenom, float moyenne){
        this.identifiant=identifiant;
        this.nom=nom;
        this.prenom=prenom;
        this.moyenne=moyenne;
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj.getClass() == Etudiant.class){
            Etudiant e = (Etudiant) obj;
            return (e.getNom() == this.getNom()) && (e.getIdentifiant() == this.getIdentifiant());
        }
        return false;
    }

    @Override
    public String toString() {
        return "Identifiant :"+ identifiant +"Nom :"+ nom + "Prénom :"+ prenom
+"Moyenne :"+ moyenne;
    }

    public abstract void ajouterUneAbsence();








}
