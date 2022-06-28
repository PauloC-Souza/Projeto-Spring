package exercicios2a4;

import java.util.Scanner;

public class Matematica {
    public static void main(String[] args) {
        Scanner sNum = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

        Double x, y, z;
        String resposta;
        int op = 0;

        do {

            System.out.println("Informe o valor de X: ");
            x = scanner.nextDouble();
            System.out.println("Informe o valor de Y: ");
            y = sNum.nextDouble();

            z = (x * y) + 5;
            if (z <= 0) {
                resposta = "A";
            } else if (z <= 100) {
                resposta = "B";
            } else {
                resposta = "C";
            }

            System.out.println("Cáulco efetuado com Z: " + z);
            System.out.println("O resultado é: " + resposta);

            System.out.println("Quer calcular de novo? 1 - Sim, 2 Não.");
            op = sNum.nextInt();
            while (op != 1 && op != 2) {
                System.out.println("Não entendi. Tente novamente!");
            }
        } while(op == 1);


        scanner.close();
        sNum.close();
    }
}
