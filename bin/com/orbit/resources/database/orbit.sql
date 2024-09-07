DROP TABLE IF EXISTS Utilisateur;
DROP TABLE IF EXISTS Profil_utilisateur;
DROP TABLE IF EXISTS Niveau;
DROP TABLE IF EXISTS Etudiant;
DROP TABLE IF EXISTS Image;
DROP TABLE IF EXISTS img_utilisateur;
DROP TABLE IF EXISTS Formateur;
DROP TABLE IF EXISTS Matiere;
DROP TABLE IF EXISTS Categorie_cours;
DROP TABLE IF EXISTS Cours;
DROP TABLE IF EXISTS Module;
DROP TABLE IF EXISTS Ressource_lecon;
DROP TABLE IF EXISTS Lecon;
DROP TABLE IF EXISTS Session;
DROP TABLE IF EXISTS Activite_session;
DROP TABLE IF EXISTS Type_exercice;
DROP TABLE IF EXISTS Exercice;
DROP TABLE IF EXISTS Solution;
DROP TABLE IF EXISTS Etat_module;
DROP TABLE IF EXISTS Progression_exercice;
DROP TABLE IF EXISTS Progression_lecon;
DROP TABLE IF EXISTS Progression ;
DROP TABLE IF EXISTS Admin;
DROP TABLE IF EXISTS Forum;
DROP TABLE IF EXISTS Question;
DROP TABLE IF EXISTS Reponse;
DROP TABLE IF EXISTS Ressource;
DROP TABLE IF EXISTS Type_ressource;
DROP TABLE IF EXISTS Categorie_ressource;
DROP TABLE IF EXISTS Ressource_market;
DROP TABLE IF EXISTS Vente_ressource;
DROP TABLE IF EXISTS Vente_paiement;
DROP TABLE IF EXISTS Type_paiement;
DROP TABLE IF EXISTS Vente_score;
DROP TABLE IF EXISTS Souscription;
DROP TABLE IF EXISTS Evaluation_ressource;


CREATE TABLE Utilisateur (
id INT AUTO_INCREMENT NOT NULL,
identifiant  VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
mdp TEXT NOT NULL,
date_inscription DATETIME NOT NULL,
derniere_connexion DATETIME NOT NULL,
PRIMARY KEY (id,email));

CREATE TABLE Profil_utilisateur (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_utilisateur INT NOT NULL,
nom VARCHAR(200) NOT NULL,
naissance DATETIME NOT NULL,
pays VARCHAR(50) NOT NULL,
biographie TEXT NOT NULL,
id_image INT NOT NULL);

CREATE TABLE Niveau (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
intitule VARCHAR(100) NOT NULL);

CREATE TABLE Etudiant (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_profil INT NOT NULL,
id_niveau INT NOT NULL);

CREATE TABLE Image (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nom VARCHAR(100) NOT NULL,
contenu BLOB NOT NULL,
taille DOUBLE NOT NULL);

CREATE TABLE img_utilisateur (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_image INT NOT NULL);

CREATE TABLE Formateur (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_profil INT NOT NULL,
specialisation INT NOT NULL);

CREATE TABLE Matiere (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
titre VARCHAR(200) NOT NULL,
description  TEXT NOT NULL,
technologie VARCHAR(100) NOT NULL);

CREATE TABLE Categorie_cours (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
intitule VARCHAR(100) NOT NULL);

CREATE TABLE Cours (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_matiere INT NOT NULL,
id_categorie INT NOT NULL,
total_point INT NOT NULL,
id_niveau INT NOT NULL);

CREATE TABLE Module (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_cours INT NOT NULL,
ordre INT NOT NULL,
titre VARCHAR(200) NOT NULL,
description  TEXT NOT NULL);

CREATE TABLE Ressource_lecon (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
url TEXT NOT NULL);

CREATE TABLE Lecon (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_module INT NOT NULL,
ordre INT NOT NULL,
titre VARCHAR(200) NOT NULL,
contenu TEXT NOT NULL,
id_ressource INT NOT NULL);

CREATE TABLE Session (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_module INT NOT NULL,
id_etudiant INT NOT NULL,
date_debut DATE NOT NULL,
date_fin DATE);

CREATE TABLE Activite_session (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_session INT NOT NULL,
derniere_activite DATETIME NOT NULL,
duree INT NOT NULL);

CREATE TABLE Type_exercice (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
intitule VARCHAR(200) NOT NULL);

CREATE TABLE Exercice (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
titre VARCHAR(200) NOT NULL,
id_module INT NOT NULL,
instruction TEXT NOT NULL,
contenu INT NOT NULL,
id_type INT NOT NULL,
Points INT NOT NULL);

