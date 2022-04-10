package com.ensi.project.model;

import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class Biblio {
    private Livre[] livres;
    private Dictionnaire[] dictionnaires;
    private int current_index =0; //indice de livre
    private int current_indexD =0;//indice de dictionnaire
    final int maxDocs = 50;

    Scanner in = new Scanner(System.in);
    public Biblio(){
        this.livres = new Livre[maxDocs];
        this.dictionnaires = new Dictionnaire[maxDocs];
    }

//Methode de verification de disponibilité d'ajout
    private void checkDocLength() throws Exception {
        if (current_index >= maxDocs) throw new Exception("YOU CAN'T ADD NO MORE BRO");
    }
//Methode d'ajout
    public void ajouterUnDoc() {

        while (true) {
            try {
                AjouterDoc();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
    private void AjouterDoc() throws Exception {
        checkDocLength();
        System.out.println("Vous voulez saisir un Livre ou un dictionnaire ? (l/d)");
        String choix = in.nextLine();
        if (choix.equals("l")){
            ajouterLivre();
        }else {
            ajouterDictionnaire();
        }


    }
    private void ajouterLivre() throws Exception {
        System.out.println("Saisissez la référence:");
        String ref = in.nextLine();
        System.out.println("saisissez le titre: ");
        String titre = in.nextLine();
        System.out.println("saisissez l'auteur du livre: ");
        String author = in.nextLine();
        System.out.println("saisissez le nombre de pages: ");
        int nbr = in.nextInt();
        Livre book = new Livre(ref,titre,author,nbr);
        livres[current_index++] = book;
        String ok="";
        in.nextLine();
        do {
            System.out.print("Continuez (o/n)...");
            ok = in.nextLine();
        } while (!ok.equals("n") && !ok.equals("o"));

        if(ok.equals("n"))
            throw new Exception("Fin de saisie");
    }
    private void ajouterDictionnaire() throws Exception {
        System.out.println("Saisissez la référence:");
        String ref = in.nextLine();
        System.out.println("saisissez le titre: ");
        String titre = in.nextLine();
        System.out.println("saisissez le nombre de définition: ");
        int nbr = in.nextInt();
        Dictionnaire dic = new Dictionnaire(ref,titre,nbr);
        dictionnaires[current_indexD++]=dic;
        String ok="";
        in.nextLine();
        do {
            System.out.print("Continuez (o/n)...");
            ok = in.nextLine();
        } while (!ok.equals("n") && !ok.equals("o"));

        if(ok.equals("n"))
            throw new Exception("Fin de saisie");
    }
//Affichage de menu
    public void menuSelectSection() {
        System.out.println("~ Menu ~");
        System.out.println("1-Ajouter un document ");
        System.out.println("2-Afficher tout les documents");
        System.out.println("3-Supprimer un document");
        System.out.println("3-Supprimer un document");
        System.out.println("4-Trier les livres ou les dictionnaires");
        System.out.println("5-Convertir les noms des livres ou des dictionnaires en majuscule ");
        System.out.println("6-Calculer le nombre de livres ");
        System.out.println("7-Afficher tout les dictionnaires");
        System.out.println("8-Afficher tout les auteurs");
        System.out.println("9-Afficher toutes les descriptions");
        System.out.print("**Votre choix : ");

    }
//Methode d'affichages
    public void show() {
        boolean isEmptyList = true;
        for (int i = 0; i < maxDocs; i++) {
            if (livres[i] != null || dictionnaires[i] !=null) {
                isEmptyList = false;
                System.out.println(livres[i]);
                System.out.println(dictionnaires[i]);
            }

        }
        if (isEmptyList) System.out.println("Liste vide");

    }
//Methode pour supprimer un document
    public void supprimerDoc() {
        System.out.println("Vous voulez supprimer un livre ou un document ? (l/d)");
        String choice = in.nextLine();
        if (choice.equals("l")){
            supprimerLivre();
        }else {
            supprimerDictionnaire();
        }


    }
    private void supprimerDictionnaire() {
        System.out.println("Saisissez le nom du dictionnaire a supprimer");
        String delName = in.nextLine();
        Dictionnaire[] newArray = new Dictionnaire[maxDocs];
        for (int i = 0, k = 0; i < maxDocs; i++) {
            if (dictionnaires[i] != null) {
                if (Objects.equals(dictionnaires[i].getTitre(), delName)) {
                    current_indexD--;
                } else {
                    newArray[k++] = dictionnaires[i];
                }
            }
        }
        dictionnaires = new Dictionnaire[maxDocs];
        for (int i = 0; i < maxDocs; i++) {
            dictionnaires[i] = newArray[i];
        }

        show();

    }
    private void supprimerLivre() {

            System.out.println("Saisissez le nom du livre a supprimer");
            String delName = in.nextLine();
            Livre[] newArray = new Livre[maxDocs];
            for (int i = 0, k = 0; i < maxDocs; i++) {
                if (livres[i] != null) {
                    if (Objects.equals(livres[i].getTitre(), delName)) {
                        current_index--;
                    } else {
                        newArray[k++] = livres[i];
                    }
                }
            }
             livres = new Livre[maxDocs];
            for (int i = 0; i < maxDocs; i++) {
                livres[i] = newArray[i];
            }

            show();

        }
//Methode de Tri (general)
    public void TrierLD() {
        System.out.println("Vous voulez triez les livres ou les dictionnaires ? (l/d)");
        String choice = in.nextLine();
        //trie de livre
        if (choice.equals("l")){
            sortArrayL();
        }else
            sortArrayD();
   }
//Tri pour livre
    static void bubbleSortL(Livre[] livres) {
        int n = livres.length;
        Livre temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (compareL(livres, j - 1, j)) {
                    //swap elements
                    temp = livres[j - 1];
                    livres[j - 1] = livres[j];
                    livres[j] = temp;
                }
            }
        }
    }
    private static boolean compareL(Livre[] livres, int a, int b) {
        Livre livreA = livres[a];
        Livre livreB = livres[b];
        if (livreB == null) return true;
        if (livreA == null) return false; //Here fichierB is already not null
        return livreA.getTitre().compareTo(livreB.getTitre()) > 0;
    }
    public void sortArrayL() {
        bubbleSortL(livres);
    }
//tri pour dictionnaire
    static void bubbleSortD(Dictionnaire[] dictionnaires) {
        int n = dictionnaires.length;
        Dictionnaire temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (compareD(dictionnaires, j - 1, j)) {
                    //swap elements
                    temp = dictionnaires[j - 1];
                    dictionnaires[j - 1] = dictionnaires[j];
                    dictionnaires[j] = temp;
                }
            }
        }
    }
    private static boolean compareD(Dictionnaire[] dictionnaires, int a, int b) {
        Dictionnaire dicA = dictionnaires[a];
        Dictionnaire dicB = dictionnaires[b];
        if (dicB == null) return true;
        if (dicA == null) return false; //Here fichierB is already not null
        return dicA.getTitre().compareTo(dicB.getTitre()) > 0;
    }
    public void sortArrayD() {
        bubbleSortD(dictionnaires);
    }
