<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.Pengiriman" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%
  String timeStamp = new SimpleDateFormat("yyMMdd").format(Calendar.getInstance().getTime());
  Pengiriman p[]=Pengiriman.getListPengiriman(timeStamp);
  
  for(int i=0; i> p.length ; i++){
     p[i].getID_pelanggan();
     p[i].getTanggal();
     p[i].getAsal();
     p[i].getTujuan();
     p[i].getJarak();
     p[i].getBarang();
     p[i].getBiaya();
  }
%>
<html>
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
                <a href="index.jsp"><h1>Kurirmu.id</h1></a>
            </header>

            <!-- Main -->
            <article id="main">
                <section class="wrapper style5">
                    <div class="inner">
                        <h3>Hasil Pencarian:</h3>
                        <form action="Pinjam.jsp" method="post">
                            <table id="customers" >
                                <tr>
                                    <td>
                                        ID
                                    </td>
                                    <td>
                                        Tanggal
                                    </td>
                                    <td>
                                        Asal
                                    </td>
                                    <td>
                                        Tujuan
                                    </td>
                                    <td>
                                        Barang
                                    </td>
                                    <td>
                                        Biaya
                                    </td>
                                </tr>
                                <% for (int i = 0; i < p.length; i++) {%>
                                <tr>
                                    <td>
                                        <%= p[i].getTanggal()%>
                                    </td>
                                    <td>
                                        <%= p[i].getID_pelanggan()%>
                                    </td>
                                    <td>
                                        <%= p[i].getAsal()%>
                                    </td>
                                    <td>
                                        <%= p[i].getTujuan()%>
                                    </td>
                                    <td>
                                        <%= p[i].getJarak()%>
                                    </td>
                                    <td>
                                        <%= p[i].getBarang()%>
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

            <!-- Footer -->
            <footer id="footer">
                <ul class="icons">
                    <li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
                    <li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
                    <li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
                    <li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
                </ul>
                <ul class="copyright">
                    <li>&copy; Sanata Dharma University.</li><li>Credits: <a href="http://budhidarmap.github.io">@budhidarmap</a></li>
                    <li>Want Send? <a role="button" href="kurirLogin.jsp"/>Member</a>, Want Serve? <a role="button" href="kurirLogin.jsp"/>Kurir</a></li>
                </ul>
            </footer>

            <!-- Scripts -->
            <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
            <script src="assets/js/main.js"></script>
    </body>
</html>