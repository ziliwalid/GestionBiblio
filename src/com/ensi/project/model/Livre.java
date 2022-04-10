package com.ensi.project.model;

public class Livre extends Document{
    private String auteur;
    private int nbr_pages;

    public Livre(String ref, String titre, String auteur, int nbr_pages) {
        super(ref, titre);
        this.auteur = auteur;
        this.nbr_pages = nbr_pages;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getNbr_pages() {
        return nbr_pages;
    }

    public void setNbr_pages(int nbr_pages) {
        this.nbr_pages = nbr_pages;
    }


    @Override
    public String toString() {
        return "Livre{" +
                "auteur='" + auteur + '\'' +
                ", nbr_pages=" + nbr_pages + "-> "+this.showDoc()+
                '}';
    }

    public void DescriptionLivre(){
        super.Description();
        System.out.println("Auteur du livre: "+auteur);
    }
}
