package com.lbb.servlet.start;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 开始
 *
 * @author Kevin
 * @create 2018-01-17 2:21
 */

public class StartServlet extends HttpServlet{

    private static final long serialVersionUID = -4724888703643052018L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder(32);
        while (req.getHeaderNames().hasMoreElements()){
            sb.append(req.getHeaderNames().nextElement());
        }
        String p1 = req.getParameter("lbb");
        PrintWriter pw = new PrintWriter(resp.getOutputStream());
        pw.append(p1);
        pw.append("--");
        pw.append(sb.toString());
        pw.println();
        pw.close();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String protocol = req.getProtocol();
        System.out.println(protocol);
        this.doGet(req,resp);
    }

}
