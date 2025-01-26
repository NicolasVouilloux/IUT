# Fiche revision reseau

iptables, ebtables

3 chaines de regles 
INPUT (qui arrive)
OUTPUT (qui sont émis)
FORWARD (qui transitent)

iptables -A INPUT -p tcp --dport 80 --destination 10.0.2.0/24 -j ACCEPT

-j :
ACCEPT 
DROP 
REJECT detruit + paquet err ICMP emis
LOG paquet loggué

syntaxe 

iptables [-t table] -L -v
iptables [-t table] -A chaine ....= Append (rajoute a la fin)
iptables [-t table] -I chaine n= INSERT a la pos n de la chaine
iptables [-t table] -R chaine n= REPLACE la regle n 
iptables [-t table] -D chaine = DELETE la regle de la chaine
iptables [-t table] -P chaine = POLICY la politique par defaut

exemples de conditions 

-p protocole (filtre selon le protocole)
-d reseau (filtre selon le reseau ou l'adresse de destination)
-s reseau (la meme mais expeditrice)
-i interface (interface d'entree)
-o interface (interface de sortie)
--dport (port de destination du paquet)
--sport (port emetteur)

