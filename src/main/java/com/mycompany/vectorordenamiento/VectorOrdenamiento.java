/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.vectorordenamiento;

import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class VectorOrdenamiento {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int aux, pos, auxi;
        System.out.println("Ingrese dimension");
        int dimension = entrada.nextInt();

        int[] sueldos = new int[dimension];

        System.out.println("Ingrese los valores del vector");

        for (int i = 0; i < sueldos.length; i++) {
            sueldos[i] = entrada.nextInt();

        }

        for (int i = 0; i < dimension - 1; i++) {
            for (int j = 0; j < dimension - 1; j++) {
                if (sueldos[j] > sueldos[i + 1]) {
                    aux = sueldos[j];
                    sueldos[j] = sueldos[j + 1];
                    sueldos[j + 1] = aux;
                }
            }
        }
        System.out.println("Derecha");
        for (int i = 0; i < dimension; i++) {
            System.out.println(sueldos[i]);
        }

        System.out.println("Izquierda");
        for (int i = dimension - 1; i >= 0; i--) {
            System.out.println(sueldos[i]);
        }

        System.out.println("Inserccion");
        for (int j = 0; j < dimension; j++) {
            pos = j;
            auxi = sueldos[j];
            while ((pos > 0) && (sueldos[pos - 1] > auxi)) {
                sueldos[pos] = sueldos[pos - 1];
                pos--;
            }
            sueldos[pos] = auxi;
        }
        for (int i = 0; i < dimension; i++) {
            System.out.println(sueldos[i]);
        }

        seleccionDirecta(sueldos);
        for (int i = 0; i < sueldos.length; i++) {
            System.out.print(sueldos[i]);
        }
        
        shell(sueldos);
        for (int i = 0; i < sueldos.length; i++) {
            System.out.print("[" + sueldos[i] + "]->");
        }
        
        quicksort(sueldos, 0, sueldos.length - 1);
         for (int i = 0; i < sueldos.length; i++) {
            System.out.print(sueldos[i]);
        }
    }

    public static void seleccionDirecta(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                if (arreglo[i] > arreglo[j]) {
                    int temporal = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temporal;
                }
            }
        }
    }

    public static void shell(int A[]) {

        int salto, aux, i;
        boolean cambios;

        for (salto = A.length / 2; salto != 0; salto /= 2) {
            cambios = true;
            while (cambios) {
                cambios = false;
                for (i = salto; i < A.length; i++) {
                    if (A[i - salto] > A[i]) {
                        aux = A[i];
                        A[i] = A[i - salto];
                        A[i - salto] = aux;
                        cambios = true;
                    }
                }
            }
        }
    }

    public static void quicksort(int A[], int izq, int der) {

        int pivote = A[izq];
        int i = izq;
        int j = der;
        int aux;

        while (i < j) {
            while (A[i] <= pivote && i < j) {
                i++;
            }
            while (A[j] > pivote) {
                j--;
            }
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }

        A[izq] = A[j];
        A[j] = pivote;

        if (izq < j - 1) {
            quicksort(A, izq, j - 1);
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der);
        }
    }
}
