<%--
  Created by IntelliJ IDEA.
  User: SONY-VAIO
  Date: 1/9/2019
  Time: 6:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>AN_EMPLOYEE</title>

  <script type="text/javascript" src="js/jquery/jquery-3.3.1.min.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery.layout-latest.js"></script>
  <script type="text/javascript" src="js/jquery/jquery-ui.js"></script>
  <script type="text/javascript" src="js/jquery/jquery.dataTables.min.js"></script>
  <script type="text/javascript" src="js/main.js"></script>

  <link rel="stylesheet" type="text/css" href="css/main.css"/>
  <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
  <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.min.css"/>
  <script type="text/javascript">
      $(function () {
          $('body').layout({ applyDemoStyles: true });

          $('#listviewId').click(function () {
              $('#anemployeeTableId').show();
              getEmployeeList();

          });

          $('#createemployeeDialogId').dialog({
              title:'New Employee',
              height:500,
              width:400,
              autoOpen:false,
              modal:true,
              buttons:{
                  "Save":function () {
                      createEmployee();
                      $(this).dialog('close');
                  },
                  "Close":function () {
                      $(this).dialog('close');
                  }
              }
          });
          $('#createemployeeBtnId').click(function () {
              $('#createemployeeDialogId').load('views/createemployee.jsp',function () {
                  $(this).dialog('open')
              });

          });

          $('.btndesign').click(function () {
              var btnId=$(this).attr('id');
              globBtnId=btnId;
          });

          $('#editemployeeDialogId').dialog({
              title:'Edit Employee',
              height:400,
              width:500,
              autoOpen:false,
              modal:true,
              buttons:{
                  "Change":function () {
                      updateAnEmployee();
                      $(this).dialog('close');
                  },
                  "Close":function () {
                      $(this).dialog('close');
                  }
              }
          });

          $('#clicknameDialogId').dialog({
              title:'An Employee Information',
              height:400,
              width:500,
              autoOpen:false,
              modal:true,
              buttons:{
                  "Close":function () {
                      $(this).dialog('close');
                  }

              }
          });



      });
  </script>
</head>
<body>
<div class="ui-layout-center">

  <div id="anemployeeTableId" style="display: none">

  </div>
  <div id="createemployeeDialogId">

  </div>
  <div id="editemployeeDialogId">

  </div>
  <div id="clicknameDialogId">

  </div>


</div>
<div class="ui-layout-north">
  <h1 style="text-align: center">AN_EMPLOYEE</h1>
</div>
<div class="ui-layout-south">South</div>
<div class="ui-layout-east">
  <input type="button" value="Create an employee" id="createemployeeBtnId" class="createbtndesign"/><br>
</div>
<div class="ui-layout-west">
  <input type="button" value="List View" id="listviewId" class="btndesign"/><br>
</div>

</body>
</html>
