
### **Fiche de Révision : JDBC et Oracle**

#### **Introduction**
- **JDBC** : API pour exécuter des instructions SQL dans Java.
- **Utilité** : Lier une application Java à une base de données relationnelle.
- **Package principal** : `java.sql`.

#### **Étapes de l'utilisation de JDBC**
1. Charger le pilote (`Class.forName("oracle.jdbc.driver.OracleDriver");`).
2. Établir une connexion via `DriverManager.getConnection(url)`.
3. Exécuter des requêtes SQL avec `Statement` ou `PreparedStatement`.
4. Traiter les résultats via `ResultSet`.
5. Mettre à jour ou insérer des données dans la base.
6. Libérer les ressources (`close()`).

---

### **Connexion**
1. **Chargement du pilote** : Statique ou dynamique (méthode recommandée avec `Class.forName()`).
2. **URL pour JDBC** :
   - Format général : `jdbc:<sous-protocole>:<compléments>`.
   - Exemple : `jdbc:oracle:thin:toto/mdpToto@oracle.iut-orsay.fr:1521:etudom`.
3. **Création de connexion** :
   ```java
   Connection conn = DriverManager.getConnection(url);
   ```

---

### **Requêtes et Résultats**

#### **Statement**
- Création : 
   ```java
   Statement stmt = conn.createStatement();
   ```
- Exécution de requêtes :
  - `executeQuery(String sql)` : Pour SELECT.
  - `executeUpdate(String sql)` : Pour INSERT, UPDATE, DELETE.

#### **ResultSet**
- Utilisé pour parcourir les résultats :
  ```java
  ResultSet rs = stmt.executeQuery("SELECT * FROM table");
  while (rs.next()) {
      String value = rs.getString("column_name");
  }
  ```
- Méthodes principales :
  - `next()` : Avancer dans les lignes.
  - `getString("col_name")`, `getInt("col_name")`, etc., pour accéder aux colonnes.
  - `wasNull()` : Vérifie si une valeur est `NULL`.

---

### **Mise à jour des données avec JDBC**
1. **INSERT, DELETE, UPDATE** :
   - Utilisez `executeUpdate()`.
   - Exemple : 
     ```java
     int rows = stmt.executeUpdate("INSERT INTO table (col) VALUES ('value')");
     ```

2. **Mises à jour via `ResultSet`** :
   - Ouvrir en mode modifiable :
     ```java
     Statement stmt = conn.createStatement(
         ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
     ```
   - Méthodes pour modification :
     - `updateXXX()` : Modifier une valeur.
     - `updateRow()` : Appliquer les modifications.
   - Exemple :
     ```java
     rs.updateString("column", "newValue");
     rs.updateRow();
     ```

---

### **Requêtes Précompilées : PreparedStatement**
- Préparer une requête avec des paramètres :
  ```java
  PreparedStatement pstmt = conn.prepareStatement(
      "SELECT * FROM table WHERE col = ?");
  pstmt.setString(1, "value");
  ResultSet rs = pstmt.executeQuery();
  ```
- Avantages :
  - Plus rapide pour des requêtes répétées.
  - Meilleure gestion des types et de la sécurité.

---

### **Appel aux Procédures et Fonctions Stockées : CallableStatement**
1. **Définition** : Appeler des procédures ou fonctions SQL via JDBC.
2. **Création** :
   ```java
   CallableStatement cstmt = conn.prepareCall("{call procedure_name(?, ?)}");
   ```
3. **Gestion des paramètres** :
   - Entrée : `setXXX()`.
   - Sortie : `registerOutParameter()`, récupérée avec `getXXX()`.
4. **Exemple** :
   ```java
   CallableStatement cstmt = conn.prepareCall("{? = call function_name(?)}");
   cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
   cstmt.setString(2, "param_value");
   cstmt.execute();
   int result = cstmt.getInt(1);
   ```

---

### **Gestion des Exceptions : SQLException**
- **Méthodes importantes** :
  - `getSQLState()` : Code SQLSTATE.
  - `getErrorCode()` : Code d'erreur spécifique.
  - `getNextException()` : Récupérer l'exception suivante.

---

### **Types de `ResultSet`**
- **Navigation** :
  - `TYPE_FORWARD_ONLY` : Navigation avant uniquement.
  - `TYPE_SCROLL_INSENSITIVE` : Navigation dans tous les sens, mais les modifications externes ne sont pas visibles.
  - `TYPE_SCROLL_SENSITIVE` : Navigation avec mise à jour des données.
