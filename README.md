# geStock
Application de gestion des stocks

cette application permet la gestion des stocks de plusieurs entreprises (magasins)

========== fonctionnalités ==============================

1. Gestion des utilisateurs

Ici il est question de creer les utilisateurs et des les attribuer des roles. ces roles sont au préalable déjà crée et managés.
Le managemenent des roles passe par la création des differents menus (ce travail est éffectué par le super administrateur), 
la création des privilèges (chaque privilège concerne un seul menu), ensuite il ya la creation du rôle proprement dit ,ici on assigne les privilèges ainsi que les
actions (créer, modifier, supprimer) possible pouvant être effectué.

NB: un employer de magasin peu avoir aussi un compte utilisateur, pour cela, à la creation d'un compte utilisateur vous devez assiner l'employé à qui appartiendra 
ce compte.

- creation des roles utilisateurs
- creation des menus
- creation des privileges
- assignation des privileges aux differents roles utilisateurs
- création des utilisateurs en lui assignant son rôle utilisateur


2. Gestion des magasins

Ici il est question de la création des magasins, des cycles des travail. en effet chaque opperqtion sera enregistré dans cycle bien précis
Ex: vous pouvez creer un cycle correspondant à une année ou un trimestre...

- creation des magasins
- creation des cycles de travail
- creation des produits
- creation des comptes des clients


3. Enregistrements des entrées (ventes)

Dans cette partie il est auestion d'enregistrer les bon de commandes, dans lesquels on retrouve le client ainsi que tous ses produits commandés.
Il sera possible par la suite de marquer les commandes comme Livrée.

- enregistrment des ventes
- marquer comme livrée celles qui le sont
- imprimer la facture
