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
            Pengiriman p = new Pengiriman();
            String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
            //membuat data
            p.setID_pelanggan(request.getParameter("user[id]"));
            p.setID_kurir(request.getParameter(null));
            p.setTanggal(timeStamp);
            p.setAsal(request.getParameter("user[asal]"));
            p.setTujuan(request.getParameter("user[tujuan]"));
            p.setJarak(Integer.parseInt(request.getParameter("user[jarak]")));
            p.setBarang(request.getParameter("user[barang]"));
            //biaya
            p.setBiaya(p.Biaya(Double.parseDouble(request.getParameter("user[jarak]"))));
            //menyimpan data
            this.tampil(request, response, " <table id='customers'>"
                    + "<tr><td>Tanggal<input type='text' name='user[tgl]' value='"+p.getTanggal()+"' />"
                    + "<tr><td>Asal<input type='text' name='user[asal]' value='"+p.getAsal()+"' />"
                    + "<tr><td>Tujuan<input type='text' name='user[tujuan]' value='"+p.getTujuan()+"' />"
                    + "<tr><td>Jarak<input type='text' name='user[jarak]' value='"+p.getJarak()+"' />"
                    + "<tr><td>Barang<input type='text' name='user[barang]' value='"+p.getBarang()+"' />"
                    + "<tr><td>Biaya<input type='text' name='user[biaya]' value='"+p.getBiaya()+"' />"
                    + "</table>");
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