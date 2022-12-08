CREATE TABLE Firmy (
    nazev_firmy nvarchar(20)  NOT NULL,
    pobocka nvarchar(20)  NULL,
    jmeno_KO nvarchar(20)  NOT NULL,
    prijmeni_KO nvarchar(20)  NOT NULL,
    email_KO nvarchar(30)  NOT NULL,
    heslo_KO nvarchar(25)  NOT NULL,
    mesto nvarchar(20)  NOT NULL,
    CONSTRAINT Firmy_pk PRIMARY KEY  (nazev_firmy)
);

-- Table: Hodnoceni
CREATE TABLE Hodnoceni (
    tema nvarchar(40)  NOT NULL,
    rok int  NOT NULL,
    splneni nvarchar(10)  NOT NULL,
    kvalita nvarchar(10)  NOT NULL,
    spokojenost_s_pristupem nvarchar(10)  NOT NULL,
    slovni_hodnoceni nvarchar(500)  NULL,
    CONSTRAINT Hodnoceni_pk PRIMARY KEY  (splneni,kvalita,spokojenost_s_pristupem,tema,rok)
);

-- Table: Klicova_slova
CREATE TABLE Klicova_slova (
    slovo nvarchar(20)  NOT NULL,
    tema nvarchar(40)  NOT NULL,
    rok int  NOT NULL,
    CONSTRAINT Klicova_slova_pk PRIMARY KEY  (slovo,tema)
);

-- Table: Praxe
CREATE TABLE Praxe (
    tema nvarchar(40)  NOT NULL,
    popis nvarchar(1000)  NOT NULL,
    pozadavky nvarchar(200)  NOT NULL,
    misto_vykonu nvarchar(30)  NOT NULL,
    zamereni nvarchar(180)  NOT NULL,
    stav int  NOT NULL,
    jmeno_konzultanta nvarchar(20)  NOT NULL,
    prijmeni_konzultanta nvarchar(20)  NOT NULL,
    email_konzultanta nvarchar(30)  NOT NULL,
    Firmy_nazev_firmy nvarchar(20)  NOT NULL,
    id_studenta int  NULL,
    id_ucitele int  NULL,
    rok int  NOT NULL,
    CONSTRAINT Praxe_pk PRIMARY KEY  (tema,rok)
);

-- Table: Uzivatel
CREATE TABLE Uzivatel (
    id_uziv int IDENTITY(50,1)  NOT NULL,
    jmeno nvarchar(20)  NOT NULL,
    prijmeni nvarchar(20)  NOT NULL,
    rocnik int  NULL,
    fakulta nvarchar(4)  NOT NULL,
    email nvarchar(30)  NOT NULL,
    role nvarchar(10)  NOT NULL,
    heslo nvarchar(25)  NOT NULL,
    CONSTRAINT Uzivatel_pk PRIMARY KEY  (id_uziv)
);

-- foreign keys
-- Reference: Hodnoceni_Praxe (table: Hodnoceni)
ALTER TABLE Hodnoceni ADD CONSTRAINT Hodnoceni_Praxe
    FOREIGN KEY (tema,rok)
    REFERENCES Praxe (tema,rok);

-- Reference: Klicova_slova_Praxe (table: Klicova_slova)
ALTER TABLE Klicova_slova ADD CONSTRAINT Klicova_slova_Praxe
    FOREIGN KEY (tema,rok)
    REFERENCES Praxe (tema,rok);

-- Reference: Praxe_Firmy (table: Praxe)
ALTER TABLE Praxe ADD CONSTRAINT Praxe_Firmy
    FOREIGN KEY (Firmy_nazev_firmy)
    REFERENCES Firmy (nazev_firmy);

-- Reference: Praxe_Student (table: Praxe)
ALTER TABLE Praxe ADD CONSTRAINT Praxe_Student
    FOREIGN KEY (id_studenta)
    REFERENCES Uzivatel (id_uziv);

-- Reference: Praxe_Ucitel (table: Praxe)
ALTER TABLE Praxe ADD CONSTRAINT Praxe_Ucitel
    FOREIGN KEY (id_ucitele)
    REFERENCES Uzivatel (id_uziv);