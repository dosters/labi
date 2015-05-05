<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="audioplayer.js"></script>
<script>
  <%@include file="js/alertify.min.js"%>
  <%@include file="js/alertify.js"%>
  function addsucces()
  {
    alertify.alert("Music added");
  }
</script>
<style>
  <%@include file="css/alertify.css"%>
  <%@include file="css/style.css"%>
  <%@include file="css/default.css"%>
</style>
<script>
  <%@include file="js/jquery.color-RGBa-patch.js"%>
  <%@include file="js/example.js"%>
  <%@include file="js/jquery-1.9.0.min.js"%>
  <%@include file="js/responsiveslides.min.js"%>
</script>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<style>
  html, body {
    height: 100%;
    width: 100%;
    padding: 0;
    margin: 0;
  }
  #cartTable td {
    vertical-align: middle;
  }
</style>
<html>
<head>
  <title>Music</title>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <link href="css/default.css" rel="stylesheet" type="text/css" media="all" />
  <script src="js/jquery-1.9.0.min.js"></script>
</head>
<c:url var="home" value="/home"/>
<c:url var="userExit" value="/userExit"/>
<div class="wrap">
  <div class="header-bot1">


    <c:choose>
      <c:when test="${users.id==6}">
      </c:when>
      <c:otherwise>
        <div class="search_box">
          <img src="http://dl.waix.ru/900d5cf01.jpg" style="vertical-align:middle">
          <span style="vertical-align: middle;"><a class="h3"><font color="#f0ffff">${users.name} ${users.lastName} </font></a><br/></span>
          <p><a href="${userExit}" style="margin-left: 20px;">Exit</a></p>
        </div>
      </c:otherwise>
    </c:choose>

    <div class="ph-no">

      <form  method="post" action="/search" role="search">
        <textarea style="visibility: hidden" type="text" class="form-control" name="id">${users.id}</textarea>
        <div class="search_box">
          <input type="text" name="textSearch" value="Search" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
          <input type="submit" value="">
        </div>
      </form>
    </div>
    <div class="clear"></div>
  </div>
</div>
<div class="header-bottom">
  <div class="wrap">
    <nav id="menu-wrap">
      <ul id="menu">
        <c:url var="playlistUrl" value="/myPlaylist?id=${users.id}" />
        <c:url var="musicUrl" value="/myMusic?id=${users.id}" />
        <c:url var="allmusicUrl" value="/allMusic?id=${users.id}" />
        <c:url var="allplaylistUrl" value="/allPlaylist?id=${users.id}" />
        <c:url var="allusersUrl" value="/allUsers?id=${users.id}" />
        <li><a href="${home}">Home</a></li>
        <c:choose>
          <c:when test="${users.id==6 || users.id==0}">

          </c:when>
          <c:otherwise>
            <li>
              <a>My </a>
              <ul>
                <li><a href="${musicUrl}">My music</a></li>
                <li><a href="${playlistUrl}">My playlists</a></li>
              </ul>
            </li>
          </c:otherwise>
        </c:choose>

        <li><a href="${allmusicUrl}">All music</a></li>
        <li><a href="${allplaylistUrl}">All playlists</a></li>
        <li><a href="${allusersUrl}">All users</a></li>
      </ul>
    </nav>
  </div>
</div>
<div class="banner">
  <div id="wrapper">
    <script src="js/responsiveslides.min.js"></script>
    <script>
      // You can also use "$(window).load(function() {"
      $(function () {
        // Slideshow 4
        $("#slider4").responsiveSlides({
          auto: true,
          pager: true,
          nav: true,
          speed: 500,
          namespace: "callbacks",
          before: function () {
            $('.events').append("<li>before event fired.</li>");
          },
          after: function () {
            $('.events').append("<li>after event fired.</li>");
          }
        });

      });
    </script>
    <div  id="top" style="margin-left: 150px;" class="callbacks_container">
      <ul class="rslides" id="slider4">
        <li>
          <div class="slider-top">
            <a ><img src="http://rghost.ru/849RCpNQj/image.png" alt="" /></a>
          </div>
      </ul>
    </div>
  </div>
</div>
<div class="main-cont" >
  <div class="main">
    <div class="wrap" style="width: 1700px;margin-left: 400px;">
      <div class="content-top" style="width: 1700px;">
        <div class="col_1_of_3 span_1_of_3" style="width: 1100px;">
          <a >
            <div class="banner_content"><h2 style="margin-left: 400px;">All<span> music</span></h2>
              <table class="table ">
                <thead>
                <tr>
                  <th></th>
                  <th></th>
                  <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="music" items="${musics}">
                  <tr>
                    <c:url var="addMusicAll" value="/addMusicAll?idMusic=${music.id}&idPerson=${users.id}" />
                    <c:url var="alllikeMusic" value="/alllikeMusic?idMusic=${music.id}&idPerson=${users.id}" />
                    <td ><a href=""><span class="glyphicon glyphicon-music"></span></a> <font color="#f0ffff"> ${music.name}</font></td>
                    <td ><audio src="${music.scr}" preload="auto" controls loop></audio></td>
                    <c:choose>
                      <c:when test="${users.id==6 || users.id==0}">
                        <td> <a class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${music.likes}</a> </td>
                      </c:when>
                      <c:otherwise>
                        <td> <a href="${alllikeMusic}" class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${music.likes}</a>  <a href="${addMusicAll}" class="btn-sm" role="button" onclick="addsucces()"><span class="glyphicon glyphicon-plus"/> </a></td>
                      </c:otherwise>
                    </c:choose>

                  </tr>
                </c:forEach>
                </tbody>
              </table>
            </div>
          </a>
        </div>
        <div class="clear"></div>
      </div>

    </div>
    <div class="clear"></div>
  </div>
</div>
</body>
</html>

