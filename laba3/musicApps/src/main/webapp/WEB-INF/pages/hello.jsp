<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="audioplayer.js"></script>
<style>
    <%@include file="css/alertify.css"%>
    <%@include file="css/alertify.min.css"%>
    <%@include file="css/alertify.rtl.css"%>
    <%@include file="css/alertify.rtl.min.css"%>
</style>
<script>
    <%@include file="js/alertify.min.js"%>
    <%@include file="js/alertify.js"%>
    function addsucces()
    {
        alertify.alert("Music added");
    }
    function prov()
    {
        if(document.form1.name.value==null || document.form1.lastName.value==null)
        {
            return 0;
        }
        else
        {
            return 1;
        }
    }
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
<body background="http://rghost.ru/6gCRD65Tz/image.png"/>
<form style="margin-left: 750px;margin-top: 300px;" action="/addPerson" method="post" th:th:object="${person}" name="form1">
    <h1 style="margin-left: 200px;" ><font color="#deb887">Login</font></h1>
    <label><font color="#deb887">Name: </font></label> <br />
    <div class="input-group input-group-lg">
        <input type="text" class="form-control" placeholder="Name" aria-describedby="sizing-addon1"id="first" name="name" size="50" th:field="*{name}"/>
    </div>
    <br />
    <label><font color="#deb887">LastName:</font> </label> <br />
    <div class="input-group input-group-lg">
        <input type="text" class="form-control" placeholder="LastName" aria-describedby="sizing-addon1"id="second" name="lastName" size="50" th:field="*{lastname}"/>
    </div>
    <br />
    <br />
    <input style="margin-left: 200px;" type="submit" value="Sign in" class="btn btn-default" />
    <br/>
    <br />
    <label><font color="#deb887">Enter from social</font></label> <br />
    <div style="margin-left: 160px;" id="uLogin" data-ulogin="callback=preview;display=panel;fields=first_name,last_name;providers=vkontakte,twitter,facebook;hidden=;redirect_uri="></div>
</form>
        <form style="margin-left: 750px;margin-top: 30px;" action="/WithOutAuth" method="post" name="form2">
            <input style="margin-left: 160px;" type="submit" value="Sign without authorization" class="btn btn-default" />
        </form>

<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.11.2.min.js"></script>
<script src="//ulogin.ru/js/ulogin.js"></script>

<script>
    function preview(token){
        $.getJSON("//ulogin.ru/token.php?host=" +
                encodeURIComponent(location.toString()) + "&token=" + token + "&callback=?",
                function(data){
                    data=$.parseJSON(data.toString());
                    if(!data.error){
                        document.form1.name.value=data.first_name;
                        document.form1.lastName.value=data.last_name;
                        alertify.alert("Hello   "+data.first_name+"   "+data.last_name);

                    }
                });
    }
</script>
</body>
</html>