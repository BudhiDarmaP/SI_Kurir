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
@WebServlet(name = "ControlPemesanan", urlPatterns = {"/ControlPemesanan"})
public class ControlPemesanan extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
        try (PrintWriter out = response.getWriter()) {
            //deklarasi
            Pengiriman p = new Pengiriman();
            String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
            String email = null;
            String password = null;
            //panggil cookies
            email=CookieUtilities.getCookie(request, "email").getValue();
            password=CookieUtilities.getCookie(request, "pass").getValue();
            //panggil pelanggan
            Pelanggan x = Pelanggan.panggilPelanggan(email, password);
            //execption
            if (!request.getParameter("user[jarak]").contains("[0-9]+")) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Format jarak salah!");
                request.setAttribute("info", x.getNama());
                dispatcher = request.getRequestDispatcher("formPemesanan.jsp");
                dispatcher.forward(request, response);
            }else{
            //panggil inputan
            p.setID_pelanggan(x.getID());
            p.setTanggal(timeStamp);
            p.setAsal(request.getParameter("user[asal]"));
            p.setTujuan(request.getParameter("user[tujuan]"));
            p.setJarak(Integer.parseInt(request.getParameter("user[jarak]")));
            p.setBarang(request.getParameter("user[barang]"));
            //biaya
            p.setBiaya(p.Biaya(Double.parseDouble(request.getParameter("user[jarak]"))));
            p.setID(timeStamp + x.getID());
            //cookies
            Cookie Pesanan = new LongLivedCookie("pesanan", p.getID());;
            response.addCookie(Pesanan);
            //simpan pengiriman
            p.tambahPengiriman(p);
            this.tampil(request, response, p.getID());
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("PengirimanApprove.jsp");
        dispatcher.forward(request, response);
    }
}
