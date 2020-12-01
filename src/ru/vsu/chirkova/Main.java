package ru.vsu.chirkova;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[][] arr1 = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}};
        test(arr1);
        int[][] arr2 = {{1665, 165, -1656, 8954}, {-44444, 0, 1, -88}, {4525, -45655, 8888, 1}};
        test(arr2);
        int[][] arr3 = {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}};
        test(arr3);
        int[][] arr4 = {{-144, 2, 3}, {1, 2, 3}, {1, -55, 1}};
        test(arr4);
        int[][] arr5 = {{0, 0, -555}, {-1, 2, -555}, {0, 0, 0}};
        test(arr5);
        int[][] array = new int[10][10];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = (int) Math.round((Math.random() * 100) - 50);
            }
        }
        test(array);
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
        if (result[2] <= 1) {
            System.out.println("Ошибка");
        } else {
            System.out.println("Квадрат с максимальной суммой: ");
            for (int i = 0; i < result[2]; i++) {
                for (int j = 0; j < result[2]; j++) {
                    System.out.print(arr[result[0] + i][result[1] + j] + "\t");
                }
                System.out.println();
            }
        }
    }

    public static int[] solution(int[][] arr) {
        int max = arr[0][0];
        int i1 = 1;
        int j1 = 1;
        int totallength = 1;
        int length;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr.length - i < arr[i].length - j) {
                    length = arr.length - i;
                } else {
                    length = arr[i].length - j;
                }
                while (length >= 2) {
                    int sum = 0;
                    for (int ii = i; ii < i + length; ii++) {
                        for (int jj = j; jj < j + length; jj++) {
                            sum = sum + arr[ii][jj];
                        }
                    }
                    if (sum >= max) {
                        max = sum;
                        i1 = i;
                        j1 = j;
                        totallength = length;
                    }
                    length--;
                }
            }
        }
        return new int[]{i1, j1, totallength};
    }
}