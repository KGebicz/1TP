# 1TP


Utwórz nowy projekt aplikacji konsolowej.


Wyświetl komunikat: „Podaj, ile liczb chcesz wprowadzić:”.


Wczytaj liczbę n od użytkownika.


Utwórz tablicę int[] liczby = new int[n];.


W pętli od 0 do n-1:


Wyświetl komunikat: „Podaj liczbę i:”.


Wczytaj liczbę i zapisz ją w tablicy liczby[i].


Utwórz zmienną najmniejsza i przypisz jej wartość liczby[0].


Utwórz zmienną najwieksza i przypisz jej wartość liczby[0].


W pętli przejdź przez tablicę i dla każdej liczby:


Jeśli liczba < najmniejsza, przypisz jej wartość do najmniejsza.


Jeśli liczba > najwieksza, przypisz jej wartość do najwieksza.


Utwórz tablicę pomocniczą int[] wystapienia = new int[n]; i w pętli zliczaj ilość wystąpień każdej liczby.


Wyświetl wszystkie liczby wraz z ilością ich wystąpień.









Rozwiązanie:


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj, ile liczb chcesz wprowadzić: ");
        int n = scanner.nextInt();

        int[] liczby = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Podaj liczbę " + (i + 1) + ": ");
            liczby[i] = scanner.nextInt();
        }

        int najmniejsza = liczby[0];
        int najwieksza = liczby[0];

        for (int i = 1; i < n; i++) {
            if (liczby[i] < najmniejsza) {
                najmniejsza = liczby[i];
            }
            if (liczby[i] > najwieksza) {
                najwieksza = liczby[i];
            }
        }

        int[] wystapienia = new int[n];
        boolean[] policzone = new boolean[n]; 
        for (int i = 0; i < n; i++) {
            if (!policzone[i]) {
                int licznik = 1;
                for (int j = i + 1; j < n; j++) {
                    if (liczby[j] == liczby[i]) {
                        licznik++;
                        policzone[j] = true;
                    }
                }
                wystapienia[i] = licznik;
            }
        }

        System.out.println("\nIlość wystąpień każdej liczby:");
        for (int i = 0; i < n; i++) {
            if (!policzone[i]) {
                System.out.println("Liczba " + liczby[i] + " występuje " + wystapienia[i] + " razy.");
            }
        }

        System.out.println("\nNajmniejsza liczba: " + najmniejsza);
        System.out.println("Największa liczba: " + najwieksza);

        scanner.close();
    }
}


Wyświetl największą i najmniejszą liczbę wprowadzonej tablicy.


Zakończ działanie programu.
