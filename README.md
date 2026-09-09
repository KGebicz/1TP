# 1TP

#Baza danych

DROP DATABASE IF EXISTS sklep_internetowy;
CREATE DATABASE sklep_internetowy
    CHARACTER SET utf8mb4
    COLLATE utf8mb4_polish_ci;

USE sklep_internetowy;


-- =========================================================
-- 1. KATEGORIE
-- =========================================================

CREATE TABLE kategorie (
    id_kategorii INT PRIMARY KEY AUTO_INCREMENT,
    nazwa VARCHAR(50) NOT NULL,
    opis VARCHAR(255)
);


INSERT INTO kategorie (nazwa, opis) VALUES
('Laptopy', 'Komputery przenośne'),
('Smartfony', 'Telefony komórkowe i smartfony'),
('Monitory', 'Monitory komputerowe'),
('Klawiatury', 'Klawiatury przewodowe i bezprzewodowe'),
('Myszy', 'Myszy komputerowe'),
('Słuchawki', 'Słuchawki przewodowe i bezprzewodowe'),
('Tablety', 'Tablety multimedialne'),
('Akcesoria', 'Pozostałe akcesoria komputerowe'),
('Konsole', 'Konsole do gier'),
('Gry', 'Gry komputerowe i konsolowe');


-- =========================================================
-- 2. PRODUCENCI
-- =========================================================

CREATE TABLE producenci (
    id_producenta INT PRIMARY KEY AUTO_INCREMENT,
    nazwa VARCHAR(50) NOT NULL,
    kraj VARCHAR(50),
    rok_zalozenia INT
);


INSERT INTO producenci (nazwa, kraj, rok_zalozenia) VALUES
('Lenovo', 'Chiny', 1984),
('Dell', 'USA', 1984),
('HP', 'USA', 1939),
('Apple', 'USA', 1976),
('Samsung', 'Korea Południowa', 1938),
('Xiaomi', 'Chiny', 2010),
('Sony', 'Japonia', 1946),
('Logitech', 'Szwajcaria', 1981),
('ASUS', 'Tajwan', 1989),
('Acer', 'Tajwan', 1976),
('Microsoft', 'USA', 1975),
('Razer', 'Singapur', 2005),
('Nintendo', 'Japonia', 1889),
('SteelSeries', 'Dania', 2001),
('Philips', 'Holandia', 1891);


-- =========================================================
-- 3. PRODUKTY
-- =========================================================

CREATE TABLE produkty (
    id_produktu INT PRIMARY KEY AUTO_INCREMENT,
    nazwa VARCHAR(100) NOT NULL,
    id_kategorii INT NOT NULL,
    id_producenta INT NOT NULL,
    cena DECIMAL(10,2) NOT NULL,
    ilosc_magazyn INT NOT NULL,
    rok_produkcji INT,
    ocena DECIMAL(2,1),
    liczba_opinii INT DEFAULT 0,

    FOREIGN KEY (id_kategorii)
        REFERENCES kategorie(id_kategorii),

    FOREIGN KEY (id_producenta)
        REFERENCES producenci(id_producenta)
);


INSERT INTO produkty
(nazwa, id_kategorii, id_producenta, cena, ilosc_magazyn, rok_produkcji, ocena, liczba_opinii)
VALUES

-- LAPTOPY
('Lenovo IdeaPad 3', 1, 1, 2499.99, 15, 2024, 4.5, 128),
('Lenovo ThinkPad E14', 1, 1, 3899.00, 8, 2024, 4.8, 94),
('Dell Inspiron 15', 1, 2, 2999.00, 12, 2023, 4.4, 76),
('Dell XPS 13', 1, 2, 6299.00, 5, 2024, 4.9, 63),
('HP Pavilion 15', 1, 3, 2799.99, 17, 2023, 4.3, 112),
('HP Envy x360', 1, 3, 4499.00, 6, 2024, 4.7, 81),
('MacBook Air M2', 1, 4, 4999.00, 10, 2023, 4.9, 203),
('MacBook Air M3', 1, 4, 5799.00, 7, 2024, 4.9, 167),
('ASUS VivoBook 15', 1, 9, 2599.00, 13, 2024, 4.4, 91),
('ASUS ROG Strix G16', 1, 9, 6999.00, 4, 2024, 4.8, 57),
('Acer Aspire 5', 1, 10, 2399.00, 19, 2023, 4.2, 145),

