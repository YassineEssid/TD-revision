package tn.esprit.gestionEtudiant.entities;

public class Etudiant3eme extends Etudiant {

    private String branche;


    @Override
    public void ajouterUneAbsence() {
        moyenne -= 0.5F;
        if (moyenne <= 0){
            moyenne = 0;
        }
    }

    public String getBranche() {
        return branche;
    }

    public void setBranche(String branche) {
        this.branche = branche;
    }

    public Etudiant3eme(int identifiant, String nom, String prenom, float moyenne,String branche) {
        super(identifiant, nom, prenom, moyenne);
        this.branche=branche;
    }


}