- **Modifications** :
  - `CONCUR_READ_ONLY` : Lecture seule.
  - `CONCUR_UPDATABLE` : Modification possible.

---

### **Bilan**
- **JDBC** permet de gérer :
  - Connexions aux bases.
  - Requêtes simples ou paramétrées.
  - Appels à des fonctions ou procédures stockées.
- **Quand utiliser PL/SQL** :
  - Pour des traitements complexes ou nécessitant plusieurs consultations.
  - Pour limiter les transferts entre le client et le serveur.

### **Fiche de Révision : Gestion des Verrous et Concurrence d'Accès**

#### **Introduction**
- **Problème** : Lorsque plusieurs utilisateurs manipulent les mêmes données en même temps, il faut arbitrer entre :
  - **Disponibilité** : Éviter de bloquer tout le monde.
  - **Cohérence** : Assurer l'intégrité des données (exemple : éviter que deux utilisateurs achètent la même place).

#### **Définitions**
- **Transaction** : Suite d'opérations devant être validées (COMMIT) ou annulées (ROLLBACK) en bloc.
- **Accès concurrent** : Plusieurs utilisateurs accèdent simultanément aux mêmes données.
- **Consistance des données** : Le SGBD garantit que les données utilisées par une transaction ne sont pas modifiées par d'autres transactions.

---

### **Les Verrous**
1. **Types de verrous** :
   - **Partagé (shared lock)** : Lecture avec intention de mise à jour.
   - **Exclusif (exclusive lock)** : Modification de données.
   - **Global (global lock)** : Blocage d'un ensemble de données (table entière).

2. **Règles** :
   - Les verrous sont relâchés à la fin de la transaction (COMMIT ou ROLLBACK).
   - Opérations comme `CREATE TABLE` déclenchent un COMMIT implicite.

---

### **Collisions de Transactions**

#### **Types de Collisions et Solutions**
1. **Perte de mise à jour** :
   - **Problème** : Deux transactions modifient la même donnée sans coordination.
   - **Solution** : Utilisation de verrous exclusifs pour éviter les conflits.

2. **Lecture impropre (dirty read)** :
   - **Problème** : Une transaction lit des données modifiées mais non validées par une autre transaction.
   - **Solution** : Verrou exclusif sur les données jusqu'à la validation ou annulation.

3. **Lecture non reproductible** :
   - **Problème** : Une transaction relit des données modifiées par une autre transaction après la première lecture.
   - **Solution** : Verrou partagé pendant la lecture et verrou exclusif avant modification.

---

### **Niveaux de Cohérence**
1. **Propriétés à garantir** :
   - Pas de modification sur des données "salis".
   - Pas de validation avant la fin de la transaction.
   - Pas de lecture de données "salis".
   - Isolation totale pendant la transaction.

2. **Niveaux** :
   - **Niveau 0** : Évite uniquement les pertes de mise à jour.
   - **Niveau 1** : Ajoute la garantie de ne pas valider avant la fin.
   - **Niveau 2** : Évite pertes de mise à jour et lectures impropres.
   - **Niveau 3** (sérialisable) : Assure une isolation totale et des lectures reproductibles.

---

### **Blocage Fatal (Deadlock)**
1. **Conditions pour un deadlock** :
   - Accès exclusif aux ressources.
   - Attente circulaire (chaque transaction attend une ressource verrouillée par une autre).
   - Au moins une transaction détient une ressource et en demande d'autres.
   - Pas de réquisition forcée des ressources.

2. **Solution : Règle de Havender** :
   - Les transactions doivent demander les ressources dans le même ordre pour éviter les attentes circulaires.

---

### **Problème de la Tasse de Café**
1. **Problème** : Verrous maintenus pendant que l'utilisateur interagit (longue saisie ou attente).
2. **Solution** :
   - Séparer les phases :
     - Collecte des données par l'utilisateur.
     - Début de transaction, accès et modifications sur la base, puis validation.

---

### **Visibilité des Données**
- **Pendant une transaction** : Les données modifiées sont visibles uniquement à l'intérieur de la transaction.
- **Après COMMIT** : Les modifications sont accessibles à tous les utilisateurs.
- **Lectures** :
  - Les données lues reflètent leur état au début de la requête, même si elles sont modifiées et validées pendant l'exécution.

