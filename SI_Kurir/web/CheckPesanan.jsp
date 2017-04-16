<%-- 
    Document   : formPemesanan
    Created on : Mar 26, 2017, 5:34:19 PM
    Author     : budhidarmap
--%>

<%@page import="Model.Pelanggan"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="Model.Pengiriman"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        //deklarasi string
        String email = null;
        String password = null;
        //Panggil Cookies
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie c = cookies[i];
                //cek nilai
                if (c.getName().equals("email")) {
                    email = c.getValue();
                }
                if (c.getName().equals("pass")) {
                    password = c.getValue();
                }
            }
        }
            //set attribute
            Pelanggan x = Pelanggan.panggilPelanggan(email, password);
            request.setAttribute("info", x.getNama());
            Pengiriman p = Pengiriman.panggilPemesanan(x.getID(),timeStamp);
    %>
    <head>
        <title>Kurirmu.id</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
        <!--[if lte IE 8]><script src="assets/js/ie/html5shiv.js"></script><![endif]-->
        <link rel="stylesheet" href="assets/css/main.css" />
        <!--[if lte IE 8]><link rel="stylesheet" href="assets/css/ie8.css" /><![endif]-->
        <!--[if lte IE 9]><link rel="stylesheet" href="assets/css/ie9.css" /><![endif]-->
    </head>
    <body>

        <!-- Page Wrapper -->
        <div id="page-wrapper">

            <!-- Header -->
            <header id="header">
                <h1>Kurirmu.id</h1>
                <p>Welcome <%= request.getAttribute("info")%></p>
            </header>

            <!-- Main -->
            <article id="main">
                <section class="wrapper style5">
                    <div class="inner">
                        <h3>Pesanan Anda:</h3>
                        <%if (p.getID()!=null) {%>
                        <table id="customers" >
                            <tr>
                                <th>
                                    <b>ID</b>
                                </th>
                                <th>
                                    <b>Asal</b>
                                </th>
                                <th>
                                    <b>Tujuan</b>
                                </th>
                                <th>
                                    <b>Barang</b>
                                </th>
                                <th>
                                    <b>Jarak</b>
                                </th>
                                <th>
                                    <b>Biaya</b>
                                </th>
                                <th>
                                    <b>Status</b>
                                </th>
                            </tr>
                            <tr>
                                <td>
                                    <input type="text" value="<%= p.getID()%>" disabled/>        
                                </td>
                                <td>
                                    <input type="text" value="<%= p.getAsal()%>" disabled/>
                                </td>
                                <td>
                                    <input type="text" value="<%= p.getTujuan()%>" disabled/>
                                </td>
                                <td>
                                    <input type="text" value="<%= p.getBarang()%>" disabled/>
                                </td>
                                <td>
                                    <input type="text" value="<%= p.getJarak()%>" disabled/>
                                </td>
                                <td>
                                    <input type="text" value="<%= p.getBiaya()%>" disabled/>
                                </td>
                                <td>
                                    <% if (p.isStatus()==false) {%>
                                    <input type="text" value="Menunggu Kurir" disabled/>
                                    <%}%>
                                </td>
                            </tr>
                            <%}else{%>
                            <p>Pesanan Anda Sedang Dikerjakan atau Pesanan Anda Kosong</p>        
                            <%}%>
                        </table>
                    </div>
                </section>
            </article>
        </div>

        <!-- Footer -->
        <footer id="footer">
            <ul class="icon">Send your package? <a role="button" href="#"/>Send</a>, Want Logout? <a role="button" href="PelangganLogout.jsp"/>Logout</a></ul>
            <ul class="icons">
                <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                <li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
                <li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
            </ul>
            <ul class="copyright">
                <li>&copy; Sanata Dharma University.</li><li>Credits: <a href="http://budhidarmap.github.io">@budhidarmap</a></li>
            </ul>
        </footer>

        <!-- Scripts -->
        <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
        <script src="assets/js/main.js"></script>

    </body>
</html>