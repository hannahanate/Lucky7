import java.util.Random;
import java.util.Scanner;

public class Lucky7 {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        

        System.out.print("Kuinka monta euroa haluat syöttää? Syötä valitsemasi summa tasalukuna: ");
        int rahat = scanner.nextInt();
        //skippaa rivinvaihdon
        scanner.nextLine(); 
        
        while (rahat > 0) {
            
            int[] numerot = new int[3];
            for (int i = 0; i < 3; i++) {
                numerot[i] = rand.nextInt(11);
            }
            
            System.out.println("Arvotut numerot: ");
            for (int numero : numerot) {
                System.out.print(numero + " ");
            }
            System.out.println();
            
            // Lasketaan seiskat voittoja varten
            int seiskat = 0;
            for (int numero : numerot) {
                if (numero == 7) {
                    seiskat++;
                }
            }
            
            // Voitot
            switch (seiskat) {
                case 1:
                    System.out.println("Voitit 3 euroa!");
                    rahat += 3;
                    break;
                case 2:
                    System.out.println("Voitit 5 euroa!");
                    rahat += 5;
                    break;
                case 3:
                    System.out.println("Voitit 10 euroa!");
                    rahat += 10;
                    break;
                default:
                    System.out.println("Hävisit 1 euron.");
                    rahat -= 1;
                    break;
            }
            
            if (rahat == 0) {
                System.out.println("Rahasi loppuivat. Peli päättyy.");
                break;
            }
            
            System.out.print("Haluatko pelata uudestaan? Rahaa on nyt jäljellä " + rahat + " euroa.\nPaina Enter jatkaaksesi tai kirjoita 'e' lopettaaksesi: ");
            String vastaus = scanner.nextLine();
            if (vastaus.equalsIgnoreCase("e")) {
                System.out.println("Kiitos! Peli päättyi.");
                break;
            }
        }
        
        scanner.close();
    }
}
