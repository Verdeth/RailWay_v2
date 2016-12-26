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
</head>
<body>
    
    <form name="saveTime" method="post" action="mmm">
	<input type="hidden" name="id" value= "<%= request.getAttribute("id") %>" />
        <input type="hidden" name="command" value="saveTime" />
	<table border='1'> 
            
            <%= request.getAttribute("id") %>
            
		<%
			StantionList stantions = (StantionList)request.getAttribute("stantionList");
			int i = 0;
			for(StantionData stantion : stantions.stantionList){
		%>
                
		<tr>
		  

			<td><%= stantion.nameStantion %></td>
                        <td><input type = "text" value="<%= stantion.date %>" name="DateStantion<%= i %>"  pattern="^([0-1]\d|2[0-3])(:[0-5]\d){1}$"></td>
                        
                        
		</tr>
		<%
                    ++i;
			}
		%>
               
	</table>
	 <input type="submit" value="Save time"/>
         </form>
<br/>
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
