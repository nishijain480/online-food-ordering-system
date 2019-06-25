<%@page import="dto.AdminDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dao.CategoryDAO"%>
<%
    AdminDTO admin=(AdminDTO)session.getAttribute("ADMIN");
    
String btn=request.getParameter("REMOVE");
String name=request.getParameter("categoryname"); 
   if(btn!=null && btn.equals("remove"))
    {
    CategoryDTO category=new CategoryDTO();
       category.setCatnm(name);
   CategoryDAO.deleteCategoryByName(category);
   }
  if(btn!=null && btn.equals("reset"))
   {
   response.sendRedirect("delete_category.jsp");
   }
  if(btn!=null && btn.equals("back"))
  {
   response.sendRedirect("admin_index.jsp"); 
  }
  String userid=request.getParameter("userid");

%>

<!DOCTYPE html>
<html>
    <head>
        <title>Remove Category</title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width-device-width , initial-state=1"/>
        <link type="text/css" rel="stylesheet" href="admin_mycss/admin_css.css">
         <link type="text/css" rel="stylesheet" href="admin_css/bootstrap.css">
        <script src="admin_js/jquery-3.3.1.min.js"></script>
        <script src="admin_js/bootstrap.js"></script>
        
    </head>
    <body>
           <div class="container-fluid" >
             
              <!--CODING FOR THE MENU PART STARTS... HERE -->
             <div class="row" style="background-color: red;">
               <div class="col-sm-4">
                  <div id="logo">
                       <a href="#"> <img class="img-responsive" src="admin_images/logo.png" style="height:20px; margin-top:15px;"> </a>
                  </div>
               </div>
               <div class="col-sm-8">
                      <div id="menu">
                        <ul>
                       <li><a href="admin_index.jsp">Home</a></li>
                       <li><a href="#">Category&nbsp;<span class='glyphicon glyphicon-menu-down'></span></a>
                       <ul>
                                        <li style="width:140px; height:35px;z-index:2"><a href="view_category.jsp">View Categories</a></li>
                                        <li style="width:140px; height:35px;z-index:2"><a href="add_new_category.jsp">Add New Category</a></li>
                                        <li style="width:140px; height:39px;z-index:2"><a href="delete_category.jsp">Remove Category</a></li>
                                    </ul>
                       </li>
                       <li style="width:130px;"><a href="#">Users&nbsp;<span class='glyphicon glyphicon-menu-down'></span></a>
                                     <ul>
                                        <li style="width:130px; height:40px;z-index:2"><a href="view_users.jsp">Current Users</a></li>
                                        <li style="width:130px; height:40px;z-index:2"><a href="view_blocked_users.jsp">Blocked Users</a></li>
                                        
                                     </ul> 
                                  </li>
                       <li><a href="view_orders.jsp">Orders</a></li>
                       <li><a href="view_notifications.jsp">Notifications</a></li>
                       <li><a href="logout_servlet">LogOut</a></li>
                        </ul>
                   </div> 
               </div>
             </div>
                 <!--CODING FOR THE MENU PART ENDS... HERE -->
                 <!--CODING FOR THE FORM PART ENDS... HERE -->
                 <div class="row">
                    <div class="col-sm-12">
                        <div class="panel panel-success" style="margin-top:70px;">
                            <div class="panel-heading">
                                <h3 align="center" style="color:black">REMOVE CATEGORY</h3>
                            </div>
                            <div class="panel-body" style="height:200px;">
                                <form action="#">
                                   <table align="center" style="margin-top:15px;">
                                       <tr>
                                           <td><h4>Category Name&nbsp;&nbsp;&nbsp;&nbsp;</h4></td>
                                          <td><input type="text" name="categoryname" placeholder="enter category name"></td>
                                          <td></td>
                                       </tr>
                                       <tr>
                                           <td><input type="submit" name="REMOVE" value="remove" ></td>
                                            <td><input type="reset" name="REMOVE" value="reset"></td>
                                             <td><input type="submit" name="REMOVE" value="back"></td>
                                       </tr>
                                    </table>
                                </form>    
                            </div>
                        </div>    
                    </div>    
                 </div> 
        </div>         
    </body>    
    
</html>