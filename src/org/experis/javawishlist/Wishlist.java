package org.experis.javawishlist;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wishlist {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);

        List<Gift> gifts = new ArrayList<>();

        int counter = 0;

        boolean exit = false;

        do {
            System.out.println("Vuoi inserire un altro regalo nella lista ? s/n");
            String choise = scan.nextLine();

            switch (choise.toUpperCase()) {
                case "S":
                    System.out.println("Inserisci un regalo");
                    String answer = scan.nextLine();
                    String answerClean = answer.trim();
                    Gift gift2 = new Gift(answerClean);
                    gifts.add(gift2);
                    System.out.println("Hai aggiunto " + gifts.size() +  " regali alla lista");
                    break;
                case "N":
                    exit = true;
                    System.out.println("Hai aggiunto " + gifts.size() +  " regali alla lista");
                    Collections.sort(gifts);

                    for (Gift g : gifts) {
                        System.out.println(g);
                    }
                    break;
                default:
                    System.out.println("comando non valido");
                    break;
            }
        }while (!exit);

        scan.close();

        // scrivo su file

        try {
            File file = new File("./resources/list.txt");
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(file.getAbsoluteFile(), true);
            // devo scrivere sul file l'arraylist gifts
            for (Gift g : gifts) {
                writer.write(g.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
