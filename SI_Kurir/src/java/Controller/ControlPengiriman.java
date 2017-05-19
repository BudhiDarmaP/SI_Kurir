package Controller;

import Model.Kurir;
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
 * @author budhidarmap
 */
@WebServlet(name = "ControlPengiriman", urlPatterns = {"/ControlPengiriman"})
public class ControlPengiriman extends HttpServlet {

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
        //deklarasi
        String pesanan=request.getParameter("id");
        String email=null;
        String password=null;
        Pengiriman p =Pengiriman.panggilPesanan(pesanan);
        //panggil cookies
        email = CookieUtilities.getCookie(request, "email").getValue();
        password = CookieUtilities.getCookie(request, "pass").getValue();
        //panggil inputan
        Kurir x = Kurir.panggilKurir(email, password);
        String pesan=
                    "<form action=listPemesanan.jsp><table>\n" +
                    "<td>ID\n <td>:"+p.getID()+
                    "<tr><td>Asal\n <td>:"+p.getAsal()+
                    "<tr><td>Tujuan\n <td>:"+p.getTujuan()+
                    "<tr><td>Jarak\n <td>:"+p.getJarak()+
                    "<tr><td>Barang\n <td>:"+p.getBarang()+
                    "<tr><td>Biaya:\n <td>:"+p.getBiaya()+
                    "</table>"
                    + "<input type=\"submit\" value=\"Home\"></form>";
        p.setID_kurir(x.getID());
        p.ubahStatus(p);
        this.tampil(request, response, "Your duty to serve this"+pesan);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("info_kurir.jsp");
        dispatcher.forward(request, response);
    }
}
