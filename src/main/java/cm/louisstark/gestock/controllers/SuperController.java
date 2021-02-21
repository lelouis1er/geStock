package cm.louisstark.gestock.controllers;

import cm.louisstark.gestock.entities.AchatArticle;
import cm.louisstark.gestock.entities.Achats;
import cm.louisstark.gestock.entities.Adresse;
import cm.louisstark.gestock.entities.ArticlesCommandeClient;
import cm.louisstark.gestock.entities.Article;
import cm.louisstark.gestock.entities.ArticleStock;
import cm.louisstark.gestock.entities.ArticleCommande;
import cm.louisstark.gestock.entities.ArticleLiv;
import cm.louisstark.gestock.entities.CategorieArticle;
import cm.louisstark.gestock.entities.Client;
import cm.louisstark.gestock.entities.Commande;
import cm.louisstark.gestock.entities.CommandeClient;
import cm.louisstark.gestock.entities.Employes;
import cm.louisstark.gestock.entities.Etagere;
import cm.louisstark.gestock.entities.Fournisseur;
import cm.louisstark.gestock.entities.Livraison;
import cm.louisstark.gestock.entities.Magasin;
import cm.louisstark.gestock.entities.Menu;
import cm.louisstark.gestock.entities.Mouchard;
import cm.louisstark.gestock.entities.Operation;
import cm.louisstark.gestock.entities.Pays;
import cm.louisstark.gestock.entities.Privilegesutilisateur;
import cm.louisstark.gestock.entities.Quartier;
import cm.louisstark.gestock.entities.Region;
import cm.louisstark.gestock.entities.Restrictionprivilege;
import cm.louisstark.gestock.entities.RetourArticleLiv;
import cm.louisstark.gestock.entities.RoleEmploye;
import cm.louisstark.gestock.entities.Roleprivilege;
import cm.louisstark.gestock.entities.Roleutilisateur;
import cm.louisstark.gestock.entities.Session;
import cm.louisstark.gestock.entities.Societe;
import cm.louisstark.gestock.entities.TypeArticle;
import cm.louisstark.gestock.entities.TypeClient;
import cm.louisstark.gestock.entities.TypeOperation;
import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.entities.Ville;
import cm.louisstark.gestock.sessions.AchatArticleFacadeLocal;
import cm.louisstark.gestock.sessions.AchatsFacadeLocal;
import cm.louisstark.gestock.sessions.AdresseFacadeLocal;
import cm.louisstark.gestock.sessions.ArticleCommandeFacadeLocal;
import cm.louisstark.gestock.sessions.ArticleFacadeLocal;
import cm.louisstark.gestock.sessions.ArticleLivFacadeLocal;
import cm.louisstark.gestock.sessions.ArticleStockFacadeLocal;
import cm.louisstark.gestock.sessions.ArticlesCommandeClientFacadeLocal;
import cm.louisstark.gestock.sessions.CategorieArticleFacadeLocal;
import cm.louisstark.gestock.sessions.ClientFacadeLocal;
import cm.louisstark.gestock.sessions.CommandeClientFacadeLocal;
import cm.louisstark.gestock.sessions.CommandeFacadeLocal;
import cm.louisstark.gestock.sessions.EmployesFacadeLocal;
import cm.louisstark.gestock.sessions.EtagereFacadeLocal;
import cm.louisstark.gestock.sessions.FournisseurFacadeLocal;
import cm.louisstark.gestock.sessions.LivraisonFacadeLocal;
import cm.louisstark.gestock.sessions.MagasinFacadeLocal;
import cm.louisstark.gestock.sessions.MenuFacadeLocal;
import cm.louisstark.gestock.sessions.MouchardFacadeLocal;
import cm.louisstark.gestock.sessions.OperationFacadeLocal;
import cm.louisstark.gestock.sessions.PaysFacadeLocal;
import cm.louisstark.gestock.sessions.PrivilegesutilisateurFacadeLocal;
import cm.louisstark.gestock.sessions.QuartierFacadeLocal;
import cm.louisstark.gestock.sessions.RegionFacadeLocal;
import cm.louisstark.gestock.sessions.RestrictionprivilegeFacadeLocal;
import cm.louisstark.gestock.sessions.RetourArticleLivFacadeLocal;
import cm.louisstark.gestock.sessions.RoleEmployeFacadeLocal;
import cm.louisstark.gestock.sessions.RoleprivilegeFacadeLocal;
import cm.louisstark.gestock.sessions.RoleutilisateurFacadeLocal;
import cm.louisstark.gestock.sessions.SessionFacadeLocal;
import cm.louisstark.gestock.sessions.SocieteFacadeLocal;
import cm.louisstark.gestock.sessions.TypeArticleFacadeLocal;
import cm.louisstark.gestock.sessions.TypeClientFacadeLocal;
import cm.louisstark.gestock.sessions.TypeOperationFacadeLocal;
import cm.louisstark.gestock.sessions.UtilisateurFacadeLocal;
import cm.louisstark.gestock.sessions.VilleFacadeLocal;
import cm.louisstark.gestock.utilitaires.SessionManagerImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.bean.ManagedProperty;
import javax.transaction.UserTransaction;

