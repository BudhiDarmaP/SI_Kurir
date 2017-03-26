/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pelanggan;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author budhidarmap
 */
@WebServlet(name = "ControlDaftarKurir", urlPatterns = {"/ControlDaftarKurir"})
public class ControlDaftarKurir extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Pelanggan p = new Pelanggan();
            String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
            String number ="000";
            int count=p.panggilID(timeStamp)+1;
            //generate ID
            if (count<10) {
                number="00"+String.valueOf(count);
            }
            else if (count<100) {
                number="0"+String.valueOf(count);
            }
            else{
                number=String.valueOf(count);
            }
            //membuat data
            p.setID(timeStamp+number);
            p.setNama(request.getParameter("user[name]"));
            p.setEmail(request.getParameter("user[email]"));
            p.setNo_tlp(request.getParameter("user[tlp]"));
            p.setAlamat(request.getParameter("user[address]"));
            p.setPassword(request.getParameter("user[password]"));
            //menyimpan data
            Pelanggan.tambahMember(p);
            this.tampil(request, response, "PENDAFTARAN KURIR SUKSES");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("info.jsp");
        dispatcher.forward(request, response);
    }
}