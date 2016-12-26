<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf8">
<title>Insert title here</title>
   <style>
            *{
    font-family: "Century Gothic";
}                
html, body, div, span, applet, object, iframe,
h1, h2, h3, h4, h5, h6, p, blockquote, pre,
a, abbr, acronym, address, big, cite, code,
del, dfn, em, img, ins, kbd, q, s, samp,
small, strike, strong, sub, sup, tt, var,
b, u, i, center,
dl, dt, dd, ol, ul, li,
fieldset, form, label, legend,
table, caption, tbody, tfoot, thead, tr, th, td,
article, aside, canvas, details, embed,
figure, figcaption, footer, header, hgroup,
menu, nav, output, ruby, section, summary,
time, mark, audio, video {
    margin: 0;
    padding: 0;
    border: 0;
    font-size: 100%;
    font: inherit;
    vertical-align: baseline;
    font-family: "Century Gothic";
    
}


/* HTML5 display-role reset for older browsers */
article, aside, details, figcaption, figure,
footer, header, hgroup, menu, nav, section {
    display: block;
}
body {
    line-height: 1;
}
ol, ul {
    list-style: none;
}
blockquote, q {
    quotes: none;
}
blockquote:before, blockquote:after,
q:before, q:after {
    content: '';
    content: none;
}
table {
    border-collapse: collapse;
    border-spacing: 0;
}



            header{


                
                
                
                
                background-color: #cccccc;
                text-align: right;
                
                
             
            }
            
            header * {
                display: inline-block;
            }
            
            
            img.train
            {
                height: 50px;
                opacity: 1;
            }
            
            
            
            input[type="submit"]
            {
                border: hidden;
                background-color: transparent;
                text-decoration: underline; 
                margin-top: -30px;
            }
            
            
            form[name="exit"]
            {
                float: left;
            }
            
            button
            {
                border: hidden;
                background-color: transparent;
                text-decoration: underline; 
                margin-top: -30px;
                cursor: pointer;
            }
            
            span.icon_header
            {
                margin-top: -10px;
                text-decoration: underline; 
                font-size: 18px;
                padding-left: 7px;
                padding-right: 15px;
 
            }
            
            img.icon_header{
                height: 15px;
                padding-top: 5px;
            }
            
            img.train_header_l{
                height: 50px;
                padding-top: 5px;
                float: left;
            }
             img.train_header_r{
                height: 50px;
                padding-top: 5px;
                float: right;      
                
            }
            
            h3.name
            {
                font-size: 18px;
                font-weight: bold;
            }
            
            h2{
                display: block;
                margin: auto;
              /*  font-weight: bold;*/
                text-align: center;
                font-size: 26px;
                padding-bottom: 20px;
                padding-top: 30px;
                background-color: black;
                color: white;
            }
            
            
            form[name="login-form"]
            {                
                margin: 50px auto;
                text-align: left;
                font-size: 20px;
                width: 300px;
                border: solid 1px;
                padding: 10px;
            }
            
            form[name="login-form"] *
            {
                margin-left: 25px;
            }
            
            form[name="login-form"] label
            {                
                text-align: left;
                font-size: 16px;
                display: block;
                margin-bottom: 4px;
                margin-top: 10px;
            }
            
            form[name="login-form"] input
            {                
               border: solid 1px; 
               margin-top: 2px;
               width: 250px;
               padding: 3px;
               font-size: 20px;
            }
            
            form[name="login-form"] input[type="submit"]
            {                
               width: 90px;
               margin-top: 20px;
               text-decoration: none;
               padding-bottom: 3px;
               padding-top: 3px;
               display: inline-block;
            }
            
            form[name="login-form"] input[type="submit"]:hover
            {             
                cursor: pointer;
                background-color: black;
                color: white;
                
            }
            
            
            
            
            
            form[name="register"]
            {                
                margin: 50px auto;
                text-align: left;
                font-size: 18px;
                width: 30%;
                border: solid 1px;
                padding: 10px;
                background-color: white;
                position: fixed;
                top: 70px;
                margin-left: 35%;
                
            }
            
            form[name="register"] *
            {
                margin-left: 10%;
            }
            
            form[name="register"] label
            {                
                text-align: left;
                font-size: 14px;
                display: block;
                margin-bottom: 4px;
                margin-top: 10px;
            }
            
            form[name="register"] input
            {                
               border: solid 1px; 
               margin-top: 2px;
               width: 80%;
               padding: 3px;
            }
            
            form[name="register"] input[type="submit"]
            {                
               width: 100px;
               margin-top: 20px;
               text-decoration: none;
               padding-bottom: 3px;
               padding-top: 3px;
               display: inline-block;
            }
            
            form[name="register"] input[type="submit"]:hover
            {             
                cursor: pointer;
                background-color: black;
                color: white;
                
            }
            
            
            
            
            
            
            
            p.reg
            {
                display: inline-block;
                font-size: 14px;
                text-decoration: underline;
                cursor: pointer;
            }
            
            p.reg:hover
            {
                display: inline-block;
                font-size: 14px;
                color: red;
                cursor: pointer;
                text-decoration: underline;
                cursor: pointer;
            }
            
            
            form#register
            {
                display: none;
                opacity: 1;
            }
            
            div#podl
            {position: fixed;
             top:0;
             right: 0;             
                width: 100%;
                height: 100%;
                background-color: black;
                opacity: 0.7;
                 display: none;
                
            }
            
            
            h4.reg
            {
                text-align: center;
                margin-top: 6px;
                margin-bottom: 5px;
                font-weight: bold;
            }
            
            div.btn
            {
                text-align: right;
                margin-right: 9%;
            }
            
            </style>



