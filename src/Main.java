import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*
        angelegt von: Nico Zorn
        angelegt am: 09.10.2025
         */



        Scanner sc = new Scanner(System.in);
        String[] strarr = {"Anna", "Gustav", "Bernt", "Lisa", "Jakob", "Sebastian", "Nina"};
        boolean sortiert = false;


        while (!sortiert) {
            System.out.println("Welche Sortierung wollen Sie verwenden? (selection || insertion)");
            String eingabe1 = sc.next();

            if (eingabe1.equals("insertion") || eingabe1.equals("Insertion")) {
                insertionSort(strarr);
                sortiert = true;

            } else if (eingabe1.equals("selection") || eingabe1.equals("Selection")) {
                selectionSort(strarr);
                sortiert = true;

            } else {
                System.out.println("Ungültige Eingabe. Bitte erneut versuchen.");
            }
        }


        for (String name : strarr) {        //Ausgabe der Sortierung
            System.out.println(name);
        }


        System.out.println("Anna, Gustav, Bernt, Lisa, Jakob, Sebastian, Nina");
        System.out.println("Welchen Namen möchten Sie suchen:");
        String eingabe2 = sc.next();

        int index = binaerSuche(strarr, eingabe2);
        if (index != -1) {      //Überprüft, ob es den eingegebenen Namen gibt
            System.out.println(eingabe2 + " gefunden an Position: " + (index + 1));
        } else {
            System.out.println("Der Name wurde nicht gefunden!");
        }
    }


    public static void insertionSort(String[] strarr) {
        for (int i = 1; i < strarr.length; i++) {       //Fängt mit dem zweiten Array an
            String currentValue = strarr[i];
            int j = i - 1;

            while (j >= 0 && strarr[j].compareTo(currentValue) > 0) {   //Kontrolliert ob strarr[j] größer als strarr[i]
                strarr[j + 1] = strarr[j];  //Die Stelle J + 1 wird zur neun J
                j--;
            }
            strarr[j + 1] = currentValue;       //Es wurde mit der niedrigsten Zahl vertauscht
        }
    }


    public static void selectionSort(String[] strarr) {
        for (int i = 0; i < strarr.length; i++) {   //Started mit dem ersten Array
            int index = i;
            for (int j = i + 1; j < strarr.length; j++) {
                if (strarr[j].compareTo(strarr[index]) < 0) {
                    index = j;          //Index bekommt die Stelle von j
                }
            }
            String temp = strarr[index];
            strarr[index] = strarr[i];
            strarr[i] = temp;   //Vertauscht die Stellen der Zahlen
        }
    }

    public static int binaerSuche(String[] strarr, String ziel) {
        int left = 0;
        int right = strarr.length - 1;      //Beginn von Hinten
        int middle = 0;
        boolean gefunden = false;

        while (left <= right && gefunden == false) {

            middle = left + (right - left) / 2;     // Er sucht sich die Mitte
            int vergleich = strarr[middle].compareTo(ziel); // Er schaut, ob gesuchte Name größer oder kleiner als die mitte ist

            if (vergleich == 0) {
                gefunden = true;
            } else if (vergleich < 0) { //Hier vergleicht er
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        if (gefunden){
            return middle; //Wenn gefunden true ist dann returned er
        }
        else {
            return -1;
        }
    }
}
