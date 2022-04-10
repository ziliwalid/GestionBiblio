package com.ensi.project.model;

public class Dictionnaire extends Document {
    private int nbr_def;

    public Dictionnaire(String ref, String titre, int nbr_def) {
        super(ref, titre);
        this.nbr_def = nbr_def;
    }

    public int getNbr_def() {
        return nbr_def;
    }

    public void setNbr_def(int nbr_def) {
        this.nbr_def = nbr_def;
    }

    @Override
    public String toString() {
        return "Dictionnaire{" +
                "nbr_def=" + nbr_def +"-> "+this.showDoc()+
                '}';
    }

    public void DescriptionDic(){
        super.Description();
        System.out.println("Nombre de définition: "+nbr_def);
    }
}
