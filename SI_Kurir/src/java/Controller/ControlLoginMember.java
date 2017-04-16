/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Pelanggan;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControlLoginMember", urlPatterns = {"/ControlLoginMember"})
public class ControlLoginMember extends HttpServlet {

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
        Cookie cookie = null;
        Pelanggan p = null;
        String email = request.getParameter("member[email]");
        String pass = request.getParameter("member[password]");
        try {
            //Check kelengkapan ID dan password
            if (email.equals("") && pass.equals("")) {
                throw new Exception("Silahkan Isi Form Login!");
            } else if (email.equals("")) {
                throw new Exception("ID Belum Terisi!");
            } else if (pass.equals("")) {
                throw new Exception("Password Belum Terisi!");
            }
        } catch (Exception e) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", e.getMessage());
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        if (isValidEmailAddress(email)) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Format email salah!");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        if (p.cekPelanggan(email) == 0) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Anda belum terdaftar!");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        //Check kelengkapan password pada anggota
        if (p.LoginPelanggan(email, pass) == false) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Password Salah");
            dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        p = Pelanggan.panggilPelanggan(email, pass);
        String pesan = p.getNama();
        //simpan cookie
        Cookie EMAIL = new Cookie("email", email);;
        response.addCookie(EMAIL);
        //cookie id
        Cookie PASS = new Cookie("pass", pass);;
        response.addCookie(PASS);
        //lempar
        this.tampil(request, response, pesan);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[!#$%&'*+/=?^_`{|}-~]+"
                + "@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])"
                + "|(([\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void returnError(HttpServletRequest request, HttpServletResponse response, Exception e) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("error", e.getMessage());
        dispatcher = request.getRequestDispatcher("error.jsp");
        dispatcher.forward(request, response);
    }

    public void tampil(HttpServletRequest request, HttpServletResponse response, String information) throws ServletException, IOException {
        RequestDispatcher dispatcher;
        request.setAttribute("info", information);
        dispatcher = request.getRequestDispatcher("formPemesanan.jsp");
        dispatcher.forward(request, response);
    }
}
