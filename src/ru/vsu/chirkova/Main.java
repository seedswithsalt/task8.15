package ru.vsu.chirkova;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int [][] arr1 = {{5,7,3,17}, {7,0,1,12}, {8,1,2,3}};
        test(arr1);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество строк массива: ");
        int row = scanner.nextInt();
        System.out.print("Введите количество столбцов массива: ");
        int column = scanner.nextInt();
        int[][] arr = new int[row][column];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print("Введите элемент arr[" + i + "][" + j + "]:");
                arr[i][j] = scanner.nextInt();
            }
        }
        test(arr);
    }

    public static void printArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void test(int[][] arr) {
        System.out.println("Исходный двумерный массив : ");
        printArray(arr);
        int result[] = solution(arr);
        printResult(result, arr);
    }

    public static void printResult(int[] result, int[][] arr) {
        if (result[2] < 2) {
            System.out.println("Нет квадрата с макс суммой");
        } else {
            System.out.println("Квадрат с максимальной суммой: ");
            for (int i = 1; i < result[2]; i++) {
                for (int j = 1; j < result[2]; j++) {
                    System.out.print(arr[result[0] + i - 1][result[1] + j - 1] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static int[] solution(int[][] arr) {
        int max = arr[0][0];
        int i1 = 1;
        int j1 = 1;
        int k = 1;
        int length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length - i < arr[i].length - j) {
                    length = arr.length - i;
                } else {
                    length = arr[i].length - j;
                }
                while (length >= 0) {
                    int sum = 0;
                    for (int ii = i; ii < i + length; ii++) {
                        for (int jj = j; jj < j + length; jj++) {
                            sum = sum + arr[ii][jj];
                        }
                    }
                    if (sum > max) {
                        max = sum;
                        i1 = i;
                        j1 = j;
                        k = length + 1;
                    }
                    length--;
                }
            }
        }
        return new int[]{i1, j1, k};
    }
}