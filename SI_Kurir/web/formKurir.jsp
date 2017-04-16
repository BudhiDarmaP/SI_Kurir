<%-- 
    Document   : formKurir
    Created on : Mar 26, 2017, 5:11:48 PM
    Author     : budhidarmap
--%>

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

        <!-- Header -->
        <header id="header">
            <a href="index.jsp"><h1>Kurirmu.id</h1></a>
            <h2>Pendaftaran</h2>
            <%if (request.getAttribute("error") != null) {%>
            <h7><font color="red"><%=request.getAttribute("error")%></font></h7>
            <%}%>
            <p>Pengisian form kurir menggunakan data sebenarnya</p>
        </header>

        <!-- Signup Form -->
        <form id="registation-form" method="post" action="ControlDaftarKurir">
            <div class="textbox">

                <div class="prompt name">
                    <div class="field" data-fieldname="name">
                        <div class="sidetip">
                        </div>
                        <input id="full-name" type="text" autocomplete="off" value="" name="user[name]" maxlength="20" aria-required="true" placeholder="Full name" />
                    </div>
                </div>

                <div class="prompt email">
                    <div class="field" data-fieldname="email">
                        <div class="sidetip">
                        </div>
                        <input id="email" class="email-input" type="text" autocomplete="off" value="" name="user[email]" aria-required="true" placeholder="Email" />
                    </div>
                </div>

                <div class="prompt email">
                    <div class="field" data-fieldname="No Telepon">
                        <div class="sidetip">
                        </div>
                        <input id="telepon" class="email-input" type="text" autocomplete="off" value="" name="user[tlp]" aria-required="true" placeholder="No Telepon" />
                    </div>
                </div>

                <div class="prompt email">
                    <div class="field" data-fieldname="Alamat">
                        <div class="sidetip">
                        </div>
                        <input id="alamat" class="email-input" type="text" autocomplete="off" value="" name="user[address]" aria-required="true" placeholder="Address" />
                    </div>
                </div>

                <div class="prompt password">
                    <div class="field" data-fieldname="password">
                        <div class="sidetip">
                        </div>
                        <input id="password" type="password" value="" name="user[password]" aria-required="true" placeholder="Password" />
                    </div>
                    <div class="score"><span><b class="fill"></b></span></div>
                </div>

                <div class="prompt optin">
                    <label class="t1-label">
                        <input type="checkbox"  name="user[use_cookie_personalization]" value="0"/>
                        <span>Saya dapat bertanggung jawab atas semua data diatas.</span>
                    </label>
                </div>

                <input type="hidden" name="ad_ref" value="">
            </div>

            <div class="doit">
                <div class="sign-up-box">
                    <input class="submit button signup"
                           type="submit"
                           id="submit_button"
                           value="Sign up">
                </div>
            </div>
        </form>

        <!-- Footer -->
        <footer id="footer">
            <ul>Want to send something? <a role="button" href="index.jsp"/>Send</a></ul>, Want to serve? 
            <a role="button" href="kurirLogin.jsp">Login</a>
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