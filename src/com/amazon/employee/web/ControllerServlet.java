package com.amazon.employee.web;

import com.amazon.employee.dao.AnEmployeeDao;
import com.amazon.employee.dao.AnEployeeDaoImpl;
import com.amazon.employee.model.AnEmployee;
import com.amazon.employee.service.AnEmployeeService;
import com.amazon.employee.service.AnEmployeeServiceImpl;

import javax.naming.Name;
import javax.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@javax.servlet.annotation.WebServlet(name = "ControllerServlet", urlPatterns = "/cs")
public class ControllerServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        processRequest(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        processRequest(request,response);
    }

    private void processRequest(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        String action=null;
        String adress=null;
        PrintWriter pw=response.getWriter();
        AnEmployeeDao anEmployeeDao=new AnEployeeDaoImpl();
        AnEmployeeService anEmployeeService= new AnEmployeeServiceImpl(anEmployeeDao);

        if (request.getParameter("action")!=null){
            action=request.getParameter("action");
        }

        try {

            if (action.equalsIgnoreCase("getEmployeeList")){
                List<AnEmployee> employeeList=anEmployeeService.getEmployeeList();
                request.setAttribute("employeeList",employeeList);
                adress="WEB-INF/pages/employeeList.jsp";


            }else if (action.equalsIgnoreCase("createEmployee")){
                String Name=request.getParameter("Name");
                String Surname=request.getParameter("Surname");
                int Age=Integer.parseInt(request.getParameter("Age"));
                String JobTitle=request.getParameter("JobTitle");
                String Homecity=request.getParameter("Homecity");
                int Experience=Integer.parseInt(request.getParameter("Experience"));
                AnEmployee anEmployee=new AnEmployee();
                anEmployee.setName(Name);
                anEmployee.setSurname(Surname);
                anEmployee.setAge(Age);
                anEmployee.setJobtitle(JobTitle);
                anEmployee.setHomecity(Homecity);
                anEmployee.setExperience(Experience);
                String result=anEmployeeService.createEmployee(anEmployee);
                request.setAttribute("result",result);

            }else if (action.equalsIgnoreCase("getAnEmployeeById")){
                long anemployeeId=Long.parseLong(request.getParameter("anemployeeId"));
                AnEmployee anemployee=anEmployeeService.getAnEmployeeById(anemployeeId);
                request.setAttribute("anemployee",anemployee);
                adress="WEB-INF/pages/editAnemployee.jsp";
            }else if (action.equalsIgnoreCase("getAnEmployeeById")){
                long anemployeeId=Long.parseLong(request.getParameter("anemployeeId"));
                AnEmployee anemployee=anEmployeeService.getAnEmployeeById(anemployeeId);
                request.setAttribute("anemployee",anemployee);
                adress="views/clickname.jsp";
            }else if (action.equalsIgnoreCase("updateAnEmployee")){
                String Name=request.getParameter("Name");
                String Surname=request.getParameter("Surname");
                int Age=Integer.parseInt(request.getParameter("Age"));
                String JobTitle=request.getParameter("JobTitle");
                String Homecity=request.getParameter("Homecity");
                int Experience=Integer.parseInt(request.getParameter("Experience"));
                long anemployeeId=Long.parseLong(request.getParameter("anemployeeId"));
                AnEmployee anEmployee=new AnEmployee();
                anEmployee.setName(Name);
                anEmployee.setSurname(Surname);
                anEmployee.setAge(Age);
                anEmployee.setJobtitle(JobTitle);
                anEmployee.setHomecity(Homecity);
                anEmployee.setExperience(Experience);
                String result=anEmployeeService.updateAnEmployee(anEmployee,anemployeeId);
                response.setContentType("text/html");
                pw.write(result);

            }else if (action.equalsIgnoreCase("deleteAnEmployee")){
                long anemployeeId=Long.parseLong(request.getParameter("anemployeeId"));
                String result=anEmployeeService.deleteAnEmployee(anemployeeId);
                response.setContentType("text/html");
                pw.write(result);
            }
            if (adress!=null){
                RequestDispatcher requestDispatcher= request.getRequestDispatcher(adress);
                requestDispatcher.forward(request,response);
            }


        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