</head>
<body>
     <header>
            
            <h2>
                Железнодорожная касса
            </h2>
     </header>
    
    
<form name="login-form" method="post" action="mmm">
	<input type="hidden" name="command" value="login" />
        <label style="color:red"><%=((String)session.getAttribute("msg2")!=null)?((String)session.getAttribute("msg2")):""%></label>
        <label>e-mail:<br/></label>
	<input type="text" name="login" value=""/><br/>
        <label>Пароль:<br/></label>
	<input type="password" name="password" value=""><br/>
	<input type="submit" value="Войти"/>
        <p class='reg' onclick="reg()">Зарегистрироваться</p>
        
</form>
<div id="podl"></div>
    <form id='register' name="register" method="post" action="mmm">
        <h4 class="reg"> Регистрациия</h4>
        <label style="color:red"><%=((String)session.getAttribute("msg")!=null)?((String)session.getAttribute("msg")):""%></label>
        <input type="hidden" name="command" value="register" />
        <label>E-mail*:<br/></label>
	<input type="text" name="login" value="" required pattern="^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$"/><br/>
	<label>Пароль*:<br/></label>
	<input type="password" name="password" value="" required><br/>        
	<label>Повторите пароль*:<br/></label>
	<input type="password" name="password2" value="" required><br/>
	<label>Имя*:<br/></label>
	<input type="text" name="name" value="" required/><br/>
	<label>Фамилия:<br/></label>
	<input type="text" name="lastname" value=""/><br/>
        <label>Отчество:<br/></label>
	<input type="text" name="secondname" value=""/><br/>
        <div class="btn">
        <input type="submit" value="ОК"/>
        <p class='reg' onclick="reg_out()">Отмена</p>
        </div>
</form>
    
<script type="text/javascript"> 

function right()
{
    <% if ((String)session.getAttribute("msg")!=null)
    { %>
       
        document.getElementById('register').style.display = "block";
document.getElementById('podl').style.display = "block";
        <%}
%>
}
window.onload = right;
//Функция показа 
function reg(){ 
/*document.getElementById('window').style.display = state;*/ 
document.getElementById('register').style.display = "block";
document.getElementById('podl').style.display = "block";
} 
//Функция показа 
function reg_out(){ 
/*document.getElementById('window').style.display = state;*/ 
document.getElementById('register').style.display = "none";
document.getElementById('podl').style.display = "none";
} 

</script> 
</body>
</html>