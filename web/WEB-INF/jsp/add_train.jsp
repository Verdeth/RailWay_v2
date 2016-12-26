<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="to.TrainList"%>
<%@ page import="to.TrainData"%>
<%@ page import="to.UserData"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

 <style> 
<%@include file='/WEB-INF/css/style.css' %> 
</style> 
<title>Insert title here</title>
</head>
<body>
    <jsp:include page="/header_admin.jsp" />
    <div id="conteiner">
                 
		<%
			TrainData train = (TrainData)request.getAttribute("trainForNew");
			
			//for(TrainData train : trains.trainList){
		%>
		<h3 class="h_page t"><%= train.idTrain %> <img class="typeTrain search" src="images/(<%= train.idType %>).jpg"> <%= train.beginStantion %> - <%= train.endStantion %>
	
        
                <h3 class="h_page">Новый поезд</h3>
                    <form name="addTrain" method="post" action="mmm">
            
            <label>Дата</label>
            <input type="date" name="date" required min="2016-12-20"/>
             <label>Общий</label>
                                <input type="number" name="type1" min="0" value="0" >
                                <label>Плацкарт</label>
                                <input type="number" name="type2" min="0" value="0" >
                                <label>Купе</label>
                                <input type="number" name="type3" min="0" value="0" >
                                <label>Сидячий</label>
                                <input type="number" name="type4" min="0" value="0" >
	<input type="hidden" name="id" value= "<%= train.idTrain %>" />
        <input type="hidden" name="command" value="addTrain" />
<input type="submit" value="Добавить поезд"/>
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