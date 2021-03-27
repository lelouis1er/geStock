/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.filters;

import cm.louisstark.gestock.utilitaires.SessionManager;
import cm.louisstark.gestock.utilitaires.SessionManagerImpl;
import java.io.IOException;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.FactoryFinder;
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
@WebFilter(filterName = "filterUser",
        urlPatterns = {
            "/parametres/securite/*",
            "/parametres/appliation/*",
            "/entreprise/*"
        })
public class FilterUser implements Filter {

    private SessionManager sessionManager;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();

        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {
            FacesContextFactory factory = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
            LifecycleFactory lifecycleFactory = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
            Lifecycle lifecycle = lifecycleFactory.getLifecycle(lifecycleFactory.DEFAULT_LIFECYCLE);
            facesContext = factory.getFacesContext(session.getServletContext(), request, response, lifecycle);
        }
        ValueExpression ve = facesContext.getApplication()
                .getExpressionFactory()
                .createValueExpression(facesContext.getELContext(), "#{manageBean}", SessionManagerImpl.class);
        sessionManager = (SessionManager) ve.getValue(facesContext.getELContext());

        if (sessionManager.is_employee()) {
            req.getRequestDispatcher("/WEB-INF/template/401.xhtml?faces-redirect=true").forward(request, response);
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
