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
            
            
		<%
			TrainData train = (TrainData)request.getAttribute("editTrain");
			
			//for(TrainData train : trains.trainList){
		%>
                <article  class="ticket">
                     <p>Поезд: <strong><%= train.idTrain %> <img class="typeTrain search" src="images/(<%= train.idType %>).jpg"> <%= train.beginStantion %> - <%= train.endStantion %></strong></p>
                    <p>Дата: <strong><%= train.date %></strong></p>                    
                
                <p>Общий: <strong><%= train.tickets[0] %></strong></p>
                <p>Плацкарт: <strong><%= train.tickets[1] %></strong></p>
                <p>Купе: <strong><%= train.tickets[2] %></strong></p>
                <p>Сидячий: <strong><%= train.tickets[3] %></strong></p>
                </article>
                <h3 class="h_page">Добавить билеты</h3>
                            <form name="saveTicket" method="post" action="mmm">
                                <label>Общий</label>
                                <input type="number" name="type1" min="0" value="0" >
                                <label>Плацкарт</label>
                                <input type="number" name="type2" min="0" value="0" >
                                <label>Купе</label>
                                <input type="number" name="type3" min="0" value="0" >
                                <label>Сидячий</label>
                                <input type="number" name="type4" min="0" value="0" >
                                <input type="hidden" name="date" value= "<%= train.date %>" />
                                <input type="hidden" name="id" value= "<%= train.idTrain %>" />
        <input type="hidden" name="command" value="saveTicket" />
<input type="submit" value="Добавить"/>
                                
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
</body></html>