-- SMARTFONY
('iPhone 13', 2, 4, 2899.00, 14, 2022, 4.7, 532),
('iPhone 15', 2, 4, 3999.00, 11, 2023, 4.8, 421),
('iPhone 15 Pro', 2, 4, 5199.00, 6, 2023, 4.9, 318),
('Samsung Galaxy S23', 2, 5, 2999.00, 18, 2023, 4.7, 387),
('Samsung Galaxy S24', 2, 5, 3699.00, 13, 2024, 4.8, 291),
('Samsung Galaxy A55', 2, 5, 1899.00, 22, 2024, 4.6, 178),
('Xiaomi Redmi Note 13', 2, 6, 999.00, 35, 2024, 4.4, 246),
('Xiaomi 14', 2, 6, 3299.00, 9, 2024, 4.7, 119),

-- MONITORY
('Dell UltraSharp 27', 3, 2, 1799.00, 9, 2024, 4.8, 87),
('Dell S2721H', 3, 2, 999.00, 16, 2023, 4.5, 134),
('Samsung Odyssey G5', 3, 5, 1499.00, 7, 2024, 4.7, 102),
('Samsung Odyssey G7', 3, 5, 2499.00, 4, 2024, 4.9, 76),
('ASUS TUF Gaming VG27', 3, 9, 1299.00, 11, 2023, 4.6, 98),
('Philips 243V7', 3, 15, 649.00, 24, 2022, 4.2, 183),

-- KLAWIATURY
('Logitech K380', 4, 8, 189.00, 31, 2023, 4.7, 412),
('Logitech MX Keys', 4, 8, 449.00, 14, 2023, 4.8, 267),
('Logitech G213', 4, 8, 299.00, 18, 2022, 4.5, 321),
('Razer BlackWidow V3', 4, 12, 499.00, 8, 2022, 4.7, 198),
('SteelSeries Apex 3', 4, 14, 279.00, 12, 2023, 4.4, 156),

-- MYSZY
('Logitech MX Master 3S', 5, 8, 399.00, 16, 2023, 4.9, 356),
('Logitech G502 Hero', 5, 8, 249.00, 21, 2022, 4.7, 489),
('Razer DeathAdder V2', 5, 12, 229.00, 15, 2022, 4.6, 376),
('Razer Basilisk V3', 5, 12, 299.00, 13, 2023, 4.7, 294),
('ASUS TUF M3', 5, 9, 129.00, 26, 2022, 4.3, 187),

-- SŁUCHAWKI
('Sony WH-1000XM5', 6, 7, 1499.00, 8, 2023, 4.9, 287),
('Sony WH-CH720N', 6, 7, 599.00, 15, 2023, 4.6, 194),
('Apple AirPods Pro 2', 6, 4, 1099.00, 17, 2023, 4.8, 631),
('Logitech G435', 6, 8, 299.00, 20, 2022, 4.4, 225),
('Razer Barracuda X', 6, 12, 449.00, 11, 2023, 4.5, 143),

-- TABLETY
('iPad 10', 7, 4, 2199.00, 12, 2022, 4.8, 267),
('iPad Air M2', 7, 4, 2999.00, 7, 2024, 4.9, 143),
('Samsung Galaxy Tab S9', 7, 5, 2999.00, 6, 2023, 4.7, 119),
('Xiaomi Pad 6', 7, 6, 1699.00, 10, 2023, 4.6, 98),

-- AKCESORIA
('Logitech C920', 8, 8, 299.00, 25, 2022, 4.6, 421),
('Razer Mouse Bungee', 8, 12, 149.00, 14, 2023, 4.3, 87),
('Samsung T7 1TB', 8, 5, 449.00, 19, 2023, 4.8, 312),
('Samsung T7 2TB', 8, 5, 749.00, 11, 2023, 4.8, 198),
('Apple Magic Mouse', 8, 4, 399.00, 9, 2022, 4.4, 276),

