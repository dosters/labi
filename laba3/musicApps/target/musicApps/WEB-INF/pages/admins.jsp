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
    <title>
    </title>
    <table class="table ">
        <thead>
        <tr>
            <th>Name</th>
            <th>Likes</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="playlist" items="${playlists}">
            <tr>
                <c:url var="delPlaylistAdmin" value="/delPlaylistAdmin?idPlaylist=${playlist.id}" />
                <td ><a >${playlist.name}</a> </td>
                <td ><a ><span class="glyphicon glyphicon-heart"/>${playlist.likes}</a> <a href="${delPlaylistAdmin}" class="btn-sm " role="button"><span class="glyphicon glyphicon-remove"/> </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <table class="table ">
        <thead>
        <tr>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody class="emptyMe items" id="block2">
        <c:forEach var="music" items="${musics}">
            <tr class="textBlock">
                <c:url var="delMusicAdmin" value="/delMusicAdmin?idMusic=${music.id}" />
                <td ><a><span class="glyphicon glyphicon-music"> </span></a>${music.name}</td>
                <td ><audio src="${music.scr}" preload="auto" controls loop></audio></td>
                <td> <a class="btn-sm" role="button"><span class="glyphicon glyphicon-heart"/>${music.likes}</a> <a href="${delMusicAdmin}" class="btn-sm " role="button"><span class="glyphicon glyphicon-remove"/> </a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</head>
<body>

</body>
</html>
