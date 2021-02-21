/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.filters;

import cm.louisstark.gestock.utilitaires.SessionManager;
import cm.louisstark.gestock.utilitaires.SessionManagerImpl;
import java.io.IOException;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
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
@WebFilter(filterName = "filterApp", urlPatterns = {"/parametres/*"})
public class FilterApp implements Filter {

    @ManagedProperty (value = "manageBean") 
    private SessionManagerImpl sessionManager;
    
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
        
        if (req.getParameter("logout") != null) {
            sessionManager.logout();
        }

        if (session.getAttribute("user") != null) {
            if (sessionManager.user_have_access()) {
                chain.doFilter(request, response);
            } else {
                request.getRequestDispatcher("/WEB-INF/template/401.xhtml?faces-redirect=true").forward(request, response);
            }
        } else {
            //request.getRequestDispatcher("/connexion.xhtml?faces-redirect=true").forward(request, response);
            session.setAttribute("last-page", req.getRequestURI());
            res.sendRedirect(req.getContextPath() + "/login");
        }

    }

    @Override
    public void destroy() {
    }

    public void setSessionManager(SessionManagerImpl sessionManager) {
        this.sessionManager = sessionManager;
    }

}
