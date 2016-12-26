<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="to.TrainList"%>
<%@ page import="to.TrainData"%>
<%@ page import="to.TicketList"%>
<%@ page import="to.TicketData"%>
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
              <section class="name_trt">Название</section>
              <section class="date_tr">Дата</section>
              <section class="ticket_kol">Кол</section>
              <section class="ticket_type">Тип билета</section>
              <section class="ticket_pr">Цена</section>
          </article>
		<%
			TicketList tickets = (TicketList)request.getAttribute("ticketList");
			
			for(TicketData ticket : tickets.ticketList){
		%>
                  <article class="trains">
              <section class="number_tr"><%= ticket.train.idTrain %></section>
              <section class="type_tr"><img class="typeTrain" src="images/(<%= ticket.train.idType %>).jpg"></section>
              <section class="name_trt"><%= ticket.train.beginStantion %> - <%= ticket.train.endStantion %></section>
              <section class="date_tr"><%= ticket.train.date %></section>
              <section class="ticket_kol"><%= ticket.count %></section>
              <section class="ticket_type"><%= ticket.typeTicket %></section>
              <section class="ticket_pr"><%= ticket.price %></section>
          <section class="path">
              <form name="deleteTicket" class="path" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= ticket.idTicket %>" />
        <input type="hidden" name="command" value="deleteTicket" />
<input type="submit" value="Удалить"/>
         </form>
          </section>          
                  </article>	
		<%
			}
		%>

        
        
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