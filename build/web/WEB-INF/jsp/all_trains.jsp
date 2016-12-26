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
         
        <jsp:include page="/header.jsp" />
        
	<div id='conteiner'>      
          <div id='info'>
          <h3 class="h_page">Ближайшие поезда</h3>
          <article class="trains">
              <section class="number_tr">N</section>
              <section class="type_tr">Тип</section>
              <section class="name_tr">Название</section>
              <section class="date_tr">Дата</section>
              <section class="ticket_o">О</section>
              <section class="ticket_p">Пл</section>
              <section class="ticket_k">К</section>
              <section class="ticket_s">C</section>
          </article>
          
          <%
			TrainList trains = (TrainList)request.getAttribute("trainList");
			
			for(TrainData train : trains.trainList){
		%>
                <article class="trains">
              <section class="number_tr"><%= train.idTrain %></section>
              <section class="type_tr"><img class="typeTrain" src="images/(<%= train.idType %>).jpg"></section>
              <section class="name_tr"><%= train.beginStantion %> - <%= train.endStantion %></section>
              <section class="date_tr"><%= train.date %></section>
              <section class="ticket_o"><%= train.tickets[0] %></section>
              <section class="ticket_p"><%= train.tickets[1] %></section>
              <section class="ticket_k"><%= train.tickets[2] %></section>
              <section class="ticket_s"><%= train.tickets[3] %></section>
          <section class="path">
              <form class="path" name="train" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= train.idTrain %>" />
        <input type="hidden" name="command" value="train" />
<input type="submit" value="Посмотреть"/>
</form></section>
          </article>
		<%
			}
		%>
          
          <%--  <table>



                    <tr>
			<td>N</td>
			<td>Тип</td>
			<td id='name'>Название</td>
			<td>Дата</td>
			<td class='ticket'>Общ</td>
			<td class='ticket'>Пл</td>
			<td class='ticket'>К</td>
			<td class='ticket'>С</td>
                        <td>
                            Путь следования
                            
                        </td>
                        
		</tr>
		<%
			TrainList trains = (TrainList)request.getAttribute("trainList");
			
			for(TrainData train : trains.trainList){
		%>
                <tr>
			<td><%= train.idTrain %></td>
			<td><img class="typeTrain" src="images/(<%= train.idType %>).jpg"></td>
			<td><%= train.beginStantion %> - <%= train.endStantion %></td>
			<td><%= train.date %></td>
			<td class='ticket'><%= train.tickets[0] %></td>
			<td class='ticket'><%= train.tickets[1] %></td>
			<td class='ticket'><%= train.tickets[2] %></td>
			<td class='ticket'><%= train.tickets[3] %></td>
                        <td>
                            <form name="train" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= train.idTrain %>" />
        <input type="hidden" name="command" value="train" />
<input type="submit" value="Посмотреть"/>
</form>
                            
                        </td>
                        
		</tr>
		<%
			}
		%>
        </table>
	--%>
        
          </div>
        
         <form name="search" method="post" action="mmm">
             
          <h3 class="h_page">Поиск поезда</h3>
	 <input type="hidden" name="command" value="search" />
         <label for="beginStantion">Начальная станция</label>

<input type="text" name="beginStantion" required/>
<label for="endStantion">Конечная станция</label>
<input type="text" name="endStantion" required/>
<label for="date">Дата</label>
<input type="date" name="date" required  min="2016-12-20"/>
<label for="type">Тип билета</label>
<select name="type" required>   
<option value="1">Общий</option> 
<option value="2">Плацкарт</option> 
<option value="3">Купе</option> 
<option value="4">Сидящий</option>
</select>
<label for="count" >Количество</label>
<input type="number" name="count" min="1" required/>
<input type="submit" value="Поиск"/>
         </form>
        
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