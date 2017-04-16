<%-- 
    Document   : formPemesanan
    Created on : Mar 26, 2017, 5:34:19 PM
    Author     : budhidarmap
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="Model.Pengiriman"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        String timeStamp = new SimpleDateFormat("ddMMyyyy").format(Calendar.getInstance().getTime());
        Pengiriman p[] = Pengiriman.getListPengiriman(timeStamp);
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
                        <h3>Daftar Pemesanan:</h3>
                        <p>Klik Kode ID untuk mengambil pengantaran</p>
                        <form action="ControlPengiriman" method="post">
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
                                </tr>
                                <%for (int i = 0; i < p.length; i++) {%>
                                <tr>
                                    <td><input type="submit" name="id"
                                               value="<%= p[i].getID()%>" 
                                               height="0.75em"/>
                                    </td>
                                    <td>
                                        <%= p[i].getAsal()%>
                                    </td>
                                    <td>
                                        <%= p[i].getTujuan()%>
                                    </td>
                                    <td>
                                        <%= p[i].getBarang()%>
                                    </td>
                                    <td>
                                        <%= p[i].getJarak()%>
                                    </td>
                                    <td>
                                        <%= p[i].getBiaya()%>
                                    </td>
                                </tr>
                                <%}%>
                            </table>
                        </form>
                    </div>
                </section>
            </article>
        </div>

        <!-- Footer -->
        <footer id="footer">
            <ul>Want Logout? <a role="button" href="PelangganLogout.jsp"/>LOGOUT</a></ul>
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