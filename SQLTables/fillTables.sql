INSERT INTO Firmy (nazev_firmy, pobocka, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) 
    VALUES ('Lipo', 'Lipo Liberec', 'Ales', 'Pospisil', 'ales.pospisil@gmail.com', HASHBYTES('md5', 'mojetajneheslo'), 'Liberec');
INSERT INTO Firmy (nazev_firmy, pobocka, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) 
    VALUES ('Apple', 'Apple Praha', 'Katerina', 'Uspela', 'katerina.uspela@gmail.com', HASHBYTES('md5', 'mojetajneheslo2'), 'Praha');
INSERT INTO Firmy (nazev_firmy, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) 
    VALUES ('Microsoft', 'Filip', 'Super', 'filip.super@gmail.com', HASHBYTES('md5', 'mojetajneheslo3'), 'Brno');
INSERT INTO Firmy (nazev_firmy, pobocka, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) 
    VALUES ('Google', 'Google Ostrava', 'Vaclav', 'Gavel', 'vaclav.gavel@gmail.com', HASHBYTES('md5', 'mojetajneheslo4'), 'Ostrava');
INSERT INTO Firmy (nazev_firmy, jmeno_KO, prijmeni_KO, email_KO, heslo_KO, mesto) 
    VALUES ('Binance', 'Jon', 'Kalol', 'jon.kalol@gmail.com', HASHBYTES('md5', 'mojetajneheslo5'), 'London');
    
SET IDENTITY_INSERT Uzivatel ON;
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('43', 'Jakub', 'Novak', '3', 'FM', 'jakub.novak@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo34'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('33', 'Mihal', 'Svejk', '2', 'FM', 'mihal.svejk@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo47t'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('25', 'George', 'Fanta', '1', 'FM', 'george.fanta@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo11'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('26', 'Nikolai', 'Bedro', '1', 'FM', 'nikolai.bedro@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo12'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('27', 'Polina', 'Dvořaková', '3', 'FM', 'polina.dvorakova@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo13'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('28', 'Aleksandra', 'Pětlík', '2', 'FM', 'aleksandra.petlik@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo14'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('29', 'Žora', 'Milučky', '2', 'FM', 'zora.milučky@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo15'));


INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('01', 'Leos', 'Petrilka', NULL, 'FM', 'leos.petrilka@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo84'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('02', 'Marie', 'Bandy', NULL, 'FM', 'marie.bandy@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo85'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('03', 'Martin', 'Novák', NULL, 'FM', 'martin.novak@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo86'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('04', 'Lenka', 'Svoboda', NULL, 'FM', 'lenka.svoboda@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo87'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('05', 'David', 'Pokorný', NULL, 'FM', 'david.pokorny@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo88'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('06', 'Jitka', 'Fiala', NULL, 'FM', 'jitka.fiala@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo89'));
SET IDENTITY_INSERT Uzivatel OFF;

INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('Robot Pepe', 'musite napsat program pro robota-cisnika Pepe','C#, prace s databazy',
    'Brno', 'Elektronika a vestavěný software, Elektrotechnika a projektování', '2', 'Marek', 'Hloubik', 'marek.hloubik@gmail.com', 'Microsoft', '43', '01', '2021');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('IOT Lednička', 'Napragramovat aplikace pro chytrou ledničku','C++, C, Python',
    'Liberec', 'Měření a řízení kvality', '3', 'Monika', 'Králová', 'monika.kralova@gmail.com', 'Google', '33', '05', '2020');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, rok)
    VALUES ('Compose.io', 'psát články o databázích. Články různých autorů vycházejí v balíčcích 2-5 týdně. Každé tři měsíce se mezi čtenáři blogu provádí průzkum nejlepšího článku. Její autor se může spolehnout na dalších 500 dolarů.'
    ,'Node.js, MongoDB, PostgeSQL, Elasticsearch, RethinkDB', 'Dublin', 'Řízení procesů a modelování, Informatika a aplikace', '1', 'Dana', 'Vaněk', 'dana.vanek@neco.cz', 'Apple', '2022');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('WordCandy', 'články o WordPressu. WordCandy nejprve zaplatí 6 centů za každé slovo v článku WP. Pokud píšete neustále a zajímavě, můžete zvýšit cenu na 10 centů za slovo.','PHP, HTML, CSS a angličtina',
    'Praha', 'Automatizace - PLC - robotika', '3', 'Libor', 'Malý', 'libor.maly@gmail.com', 'Lipo', '26', '02', '2019');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, rok)
    VALUES ('uScript', 'Napíšete widget pro internetový obchod nebo web na uCoz a vložíte jej do oficiálního obchodu a sami nastavíte cenu. Peníze-nejprve 50, pak 60, pak 70 procent - pocházejí z každého prodeje. Kupující jsou přitahováni k webu, peníze mohou být odebrány z účtu jednou měsíčně.','JavaScript, PHP',
    'Karlovy Vary', 'Měření a řízení kvality, Elektronika a vestavěný software', '1', 'Filip', 'Urban', 'filip.urban@gmail.com', 'Binance', '2022');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('Specialista technické podpory', 'Budete musít dělat: zpracování požadavků přicházejících z horké linky a uživatelů systémů, analýza technických problémů a hledání příčin podle protokolů, komunikace s vývojovým týmem, sledování chyb, účast na testování a uvádění nových produktů a služeb na trh','základní úroveň SQL, zkušenosti s 1C na uživatelské úrovni, základní úroveň aplikace Excel, zkušenosti s Charlesem / insomnií / Postmanem',
    'Kyev', 'Elektronika a vestavěný software, Automatizace - PLC - robotika', '2', 'Rudolf', 'Šimek', 'rudolf.simek@gmail.com', 'Google', '27', '03', '2022');


INSERT INTO Hodnoceni (tema, rok, splneni, kvalita, spokojenost_s_pristupem, slovni_hodnoceni) VALUES ('IOT Lednička', '2020', 'ne', 'ne', 'spíše ano', 'Práce nebyla dokončena až do konce');
INSERT INTO Hodnoceni (tema, rok, splneni, kvalita, spokojenost_s_pristupem) VALUES ('WordCandy', '2019', 'spíše ano', 'ano', 'ano');

INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Robot','Robot Pepe','2021');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Databáza','Robot Pepe','2021');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Software','Robot Pepe','2021');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Lednička','IOT Lednička','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Aplikace','IOT Lednička','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('C++','IOT Lednička','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Python','IOT Lednička','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('databáza','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('MongoDB','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Node.js','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('PostgeSQL','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Elasticsearch','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('RethinkDB','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('WordPress','WordCandy','2019');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('JavaScript','WordCandy','2019');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('PHP','WordCandy','2019');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('widget','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('internetový obchod','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('web','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('uCoz','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('horká linka','Specialista technické podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('analýza','Specialista technické podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('sledování chyb','Specialista technické podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('SQL','Specialista technické podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Excel','Specialista technické podpory','2022');



SELECT * FROM Firmy
SELECT * FROM Praxe
SELECT * FROM Uzivatel