-- KONSOLE
('PlayStation 5 Slim', 9, 7, 2499.00, 9, 2023, 4.9, 712),
('Xbox Series X', 9, 11, 2399.00, 7, 2020, 4.8, 487),
('Nintendo Switch OLED', 9, 13, 1499.00, 12, 2021, 4.8, 634),

-- GRY
('Minecraft', 10, 11, 119.00, 40, 2023, 4.9, 823),
('Forza Horizon 5', 10, 11, 199.00, 22, 2021, 4.8, 421),
('The Legend of Zelda: Tears of the Kingdom', 10, 13, 249.00, 13, 2023, 4.9, 387),
('Spider-Man 2', 10, 7, 299.00, 18, 2023, 4.8, 356),
('Mario Kart 8 Deluxe', 10, 13, 229.00, 16, 2017, 4.9, 634);


-- =========================================================
-- 4. KLIENCI
-- =========================================================

CREATE TABLE klienci (
    id_klienta INT PRIMARY KEY AUTO_INCREMENT,
    imie VARCHAR(40) NOT NULL,
    nazwisko VARCHAR(50) NOT NULL,
    miasto VARCHAR(50),
    wojewodztwo VARCHAR(50),
    data_rejestracji DATE,
    typ_klienta VARCHAR(20)
);


INSERT INTO klienci
(imie, nazwisko, miasto, wojewodztwo, data_rejestracji, typ_klienta)
VALUES
('Jan', 'Kowalski', 'Łódź', 'łódzkie', '2024-01-15', 'standard'),
('Anna', 'Nowak', 'Warszawa', 'mazowieckie', '2024-02-10', 'premium'),
('Piotr', 'Wiśniewski', 'Kraków', 'małopolskie', '2024-02-22', 'standard'),
('Kacper', 'Wójcik', 'Poznań', 'wielkopolskie', '2024-03-03', 'standard'),
('Zuzanna', 'Kamińska', 'Wrocław', 'dolnośląskie', '2024-03-19', 'premium'),
('Michał', 'Lewandowski', 'Gdańsk', 'pomorskie', '2024-04-01', 'standard'),
('Julia', 'Zielińska', 'Łódź', 'łódzkie', '2024-04-17', 'premium'),
('Szymon', 'Szymański', 'Katowice', 'śląskie', '2024-05-08', 'standard'),
('Oliwia', 'Woźniak', 'Lublin', 'lubelskie', '2024-05-21', 'standard'),
('Jakub', 'Dąbrowski', 'Szczecin', 'zachodniopomorskie', '2024-06-12', 'premium'),
('Natalia', 'Kozłowska', 'Łódź', 'łódzkie', '2024-06-30', 'standard'),
('Adam', 'Jankowski', 'Warszawa', 'mazowieckie', '2024-07-14', 'premium'),
('Wiktoria', 'Mazur', 'Kraków', 'małopolskie', '2024-07-28', 'standard'),
('Bartosz', 'Krawczyk', 'Poznań', 'wielkopolskie', '2024-08-09', 'standard'),
('Amelia', 'Piotrowska', 'Wrocław', 'dolnośląskie', '2024-08-25', 'premium'),
('Filip', 'Grabowski', 'Gdańsk', 'pomorskie', '2024-09-02', 'standard'),
('Lena', 'Pawłowska', 'Łódź', 'łódzkie', '2024-09-17', 'standard'),
('Wojciech', 'Michalski', 'Katowice', 'śląskie', '2024-10-04', 'premium'),
('Maja', 'Król', 'Warszawa', 'mazowieckie', '2024-10-19', 'standard'),
('Antoni', 'Wieczorek', 'Lublin', 'lubelskie', '2024-11-02', 'standard');


-- =========================================================
-- 5. ZAMÓWIENIA
-- =========================================================

CREATE TABLE zamowienia (
    id_zamowienia INT PRIMARY KEY AUTO_INCREMENT,
    id_klienta INT NOT NULL,
    data_zamowienia DATE NOT NULL,
    status VARCHAR(30),
    forma_platnosci VARCHAR(30),
    koszt_dostawy DECIMAL(6,2),

    FOREIGN KEY (id_klienta)
        REFERENCES klienci(id_klienta)
);


