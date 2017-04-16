<%-- 
    Document   : formPemesanan
    Created on : Mar 26, 2017, 5:34:19 PM
    Author     : budhidarmap
--%>

<%@page import="Model.Pelanggan"%>
<%@page import="Model.Kurir"%>
<%@page import="Model.Pengiriman"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
     String email = null;
        String password = null;
        //panggil cookies
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
                } else {
                    c = null;
                    cookies = null;
                    // Get an array of Cookies associated with this domain
                    cookies = request.getCookies();
                }
            }
        }
        Pelanggan x = Pelanggan.panggilPelanggan(email, password);
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
                <p>Are you sure Logout <%=x.getNama()%>?</p>
            </header>

            <!-- Main -->
            <article id="main">
                <section class="wrapper style5">
                    <div class="inner">
                        <form id="registation-form" method="post" action="ControlLogout">
                            <div class="doit">
                                <div class="sign-up-box">
                                    <input class="submit button signup"
                                           type="submit"
                                           id="submit_button"
                                           value="Logout">
                                </div>
                            </div>
                        </form>
                    </div>
                </section>
            </article>
        </div>

        <!-- Footer -->
        <footer id="footer">
            <ul>Check your package? <a role="button" href="CheckPesanan.jsp"/>Check</a>, Want Send? <a role="button" href="formPemesanan.jsp"/>Send</a></ul>
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