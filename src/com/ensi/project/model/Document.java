package com.ensi.project.model;

public class Document {
    private String ref;
    private String titre;

    public Document(String ref, String titre) {
        this.ref = ref;
        this.titre = titre;
    }

    public Document() {
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String showDoc() {
        return "Référence='" + ref + '\'' +
                ", titre='" + titre + '\'';
    }

    public void Description(){
        System.out.println("fiche de bibliothèque -> Référence: "+ref+" Titre: "+titre);
    }
}
