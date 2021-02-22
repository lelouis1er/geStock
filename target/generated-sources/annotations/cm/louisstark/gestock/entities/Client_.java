package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.entities.TypeClient;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-22T15:12:09")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile ListAttribute<Client, CommandeClient> commandeClientList;
    public static volatile SingularAttribute<Client, Societe> idSociete;
    public static volatile SingularAttribute<Client, TypeClient> idType;
    public static volatile SingularAttribute<Client, Integer> idClient;
    public static volatile SingularAttribute<Client, String> tel;
    public static volatile SingularAttribute<Client, Adresse> idadresse;
    public static volatile SingularAttribute<Client, String> nom;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> email;

}