import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pliki {

    public static void main(String[] args) throws IOException {

        String nazwaPliku = "przyklad.txt";

        // ===============================
        // ZAPIS DO PLIKU (nadpisanie)
        // ===============================
        BufferedWriter writer = new BufferedWriter(new FileWriter(nazwaPliku, false));
        writer.write("To jest pierwsza linia tekstu.");
        writer.newLine();
        writer.write("To jest druga linia tekstu.");
        writer.newLine();
        writer.close();

        // ===============================
        // DOPISANIE DO PLIKU
        // ===============================
        writer = new BufferedWriter(new FileWriter(nazwaPliku, true));
        writer.write("To jest linia dopisana na końcu pliku.");
        writer.newLine();
        writer.close();

        // ===============================
        // ODCZYT CAŁYMI LINIAMI → TABLICA
        // ===============================
        BufferedReader reader = new BufferedReader(new FileReader(nazwaPliku));
        ArrayList<String> linie = new ArrayList<>();
        String linia;

        while ((linia = reader.readLine()) != null) {s
            linie.add(linia);
        }
        reader.close();

        System.out.println("Odczyt liniami (z tablicy):");
        for (int i = 0; i < linie.size(); i++) {
            System.out.println(linie.get(i));
        }

        // ===============================
        // ODCZYT ZNAK PO ZNAKU → TABLICA
        // ===============================
        FileReader charReader = new FileReader(nazwaPliku);
        ArrayList<Character> znaki = new ArrayList<>();
        int znak;

        while ((znak = charReader.read()) != -1) {
            znaki.add((char) znak);
        }
        charReader.close();

        System.out.println("\nOdczyt znak po znaku (z tablicy):");
        for (int i = 0; i < znaki.size(); i++) {
            System.out.print(znaki.get(i));
        }
    }
}
