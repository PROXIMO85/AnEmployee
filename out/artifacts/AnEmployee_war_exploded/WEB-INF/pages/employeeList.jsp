<%@ page import="java.util.List" %>
<%@ page import="com.amazon.employee.model.AnEmployee" %><%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 1/11/2019
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    $(function () {
        $('#anemployeeDataTableId').DataTable();
    })
</script>
<%List<AnEmployee> employeeList= (List<AnEmployee>) request.getAttribute("employeeList");%>
<table id="anemployeeDataTableId" class="display" cellspacing="0" width="100%">
               <thead>
               <tr>
                   <th>No</th>
                   <th>name</th>
                   <th>surname</th>
                   <th>age</th>
                   <th>jobtitle</th>
                   <th>homecity</th>
                   <th>experience</th>
                   <th>Edit</th>
                   <th>Delete</th>
               </tr>
               </thead>
               <tbody>
               <% for (AnEmployee an: employeeList){%>



               <tr>
                   <td><%=an.getId()%></td>
                   <td><a href="javascript:clickname('<%=an.getId()%>');"><%=an.getName()%></a></td>
                   <td><%=an.getSurname()%></td>
                   <td><%=an.getAge()%></td>
                   <td><%=an.getJobtitle()%></td>
                   <td><%=an.getHomecity()%></td>
                   <td><%=an.getExperience()%></td>
                   <td><a href="javascript:editAnEmployee('<%=an.getId()%>');">Edit</a></td>
                   <td><a href="javascript:deleteAnEmployee('<%=an.getId()%>');">Delete</a></td>
               </tr>
               <%}%>
               </tbody>
</table>