CREATE TABLE Solution (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_exercice INT NOT NULL,
contenu TEXT NOT NULL);

CREATE TABLE Etat_module (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
statut VARCHAR(50) NOT NULL);

CREATE TABLE Progression_exercice (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_exercice INT NOT NULL,
score DOUBLE NOT NULL);

CREATE TABLE Progression_lecon (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_lecon INT NOT NULL,
score DOUBLE NOT NULL);

CREATE TABLE Progression  (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_activite INT NOT NULL,
id_prog_lecon INT NOT NULL,
id_prog_exercice INT NOT NULL);

CREATE TABLE Admin (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_utilisateur INT NOT NULL);

CREATE TABLE Forum (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
titre VARCHAR(200) NOT NULL,
date_creation DATETIME NOT NULL,
maj DATETIME NOT NULL);

CREATE TABLE Question (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_forum INT NOT NULL,
id_etudiant INT NOT NULL,
titre VARCHAR(200) NOT NULL,
contenu TEXT NOT NULL,
date_creation DATETIME NOT NULL,
maj DATETIME NOT NULL,
nbre_like INT NOT NULL,
nbre_dislike INT NOT NULL);

CREATE TABLE Reponse (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_question INT NOT NULL,
id_utilisateur INT NOT NULL,
contenu TEXT NOT NULL,
date_creation DATETIME NOT NULL,
nbre_like INT NOT NULL,
nbre_dislike INT NOT NULL);

CREATE TABLE Ressource (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
titre VARCHAR(200) NOT NULL,
description TEXT NOT NULL,
prix_espece DOUBLE NOT NULL,
prix_score INT NOT NULL,
premium BOOLEAN NOT NULL,
date_creation DATETIME NOT NULL,
maj DATETIME NOT NULL,
id_type INT NOT NULL);

CREATE TABLE Type_ressource (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
type VARCHAR(20) NOT NULL);

CREATE TABLE Categorie_ressource (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nom VARCHAR(100) NOT NULL,
description  TEXT NOT NULL);

CREATE TABLE Ressource_market (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_ressource INT NOT NULL,
id_categorie INT NOT NULL);

CREATE TABLE Vente_ressource (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_etudiant INT NOT NULL,
id_ressource INT NOT NULL,
date_vendu DATETIME NOT NULL);

CREATE TABLE Vente_paiement (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_vente INT NOT NULL,
montant DOUBLE NOT NULL,
id_type_paiement INT NOT NULL);

CREATE TABLE Type_paiement (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
nom VARCHAR(50) NOT NULL);

CREATE TABLE Vente_score (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_vente INT NOT NULL,
score_utilise INT NOT NULL);

CREATE TABLE Souscription (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_etudiant INT NOT NULL,
date_debut DATE NOT NULL,
date_fin DATE NOT NULL,
premium_actif BOOLEAN NOT NULL);

CREATE TABLE Evaluation_ressource (
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_ressource INT NOT NULL,
id_etudiant INT NOT NULL,
note INT NOT NULL,
commentaire TEXT NOT NULL,
date_creation DATETIME NOT NULL);