/**
 *
 * @author Louis Stark
 */
public abstract class SuperController {
    
    protected Properties app_properties;
    
    protected String mode = "";
    
    protected boolean creer = false, modifier = false, details = false, supprimer = false;
    
    @ManagedProperty (value = "#{manageBean}")
    protected SessionManagerImpl sessionManager;
    
    @Resource
    protected UserTransaction ut;
    
    @EJB
    protected MouchardFacadeLocal mouchardFacadeLocal;
    protected List<Mouchard> list_mouchards = new ArrayList<>();
    protected Mouchard mouchard = new Mouchard(0l);
    
    @EJB
    protected AdresseFacadeLocal adresseFacadeLocal;
    protected List<Adresse> list_adresses = new ArrayList<>();
    protected Adresse adresse = new Adresse(0);
       
    @EJB
    protected MenuFacadeLocal menuFacadeLocal;
    protected List<Menu> list_menus = new ArrayList<>();
    protected Menu menu = new Menu(0);
    
    @EJB
    protected PaysFacadeLocal paysFacadeLocal;
    protected List<Pays> list_pays = new ArrayList<>();
    protected Pays pays = new Pays(0);
    
    @EJB
    protected PrivilegesutilisateurFacadeLocal privilegesutilisateurFacadeLocal;
    protected List<Privilegesutilisateur> list_privilegesutilisateurs = new ArrayList<>();
    protected Privilegesutilisateur privilegesutilisateur = new Privilegesutilisateur(0);

    @EJB
    protected QuartierFacadeLocal quartierFacadeLocal;
    protected List<Quartier> list_quartiers = new ArrayList<>();
    protected Quartier quartier = new Quartier(0);
    
    @EJB
    protected RegionFacadeLocal regionFacadeLocal;
    protected List<Region> list_regions = new ArrayList<>();
    protected Region region = new Region(0);
    
    @EJB
    protected RestrictionprivilegeFacadeLocal restrictionprivilegeFacadeLocal;
    protected List<Restrictionprivilege> list_restrictionprivileges = new ArrayList<>();
    protected Restrictionprivilege restrictionprivilege = new Restrictionprivilege(0);
    
    @EJB
    protected RoleprivilegeFacadeLocal roleprivilegeFacadeLocal;
    protected List<Roleprivilege> list_roleprivileges = new ArrayList<>();
    protected Roleprivilege roleprivilege = new Roleprivilege(0);
    
    @EJB
    protected RoleutilisateurFacadeLocal roleutilisateurFacadeLocal;
    protected List<Roleutilisateur> list_roleutilisateurs = new ArrayList<>();
    protected Roleutilisateur roleutilisateur = new Roleutilisateur(0);
    
    @EJB
    protected UtilisateurFacadeLocal utilisateurFacadeLocal;
    protected List<Utilisateur> list_utilisateurs = new ArrayList<>();
    protected Utilisateur utilisateur = new Utilisateur(0);
    
    @EJB
    protected VilleFacadeLocal villeFacadeLocal;
    protected List<Ville> list_villes = new ArrayList<>();
    protected Ville ville = new Ville(0);
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @EJB
    protected AchatArticleFacadeLocal achatArticleFacadeLocal;
    protected List<AchatArticle> list_achatArticles = new ArrayList<>();
    protected AchatArticle achatArticle = new AchatArticle(0l);
    
    @EJB
    protected AchatsFacadeLocal achatsFacadeLocal;
    protected List<Achats> list_achats = new ArrayList<>();
    protected Achats achat = new Achats(0l);
    
