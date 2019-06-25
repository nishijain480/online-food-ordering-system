<%-- 
    Document   : add_new_item
    Created on : 31 May, 2019, 9:51:57 AM
    Author     : NJAIN
--%>

<%@page import="dto.AdminDTO"%>
<%@page import="dto.CategoryDTO"%>
<%@page import="dao.ItemDAO"%>
<%@page import="dto.ItemDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    AdminDTO admin=(AdminDTO)session.getAttribute("ADMIN");
    String catnm=request.getParameter("catnm");
    int catid=Integer.parseInt(request.getParameter("catid"));
    CategoryDTO cat=new CategoryDTO();
    cat.setCatid(catid);
    cat.setCatnm(catnm);
    
    String btn=request.getParameter("additem");
    if(btn!=null && btn.equals("Add Item"))
    { 
    String itemnm=request.getParameter("itemnm");
    int itemprice=Integer.parseInt(request.getParameter("itemprice"));
    String itemdesc=request.getParameter("itemdesc");
    
    ItemDTO item=new ItemDTO();
    
    item.setItemdesc(itemdesc);
    item.setItemnm(itemnm);
    item.setItempic(null);
    item.setItemprice(itemprice);
    item.setCat(cat);
    
    ItemDAO.addItem(item);
  
    }
    if(btn!=null && btn.equals("back"))
    { 
        response.sendRedirect("view_category.jsp");
    }
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body style="background-image:url(admin_images/image01.jpg);">
        <div align="center">
            <h1 style="text-align:center; color:white;margin-top:40px;">ENTER NEW ITEM IN <%=(catnm).toUpperCase()%> CATEGORY</h1>
            <form action="add_new_item.jsp?&catid=<%=catid%>&catnm=<%=catnm%>" method="post" >
                <table style="margin-top:150px;" >
                    
                    <tr>
                        <td>  <label style="color: white;font-size:25px; ">Enter Item Name: </label> </td>
                        <td> <input style="height:30px; width:150px;" type="text" name="itemnm"/>  </td>
                       
                    </tr>
                    <tr>
                       <td><label style="color: white;font-size:25px;"  >Enter Item Price:</label></td>
                       <td><input style="height:30px; width:150px;" type="number" name="itemprice"/> </td>
                     
                      </tr>  
              <!--      <tr> 
                       <td><label style="color: white;font-size:25px;">Enter Item pic </label></td>
                       <td><input type='file' name='photo' size='50' > </td>     
                    </tr>
              -->
                     <tr>    
                     <td> <label style="color: white;font-size:25px; ">Enter Item Description </label></td>
                    <td>  <input style="height:30px; width: 150px;" type="text" name="itemdesc"/> </td>    
                    </tr>
                    <tr> 
                        <td style="text-align:center; " colspan="2"><button style="width:200px;  height:30px;  font-size:20px;" type="submit" value="Add Item" name="additem">Add Item</button>></td>
                    </tr>  
                    <tr> 
                        <td style="text-align:center; " colspan="2"><button style="width:200px;  height:30px;  font-size:20px;" type="reset" value="Reset" name="additem">Reset</button></td>
                    </tr> 
                    <tr>
                     <td style="text-align:center;" colspan="2"><button style="width:200px;  height:30px;  font-size:20px;" type="submit" name="additem" value="back">Back</button>
                     </td>
                    </tr>
                    <%
                        if(btn!=null && btn.equals("Add Item"))
                        {
                    %>
                    <!--here we are using javascript -->
                    <script>
                        confirm("ITEM ADDED SUCESSFULLY IN <%=(catnm).toString()%> CATEGORY");       
                    </script>
                    <%
                        }
                   
                    %>
                   
               </table>
            
            </form>
            
            
        </div>
     
    </body>
</html>
