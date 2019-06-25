<%@page import="dto.AdminDTO"%>
<%
AdminDTO admin=(AdminDTO)session.getAttribute("ADMIN");
%>


<!DOCTYPE html>

<html>
    <head>
        <title>bootstrap</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <link type="text/css" rel="stylesheet" href="admin_mycss/admin_css.css">
        <link type="text/css" rel="stylesheet" href="admin_css/bootstrap.css">
        <script src="admin_js/jquery-3.3.1.min.js"></script>
        <script src="admin_js/bootstrap.js"></script>
    </head>
    <body>
        
      <!--this is for menu -->  
        <div class="container-fluid">
            <%  if(admin!=null)
                  {
             %>
            <div class="row">
                
                                    
                <div class="col-sm-3" >
                            <div id="logo">
                                <a href="#"> <img src="admin_images/logo.png" height="20"> </a>
                            </div>
                </div>
                <div class="col-sm-9">
                           <div id="menu">
                              <ul>
                                  <li><a href="admin_index.jsp">Home</a></li>     
                                 <li style="width:130px;"><a href="#">Categories&nbsp;<span class='glyphicon glyphicon-menu-down'></span></a>
                                 <ul>
                                        <li style="width:130px;"><a href="view_category.jsp">View Categories</a></li>
                                        <li style="width:130px;"><a href="add_new_category.jsp">Add New Category</a></li>
                                        <li style="width:130px;"><a href="delete_category.jsp">Remove Category</a></li>
                                 </ul>
                                
                                 </li>
                                     
                                  <li style="width:130px;"><a href="#">&nbsp;&nbsp;Users<span class='glyphicon glyphicon-menu-down'></span></a>
                                     <ul>
                                        <li style="width:130px;"><a href="view_users.jsp">Current Users</a></li>
                                        <li style="width:130px;"><a href="view_blocked_users.jsp">Blocked Users</a></li>
                                        
                                     </ul> 
                                  </li>
                                 <li style="width:100px;"><a href="view_orders.jsp">Orders</a></li>
                                 <li style="width:100px;"><a href="view_notifications.jsp">Notifications</a></li>
                               
                                 <li style="width:250px;" ><a href="admin_index.jsp"><%="WELCOME!"+"   "+ (admin.getUnm()).toUpperCase()%></a></li>
                                
                                  <li style="width:50px;"><a href="logout_servlet">Logout</a></li>
                               
                             </ul>
                           </div>
                </div>
        </div>
                                  <%       
                                  }
                                   else
                                  {

                                  %>
                                   <div class="row">
                                   <div class="col-sm-9" >
                            <div id="logo">
                                <a href="#"> <img src="admin_images/logo.png" height="20"> </a>
                            </div>
                </div>
                <div class="col-sm-3">
                           <div id="menu">
                              <ul>
                                       
                                
                                 <li style="width:150px;"><a href="admin_registration.jsp"><span class="glyphicon glyphicon-user"> </span> SIGNUP OR LOGIN</a></li>
                                 
                                  
                               
                             </ul>
                           </div>
                </div>
        </div>
                                 
                  <%
                       }
                  %>                  
                                  
         </div>                            
   
    <!--now we start -->    
      <img src="admin_images/image01.jpg"> 
    </body>
</html>