INSERT INTO zamowienia
(id_klienta, data_zamowienia, status, forma_platnosci, koszt_dostawy)
VALUES
(1, '2024-09-01', 'zrealizowane', 'karta', 12.99),
(2, '2024-09-03', 'zrealizowane', 'blik', 0.00),
(3, '2024-09-05', 'wysłane', 'karta', 14.99),
(4, '2024-09-07', 'zrealizowane', 'przelew', 12.99),
(5, '2024-09-10', 'zrealizowane', 'blik', 0.00),
(6, '2024-09-12', 'anulowane', 'karta', 12.99),
(7, '2024-09-14', 'zrealizowane', 'blik', 0.00),
(8, '2024-09-16', 'wysłane', 'karta', 14.99),
(9, '2024-09-18', 'zrealizowane', 'przelew', 12.99),
(10, '2024-09-20', 'w realizacji', 'blik', 0.00),
(11, '2024-09-22', 'zrealizowane', 'karta', 12.99),
(12, '2024-09-25', 'zrealizowane', 'blik', 0.00),
(13, '2024-09-28', 'wysłane', 'karta', 14.99),
(14, '2024-10-01', 'zrealizowane', 'przelew', 12.99),
(15, '2024-10-04', 'zrealizowane', 'blik', 0.00),
(16, '2024-10-07', 'anulowane', 'karta', 12.99),
(17, '2024-10-10', 'zrealizowane', 'blik', 0.00),
(18, '2024-10-12', 'wysłane', 'karta', 14.99),
(19, '2024-10-15', 'zrealizowane', 'przelew', 12.99),
(20, '2024-10-18', 'w realizacji', 'blik', 0.00);


-- =========================================================
-- 6. POZYCJE ZAMÓWIEŃ
-- =========================================================

CREATE TABLE pozycje_zamowien (
    id_pozycji INT PRIMARY KEY AUTO_INCREMENT,
    id_zamowienia INT NOT NULL,
    id_produktu INT NOT NULL,
    ilosc INT NOT NULL,
    cena_w_momencie_zakupu DECIMAL(10,2) NOT NULL,

    FOREIGN KEY (id_zamowienia)
        REFERENCES zamowienia(id_zamowienia),

    FOREIGN KEY (id_produktu)
        REFERENCES produkty(id_produktu)
);


INSERT INTO pozycje_zamowien
(id_zamowienia, id_produktu, ilosc, cena_w_momencie_zakupu)
VALUES
(1, 1, 1, 2499.99),
(1, 26, 1, 449.00),

(2, 13, 1, 3999.00),
(2, 35, 1, 1099.00),

(3, 15, 1, 2999.00),
(3, 19, 1, 1799.00),

(4, 17, 2, 1899.00),
(4, 31, 1, 299.00),

(5, 22, 1, 1499.00),
(5, 48, 1, 249.00),

(6, 7, 1, 4999.00),

(7, 32, 1, 399.00),
(7, 33, 1, 249.00),
(7, 34, 1, 229.00),

(8, 8, 1, 5799.00),

(9, 18, 2, 999.00),
(9, 40, 1, 1699.00),

(10, 10, 1, 6999.00),
(10, 24, 1, 1299.00),

(11, 37, 1, 2199.00),
(11, 39, 1, 1699.00),

(12, 44, 1, 2499.00),
(12, 45, 1, 2399.00),

(13, 49, 2, 119.00),
(13, 50, 1, 199.00),

(14, 3, 1, 2999.00),
(14, 27, 1, 299.00),

(15, 16, 1, 3699.00),
(15, 36, 1, 299.00),

(16, 12, 1, 2899.00),

(17, 29, 1, 499.00),
(17, 30, 1, 279.00),

(18, 6, 1, 4499.00),
(18, 21, 1, 1499.00),

(19, 41, 1, 299.00),
(19, 42, 1, 449.00),

(20, 14, 1, 5199.00),
(20, 34, 1, 229.00);
