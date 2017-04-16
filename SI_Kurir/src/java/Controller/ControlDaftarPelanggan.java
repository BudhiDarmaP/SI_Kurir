/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pelanggan;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Math.random;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.regex.Pattern;
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
@WebServlet(name = "ControlDaftarPelanggan", urlPatterns = {"/ControlDaftarPelanggan"})
public class ControlDaftarPelanggan extends HttpServlet {

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
            String number = "000";
            int count = p.panggilID(timeStamp) + 1;
            //generate ID
            if (count < 10) {
                number = "00" + String.valueOf(count);
            } else if (count < 100) {
                number = "0" + String.valueOf(count);
            } else {
                number = String.valueOf(count);
            }
            //membuat data
            p.setID(timeStamp + number);
            p.setNama(request.getParameter("user[name]"));
            p.setEmail(request.getParameter("user[email]"));
            p.setNo_tlp(request.getParameter("user[tlp]"));
            p.setAlamat(request.getParameter("user[address]"));
            p.setPassword(request.getParameter("user[pass]"));
            //exception
            try {
                //Check kelengkapan inputan
                if (request.getParameter("user[name]").equals("")) {
                    throw new Exception("Nama Belum Terisi!");
                } else if (request.getParameter("user[email]").equals("")) {
                    throw new Exception("Email Belum Terisi!");
                } else if (request.getParameter("user[tlp]").equals("")) {
                    throw new Exception("Nomor Telepon Belum Terisi!");
                } else if (request.getParameter("user[address]").equals("")) {
                    throw new Exception("Alamat Belum Terisi!");
                } else if (request.getParameter("user[pass]").equals("")) {
                    throw new Exception("Password Belum Terisi!");
                }
            } catch (Exception e) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", e.getMessage());
                dispatcher = request.getRequestDispatcher("formPelanggan.jsp");
                dispatcher.forward(request, response);
            }
            if (!Pattern.matches("[a-zA-Z]+", p.getNama())) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Format nama salah!");
                dispatcher = request.getRequestDispatcher("formPelanggan.jsp");
                dispatcher.forward(request, response);
            }
            if (isValidEmailAddress(p.getEmail())) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Format email salah!");
                dispatcher = request.getRequestDispatcher("formPelanggan.jsp");
                dispatcher.forward(request, response);
            }
            if (!p.getNo_tlp().contains("[0-9]+")&&p.getNo_tlp().length()<11||p.getNo_tlp().length()>13) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Format Nomor Telepon salah!");
                dispatcher = request.getRequestDispatcher("formPelanggan.jsp");
                dispatcher.forward(request, response);
            }
            if (p.cekPelanggan(p.getEmail()) == 1) {
                RequestDispatcher dispatcher;
                request.setAttribute("error", "Email anda sudah terdaftar!");
                dispatcher = request.getRequestDispatcher("formPelanggan.jsp");
                dispatcher.forward(request, response);
            }
            //menyimpan data
            Pelanggan.tambahMember(p);
            this.tampil(request, response, "PENDAFTARAN MEMBER SUKSES");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("infoNoLogin.jsp");
        dispatcher.forward(request, response);
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[!#$%&'*+/=?^_`{|}-~]+"
                + "@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])"
                + "|(([\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
