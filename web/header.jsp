<%-- 
    Document   : header
    Created on : 19.12.2016, 11:49:44
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

        <header>
            
            <h2 id="name_site">Железнодорожная касса
            </h2>
            <h3 class="name" onclick="show()"> <%= session.getAttribute("nameUser") %></h3>
            <div id="for_menu">
           
        <form name="tickets" class="menu" method="post" action="mmm">
             <input type="hidden" name="id" value= "<%= session.getAttribute("loginUser") %>" /> 
        <input type="hidden" name="command" value="tickets" />

        <button type="submit"><img class="icon_header" src="images/18216.png" alt=""/><span class='icon_header'>Билеты</span></button>
         </form>         
        <form name="all_train" class="menu" method="post" action="mmm">
             <input type="hidden" name="id" value= "<%= session.getAttribute("loginUser") %>" /> 
        <input type="hidden" name="command" value="all_train" />

        <button type="submit"><img class="icon_header" src="images/train.png" alt=""/><span class='icon_header'>Поезда</span></button>
         </form> 
        
        <form name="exit" class="menu exit" method="post" action="mmm">
             <input type="hidden" name="id" value= "<%= session.getAttribute("loginUser") %>" /> 
        <input type="hidden" name="command" value="logout" />

        <button type="submit"><img class="icon_header" src="images/exit.png" alt=""/><span class='icon_header'>Выход</span></button>
         </form>     
          </div>
        </header>
