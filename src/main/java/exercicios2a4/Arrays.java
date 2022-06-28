package exercicios2a4;

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {

        Scanner scanNum = new Scanner(System.in);

        int v1;
        int v2;
        System.out.println("Qual o tamanho do seu primeiro vetor: ");
        v1 = scanNum.nextInt();
        System.out.println("Qual o tamanho do seu segundo vetor: ");
        v2 = scanNum.nextInt();

        int vetor[] = new int[v1];
        int vetor2[] = new int[v2];
        int uniaoDosVetores[] = new int[v1 + v2];
        for (int m = 0; m < vetor.length; m++) {
            System.out.println("Digite o " + (m+1) + "º número a que você quer colocar no seu primeiro vetor: ");
            vetor[m] = scanNum.nextInt();
        }

        for (int m=0; m<vetor2.length; m++) {
            System.out.println("Digite o " + (m+1) + "º número a que você quer colocar no seu segundo vetor: ");
            vetor2[m] = scanNum.nextInt();
        }

        for (int m=0; m<vetor.length; m++) {
            uniaoDosVetores[m] = vetor[m];
        }

        for (int m = vetor.length, o = 0; m < uniaoDosVetores.length; m++, o++) {
            uniaoDosVetores[m] = vetor2[o];
        }

        for (int m = 0; m < uniaoDosVetores.length; m++) {
            for (int o = 0; o < uniaoDosVetores.length - 1; o++) {
                if (uniaoDosVetores[m] < uniaoDosVetores[o]) {
                    int x = uniaoDosVetores[m];
                    uniaoDosVetores[m] = uniaoDosVetores[o];
                    uniaoDosVetores[o] = x;
                }
            }
        }

        for (int m = 0; m < uniaoDosVetores.length; m++) {
            System.out.println("[" + uniaoDosVetores[m] + "]");
        }
    }
}
