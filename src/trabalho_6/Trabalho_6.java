/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho_6;

import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Trabalho_6 {

    private Vector<Node> heap = new Vector<Node>();

    // tamanho maximo da arvore
    private final int DIM = 453;

    // dimensao do vetor (posiÃ§Ã£o 0 ignorada)
    private final int DIMV = DIM + 1;

    // vetor que representa implicitamente uma arvore binaria
    private Node[] v = new Node[DIMV];

    // numero de nos existente na arvore
    private int N = 0;

    // maior numero inteiro positivo de 32 bits
    // sentinela a colocar na posicao 0 do vetor
    private final int INTMAX = 2147483647;

    private Node sent = new Node((char) 125, INTMAX);

    // metodo para inserir novo elemento no heap
    public void insert(Node[] a, Node x) {
        if (N <= DIM) {
            a[++N] = x;
            upHeap(a, N);
        }
    }

    // sobe o heap para colocar o valor inserido na posicao correta   
    public void upHeap(Node[] a, int k) {
        Node x;
        x = a[k];
        a[0] = sent;    // funciona como sentinela
        while (a[k / 2].getVezes() <= x.getVezes()) {
            a[k] = a[k / 2];
            k = k / 2;
        }
        a[k] = x;
    }

    // metodo de ordenacao heapsort
    void heapSort(Node[] a, int n) {

        toHeap(a, n);

        while (n > 1) {
            Node t = a[1];
            a[1] = a[n];
            a[n] = t;

            downHeap(a, --n, 1);
        }
    }

    // metodo que troca sucessivamente cada no com o maior dos seus filhos
    void downHeap(Node[] a, int n, int k) {
        int j;
        Node v = a[k];
        while (k <= n / 2) {
            j = 2 * k;
            if (j < n && a[j].getVezes() > a[j + 1].getVezes()) {
                j++;
            }
            if (v.getVezes() <= a[j].getVezes()) {
                break;
            }
            a[k] = a[j];
            k = j;
        }
        a[k] = v;
    }

    // transforma o vetor num heap representado implicitamente
    public void toHeap(Node[] a, int n) {

        for (int k = n / 2; k >= 1; k--) {
            downHeap(a, n, k);
        }
    }

    // imprime o vetor
    public void print(Node[] vv) {
        System.out.println();
        for (int i = 1; i < N; i++) {
            System.out.println("v[" + i + "] = " + vv[i]);
        }
    }

    public void go() throws IOException {

        File ficheiro = new File("ficheiro.txt");
        Scanner leia = new Scanner(System.in);
        BufferedReader leitura = new BufferedReader(new FileReader(ficheiro));
        String frase_ficheiro = null;
        int vezes = 0, escolha;

        while ((frase_ficheiro = leitura.readLine()) != null) {
            if (frase_ficheiro == null) {
                break;
            }

            frase_ficheiro = frase_ficheiro.toLowerCase();
            Scanner ler = new Scanner(frase_ficheiro);

            while (ler.hasNext()) {

                String palavra = ler.next();
                palavra = palavra.replaceAll("[.,-]", "").toLowerCase();
                palavra = palavra.replaceAll(" ", "");
                for (char c : palavra.toCharArray()) {
                    if (c != ' ') {
                        boolean carater_existe = false;
                        if (N > 0) {
                            for (int i = 0; i < N; i++) {
                                if (c == v[i].getLetra()) {
                                    carater_existe = true; //se a palavra existir vai acrescentar os valores e adicionando ao node
                                    vezes = v[i].getVezes() + 1;
                                    v[i].setVezes(vezes);
                                    break;
                                }
                            }
                        }
                        if (carater_existe == false) {
                            Node n = new Node();// caso não haja essa palavra no node irá adicionar ao node
                            vezes = 1;
                            n.setLetra(c);
                            n.setVezes(vezes);
                            insert(v, n);
                        }
                    }
                }
            }
        }

        do {
            System.out.println("\nLista de carateres\n");
            System.out.println("1- Ver carateres e a sua respetiva contagem");
            System.out.println("2- Selecionar quantos carateres visualizar");
            System.out.println("3- Sair\n");
            System.out.printf("Insira o digito da ação que pretende: ");
            escolha = leia.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Heap Ordenado:");
                    heapSort(v, N);
                    print(v);
                    break;

                case 2:
                    heapSort(v, N);
                    System.out.printf("Indicar o x valores que pretende visualizar: ");
                    int x = leia.nextInt();
                    for (int i = 1; i <= x; i++) {
                        System.out.println(v[i]);

                    }
            }
        } while (escolha != 3);
    }

    public static void main(String[] args) throws IOException {
        new Trabalho_6().go();
    }

}