//conversion des titres en majuscules
    public void convertToUppercase() {
        System.out.println("Vous voulez convertir les titres des Livres ou des dictionnaires ? (l/d)");
        String choice = in.nextLine();
        if (choice.equals("l")){
            for (Livre livre : livres) {
                if (livre != null) {
                    System.out.println(livre.getTitre().toUpperCase());
                }
            }
        }else {
            for (Dictionnaire dictionnaire : dictionnaires) {
                if (dictionnaire != null) {
                    System.out.println(dictionnaire.getTitre().toUpperCase());
                }
            }
        }
    }
//Methode pour calculer le nombre de livres
    public void CalculerLivre(){
        int nbrL = 1;
        for (int i = 0; i < livres.length ; i++) {
            if (livres[i] != null){
                nbrL += i;
            }else if (livres[i] == null){
                System.out.println("pas de livres");
            }
        }
        System.out.println("le nombre de livres est : "+nbrL);
    }
//methode affichage de dictionnaire
    public void AfficherDic(){
        boolean isEmptyList = true;
        for (int i = 0; i < maxDocs; i++) {
            if (dictionnaires[i] !=null) {
                isEmptyList = false;
                System.out.println(dictionnaires[i]);
            }

        }
        if (isEmptyList) System.out.println("Liste de dictionnaire vide");

    }
//methode pour afficher tous les auteurs
    public void tousLesAuteurs(){
        boolean isEmptyList = true;
        for (int i = 0; i < livres.length; i++) {
            if (livres[i] !=null) {
                isEmptyList = false;
                System.out.println(i+"-"+livres[i].getAuteur());
            }

        }
        if (isEmptyList) System.out.println("Liste de dictionnaire vide");
    }
//methode pour afficher toutes les descriptions
    public void toutesLesDescriptions(){
        for (int i = 0; i < maxDocs; i++) {
            if (livres[i] != null && dictionnaires[i] != null){
                livres[i].DescriptionLivre();
                dictionnaires[i].DescriptionDic();
            }
        }
    }


}


