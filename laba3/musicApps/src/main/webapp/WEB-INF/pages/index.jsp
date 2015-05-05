<%@ page language="java" contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
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
    <%@include file="js/swfobject.js"%>
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
<c:url var="login" value="/login"/>
<c:url var="playlistUrl" value="/myPlaylist?id=${users.id}" />
<c:url var="musicUrl" value="/myMusic?id=${users.id}" />
<c:url var="allmusicUrl" value="/allMusic?id=${users.id}" />
<c:url var="allplaylistUrl" value="/allPlaylist?id=${users.id}" />
<c:url var="allusersUrl" value="/allUsers?id=${users.id}" />
<div class="wrap">
    <div class="header-bot1">

            <c:choose>
                <c:when test="${users.id==6 || users.id==0}">
                    <div class="search_box">
                        <p><a href="${login}" style="margin-left: 20px;">Sing up</a></p>
                    </div>
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
        <div class="wrap" style="width: 1700px;margin-left: 110px;">
            <div class="content-top" style="width: 1700px;">
                <div class="col_1_of_3 span_1_of_3" style="width: 300px;">
                    <a >
                        <div class="banner_content"><h2 style="margin-left: 10px;">Top<span> users</span></h2>
                            <table class="table ">
                                <thead>
                                <tr>
                                    <th><font color="#f0ffff">Firstname</font></th>
                                    <th><font color="#f0ffff">Lastname</font></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="person" items="${persons}">
                                    <c:url var="personInfo" value="/personInfo?id=${users.id}&personId=${person.id}" />
                                    <tr>
                                        <c:choose>
                                            <c:when test="${users.id==6 || users.id==0}">
                                                <td ><a ><font color="#f0ffff">${person.name}</font></a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td ><a href="${personInfo}">${person.name}</a></td>
                                            </c:otherwise>
                                        </c:choose>

                                        <td ><font color="#f0ffff">${person.lastName}</font></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </a>

                    <div class="clear"></div>
                </div>
                <div class="col_1_of_3 span_1_of_3" style="width: 920px;">
                    <a >
                        <div class="banner_content"><h2 style="margin-left: 300px;">Top<span> music</span></h2>
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
                                        <c:url var="addMusic" value="/addMusic?idMusic=${music.id}&idPerson=${users.id}" />
                                        <c:url var="likeMusic" value="/likeMusic?idMusic=${music.id}&idPerson=${users.id}" />
                                        <td ><a href=""><span class="glyphicon glyphicon-music"> </span></a><font color="#f0ffff"> ${music.name}</font></td>
                                        <td ><audio src="${music.scr}" preload="auto" controls loop></audio></td>
                                        <div class="btn-group-sm">
                                        <c:choose>
                                            <c:when test="${users.id==6 || users.id==0}">
                                                <td> <a class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${music.likes}</a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td> <a href="${likeMusic}" class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${music.likes}</a>  <a href="${addMusic}" class="btn-sm" role="button" onclick="addsucces()"><span class="glyphicon glyphicon-plus"/> </a></td>
                                            </c:otherwise>
                                        </c:choose>
                                        </div>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </a>
                </div>
                <div class="col_1_of_3 span_1_of_3" style="width: 400px;">
                    <a >
                        <div class="banner_content"><h2 style="margin-left: 20px;">Top<span> playlists</span></h2>
                            <table class="table ">
                                <thead>
                                <tr>
                                    <th><font color="#f0ffff">Name</font></th>
                                    <th><font color="#f0ffff">Likes</font></th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="playlist" items="${playlists}">
                                    <tr>
                                        <c:url var="likePlaylist" value="/likePlaylist?idPlaylist=${playlist.id}&idPerson=${users.id}" />
                                        <c:url var="playlistMusicIndex" value="/playlistMusicIndex?id=${users.id}&idPlaylist=${playlist.id}&idPerson=${users.id}" />
                                        <c:choose>
                                            <c:when test="${users.id==6 || users.id==0}">
                                                <td ><a ><font color="#f0ffff">${playlist.name}</font></a></td>
                                                <td> <a class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${playlist.likes}</a></td>
                                            </c:when>
                                            <c:otherwise>
                                                <td ><a href="${playlistMusicIndex}">${playlist.name}</a></td>
                                                <td> <a href="${likePlaylist}" class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${playlist.likes}</a></td>
                                            </c:otherwise>
                                        </c:choose>

                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </a>
                </div>
                <c:choose>
                    <c:when test="${users.id==6}">
                    </c:when>
                    <c:otherwise>
                        <div align="center">
                            <div id="cloud_block" style="text-align:center;font-size:12pt;">
                                Для отображения блока требуется <a href="https://get.adobe.com/flashplayer/?loc=ru" target="_blank" title="Скачать Flash Player 10 бесплатно">Flash Player 10</a><br><br>
                            </div>
                            <script type="text/javascript">
                                var rnumber = Math.floor(Math.random()*9999999);
                                var so = new SWFObject("http://my-files.ru/Download/tuqtvr/tagcloud.swf?r="+rnumber, "tagcloudflash", "500", "350", "9");
                                so.addParam("wmode", "transparent");
                                so.addParam("allowScriptAccess", "always");
                                so.addParam("bgcolor", "#FF0000");
                                so.addVariable("tspeed", "100");
                                so.addVariable("distr", "true");
                                so.addVariable("mode", "tags");
                                so.addVariable("minFontSize", "1");
                                so.addVariable("maxFontSize", "2");
                                so.addVariable("tcolor", "0x008B8B");
                                so.addVariable("tcolor2", "0x009CFF");
                                so.addVariable("hicolor", "0xDC143C");
                                so.addVariable("tagcloud", "<tags><a href='${musicUrl}' style='font-size:18pt;'>My music</a>" +
                                "<a href='${playlistUrl}' style='font-size:18pt;'>My playlists</a>" +
                                "<a href='${allmusicUrl}' style='font-size:18pt;'>All music</a>" +
                                "<a href='${allusersUrl}' style='font-size:18pt;'>All users</a>" +
                                "<a href='${allplaylistUrl}' style='font-size:18pt;'>All playlists</a>" +
                                "<a href='${home}' style='font-size:18pt;'>Home</a>"+
                                "<a href='${home}' style='font-size:18pt;'>Top music</a>"+
                                "<a href='${home}' style='font-size:18pt;'>Top playlists</a>"+
                                "<a href='${home}' style='font-size:18pt;'>Top users</a></tags>");
                                so.write("cloud_block");
                            </script>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div class="clear"></div>
            </div>
        </div>
        <div class="clear"></div>

    </div>

</div>

</body>
</html>

