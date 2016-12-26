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
    <div id="conteiner">
        <div id="info">
            
		<%
			TrainData train = (TrainData)request.getAttribute("trainForTicket");
			
			//for(TrainData train : trains.trainList){
		%>
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
                <h3 class="h_page">Приобрести билет?</h3>
		<article class="ticket">
                    <p>Поезд: <strong><%= train.idTrain %> <img class="typeTrain search" src="images/(<%= train.idType %>).jpg"> <%= train.beginStantion %> - <%= train.endStantion %></strong></p>
                    <p>Дата: <strong><%= train.date %></strong></p>
                        <p>Отправление со станции <strong><%= train.nameStantionOne %> в <%= train.timeOne %></strong></p>
                        <p>Прибытие на станцию <strong><%= train.nameStantionTwo %> в <%= train.timeTwo %></strong></p>
                        <p>Тип билета: <strong><%= t %></strong></p>
                        <p>Количество: <strong><%= session.getAttribute("count") %></strong></p>
                        <%
			double sum = train.price*Integer.parseInt((String)session.getAttribute("count"));
			
			//for(TrainData train : trains.trainList){
		%>
                <p>Цена: <strong><%= (Math.round(sum*100.0) / 100.0) %></strong></p>
                            <form name="yes" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= request.getAttribute("idTicket") %>" />        
        <input type="hidden" name="price" value= "<%= (Math.round(sum*100.0) / 100.0) %>" />
        <input type="hidden" name="command" value="yes" />
<input type="submit" value="Да"/>
</form>
        <form name="no" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= request.getAttribute("idTicket") %>" />
        <input type="hidden" name="command" value="no" />
<input type="submit" value="Нет"/>
</form>
                            
                        </td>
                        
		</article>
		<%
			//}
		%>
    </div>
     <form name="search" method="post" action="mmm">
          <h3 class="h_page">Поиск поезда</h3>
	 <input type="hidden" name="command" value="search" />
         <label for="beginStantion">Начальная станция</label>

<input type="text" name="beginStantion" value="<%= session.getAttribute("beginStantion") %>"/>
<label for="endStantion">Конечная станция</label>
<input type="text" name="endStantion" value="<%= session.getAttribute("endStantion") %>"/>
<label for="date">Дата</label>
<input type="date" name="date" value = "<%= session.getAttribute("date") %>"  min="2016-12-20"/>
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