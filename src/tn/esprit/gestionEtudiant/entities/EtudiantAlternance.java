package tn.esprit.gestionEtudiant.entities;

public class EtudiantAlternance extends Etudiant {

    private int salaire;

    @Override
    public void ajouterUneAbsence() {
        salaire -= 50;
        if (salaire <= 0) {
            salaire = 0;
        }
    }


    public int getSalaire() {
        return salaire;
    }

    public void setSalaire(int salaire) {
        this.salaire = salaire;
    }

    public EtudiantAlternance(int identifiant, String nom, String prenom, float moyenne,int salaire) {
        super(identifiant, nom, prenom, moyenne);
        this.salaire=salaire;
    }

    public String toString() {
        return "Identifiant :"+ identifiant +"Nom :"+ nom + "Prénom :"+ prenom
                +"Moyenne :"+ moyenne +"Salaire :"+ salaire;
    }
}
