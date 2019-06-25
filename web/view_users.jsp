<%-- 
    Document   : view_users
    Created on : 11 Apr, 2019, 9:52:22 PM
    Author     : NJAIN
--%>

<%@page import="dto.AdminDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.UserDAO"%>
<%@page import="dto.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="sample.html" %> 
<%
  AdminDTO admin=(AdminDTO)session.getAttribute("ADMIN");
String mobileno=request.getParameter("mobileno");
if(mobileno!=null)
{
UserDTO blockuser=new UserDTO();
blockuser.setMobileno(mobileno);
UserDAO.blockUser(blockuser);
}
//blockuser=UserDAO.blockUser(blockuser);

%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link type="text/css" rel="stylesheet" href="admin_mycss/admin_css.css">
         <link type="text/css" rel="stylesheet" href="admin_css/bootstrap.css">
        <script src="admin_js/jquery-3.3.1.min.js"></script>
        <script src="admin_js/bootstrap.js"></script>
        <title>View Users</title>
    </head>
    <body>
        <script>
          function f1()
          {
              alert("User Blocked Sucessfully");
          }
          </script>
     <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-success" style="margin-top:100px;">
                           
                            <div class="panel-heading">
                                <h3 align="center">Users of TheFood</h3>
                            </div>
                         
                            <div class="panel-body" style="">
                               
                              <table style="width:100%">
                                  <tr>
                                       
                                     <th style="padding:15px">User ID</th> 
                                      <th style="padding:15px">Mobile No.</th> 
                                     <th style="padding:15px">User Email</th> 
                                     <th style="padding:15px"> User Full Name</th>
                                     <th style="padding:15px">Registration date</th>
                                      
                                  </tr>
                                        <%
                          ArrayList<UserDTO> users=UserDAO.getUserList();
                            for(UserDTO user : users)
                              {
                              %>
                              <tr>
                                      
                                     <td style="padding:15px"><%=user.getUid()%></td> 
                                     <td style="padding:15px"><%=user.getMobileno()%></td> 
                                     <td style="padding:15px"><%=user.getEmail()%></td> 
                                     <td style="padding:15px"><%=user.getFullname()%></td> 
                                     <td style="padding:15px"><%=user.getRegdate()%></td> 
                                  <!-- <td style="padding:15px"><a href="view_users.jsp?&mobileno=<%=user.getMobileno()%>" >Block User</a></td> -->
                                     <td style="padding:15px"><a onclick="f1()" href="view_users.jsp?&mobileno=<%=user.getMobileno()%>" >Block User</a></td>  
                                    
                              </tr>
                              <%
                              }
                              %>
                             </table>
                                
                            </div>
                             
                        </div>
                      </div>
          </div>
    </body>
</html>
