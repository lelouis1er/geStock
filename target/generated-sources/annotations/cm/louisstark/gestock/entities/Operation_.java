package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Achats;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.TypeOperation;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-21T19:17:54")
@StaticMetamodel(Operation.class)
public class Operation_ { 

    public static volatile ListAttribute<Operation, CommandeClient> commandeClientList;
    public static volatile SingularAttribute<Operation, TypeOperation> idType;
    public static volatile ListAttribute<Operation, Commande> commandeList;
    public static volatile ListAttribute<Operation, Achats> achatsList;
    public static volatile SingularAttribute<Operation, Integer> idOperation;
    public static volatile ListAttribute<Operation, Livraison> livraisonList;
    public static volatile SingularAttribute<Operation, Session> idSession;
    public static volatile SingularAttribute<Operation, String> intitule;
    public static volatile SingularAttribute<Operation, Employes> idEmploye;

}