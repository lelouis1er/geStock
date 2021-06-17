/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.filters;

import cm.louisstark.gestock.entities.Utilisateur;
import cm.louisstark.gestock.sessions.MouchardFacadeLocal;
import cm.louisstark.gestock.utilitaires.SessionManager;
import cm.louisstark.gestock.utilitaires.SessionManagerImpl;
import cm.louisstark.gestock.utilitaires.Utilitaires;
import java.io.IOException;
import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.LifecycleFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Louis Stark
 */
@WebFilter(filterName = "filterConnexion", urlPatterns = {"/login.xhtml", "/login.html", "/login", "/connexion"})
public class FiltreConnexion implements Filter {

    @ManagedProperty(value = "#{manageBean}")
    private SessionManagerImpl sessionManager;
    
    @EJB
    private MouchardFacadeLocal mouchardFacadeLocal;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        //recupereation du context
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            FacesContextFactory contextFactory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
            LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
            Lifecycle lifecycle = lifecycleFactory.getLifecycle(lifecycleFactory.DEFAULT_LIFECYCLE);
            context = contextFactory.getFacesContext(session.getServletContext(), request, response, lifecycle);
        }
        ValueExpression ve = context.getApplication().getExpressionFactory().createValueExpression(context.getELContext(), "#{manageBean}", SessionManager.class);
        sessionManager = (SessionManagerImpl) ve.getValue(context.getELContext());

        if (request.getParameter("logout") != null) {
            Utilisateur temp = sessionManager.getSessionUser();
            sessionManager.logout();
            Utilitaires.saveActivity(mouchardFacadeLocal, "Deconnexion de l'urilisateur " + temp.getLogin(), temp);
        }

        if (session.getAttribute("user") != null) {
            if (session.getAttribute("last-page") != null) {
                System.out.println("redirection vers la page précédente");
                res.sendRedirect((String) session.getAttribute("last-page"));
            } else {
                System.out.println("redirection vers la page d'acceuil");
                res.sendRedirect(req.getContextPath() + "/acceuil");
                //request.getRequestDispatcher("/index.xhtml?faces-redirect=true").forward(request, response);
            }
        } else {
            System.out.println("Session non existante Affichage du formulaire de connexion");
            request.getRequestDispatcher("/login.xhtml?faces-redirect=true").forward(request, response);
            //chain.doFilter(request, response);
        }

    }

    @Override
    public void destroy() {
    }

    public void setSessionManager(SessionManagerImpl sessionManager) {
        this.sessionManager = sessionManager;
    }
}
