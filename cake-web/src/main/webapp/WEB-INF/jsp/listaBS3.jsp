<%-- 
    Document   : lista
    Created on : 30/08/2015, 16:05:03
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/jasny-bootstrap.min.css" />
    <link rel="stylesheet" href="resources/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="resources/css/navmenu-reveal.css" />
  </head>
  <body>
    <nav class="navmenu navmenu-default navmenu-fixed-left navmenu-inverse navmenu-left">
      <a class="navmenu-brand" href="#">Project name</a>
      <ul class="nav navmenu-nav">
        <li><a href="../navmenu/">Slide in</a></li>
        <li><a href="../navmenu-push/">Push</a></li>
        <li class="active"><a href="./">Reveal</a></li>
        <li><a href="../navbar-offcanvas/">Off canvas navbar</a></li>
      </ul>
      <ul class="nav navmenu-nav">
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
          <ul class="dropdown-menu navmenu-nav">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Nav header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
    </nav>
    
    <nav class="navmenu navmenu-default navmenu-fixed-right navmenu-inverse navmenu-right">
      <a class="navmenu-brand" href="#">Project name</a>
      <ul class="nav navmenu-nav">
        <li><a href="../navmenu/">Slide in</a></li>
        <li><a href="../navmenu-push/">Push</a></li>
        <li class="active"><a href="./">Reveal</a></li>
        <li><a href="../navbar-offcanvas/">Off canvas navbar</a></li>
      </ul>
      <ul class="nav navmenu-nav">
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
          <ul class="dropdown-menu navmenu-nav">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li class="dropdown-header">Nav header</li>
            <li><a href="#">Separated link</a></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
    </nav>

    <div class="canvas">
      <div class="navbar navbar-default navbar-fixed-top">
        <button type="button" class="navbar-toggle" data-toggle="offcanvas" data-recalc="false" data-target=".navmenu-left" data-canvas=".canvas">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <button type="button" class="navbar-toggle " data-toggle="offcanvas" data-recalc="false" data-target=".navmenu-right" data-canvas=".canvas">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
      </div>

      <div class="container-fluid">
        <div class="page-header">
          <h1>Off Canvas Reveal Menu Template</h1>
        </div>
        <p class="lead">This example demonstrates the use of the offcanvas plugin with a reveal effect.</p>
        <p>On the contrary of the push effect, the menu doesn't move with the canvas.</p>
        <p>You get the reveal effect by wrapping the content in a div and setting the <code>canvas</code> option to target that div.</p>
        <p>Note that in this example, the navmenu doesn't have the <code>offcanvas</code> class, but is placed under the canvas by setting the <code>z-index</code>.</p>
        <p>Also take a look at the examples for a navmenu with <a href="../navmenu">slide in effect</a> and <a href="../navmenu-push">push effect</a>.</p>
      </div><!-- /.container -->
    </div>
    <script src="resources/js/jquery-1.11.3.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jasny-bootstrap.min.js"></script>
  </body>
</html>