    @EJB
    protected ArticleFacadeLocal articleFacadeLocal;
    protected List<Article> list_articles = new ArrayList<>();
    protected Article article = new Article(0l);
    
    @EJB
    protected ArticleCommandeFacadeLocal articleCommandeFacadeLocal;
    protected List<ArticleCommande> list_articlescommande = new ArrayList<>();
    protected ArticleCommande articleCommande = new ArticleCommande(0l);
    
    @EJB
    protected ArticleLivFacadeLocal articleLivFacadeLocal;
    protected List<ArticleLiv> list_articlesLiv = new ArrayList<>();
    protected ArticleLiv articleLiv = new ArticleLiv(0l);
    
    @EJB
    protected ArticleStockFacadeLocal articleStockFacadeLocal;
    protected List<ArticleStock> list_artticlesStock = new ArrayList<>();
    protected ArticleStock articleStock = new ArticleStock(0l);

    @EJB
    protected ArticlesCommandeClientFacadeLocal articlesCommandeClientFacadeLocal;
    protected List<ArticlesCommandeClient> list_articlesCommandeClients = new ArrayList<>();
    protected ArticlesCommandeClient articlesCommandeClient = new ArticlesCommandeClient(0l);
    
    @EJB
    protected CategorieArticleFacadeLocal categorieArticleFacadeLocal;
    protected List<CategorieArticle> list_categoriesArticles = new ArrayList<>();
    protected CategorieArticle categorieArticle = new CategorieArticle(0);
    
    @EJB
    protected ClientFacadeLocal clientFacadeLocal;
    protected List<Client> list_clients = new ArrayList<>();
    protected Client client = new Client(0);
    
    @EJB
    protected CommandeFacadeLocal commandeFacadeLocal;
    protected List<Commande> list_commandes = new ArrayList<>();
    protected Commande commande = new Commande(0);
    
    @EJB
    protected CommandeClientFacadeLocal commandeClientFacadeLocal;
    protected List<CommandeClient> list_commandeClients = new ArrayList<>();
    protected CommandeClient commandeClient = new CommandeClient(0l);
    
    @EJB
    protected EmployesFacadeLocal employesFacadeLocal;
    protected List<Employes> list_employes = new ArrayList<>();
    protected Employes employe = new Employes(0);
    
    @EJB
    protected EtagereFacadeLocal etagereFacadeLocal;
    protected List<Etagere> list_etageres = new ArrayList<>();
    protected Etagere etagere = new Etagere(0);
    
    @EJB
    protected FournisseurFacadeLocal fournisseurFacadeLocal;
    protected List<Fournisseur> list_fournisseurs = new ArrayList<>();
    protected Fournisseur fournisseur = new Fournisseur(0);
    
    @EJB
    protected LivraisonFacadeLocal livraisonFacadeLocal;
    protected List<Livraison> list_livraisons = new ArrayList<>();
    protected Livraison livraison = new Livraison(0);
    
    @EJB
    protected MagasinFacadeLocal magasinFacadeLocal;
    protected List<Magasin> list_magasins = new ArrayList<>();
    protected Magasin magasin = new Magasin(0);
    
    @EJB
    protected OperationFacadeLocal operationFacadeLocal;
    protected List<Operation> list_operations = new ArrayList<>();
    protected Operation operation = new Operation();
    
    @EJB
    protected RetourArticleLivFacadeLocal retourArticleLivFacadeLocal;
    protected List<RetourArticleLiv> list_retourArticleLivs = new ArrayList<>();
    protected RetourArticleLiv retourArticleLiv = new RetourArticleLiv(0);
    
    @EJB
    protected RoleEmployeFacadeLocal roleEmployeFacadeLocal;
    protected List<RoleEmploye> list_roleEmployes = new ArrayList<>();
    protected RoleEmploye roleEmploye = new RoleEmploye(0);
    
    @EJB
    protected SessionFacadeLocal sessionFacadeLocal;
    protected List<Session> list_sessions = new ArrayList<>();
    protected Session session = new Session(0);
    
    @EJB
    protected SocieteFacadeLocal societeFacadeLocal;
    protected List<Societe> list_societe = new ArrayList<>();
    protected Societe societe = new Societe(0);
    
