package rubrica;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Rubrica rubrica = new Rubrica();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Aggiungi contatto");
            System.out.println("2. Visualizza rubrica");
            System.out.println("3. Esci");
            System.out.print("Scelta: ");
            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Numero: ");
                    String numero = scanner.nextLine();
                    rubrica.aggiungiContatto(new Contatto(nome, numero));
                    break;
                case 2:
                    rubrica.visualizzaRubrica();
                    break;
                case 3:
                    rubrica.salvaRubrica();
                    System.out.println("Rubrica salvata. Uscita...");
                    return;
                default:
                    System.out.println("Scelta non valida");
            }
        }
    }
}

