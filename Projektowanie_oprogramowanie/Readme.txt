```
liczba1 = float(input("Podaj pierwszą liczbę: "))
operator = input("Podaj operator (+, -, *, /): ")
liczba2 = float(input("Podaj drugą liczbę: "))

if operator == "+":
    wynik = liczba1 + liczba2
    print("Wynik:", wynik)

elif operator == "-":
    wynik = liczba1 - liczba2
    print("Wynik:", wynik)

elif operator == "*":
    wynik = liczba1 * liczba2
    print("Wynik:", wynik)

elif operator == "/":
    if liczba2 != 0:
        wynik = liczba1 / liczba2
        print("Wynik:", wynik)
    else:
        print("Błąd! Nie można dzielić przez zero.")

else:
    print("Błąd! Nieprawidłowy operator.")```
