<%-- 
    Document   : formPemesanan
    Created on : Mar 26, 2017, 5:34:19 PM
    Author     : budhidarmap
--%>

<%@page import="Model.Pengiriman"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <h1>Kurirmu.id</h1>
                <p>Welcome <%= request.getAttribute("info")%></p>
            </header>

            <!-- Main -->
            <article id="main">
                <section class="wrapper style5">
                    <div class="inner">
                        <form id="registation-form" method="post" action="ControlPemesanan">
                            <div class="textbox">
                                <div class="prompt asal">
                                    <div class="field" data-fieldname="Asal">
                                        <input id="full-name" type="text" autocomplete="off" value="" name="user[asal]" maxlength="20" aria-required="true" placeholder="Asal" />
                                    </div>
                                </div>

                                <div class="prompt tujuan">
                                    <div class="field" data-fieldname="Tujuan">
                                        <input id="email" class="email-input" type="text" autocomplete="off" value="" name="user[tujuan]" aria-required="true" placeholder="Tujuan" />
                                    </div>
                                </div>

                                <div class="prompt jarak">
                                    <div class="field" data-fieldname="Jarak">
                                        <input id="telepon" class="email-input" type="text" autocomplete="off" value="" name="user[jarak]" aria-required="true" placeholder="Jarak(Km)" />
                                    </div>
                                </div>
                                <div class="prompt barang">
                                    <div class="field" data-fieldname="Barang">
                                        <input id="alamat" class="email-input" type="text" autocomplete="off" value="" name="user[barang]" aria-required="true" placeholder="Jenis Barang" />
                                    </div>
                                </div>
                                <div class="score"><span><b class="fill">
                                        </b></span></div>
                            </div>
                            <input type="hidden" name="ad_ref" value="">
                            <div class="doit">
                                <div class="sign-up-box">
                                    <input class="submit button asal"
                                           type="submit"
                                           id="submit_button"
                                           value="Pesan">
                                    <input class="submit button reset"
                                           type="reset"
                                           id="submit_button"
                                           value="Reset">
                                </div>
                            </div>
                            <%if (request.getAttribute("error") != null) {%>
                            <h7><font color="red"><%=request.getAttribute("error")%></font></h7>
                                <%}%>
                        </form>
                    </div>
                </section>
            </article>
        </div>

        <!-- Footer -->
        <footer id="footer">
            <ul>Check your package? <a role="button" href="CheckPesanan.jsp"/>CHECK</a>, Want Logout? <a role="button" href="PelangganLogout.jsp"/>LOGOUT</a></ul>
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