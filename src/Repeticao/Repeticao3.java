package Repeticao;

/*Faça um programa que leia 5 números e informe o maior número e a média dos números.
 */

import java.util.Scanner;

public class Repeticao3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numero;
        int maior = 0;
        int soma = 0;
        int count = 0;

        do {
            System.out.println("Insira um número: ");
            numero = scan.nextInt();

            soma = soma + numero;

            if (numero > maior) maior = numero;

            count = count + 1;
        } while (count < 5);

        System.out.println("O maior número é: " + maior);
        System.out.println("A média dos números é: " + soma/5);
    }
}