    @EJB
    protected TypeArticleFacadeLocal typeArticleFacadeLocal;
    protected List<TypeArticle> list_typeArticles = new ArrayList<>();
    protected TypeArticle typeArticle = new TypeArticle(0);
    
    @EJB
    protected TypeClientFacadeLocal typeClientFacadeLocal;
    protected List<TypeClient> list_typeClients = new ArrayList<>();
    protected TypeClient typeClient = new TypeClient(0);
    
    @EJB
    protected TypeOperationFacadeLocal typeOperationFacadeLocal;
    protected List<TypeOperation> list_typeOperations = new ArrayList<>();
    protected TypeOperation typeOperation = new TypeOperation(0);
    
    ///////////////////
    /*      Fonctions usuelles           */
    //////////////////////////////////////////  
    
    public abstract void define_create_update_delete_details (Object o);
    
    public void define_list_adresse () {}
    public void define_list_menus () {}
    public void define_list_pays () {}
    public void define_list_privilegesutilisateurs () {}
    public void define_list_quartiers () {}
    public void define_list_regions () {}
    public void define_list_restrictionsprivileges () {}
    public void define_list_roleprivileges () {}
    public void define_list_roleutilisateur () {}
    public void define_list_utilisateurs () {}
    public void define_list_villes () {}
    public void define_list_mouchards () {}
    /////////////////////////////////////////////////////////////////////////////
    public void define_list_achatArticles () {}
    public void define_list_Achats () {}
    public void define_list_Articles() {}
    public void define_list_ArticleCommandes () {}
    public void define_list_ArticlesLiv() {}
    public void define_list_ArticlesStock () {}
    public void define_list_ArticlesCommandeClient () {}
    public void define_list_categoriesArticle () {}
    public void define_list_clients() {}
    public void define_list_commandes () {}
    public void define_list_commandesClient () {}
    public void define_list_Employes () {}
    public void define_list_Etageres () {}
    public void define_list_fournisseurs () {}
    public void define_list_livraisons() {}
    public void define_list_magasins () {}
    public void define_list_operations () {}
    public void define_list_retoursArticleLiv () {}
    public void define_list_roleEmployes () {}
    public void define_list_sessions () {}
    public void define_list_societes () {}
    public void define_list_typeArticles () {}
    public void define_list_typeClients () {}
    public void define_list_typeOperations () {}
    
    // ----------------------------------------------------------------------------------------
    /*      getters and setters            */
    // ------------------------------------------------------------------------------------

    public Properties getApp_properties() {
        return app_properties;
    }

    public List<Adresse> getList_adresses() {
        define_list_adresse();
        return list_adresses;
    }

    public List<Menu> getList_menus() {
        define_list_menus();
        return list_menus;
    }

    public List<Pays> getList_pays() {
        define_list_pays();
        return list_pays;
    }

    public List<Privilegesutilisateur> getList_privilegesutilisateurs() {
        define_list_privilegesutilisateurs();
        return list_privilegesutilisateurs;
    }

    public List<Quartier> getList_quartiers() {
        define_list_quartiers();
        return list_quartiers;
    }

    public List<Region> getList_regions() {
        define_list_regions();
        return list_regions;
    }

    public List<Restrictionprivilege> getList_restrictionprivileges() {
        define_list_restrictionsprivileges();
        return list_restrictionprivileges;
    }

    public List<Roleprivilege> getList_roleprivileges() {
        define_list_roleprivileges();
        return list_roleprivileges;
    }

    public List<Roleutilisateur> getList_roleutilisateurs() {
        define_list_roleutilisateur();
        return list_roleutilisateurs;
    }

    public List<Utilisateur> getList_utilisateurs() {
        define_list_utilisateurs();
        return list_utilisateurs;
    }

    public List<Ville> getList_villes() {
        define_list_villes();
        return list_villes;
    }

    public List<Mouchard> getList_mouchards() {
        define_list_mouchards();
        return list_mouchards;
    }
    
//////////////////////////////

    public List<AchatArticle> getList_achatArticles() {
        define_list_achatArticles();
        return list_achatArticles;
    }

    public List<Achats> getList_achats() {
        define_list_Achats();
        return list_achats;
    }

    public List<Article> getList_articles() {
        define_list_Articles();
        return list_articles;
    }

    public List<ArticleCommande> getList_articlescommande() {
        define_list_ArticleCommandes();
        return list_articlescommande;
    }

