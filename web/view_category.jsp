<%@page import="dto.AdminDTO"%>
<%@page import="dao.ItemDAO"%>
<%@page import="dto.ItemDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.CategoryDAO"%>
<%
    
AdminDTO admin=(AdminDTO)session.getAttribute("ADMIN");

String itemnm=(request.getParameter("itemnm"));
if(itemnm!=null)
{
ItemDTO blockitem=new ItemDTO();
blockitem.setItemnm(itemnm);
ItemDAO.blockItem(blockitem);
}
%>
<!DOCTYPE html>
<html>
    <head>
        <title>VIEW CATEGORY</title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width-device-width , initial-state=1"/>
         <link type="text/css" rel="stylesheet" href="admin_mycss/admin_css.css">
         <link type="text/css" rel="stylesheet" href="admin_css/bootstrap.css">
        <script src="admin_js/jquery-3.3.1.min.js"></script>
        <script src="admin_js/bootstrap.js"></script>
        
    </head>
    <body>
      <script>
          function f1()
          {
              alert("Item Deleted Sucessfully");
          }
          </script>
         <div class="container-fluid" >
             
              <!--CODING FOR THE MENU PART STARTS... HERE -->
             <div class="row" style="background-color: red;">
               <div class="col-sm-4">
                  <div id="logo">
                       <a href="#"> <img class="img-responsive" src="admin_images/logo.png" style="height:20px; margin-top:15px;"> </a>
                  </div>
               </div>
                    <div id="menu">
                        <ul>
                       <li style="width:130px;"><a href="admin_index.jsp">Home</a></li>
                       <li style="width:130px;"><a href="#">Category&nbsp;<span class='glyphicon glyphicon-menu-down'></span></a>
                       <ul>
                                        <li style="width:130px;height:35px;z-index:2"><a href="view_category.jsp">View Categories</a></li>
                                        <li style="width:130px;height:35px;z-index:2"><a href="add_new_category.jsp">Add New Category</a></li>
                                        <li style="width:130px;height:39px; z-index:2"><a href="delete_category.jsp">Remove Category</a></li>
                       </ul>
                       
                       
                       
                       </li>
                        <li style="width:130px;"><a href="#">Users&nbsp;<span class='glyphicon glyphicon-menu-down'></span></a>
                                     <ul>
                                        <li style="width:130px; height:40px;z-index:2"><a href="view_users.jsp">Current Users</a></li>
                                        <li style="width:130px; height:40px;z-index:2"><a href="view_blocked_users.jsp">Blocked Users</a></li>
                                        
                                     </ul> 
                                  </li>
                       <li style="width:130px;"><a href="view_orders.jsp">Orders</a></li>
                       <li style="width:130px;"><a href="view_notifications.jsp">Notifications</a></li>
                       <li style="width:130px;"><a href="logout_servlet">LogOut</a></li>
                        </ul>
                   </div>
               </div>
             </div>
                 <!--CODING FOR THE MENU PART ENDS... HERE -->
                 <!--CODING FOR THE LIST OF CATEGORIES STARTS... HERE IN THE FORM OF PANEL -->
                
                
              <div class="row">
                  <div class="col-sm-12">
                     <div class="panel panel-success" style="margin-top:70px;">
                       <%
                          ArrayList<CategoryDTO> categories=CategoryDAO.getCategoryList();
                            for( CategoryDTO category: categories)
                              {
                       %>
                         <div class="panel-heading">
                            <h2><%=category.getCatid()%>.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=(category.getCatnm()).toUpperCase()%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a style="color:green;background-color:lightgrey;" href="add_new_item.jsp?&catid=<%=(category.getCatid())%>&catnm=<%=(category.getCatnm())%>" >Add More Items</a></h2>
                        </div> 
                          <div class="panel-body">
                              <table style="width:100%">
                                  <tr>
                                       <hr></hr>  
                                     <th style="padding:15px">Item Pic</th> 
                                      <th style="padding:15px">Item Id</th> 
                                     <th style="padding:15px">Item Name</th> 
                                     <th style="padding:15px"> Item Description</th>
                                     <th style="padding:15px">Item Price</th>
                                      
                                  </tr>
                                
                              <%
                               ArrayList<ItemDTO> items=ItemDAO.getItemByCategory(category);
                               for(ItemDTO item:items)
                                {
                              %>
                            
                                   <tr>
                                     <td style="padding:15px">picture</td>    
                                     <td style="padding:15px"><%=item.getItemid()%></td> 
                                     <td style="padding:15px"><%=(item.getItemnm()).toUpperCase()%></td> 
                                     <td style="padding:15px"><%=item.getItemdesc()%></td> 
                                     <td style="padding:15px"><%=item.getItemprice()%></td> 
                                     <td style="padding:15px"><a onclick="f1()" href="view_category.jsp?&itemnm=<%=item.getItemnm()%>">Delete Item</a></td> 
                                  </tr>
                                  
                              
                          
                              <%
                               } 
                              %>
                          </table>
                          </div> 
                    <%
                      }       
                    %>
                     </div>    
                  </div>    
              </div>
                 
                 
                 
                 
        </div>
        
        
        
        
        
        
        
        
    </body>    
    
</html>