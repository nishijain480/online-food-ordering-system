<%@page import="thefood.Mailer"%>
<%
//jain.ritesh@rediffmail.com
String msg = Mailer.send("thefoodindore@gmail.com","Abc@12345", "nishijain480@gmail.com", "Test Mail", "Welcome to The Food");
//out.println(msg);

%>