    public List<ArticleLiv> getList_articlesLiv() {
        define_list_ArticlesLiv();
        return list_articlesLiv;
    }

    public List<ArticleStock> getList_artticlesStock() {
        define_list_ArticlesStock();
        return list_artticlesStock;
    }

    public List<ArticlesCommandeClient> getList_articlesCommandeClients() {
        define_list_ArticlesCommandeClient();
        return list_articlesCommandeClients;
    }

    public List<CategorieArticle> getList_categoriesArticles() {
        define_list_categoriesArticle();
        return list_categoriesArticles;
    }

    public List<Client> getList_clients() {
        define_list_clients();
        return list_clients;
    }

    public List<Commande> getList_commandes() {
        define_list_commandes();
        return list_commandes;
    }

    public List<CommandeClient> getList_commandeClients() {
        define_list_commandesClient();
        return list_commandeClients;
    }

    public List<Employes> getList_employes() {
        define_list_Employes();
        return list_employes;
    }

    public List<Etagere> getList_etageres() {
        define_list_Etageres();
        return list_etageres;
    }

    public List<Fournisseur> getList_fournisseurs() {
        define_list_fournisseurs();
        return list_fournisseurs;
    }

    public List<Livraison> getList_livraisons() {
        define_list_livraisons();
        return list_livraisons;
    }

    public List<Magasin> getList_magasins() {
        define_list_magasins();
        return list_magasins;
    }

    public List<Operation> getList_operations() {
        define_list_operations();
        return list_operations;
    }

    public List<RetourArticleLiv> getList_retourArticleLivs() {
        define_list_retoursArticleLiv();
        return list_retourArticleLivs;
    }

    public List<RoleEmploye> getList_roleEmployes() {
        define_list_roleEmployes();
        return list_roleEmployes;
    }

    public List<Session> getList_sessions() {
        define_list_sessions();
        return list_sessions;
    }

    public List<Societe> getList_societe() {
        define_list_societes();
        return list_societe;
    }

    public List<TypeArticle> getList_typeArticles() {
        define_list_typeArticles();
        return list_typeArticles;
    }

    public List<TypeClient> getList_typeClients() {
        define_list_typeClients();
        return list_typeClients;
    }

    public List<TypeOperation> getList_typeOperations() {
        define_list_typeOperations();
        return list_typeOperations;
    }
    
    
    
