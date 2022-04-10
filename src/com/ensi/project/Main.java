package com.ensi.project;

import com.ensi.project.model.Biblio;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblio biblio = new Biblio();

        Scanner in = new Scanner(System.in);
        int choice= -1;
        do {

            biblio.menuSelectSection();
            choice = in.nextInt();in.nextLine();
            switch (choice){
                case 1 :biblio.ajouterUnDoc()             ;break;
                case 2 :biblio.show()                     ;break;
                case 3 :biblio.supprimerDoc()             ;break;
                case 4 :biblio.TrierLD()                  ;break;
                case 5 :biblio.convertToUppercase()       ;break;
                case 6 :biblio.CalculerLivre()            ;break;
                case 7 :biblio.AfficherDic()              ;break;
                case 8 :biblio.tousLesAuteurs()           ;break;
                case 9 :biblio.toutesLesDescriptions()    ;break;

            }
        }while (choice!=0);
    }

    }

