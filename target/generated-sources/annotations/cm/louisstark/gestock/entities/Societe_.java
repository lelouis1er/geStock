package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Magasin;
import cm.louisstark.gestock.entities.Session;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-26T08:09:33")
@StaticMetamodel(Societe.class)
public class Societe_ { 

    public static volatile SingularAttribute<Societe, Date> dateCreation;
    public static volatile SingularAttribute<Societe, Integer> idSociete;
    public static volatile SingularAttribute<Societe, String> code;
    public static volatile SingularAttribute<Societe, String> siteweb;
    public static volatile ListAttribute<Societe, Employes> employesList;
    public static volatile SingularAttribute<Societe, String> description;
    public static volatile SingularAttribute<Societe, String> telephone;
    public static volatile SingularAttribute<Societe, Adresse> idadresse;
    public static volatile SingularAttribute<Societe, String> nom;
    public static volatile SingularAttribute<Societe, Date> dateEnregistrement;
    public static volatile ListAttribute<Societe, Session> sessionList;
    public static volatile ListAttribute<Societe, Magasin> magasinList;
    public static volatile ListAttribute<Societe, Article> articleList;
    public static volatile ListAttribute<Societe, Client> clientList;
    public static volatile SingularAttribute<Societe, String> email;

}