    ///////////////////////////////// Setter et getters -------------------------------------
    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
        define_create_update_delete_details(adresse);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
        define_create_update_delete_details(menu);
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
        define_create_update_delete_details(pays);
    }

    public Privilegesutilisateur getPrivilegesutilisateur() {
        return privilegesutilisateur;
    }

    public void setPrivilegesutilisateur(Privilegesutilisateur privilegesutilisateur) {
        this.privilegesutilisateur = privilegesutilisateur;
        define_create_update_delete_details(privilegesutilisateur);
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
        define_create_update_delete_details(quartier);
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
        define_create_update_delete_details(region);
    }

    public Restrictionprivilege getRestrictionprivilege() {
        return restrictionprivilege;
    }

    public void setRestrictionprivilege(Restrictionprivilege restrictionprivilege) {
        this.restrictionprivilege = restrictionprivilege;
        define_create_update_delete_details(restrictionprivilege);
    }

    public Roleprivilege getRoleprivilege() {
        return roleprivilege;
    }

    public void setRoleprivilege(Roleprivilege roleprivilege) {
        this.roleprivilege = roleprivilege;
        define_create_update_delete_details(roleprivilege);
    }

    public Roleutilisateur getRoleutilisateur() {
        return roleutilisateur;
    }

    public void setRoleutilisateur(Roleutilisateur roleutilisateur) {
        this.roleutilisateur = roleutilisateur;
        define_create_update_delete_details(roleutilisateur);
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        define_create_update_delete_details(utilisateur);
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
        define_create_update_delete_details(ville);
    }

    public void setSessionManager(SessionManagerImpl sessionManager) {
        this.sessionManager = sessionManager;
    }

    public Mouchard getMouchard() {
        return mouchard;
    }

    public void setMouchard(Mouchard mouchard) {
        this.mouchard = mouchard;
        define_create_update_delete_details(mouchard);
    }

    public boolean isCreer() {
        return creer;
    }

    public boolean isModifier() {
        return modifier;
    }

    public boolean isDetails() {
        return details;
    }

    public boolean isSupprimer() {
        return supprimer;
    }

    public String getMode() {
        return mode;
    }
    //////////////////////////////////////////////////////////////////

    public AchatArticle getAchatArticle() {
        return achatArticle;
    }

    public void setAchatArticle(AchatArticle achatArticle) {
        this.achatArticle = achatArticle;
        define_create_update_delete_details(achatArticle);
    }

    public Achats getAchat() {
        return achat;
    }

    public void setAchat(Achats achat) {
        this.achat = achat;
        define_create_update_delete_details(achat);
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
        define_create_update_delete_details(article);
    }

    public ArticleCommande getArticleCommande() {
        return articleCommande;
    }

    public void setArticleCommande(ArticleCommande articleCommande) {
        this.articleCommande = articleCommande;
        define_create_update_delete_details(articleCommande);
    }

    public ArticleLiv getArticleLiv() {
        return articleLiv;
    }

    public void setArticleLiv(ArticleLiv articleLiv) {
        this.articleLiv = articleLiv;
        define_create_update_delete_details(articleLiv);
    }

    public ArticleStock getArticleStock() {
        return articleStock;
    }

    public void setArticleStock(ArticleStock articleStock) {
        this.articleStock = articleStock;
        define_create_update_delete_details(articleStock);
    }

    public ArticlesCommandeClient getArticlesCommandeClient() {
        return articlesCommandeClient;
    }

    public void setArticlesCommandeClient(ArticlesCommandeClient articlesCommandeClient) {
        this.articlesCommandeClient = articlesCommandeClient;
        define_create_update_delete_details(articlesCommandeClient);
    }

    public CategorieArticle getCategorieArticle() {
        return categorieArticle;
    }

    public void setCategorieArticle(CategorieArticle categorieArticle) {
        this.categorieArticle = categorieArticle;
        define_create_update_delete_details(categorieArticle);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
        define_create_update_delete_details(client);
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
        define_create_update_delete_details(commande);
    }

    public CommandeClient getCommandeClient() {
        return commandeClient;
    }

    public void setCommandeClient(CommandeClient commandeClient) {
        this.commandeClient = commandeClient;
        define_create_update_delete_details(commandeClient);
    }

    public Employes getEmploye() {
        return employe;
    }

    public void setEmploye(Employes employe) {
        this.employe = employe;
        define_create_update_delete_details(employe);
    }

    public Etagere getEtagere() {
        return etagere;
    }

    public void setEtagere(Etagere etagere) {
        this.etagere = etagere;
        define_create_update_delete_details(etagere);
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
        define_create_update_delete_details(fournisseur);
    }

    public Livraison getLivraison() {
        return livraison;
    }

    public void setLivraison(Livraison livraison) {
        this.livraison = livraison;
        define_create_update_delete_details(livraison);
    }

    public Magasin getMagasin() {
        return magasin;
    }

    public void setMagasin(Magasin magasin) {
        this.magasin = magasin;
        define_create_update_delete_details(magasin);
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        define_create_update_delete_details(operation);
    }

    public RetourArticleLiv getRetourArticleLiv() {
        return retourArticleLiv;
    }

    public void setRetourArticleLiv(RetourArticleLiv retourArticleLiv) {
        this.retourArticleLiv = retourArticleLiv;
        define_create_update_delete_details(retourArticleLiv);
    }

    public RoleEmploye getRoleEmploye() {
        return roleEmploye;
    }

    public void setRoleEmploye(RoleEmploye roleEmploye) {
        this.roleEmploye = roleEmploye;
        define_create_update_delete_details(roleEmploye);
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
        define_create_update_delete_details(session);
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
        define_create_update_delete_details(societe);
    }

    public TypeArticle getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(TypeArticle typeArticle) {
        this.typeArticle = typeArticle;
        define_create_update_delete_details(typeArticle);
    }

    public TypeClient getTypeClient() {
        return typeClient;
    }

    public void setTypeClient(TypeClient typeClient) {
        this.typeClient = typeClient;
        define_create_update_delete_details(typeClient);
    }

    public TypeOperation getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(TypeOperation typeOperation) {
        this.typeOperation = typeOperation;
        define_create_update_delete_details(typeOperation);
    }
    
    
}
