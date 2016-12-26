<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="to.StantionList"%>
<%@ page import="to.StantionData"%>
<%@ page import="servlet.InDataWrapper"%>
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
        <h3 class="h_page">Маршрут следования поезда <strong>N<%= request.getAttribute("id") %></strong></h3>
	 <article class="trains_one">
              <section class="stantion_tr">Станция</section>
              <section class="time_tr">Время</section>
          </article>
        
        
           
		<%
			StantionList stantions = (StantionList)request.getAttribute("stantionList");
			
			for(StantionData stantion : stantions.stantionList){
		%>
                <article class="trains_one">
              <section class="stantion_tr"><%= stantion.nameStantion %></section>
              <section class="time_tr"><%= stantion.date %></section>
          </article>
		<%
			}
		%>
                <%--
        <table class="stantion" border='1'>
            
		<%
			StantionList stantions = (StantionList)request.getAttribute("stantionList");
			
			for(StantionData stantion : stantions.stantionList){
		%>
                
		<tr>
		
			<td><%= stantion.nameStantion %></td>
			<td><%= stantion.date %></td>
                        
                        
		</tr>
		<%
			}
		%>
	</table>--%>
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
