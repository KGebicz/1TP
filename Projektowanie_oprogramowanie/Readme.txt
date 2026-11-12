```
# Tworzymy pustą listę na historię zakupów
historia = []

# Zmienna przechowująca łączną kwotę zakupów
suma_zakupow = 0


# Pętla działa cały czas, dopóki nie użyjemy break
while True:

    # Wyświetlamy menu główne
    print("\n===== SZKOLNY SKLEPIK =====")
    print("1. Kup jabłko - 2 zł")
    print("2. Kup kanapkę - 6 zł")
    print("3. Kup sok - 4 zł")
    print("4. Pokaż historię zakupów")
    print("5. Pokaż łączną kwotę zakupów")
    print("6. Wyczyść historię zakupów")
    print("7. Zakończ program")

    # Pobieramy wybór użytkownika
    wybor = input("Wybierz opcję: ")

    # Jeśli użytkownik wybierze 7, kończymy program
    if wybor == "7":
        print("Dziękujemy za zakupy!")
        break

    # Jeśli użytkownik wybierze 4, pokazujemy historię
    elif wybor == "4":

        print("\n===== HISTORIA ZAKUPÓW =====")

        # Sprawdzamy, czy historia jest pusta
        if len(historia) == 0:
            print("Brak zakupów.")

        # Jeśli historia zawiera zakupy, wyświetlamy je
        else:
            for zakup in historia:
                print(zakup)

    # Jeśli użytkownik wybierze 5, pokazujemy sumę zakupów
    elif wybor == "5":
        print("Łączna kwota zakupów:", suma_zakupow, "zł")

    # Jeśli użytkownik wybierze 6, czyścimy historię
    elif wybor == "6":

        # Usuwamy wszystkie elementy z listy
        historia.clear()

        # Zerujemy łączną kwotę zakupów
        suma_zakupow = 0

        print("Historia zakupów została wyczyszczona.")

    # Sprawdzamy, czy użytkownik wybrał zakup produktu
    elif wybor in ["1", "2", "3"]:

        # Pobieramy liczbę sztuk produktu
        ilosc = int(input("Podaj liczbę sztuk: "))

        # Sprawdzamy, czy ilość jest większa od zera
        if ilosc <= 0:
            print("Liczba sztuk musi być większa od zera!")
            continue

        # Jeśli wybrano jabłko
        if wybor == "1":
            produkt = "Jabłko"
            cena = 2

        # Jeśli wybrano kanapkę
        elif wybor == "2":
            produkt = "Kanapka"
            cena = 6

        # Jeśli wybrano sok
        elif wybor == "3":
            produkt = "Sok"
            cena = 4

        # Obliczamy koszt zakupów
        koszt = ilosc * cena

        # Sprawdzamy, czy przysługuje rabat
        if koszt > 30:

            # Obliczamy rabat 10%
            rabat = koszt * 0.10

            # Odejmujemy rabat od ceny
            koszt = koszt - rabat

            print("Przyznano rabat 10%!")

        else:
            rabat = 0

        # Wyświetlamy informacje o zakupie
        print("Produkt:", produkt)
        print("Ilość:", ilosc)
        print("Do zapłaty:", round(koszt, 2), "zł")

        # Tworzymy zapis zakupu
        zapis = f"{produkt} - {ilosc} szt. = {round(koszt, 2)} zł"

        # Dodajemy zakup do historii
        historia.append(zapis)

        # Dodajemy koszt do łącznej kwoty zakupów
        suma_zakupow += koszt

    # Jeśli użytkownik poda nieprawidłową opcję
    else:
        print("Nieprawidłowa opcja!")
```
