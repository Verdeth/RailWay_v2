<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="to.TrainList"%>
<%@ page import="to.TrainData"%>
<%@ page import="to.UserData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

 <style> 
<%@include file='/WEB-INF/css/style.css' %> 
</style> 

</head>
<body>
    <jsp:include page="/header_admin.jsp" />
    <div id="conteiner">
        <div id="info1">
        <h3 class="h_page">Существующие поезда</h3>
        <article class="trains">
              <section class="number_tr">N</section>
              <section class="type_tr">Тип</section>
              <section class="name_tr">Название</section>         
          </article>    
                    
		<%
			TrainList trains = (TrainList)request.getAttribute("trainList");
			
			for(TrainData train : trains.trainList){
		%>
                <article class="trains">
              <section class="number_tr"><%= train.idTrain %></section>
              <section class="type_tr"><img class="typeTrain" src="images/(<%= train.idType %>).jpg"></section>
              <section class="name_tr"><%= train.beginStantion %> - <%= train.endStantion %></section>
             <section class="path">
              <form class="path" name="newTrain" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= train.idTrain %>" />
        <input type="hidden" name="command" value="newTrain" />
<input type="submit" value="Добавить"/>
              </form>
             </section>
                </article>
		
		<%
			}
		%>

    </div>
    </div>
                <script type="text/javascript"> 

function show()
{
    var r = document.getElementById("for_menu").style.display;
    if (r==='block')
    {document.getElementById("for_menu").style.display = 'none';}
    else
    {document.getElementById("for_menu").style.display = 'block';}
    
} 

</script> 
</body>
</html>