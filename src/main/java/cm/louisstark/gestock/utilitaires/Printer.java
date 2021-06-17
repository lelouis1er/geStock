/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm.louisstark.gestock.utilitaires;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author Louis Stark
 */
public final class Printer {

    protected JasperPrint jasperPrint;

    protected final String db_user = "postgres";
    protected final String db_user_pass = "batrapi";
    protected final String port = "5432";
    protected final String db_name = "gestock_db";
    protected String url_server = "jdbc:postgresql://localhost:" + port + "/" + db_name;

    protected final String driver = "org.postgresql.Driver";
    protected Connection conn;

    public Printer() {
    }

    public void export_pdf(String jasper_path, Map params, String exported_file_name) throws Exception {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url_server, db_user, db_user_pass);
            String jasperreportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasper_path);

            params.put("REPORT_LOCALE", FacesContext.getCurrentInstance().getViewRoot().getLocale());

            jasperPrint = JasperFillManager.fillReport(jasperreportPath, params, conn);

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.addHeader("Content-disposition", "attachment; filename=" + exported_file_name + ".pdf");
            ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);

            FacesContext.getCurrentInstance().responseComplete();
        } catch (IOException | ClassNotFoundException | SQLException | JRException e) {
            throw e;
        }
    }

    public void export_xlsx(String jasper_path, Map params, String exported_file_name) throws Exception {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url_server, db_user, db_user_pass);
            String jasperreportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath(jasper_path);

            jasperPrint = JasperFillManager.fillReport(jasperreportPath, params, conn);
            JRXlsExporter xlsxExporter = new JRXlsExporter();

            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.reset();
            httpServletResponse.addHeader("Content-disposition", "inline; filename=" + exported_file_name + ".xlsx");
            
            xlsxExporter.exportReport();
            conn.close();

        } catch (ClassNotFoundException | SQLException | JRException e) {
            throw e;
        }
    }

}
