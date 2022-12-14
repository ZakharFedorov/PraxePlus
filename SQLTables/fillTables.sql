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
    VALUES ('27', 'Polina', 'Dvo??akov??', '3', 'FM', 'polina.dvorakova@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo13'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('28', 'Aleksandra', 'P??tl??k', '2', 'FM', 'aleksandra.petlik@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo14'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('29', '??ora', 'Milu??ky', '2', 'FM', 'zora.milu??ky@tul.cz', 'student', HASHBYTES('md5', 'mojetajneheslo15'));


INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('01', 'Leos', 'Petrilka', NULL, 'FM', 'leos.petrilka@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo84'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('02', 'Marie', 'Bandy', NULL, 'FM', 'marie.bandy@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo85'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('03', 'Martin', 'Nov??k', NULL, 'FM', 'martin.novak@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo86'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('04', 'Lenka', 'Svoboda', NULL, 'FM', 'lenka.svoboda@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo87'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('05', 'David', 'Pokorn??', NULL, 'FM', 'david.pokorny@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo88'));
INSERT INTO Uzivatel (id_uziv, jmeno, prijmeni, rocnik, fakulta, email, [role], heslo)
    VALUES ('06', 'Jitka', 'Fiala', NULL, 'FM', 'jitka.fiala@tul.cz', 'ucitel', HASHBYTES('md5', 'mojetajneheslo89'));
SET IDENTITY_INSERT Uzivatel OFF;

INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('Robot Pepe', 'musite napsat program pro robota-cisnika Pepe','C#, prace s databazy',
    'Brno', 'Elektronika a vestav??n?? software, Elektrotechnika a projektov??n??', '2', 'Marek', 'Hloubik', 'marek.hloubik@gmail.com', 'Microsoft', '43', '01', '2021');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('IOT Ledni??ka', 'Napragramovat aplikace pro chytrou ledni??ku','C++, C, Python',
    'Liberec', 'M????en?? a ????zen?? kvality', '3', 'Monika', 'Kr??lov??', 'monika.kralova@gmail.com', 'Google', '33', '05', '2020');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, rok)
    VALUES ('Compose.io', 'ps??t ??l??nky o datab??z??ch. ??l??nky r??zn??ch autor?? vych??zej?? v bal????c??ch 2-5 t??dn??. Ka??d?? t??i m??s??ce se mezi ??ten????i blogu prov??d?? pr??zkum nejlep????ho ??l??nku. Jej?? autor se m????e spolehnout na dal????ch 500 dolar??.'
    ,'Node.js, MongoDB, PostgeSQL, Elasticsearch, RethinkDB', 'Dublin', '????zen?? proces?? a modelov??n??, Informatika a aplikace', '1', 'Dana', 'Van??k', 'dana.vanek@neco.cz', 'Apple', '2022');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('WordCandy', '??l??nky o WordPressu. WordCandy nejprve zaplat?? 6 cent?? za ka??d?? slovo v ??l??nku WP. Pokud p????ete neust??le a zaj??mav??, m????ete zv????it cenu na 10 cent?? za slovo.','PHP, HTML, CSS a angli??tina',
    'Praha', 'Automatizace - PLC - robotika', '3', 'Libor', 'Mal??', 'libor.maly@gmail.com', 'Lipo', '26', '02', '2019');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, rok)
    VALUES ('uScript', 'Nap????ete widget pro internetov?? obchod nebo web na uCoz a vlo????te jej do ofici??ln??ho obchodu a sami nastav??te cenu. Pen??ze-nejprve 50, pak 60, pak 70 procent - poch??zej?? z ka??d??ho prodeje. Kupuj??c?? jsou p??itahov??ni k webu, pen??ze mohou b??t odebr??ny z ????tu jednou m??s????n??.','JavaScript, PHP',
    'Karlovy Vary', 'M????en?? a ????zen?? kvality, Elektronika a vestav??n?? software', '1', 'Filip', 'Urban', 'filip.urban@gmail.com', 'Binance', '2022');
INSERT INTO Praxe (tema, popis, pozadavky, misto_vykonu, zamereni, stav, jmeno_konzultanta, prijmeni_konzultanta, email_konzultanta, Firmy_nazev_firmy, id_studenta, id_ucitele, rok)
    VALUES ('Specialista technick?? podpory', 'Budete mus??t d??lat: zpracov??n?? po??adavk?? p??ich??zej??c??ch z hork?? linky a u??ivatel?? syst??m??, anal??za technick??ch probl??m?? a hled??n?? p??????in podle protokol??, komunikace s v??vojov??m t??mem, sledov??n?? chyb, ????ast na testov??n?? a uv??d??n?? nov??ch produkt?? a slu??eb na trh','z??kladn?? ??rove?? SQL, zku??enosti s 1C na u??ivatelsk?? ??rovni, z??kladn?? ??rove?? aplikace Excel, zku??enosti s Charlesem / insomni?? / Postmanem',
    'Kyev', 'Elektronika a vestav??n?? software, Automatizace - PLC - robotika', '2', 'Rudolf', '??imek', 'rudolf.simek@gmail.com', 'Google', '27', '03', '2022');


INSERT INTO Hodnoceni (tema, rok, splneni, kvalita, spokojenost_s_pristupem, slovni_hodnoceni) VALUES ('IOT Ledni??ka', '2020', 'ne', 'ne', 'sp????e ano', 'Pr??ce nebyla dokon??ena a?? do konce');
INSERT INTO Hodnoceni (tema, rok, splneni, kvalita, spokojenost_s_pristupem) VALUES ('WordCandy', '2019', 'sp????e ano', 'ano', 'ano');

INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Robot','Robot Pepe','2021');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Datab??za','Robot Pepe','2021');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Software','Robot Pepe','2021');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Ledni??ka','IOT Ledni??ka','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Aplikace','IOT Ledni??ka','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('C++','IOT Ledni??ka','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Python','IOT Ledni??ka','2020');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('datab??za','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('MongoDB','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Node.js','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('PostgeSQL','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Elasticsearch','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('RethinkDB','Compose.io','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('WordPress','WordCandy','2019');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('JavaScript','WordCandy','2019');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('PHP','WordCandy','2019');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('widget','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('internetov?? obchod','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('web','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('uCoz','uScript','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('hork?? linka','Specialista technick?? podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('anal??za','Specialista technick?? podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('sledov??n?? chyb','Specialista technick?? podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('SQL','Specialista technick?? podpory','2022');
INSERT INTO Klicova_slova (slovo, tema, rok) VALUES ('Excel','Specialista technick?? podpory','2022');



SELECT * FROM Firmy
SELECT * FROM Praxe
SELECT * FROM Uzivatel
