# 🍽️ Food Sharing Application

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![JavaFX](https://img.shields.io/badge/JavaFX-17-blue.svg)](https://openjfx.io/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-red.svg)](https://maven.apache.org/)
[![SQLite](https://img.shields.io/badge/SQLite-3.42-green.svg)](https://www.sqlite.org/)

Application desktop JavaFX qui connecte les **donateurs** avec les **bénéficiaires** pour réduire le gaspillage alimentaire et aider les personnes dans le besoin.

---

## 🏆 Contexte du Hackathon

- Projet réalisé dans le cadre d'un hackathon
- Temps de développement : 1 semaine
- Objectif : proposer une solution fonctionnelle et impactante contre le gaspillage alimentaire

⚠️ **Pour les évaluateurs** : Une démonstration vidéo et des captures d'écran sont disponibles ci-dessous. Le projet peut être exécuté localement via JavaFX si nécessaire.

---

## 📋 Table des Matières

- [À propos](#à-propos)
- [Objectifs de Développement Durable](#objectifs-de-développement-durable)
- [Fonctionnalités](#fonctionnalités)
- [Technologies Utilisées](#technologies-utilisées)
- [Architecture du Projet](#architecture-du-projet)
- [Installation](#installation)
- [Utilisation](#utilisation)
- [Structure de la Base de Données](#structure-de-la-base-de-données)
- [Captures d'Écran](#captures-décran)
- [Défis techniques rencontrés](#défis-techniques-rencontrés)
- [Améliorations Futures](#améliorations-futures)
- [Contributeurs](#contributeurs)
- [Licence](#licence)

---

## 📖 À propos

Cette application vise à résoudre le problème du gaspillage alimentaire en créant une plateforme où :
- Les **donateurs** peuvent publier des repas excédentaires
- Les **bénéficiaires** peuvent consulter et recevoir de la nourriture gratuite

### Problématique
- Une grande quantité de nourriture est gaspillée chaque année
- Des millions de personnes souffrent de l'insécurité alimentaire
- Manque de coordination entre ceux qui ont de la nourriture et ceux qui en ont besoin

### Solution
Une application simple et intuitive qui facilite le partage de nourriture en temps réel, permettant de connecter directement les donateurs avec les personnes dans le besoin.

---

## 🌍 Objectifs de Développement Durable

Ce projet contribue aux Objectifs de Développement Durable (ONU) suivants :

- 🎯 **ODD 2** – Faim Zéro : Réduction de la faim en facilitant l'accès à la nourriture
- 🏙️ **ODD 11** – Villes et communautés durables : Renforcement des liens communautaires
- ♻️ **ODD 12** – Consommation et production responsables : Réduction du gaspillage alimentaire

---

## ✨ Fonctionnalités

### Pour tous les utilisateurs
- ✅ Inscription avec validation complète des données
- ✅ Connexion sécurisée
- ✅ Interface intuitive en arabic
- ✅ Interface claire et responsive

### Pour les Donateurs
- ✅ Ajouter de nouveaux repas avec :
  - Nom du repas
  - Quantité disponible
  - Description détaillée
  - Localisation précise
- ✅ Consulter la liste de leurs dons
- ✅ Affichage automatique de la date d'ajout
- ✅ Gestion complète de leurs publications

### Pour les Bénéficiaires
- ✅ Consulter tous les repas disponibles en temps réel
- ✅ Voir les informations du donateur :
  - Nom complet
  - Numéro de téléphone
  - Localisation
- ✅ Affichage de la date de publication
- ✅ Contact direct avec le donateur

---

## 🛠️ Technologies Utilisées

### Frontend
- **JavaFX 17** - Framework d'interface graphique moderne
- **FXML** - Langage de balisage pour les interfaces
- **CSS Inline** - Stylisation des composants

### Backend
- **Java 17** - Langage de programmation
- **SQLite 3.42** - Base de données locale légère
- **JDBC** - Connectivité à la base de données

### Outils de Build
- **Maven 3.6+** - Gestion des dépendances et build automatisé
- **IntelliJ IDEA 2025** - Environnement de développement

---

## 🏗️ Architecture du Projet

```
src/
├── main/
│   ├── java/com/example/test/
│   │   ├── HelloApplication.java       # Point d'entrée principal
│   │   ├── Launcher.java               # Lanceur pour fichier JAR
│   │   │
│   │   ├── User.java                   # Modèle utilisateur
│   │   ├── Meal.java                   # Modèle repas
│   │   │
│   │   ├── DatabaseManager.java        # Gestion centralisée BDD
│   │   │
│   │   └── controllers/
│   │       ├── LoginController.java
│   │       ├── RegisterController.java
│   │       ├── DonorController.java
│   │       ├── ReceiverController.java
│   │       ├── AddMealController.java
│   │       ├── MyMealsController.java
│   │       └── AvailableMealsController.java
│   │
│   └── resources/com/example/test/
│       ├── login-view.fxml
│       ├── register-view.fxml
│       ├── donor-view.fxml
│       ├── receiver-view.fxml
│       ├── add-meal-view.fxml
│       ├── my-meals-view.fxml
│       └── available-meals-view.fxml
│
└── pom.xml                              # Configuration Maven
```

---

## 📦 Installation

### Prérequis
- **Java Development Kit (JDK) 17** ou supérieur
- **Maven 3.6+** ou supérieur
- **IntelliJ IDEA** (recommandé) ou tout autre IDE Java

### Étapes d'installation

1. **Cloner le dépôt**
```bash
git clone https://github.com/yassinebmoallem/FoodShare-JavaFX.git
cd FoodShare-JavaFX
```

2. **Ouvrir avec IntelliJ IDEA**
- File → Open → Sélectionner le dossier du projet
- Attendre l'indexation Maven automatique

3. **Installer les dépendances**
```bash
mvn clean install
```

4. **Lancer l'application**
- Exécuter `HelloApplication.java` depuis l'IDE
- Ou depuis le terminal:
```bash
mvn javafx:run
```

### Créer un fichier JAR exécutable

```bash
mvn clean package
```

Le fichier JAR sera créé dans : `target/FoodSharing-1.0.jar`

Pour exécuter :
```bash
java -jar target/FoodSharing-1.0.jar
```

---

## 🚀 Utilisation

### Première utilisation

1. **Lancer l'application**
2. **Créer un compte** :
   - Cliquer sur "Créer un nouveau compte"
   - Remplir tous les champs requis :
     - Nom complet
     - Email (format validé)
     - Localisation
     - Numéro de téléphone (chiffres uniquement)
     - Mot de passe
   - Choisir le type de compte (Donateur / Bénéficiaire)
   - Cliquer sur "Créer le compte"

3. **Se connecter** :
   - Entrer email et mot de passe
   - Cliquer sur "Se connecter"
   - Redirection automatique selon le type de compte

### En tant que Donateur

1. Cliquer sur **"Ajouter un nouveau repas"**
2. Remplir les informations :
   - Nom du repas (ex: Riz et poulet)
   - Quantité (nombre de portions)
   - Description détaillée
   - Localisation (adresse précise)
3. Cliquer sur **"Ajouter le repas"**
4. Confirmation et retour automatique à la page principale
5. Consulter vos repas via **"Voir mes repas donnés"**

### En tant que Bénéficiaire

1. Cliquer sur **"Voir les repas disponibles"**
2. Parcourir la liste des repas avec :
   - Détails complets du repas
   - Nom du donateur
   - Numéro de téléphone pour contact
   - Localisation exacte
   - Date et heure de publication
3. Contacter le donateur directement par téléphone

---

## 🗄️ Structure de la Base de Données

### Table : users

| Colonne   | Type    | Contraintes            | Description                    |
|-----------|---------|------------------------|--------------------------------|
| id        | INTEGER | PRIMARY KEY, AUTOINCREMENT | Identifiant unique            |
| name      | TEXT    | NOT NULL               | Nom complet de l'utilisateur  |
| email     | TEXT    | UNIQUE, NOT NULL       | Adresse email                 |
| location  | TEXT    | NOT NULL               | Localisation de l'utilisateur |
| phone     | TEXT    | NOT NULL               | Numéro de téléphone           |
| password  | TEXT    | NOT NULL               | Mot de passe                  |
| role      | TEXT    | NOT NULL               | "Donateur" ou "Bénéficiaire"  |

### Table : meals

| Colonne      | Type    | Contraintes            | Description                    |
|--------------|---------|------------------------|--------------------------------|
| id           | INTEGER | PRIMARY KEY, AUTOINCREMENT | Identifiant unique            |
| name         | TEXT    | NOT NULL               | Nom du repas                  |
| quantity     | INTEGER | NOT NULL               | Nombre de portions            |
| description  | TEXT    | NOT NULL               | Description détaillée         |
| location     | TEXT    | NOT NULL               | Localisation du repas         |
| donor_id     | INTEGER | FOREIGN KEY, NOT NULL  | Référence vers users(id)      |
| created_at   | TEXT    | NOT NULL               | Date et heure de création (ISO) |

### Relations et intégrité
- **1:N** - Un utilisateur (donateur) peut avoir plusieurs repas
- **FOREIGN KEY** - Chaque repas est lié à un donateur existant
- **CASCADE** - Suppression automatique des repas si l'utilisateur est supprimé

---

## 📸 Captures d'Écran

### Page de Connexion
Interface épurée avec validation en temps réel

### Page d'Inscription
Formulaire complet avec vérification des données

### Page Donateur
Tableau de bord avec accès rapide aux fonctionnalités

### Ajouter un Repas
Formulaire détaillé pour publication de repas

### Repas Disponibles
Liste complète avec toutes les informations nécessaires

---

## 🔧 Défis techniques rencontrés

### 1. Intégration JavaFX avec SQLite
**Problème** : JavaFX ne supporte pas SQLite nativement, absence de driver JDBC

**Solution implémentée** :
- Ajout du driver JDBC SQLite (`xerial:sqlite-jdbc:3.42.0.0`) dans `pom.xml`
- Création d'une classe `DatabaseManager` centralisée pour toutes les opérations
- Utilisation systématique de `PreparedStatement` pour éviter les injections SQL
- Gestion automatique des connexions avec `try-with-resources`

**Résultat** : Architecture robuste et sécurisée pour l'accès aux données

---

### 2. Gestion des Layouts FXML
**Problème** : Difficultés avec SceneBuilder, layouts complexes et éléments imbriqués

**Solutions appliquées** :
- Utilisation de `VBox` comme conteneur principal pour une structure verticale simple
- Application de styles CSS inline au lieu de fichiers CSS externes
- Configuration correcte de `ScrollPane` avec `fitToWidth="true"` et `VBox.vgrow="ALWAYS"`
- Résolution du bug ComboBox avec `FXCollections.observableArrayList()`

**Résultat** : Interface fluide et responsive sans dépendances externes

---

### 3. Navigation entre les Pages avec persistance des données
**Problème** : Perte des données utilisateur lors des transitions entre vues

**Solution architecturale** :
- Utilisation de `FXMLLoader` pour charger dynamiquement les vues
- Implémentation d'une méthode `setUser(User user)` dans chaque Controller
- Passage des données utilisateur via les Controllers lors de chaque transition
- Maintien de l'état de l'application grâce à la référence `currentUser`

**Résultat** : Expérience utilisateur cohérente sans perte de contexte

---

### 4. Gestion des Dates et Timestamps
**Problème** : SQLite ne supporte pas nativement les types DATE/TIMESTAMP

**Solution technique** :
- Utilisation de `LocalDateTime` en Java pour manipulation des dates
- Conversion en `String` format ISO-8601 pour stockage SQLite
- Méthode `getFormattedDate()` avec `DateTimeFormatter` pour affichage personnalisé
- Format d'affichage : `yyyy-MM-dd HH:mm` (ex: 2025-11-30 14:30)

**Résultat** : Gestion complète et précise des horodatages

---

### 5. Sécurité et validation des données
**Problème** : Nécessité de valider les entrées utilisateur et prévenir les failles

**Mesures de sécurité implémentées** :
- Validation email : vérification de la présence du caractère `@`
- Validation téléphone : vérification que seuls des chiffres sont entrés (`\\d+`)
- Vérification de correspondance des mots de passe
- Protection contre SQL Injection via `PreparedStatement`
- Contraintes d'unicité sur l'email en base de données

**Note** : Hashage des mots de passe prévu pour version production

---

## 🔮 Améliorations Futures

### Court terme (Sprint 1-2)
- [ ] Hashage sécurisé des mots de passe (BCrypt)
- [ ] Système de recherche par localisation avec filtres
- [ ] Catégorisation des repas (végétarien, halal, etc.)
- [ ] Upload de photos des repas
- [ ] Système de notifications push

### Moyen terme (Mois 1-3)
- [ ] Version web avec Spring Boot + REST API
- [ ] Application mobile native (Android/iOS) avec React Native
- [ ] Messagerie instantanée intégrée entre utilisateurs
- [ ] Système de réservation avec confirmation
- [ ] Dashboard administrateur avec statistiques

### Long terme (Trimestre 2-4)
- [ ] Intégration de cartes géographiques interactives (Google Maps API)
- [ ] Système de notation et avis post-donation
- [ ] Programme de partenariats avec restaurants et associations
- [ ] Génération de rapports d'impact social et environnemental
- [ ] Mode hors-ligne avec synchronisation différée

---

## 👥 Contributeurs

- **Yassine Ben Maallem** - Développeur principal - [GitHub](https://github.com/yassinebmoallem) | [LinkedIn](https://www.linkedin.com/in/yassine-ben-maalem/)

---

## 📄 Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

---

## 🤝 Contribution

Les contributions sont les bienvenues ! Pour contribuer :

1. Fork le projet
2. Créer une branche feature (`git checkout -b feature/NouvelleFeature`)
3. Commit les changements (`git commit -m 'Ajout de NouvelleFeature'`)
4. Push vers la branche (`git push origin feature/NouvelleFeature`)
5. Ouvrir une Pull Request

### Guidelines de contribution
- Code commenté en français
- Respect des conventions de nommage Java
- Tests unitaires pour les nouvelles fonctionnalités
- Documentation mise à jour

---

## 📧 Contact

Pour toute question, suggestion ou collaboration :
- **Email** : yassine.bmaalem@gmail.com
- **LinkedIn** : [Yassine Ben Maallem](https://www.linkedin.com/in/yassine-ben-maalem/?skipRedirect=true)
- **GitHub** : [@yassinebmoallem](https://github.com/yassinebmoallem)

---

## 🙏 Remerciements

- [JavaFX Documentation](https://openjfx.io/) - Framework UI moderne
- [SQLite Documentation](https://www.sqlite.org/docs.html) - Base de données embarquée
- [Maven Central Repository](https://mvnrepository.com/) - Gestion des dépendances
- La communauté open-source pour les retours et suggestions
- Tous les contributeurs et testeurs du projet

---

## 📊 Statistiques du Projet

| Métrique | Valeur |
|----------|--------|
| **Langage principal** | Java 17 |
| **Framework UI** | JavaFX 17 |
| **Base de données** | SQLite 3.42 |
| **Lignes de code** | ~2500 |
| **Nombre de classes** | 11 |
| **Nombre de vues FXML** | 7 |
| **Temps de développement** | 1 semaine (hackathon) |
| **Tests** | En cours d'implémentation |

---

## 🎯 Impact Attendu

### Bénéfices sociaux
- Réduction du gaspillage alimentaire dans les communautés locales
- Accès facilité à la nourriture pour les personnes en situation précaire
- Renforcement des liens sociaux et de la solidarité

### Bénéfices environnementaux
- Diminution de l'empreinte carbone liée à la production alimentaire
- Réduction des déchets organiques
- Promotion de la consommation responsable

---

**Développé avec ❤️ pour réduire le gaspillage alimentaire et aider la communauté**

*Version 1.0 - Décembre 2025*
