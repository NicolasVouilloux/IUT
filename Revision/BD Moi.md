### **Fiche de Révision : JDBC et Oracle*


## CODE Exemple

# Ordre

Charer le pilote 
   - Class forName(oracle.jdbc.driver.OracleDriver");
creer un objet connexion
   - Connection co = DriverManager.getConnextion("oracle.jdbc.driver.OracleDriver");
creer un objet
   - Statement st = co(rien ou ResultSet.exemple);
   - Exemple (besoin des trois)
      - Navigabilité
         - TYPE_FORWARD_ONLY(défaut)
         - TYPE_SCROLL_INTENSITIVE(dans tous les sens mais pas de modif depuis l'ouverture du resultset)
         - TYPE_SCROLL_SENSITIVE(navigation + acces aux modifications)
      - Mise à jour
         - CONCUR_READ_ONLY(défaut)
         - CONCUR_UPDATABLE(modif possible)
      - Comportement à la validation
         - CLOSE_CURSORS_OVER_COMMIT(reste ouvert lors d'une validation commit rollback)
         - CLOSE_CURSORS_AT_COMMIT (défaut) (ferme apres chaque validation)
envoyer la requete
   - ResultSet res = requeteSql.executeQuery()

mouvement dans resultset 
   - next()
   - previous()
   - first()
   - last()
   - before()
   - beforeFirst()
   - afterLast()
   - relative(int rows)
   - absolute(int row)
mouvement