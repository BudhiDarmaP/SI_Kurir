/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pengiriman;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControlSimpanPesanan", urlPatterns = {"/ControlSimpanPesanan"})
public class ControlSimpanPesanan extends HttpServlet {
    
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
            Pengiriman p = new Pengiriman();
            //membuat data
            p.setID_pelanggan(request.getParameter("user[id]"));
            p.setID_kurir(request.getParameter(null));
            p.setTanggal(request.getParameter("user[tgl]"));
            p.setAsal(request.getParameter("user[asal]"));
            p.setTujuan(request.getParameter("user[tujuan]"));
            p.setJarak(Integer.parseInt(request.getParameter("user[jarak]").substring(1)));
            p.setBarang(request.getParameter("user[barang]"));
            //biaya
            p.Biaya(Double.parseDouble(request.getParameter("user[jarak]")));
            //menyimpan data
            p.tambahPengiriman(p);
            this.tampil(request, response, "Pesanan telah diterbitkan");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("info.jsp");
        dispatcher.forward(request, response);
    }
}