ALTER TABLE Profil_utilisateur ADD CONSTRAINT Profil_utilisateur_id_utilisateur_Utilisateur_id FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Profil_utilisateur ADD CONSTRAINT Profil_utilisateur_id_image_img_utilisateur_id FOREIGN KEY (id_image) REFERENCES img_utilisateur(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Etudiant ADD CONSTRAINT Etudiant_id_profil_Profil_utilisateur_id FOREIGN KEY (id_profil) REFERENCES Profil_utilisateur(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Etudiant ADD CONSTRAINT Etudiant_id_niveau_Niveau_id FOREIGN KEY (id_niveau) REFERENCES Niveau(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE img_utilisateur ADD CONSTRAINT img_utilisateur_id_image_Image_id FOREIGN KEY (id_image) REFERENCES Image(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Formateur ADD CONSTRAINT Formateur_id_profil_Profil_utilisateur_id FOREIGN KEY (id_profil) REFERENCES Profil_utilisateur(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Cours ADD CONSTRAINT Cours_id_matiere_Matiere_id FOREIGN KEY (id_matiere) REFERENCES Matiere(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Cours ADD CONSTRAINT Cours_id_categorie_Categorie_cours_id FOREIGN KEY (id_categorie) REFERENCES Categorie_cours(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Cours ADD CONSTRAINT Cours_id_niveau_Niveau_id FOREIGN KEY (id_niveau) REFERENCES Niveau(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Module ADD CONSTRAINT Module_id_cours_Cours_id FOREIGN KEY (id_cours) REFERENCES Cours(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Lecon ADD CONSTRAINT Lecon_id_module_Module_id FOREIGN KEY (id_module) REFERENCES Module(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Lecon ADD CONSTRAINT Lecon_id_ressource_Ressource_lecon_id FOREIGN KEY (id_ressource) REFERENCES Ressource_lecon(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Session ADD CONSTRAINT Session_id_module_Module_id FOREIGN KEY (id_module) REFERENCES Module(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Session ADD CONSTRAINT Session_id_etudiant_Etudiant_id FOREIGN KEY (id_etudiant) REFERENCES Etudiant(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Activite_session ADD CONSTRAINT Activite_session_id_session_Session_id FOREIGN KEY (id_session) REFERENCES Session(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Exercice ADD CONSTRAINT Exercice_id_module_Module_id FOREIGN KEY (id_module) REFERENCES Module(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Exercice ADD CONSTRAINT Exercice_id_type_Type_exercice_id FOREIGN KEY (id_type) REFERENCES Type_exercice(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Solution ADD CONSTRAINT Solution_id_exercice_Exercice_id FOREIGN KEY (id_exercice) REFERENCES Exercice(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Progression_exercice ADD CONSTRAINT Progression_exercice_id_exercice_Exercice_id FOREIGN KEY (id_exercice) REFERENCES Exercice(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Progression_lecon ADD CONSTRAINT Progression_lecon_id_lecon_Lecon_id FOREIGN KEY (id_lecon) REFERENCES Lecon(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Progression  ADD CONSTRAINT Progression_id_activite_Activite_session_id FOREIGN KEY (id_activite) REFERENCES Activite_session(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Progression  ADD CONSTRAINT Progression_id_prog_lecon_Progression_lecon_id FOREIGN KEY (id_prog_lecon) REFERENCES Progression_lecon(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Progression  ADD CONSTRAINT Progression_id_prog_exercice_Progression_exercice_id FOREIGN KEY (id_prog_exercice) REFERENCES Progression_exercice(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Admin ADD CONSTRAINT Admin_id_utilisateur_Utilisateur_id FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Question ADD CONSTRAINT Question_id_forum_Forum_id FOREIGN KEY (id_forum) REFERENCES Forum(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Question ADD CONSTRAINT Question_id_etudiant_Etudiant_id FOREIGN KEY (id_etudiant) REFERENCES Etudiant(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Reponse ADD CONSTRAINT Reponse_id_question_Question_id FOREIGN KEY (id_question) REFERENCES Question(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Reponse ADD CONSTRAINT Reponse_id_utilisateur_Utilisateur_id FOREIGN KEY (id_utilisateur) REFERENCES Utilisateur(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Ressource ADD CONSTRAINT Ressource_id_type_Type_ressource_id FOREIGN KEY (id_type) REFERENCES Type_ressource(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Ressource_market ADD CONSTRAINT Ressource_market_id_ressource_Ressource_id FOREIGN KEY (id_ressource) REFERENCES Ressource(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Ressource_market ADD CONSTRAINT Ressource_market_id_categorie_Categorie_ressource_id FOREIGN KEY (id_categorie) REFERENCES Categorie_ressource(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Vente_ressource ADD CONSTRAINT Vente_ressource_id_etudiant_Etudiant_id FOREIGN KEY (id_etudiant) REFERENCES Etudiant(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Vente_ressource ADD CONSTRAINT Vente_ressource_id_ressource_Ressource_market_id FOREIGN KEY (id_ressource) REFERENCES Ressource_market(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Vente_paiement ADD CONSTRAINT Vente_paiement_id_vente_Vente_ressource_id FOREIGN KEY (id_vente) REFERENCES Vente_ressource(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Vente_paiement ADD CONSTRAINT Vente_paiement_id_type_paiement_Type_paiement_id FOREIGN KEY (id_type_paiement) REFERENCES Type_paiement(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Vente_score ADD CONSTRAINT Vente_score_id_vente_Vente_ressource_id FOREIGN KEY (id_vente) REFERENCES Vente_ressource(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Souscription ADD CONSTRAINT Souscription_id_etudiant_Etudiant_id FOREIGN KEY (id_etudiant) REFERENCES Etudiant(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Evaluation_ressource ADD CONSTRAINT Evaluation_ressource_id_ressource_Ressource_market_id FOREIGN KEY (id_ressource) REFERENCES Ressource_market(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Evaluation_ressource ADD CONSTRAINT Evaluation_ressource_id_etudiant_Etudiant_id FOREIGN KEY (id_etudiant) REFERENCES Etudiant(id) ON DELETE CASCADE ON UPDATE CASCADE;
