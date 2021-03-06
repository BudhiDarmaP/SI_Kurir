<%-- 
    Document   : kurirLogin
    Created on : Mar 26, 2017, 5:13:16 PM
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
            <p>Serve to send something valuable for help the other,
                with us bring happiness to around world.</p>
        </header>

        <!-- Signup Form -->
        <form id="signin-form" method="post" action="ControlLoginKurir">
            <table>
                <tr><td><input type="email" name="email" id="email" placeholder="Email Address" />
                <tr><td><input type="password" name="password" id="password" placeholder="Password" />
                        <% if (request.getAttribute("error") != null) {%>
                <tr><td><font color="red"><%= request.getAttribute("error")%></font>
                        <%}%>
                <tr><td><input type="submit" value="Sign In" />
            </table>
        </form>
        <p>Don't have any account? <a role="button" href="formKurir.jsp"/>Sign Up</a>.</p>

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
            <li>Want to send anything? <a role="button" href="index.jsp"/>Login</a> or <a role="button" href="formPelanggan.jsp"/>Daftar</a></li>
        </ul>
    </footer>

    <!-- Scripts -->
    <!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
    <script src="assets/js/main.js"></script>

</body>
</html>