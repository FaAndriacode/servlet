package etu1763.framework.servlet;

import etu1763.framework.Mapping;
import utilPerso.Utilitaire;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Front_Servlet extends HttpServlet {
    HashMap<String, Mapping> mappingUrls;
    
    @Override
    public void init() throws ServletException {
        try {
            this.mappingUrls = Utilitaire.initHashMap();
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
    }

    public void ProcessRequest(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/plain");
        PrintWriter out = res.getWriter();
        out.println("all chemin : "+this.getClass().getName());

        String url = req.getServletPath();
        out.println("URL : "+url);

        List<String> params = Utilitaire.getInfoURL(req);
        out.println("\n\ndecomposition : ");

        for (String s : params) {
            out.println(s);
        }

        out.println("\n\nMappingUrls :");

        for (Map.Entry me : this.mappingUrls.entrySet()) {
            out.println("Key : "+me.getKey()+", Value : "+me.getValue());
        }

        out.println("\n\nL'URL est supportée : "+this.mappingUrls.containsKey(url));

    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ProcessRequest(req, res);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        ProcessRequest(req, res);
    }
}
