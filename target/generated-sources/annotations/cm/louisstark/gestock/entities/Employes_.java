package cm.louisstark.gestock.entities;

import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.Operation;
import cm.louisstark.gestock.entities.RoleEmploye;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.entities.Utilisateur;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-02-22T15:12:09")
@StaticMetamodel(Employes.class)
public class Employes_ { 

    public static volatile ListAttribute<Employes, Operation> operationList;
    public static volatile SingularAttribute<Employes, Societe> idSociete;
    public static volatile SingularAttribute<Employes, String> matricule;
    public static volatile SingularAttribute<Employes, Adresse> idadresse;
    public static volatile SingularAttribute<Employes, String> tel;
    public static volatile SingularAttribute<Employes, RoleEmploye> idRoleEmploye;
    public static volatile SingularAttribute<Employes, String> nom;
    public static volatile SingularAttribute<Employes, String> prenom;
    public static volatile SingularAttribute<Employes, Integer> idEmploye;
    public static volatile SingularAttribute<Employes, Date> dateEnregistrement;
    public static volatile SingularAttribute<Employes, String> email;
    public static volatile ListAttribute<Employes, Utilisateur> utilisateurList;

}