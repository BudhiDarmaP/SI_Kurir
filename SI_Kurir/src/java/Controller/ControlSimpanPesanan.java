/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pelanggan;
import Model.Pengiriman;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
        //deklarasi string
        String email = null;
        String password = null;
        String id = null;
        String timeStamp = new SimpleDateFormat("dd-MMM-yyyy hh:mm").format(Calendar.getInstance().getTime());
        //Panggil Cookies
        email = CookieUtilities.getCookie(request, "email").getValue();
        password = CookieUtilities.getCookie(request, "pass").getValue();
        id = CookieUtilities.getCookie(request, "pesanan").getValue();
        //deklarasi model
        Pelanggan x = Pelanggan.panggilPelanggan(email, password);
        Pengiriman p = Pengiriman.panggilPesanan(id);
        x.getID();
        p.getID();
        //keputusan data
        if (request.getParameter("tombol") == "Batal") {
            p.hapusPengiriman(p.getID(), x.getID());
            this.rollBack(request, response, x.getNama());
        } else {
            String pesan
                    = "<form action=formPemesanan.jsp><table>\n"
                    + "<td>ID\n <td>:" + p.getID()
                    + "<tr><td>Tanggal\n <td>:" + timeStamp
                    + "<tr><td>Asal\n <td>:" + p.getAsal()
                    + "<tr><td>Tujuan\n <td>:" + p.getTujuan()
                    + "<tr><td>Jarak\n <td>:" + p.getJarak()
                    + "<tr><td>Barang\n <td>:" + p.getBarang()
                    + "<tr><td>Biaya:\n <td>:" + p.getBiaya()
                    + "</table>"
                    + "<input type=\"submit\" value=\"Home\"></form>";
            this.tampil(request, response, "<p>Pesanan telah diterbitkan</p>" + pesan, x.getNama());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information, String nama) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        request.setAttribute("nama", nama);
        dispatcher = request.getRequestDispatcher("info.jsp");
        dispatcher.forward(request, response);
    }

    public void rollBack(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("formPemesanan.jsp");
        dispatcher.forward(request, response);
    }
}
