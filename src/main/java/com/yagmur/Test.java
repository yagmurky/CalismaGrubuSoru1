package com.yagmur;

/*
(Örüntü yakalama: 4 adet sıralı dizilmiş sayı) 2 boyutlu bir dizinin yatay olarak,
dikey olarak veya çapraz bir şekilde aynı değerleri sıralı bir biçimde içerip içermediğini
test eden aşağıdaki method başlığını yazın.


public static boolean isConsecutiveFour(int[][] values)

Kullanıcıdan iki boyutlu dizinin satır ve sütun sayısını girmesini
sonra dizideki elemanların değerlerini girmesini sağlayacak bir test sınıfı yazın ve
dizi eğer 4 adet sıralı aynı değerleri içeriyorsa ekrana true değerini yazdırın
eğer böyle bir örüntü yok ise ekrana false değerini yazdırın.

 */

import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        int[][] dizi=arrayOlustur();

        System.out.println("****** Oluşturulan Dizi *******");
        for (int i = 0; i < dizi.length; i++) {
            for (int j = 0; j < dizi[i].length; j++) {
                System.out.print(dizi[i][j] + " ");
            }
            System.out.println();
        }

        boolean kontrol = isConsecutiveFour(dizi);
        System.out.println("Sıralı değer içeriyor mu? ==> " + kontrol);


    }


    public static int[][] arrayOlustur (){

        //Kullanıcıdan satır ve sütun boyutlarını istiyorum
        Scanner scanner = new Scanner(System.in);
        System.out.print("Satır sayısını girin: ");
        int satir = scanner.nextInt();
        System.out.print("Sütun sayısını girin: ");
        int sutun = scanner.nextInt();

        //biraz aceleye getirdiğim için girilen değerlerin doğru olup olmadığını kontrol etmiyorum.
        //direkt 2 boyutlu dizi oluşturuyorum.
        int[][] dizi = new int[satir][sutun];

        System.out.println("Dizinin elemanlarını girin:");

        //kullanıcıdan aldığım değerleri diziye ekliyorum
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                System.out.print("Dizi[" + i + "][" + j + "]: ");
                dizi[i][j] = scanner.nextInt();
            }
        }

        return dizi;
    }

    public static boolean isConsecutiveFour(int[][] values){


        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j <= values[i].length - 4; j++) {
                if (values[i][j] == values[i][j + 1] &&
                        values[i][j] == values[i][j + 2] &&
                        values[i][j] == values[i][j + 3]) {
                    return true;
                }
            }
        }

        // Dikey kontrol
        for (int i = 0; i <= values.length - 4; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (values[i][j] == values[i + 1][j] &&
                        values[i][j] == values[i + 2][j] &&
                        values[i][j] == values[i + 3][j]) {
                    return true;
                }
            }
        }

        // Çapraz kontrol (sol üstten sağ alta kadar)
        for (int i = 0; i <= values.length - 4; i++) {
            for (int j = 0; j <= values[i].length - 4; j++) {
                if (values[i][j] == values[i + 1][j + 1] &&
                        values[i][j] == values[i + 2][j + 2] &&
                        values[i][j] == values[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        // Çapraz kontrol (sol alttan sağ üste kadar)
        for (int i = 3; i < values.length; i++) {
            for (int j = 0; j <= values[i].length - 4; j++) {
                if (values[i][j] == values[i - 1][j + 1] &&
                        values[i][j] == values[i - 2][j + 2] &&
                        values[i][j] == values[i - 3][j + 3]) {
                    return true;
                }
            }
        }

        // Hiçbir örüntü bulunamazsa
        return false;
    }


}
