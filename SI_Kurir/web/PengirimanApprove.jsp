<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="Model.Pengiriman"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <%
        //deklasrasi
        String timeStamp = new SimpleDateFormat("dd-MMM-yyyy | hh:mm").format(Calendar.getInstance().getTime());
        String id = String.valueOf(request.getAttribute("info"));
        Pengiriman p = Pengiriman.panggilPesanan(id);
        //cek
        if (p == null) {
            RequestDispatcher dispatcher;
            request.setAttribute("error", "Data tidak ditemukan");
            dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request, response);
        }
    %>
    <head>
        <title>Konfirmasi</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
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
                        <h2>Konfirmasi Pengiriman</h2>
                        <form action="ControlSimpanPesanan" method="post">
                            <table>
                                <td>Tanggal:
                                <tr><td><input type="text" value="<%= timeStamp%>" disabled/>
                                <tr><td>Asal:
                                <tr><td><input type="text" value="<%= p.getAsal()%>" disabled>
                                <tr><td>Tujuan:
                                <tr><td><input type="text" value="<%= p.getTujuan()%>" disabled>
                                <tr><td>Jarak:
                                <tr><td><input type="text" value="<%= p.getJarak()%> Km" disabled>
                                <tr><td>Barang:
                                <tr><td><input type="text" value="<%= p.getBarang()%>" disabled>
                                <tr><td>Biaya:
                                <tr><td><input type="text" value="Rp.<%= p.getBiaya()%>0" disabled>
                            </table>
                            <input type="submit" value="Konfirmasi" name="tombol"/>
                            <input type="submit" value="Batal" name="tombol" />
                        </form>
                    </div>
                </section>
        </div>

        <!-- Footer -->
        <footer id="footer">
            <ul>Want Check? <a role="button" href="CheckPesanan.jsp"/>Member</a>, Want Logout? <a role="button" href="PelangganLogout.jsp.jsp"/>Logout</a></ul>
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