<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="to.TrainList"%>
<%@ page import="to.TrainData"%>
<%@ page import="to.UserData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <style> 
<%@include file='/WEB-INF/css/style.css' %> 
</style> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
    <jsp:include page="/header.jsp" />
    <div id="conteiner">
        <div id="info">
        <%
String arr[] = {"","","",""};
String type = (String)session.getAttribute("type");
String t = ""; 
//System.out.print(type);
switch (type)
{
    case "1":
        arr[0] = " selected";
        t = "Общий";
        break;
    case "2":
        arr[1] = " selected";
        t = "Плацкарт";
        break;
    case "3":
        arr[2] = " selected";
        t = "Купе";
        break;
    case "4":
        arr[3] = " selected";
        t = "Сидячий";
        break;
    
}
%>
<h3 class="h_page">Поезда <strong><%= session.getAttribute("beginStantion") %> - <%= session.getAttribute("endStantion") %></strong> на <%= session.getAttribute("date") %>, тип билета: <%= t %>, количество: <%= session.getAttribute("count") %></h3>
<article class="trains">
              <section class="number_tr">N</section>
              <section class="type_tr">Тип</section>
              <section class="name_trt">Название</section>
              <section class="date_trt">Дата</section>
              <section class="other">Откуда</section>
              <section class="other">Время</section>
              <section class="other">Куда</section>
              <section class="other">Время</section>
              <section class="other">Цена</section>
          </article>	


		<%
			TrainList trains = (TrainList)request.getAttribute("trainListSearch");
			
			for(TrainData train : trains.trainList){
		%>
                <article class="trains">
              <section class="number_tr"><%= train.idTrain %></section>
              <section class="type_tr"><img class="typeTrain" src="images/(<%= train.idType %>).jpg"></section>
              <section class="name_trt"><%= train.beginStantion %> - <%= train.endStantion %></section>
              <section class="date_trt"><%= train.date %></section>
              <section class="other"><%= train.nameStantionOne %></section>
              <section class="other"><%= train.timeOne %></section>
              <section class="other"><%= train.nameStantionTwo %></section>
              <section class="other"><%= train.timeTwo %></section>
              <section class="other"><%= train.price %></section>
              <section class="path">
              <form class="path" name="addTicket" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= train.idTrain %>" />
        <input type="hidden" name="command" value="addTicket" />
<input type="submit" value="Заказать"/>
</form>
              </section>
          </article>	                
		
		<%
			}
		%>
	
        </div>
        
         <form name="search" method="post" action="mmm">
	 <input type="hidden" name="command" value="search" />
         <label for="beginStantion">Начальная станция</label>

<input type="text" name="beginStantion" value="<%= session.getAttribute("beginStantion") %>"/>
<label for="endStantion">Конечная станция</label>
<input type="text" name="endStantion" value="<%= session.getAttribute("endStantion") %>"/>
<label for="date"  min="2016-12-20">Дата</label>
<input type="date" name="date" value = "<%= session.getAttribute("date") %>"/>
<label for="type">Тип билета</label>

<select name="type" >   
<option value="1" <%= arr[0]%>>Общий</option> 
<option value="2" <%= arr[1]%>>Плацкарт</option> 
<option value="3" <%= arr[2]%>>Купе</option> 
<option value="4" <%= arr[3]%>>Сидящий</option>
</select>
<label for="count">Количество</label>
<input type="number" name="count" min="1" value="<%= session.getAttribute("count") %>"/>
<input type="submit" value="Поиск"/>
         </form>
<br/>
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