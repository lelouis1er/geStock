package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Fournisseur;
import cm.louisstark.gestock.entities.Quartier;
import cm.louisstark.gestock.entities.Societe;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-03-04T16:15:08")
@StaticMetamodel(Adresse.class)
public class Adresse_ { 

    public static volatile ListAttribute<Adresse, Societe> societeList;
    public static volatile ListAttribute<Adresse, Employes> employesList;
    public static volatile SingularAttribute<Adresse, String> autredescription;
    public static volatile SingularAttribute<Adresse, Quartier> idquartier;
    public static volatile SingularAttribute<Adresse, Integer> idadresse;
    public static volatile ListAttribute<Adresse, Fournisseur> fournisseurList;
    public static volatile ListAttribute<Adresse, Client> clientList;

}