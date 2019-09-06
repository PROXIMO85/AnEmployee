package com.amazon.employee.dao;

import com.amazon.employee.model.AnEmployee;
import com.amazon.employee.util.JdbcUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnEployeeDaoImpl implements AnEmployeeDao {
    @Override
    public List<AnEmployee> getEmployeeList() throws Exception {
        List<AnEmployee> employeeList=new ArrayList<AnEmployee>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ID,NAME,SURNAME,AGE,JOB_TITLE,HOME_CITY,EXPERIENCE FROM AN_EMPLOYEE\n" +
                "WHERE ACTIVE=1 ";
        try{

            c=DBHelper.getConnection();
            if (c!=null){
                ps=c.prepareStatement(sql);
                rs=ps.executeQuery();
                while (rs.next()){
                    AnEmployee anEmployee=new AnEmployee();
                    anEmployee.setId(rs.getLong("ID"));
                    anEmployee.setName(rs.getString("NAME"));
                    anEmployee.setSurname(rs.getString("SURNAME"));
                    anEmployee.setAge(rs.getInt("AGE"));
                    anEmployee.setJobtitle(rs.getString("JOB_TITLE"));
                    anEmployee.setHomecity(rs.getString("HOME_CITY"));
                    anEmployee.setExperience(rs.getInt("EXPERIENCE"));
                    employeeList.add(anEmployee);

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtility.close(c,ps,rs);
        }
        return employeeList;
    }

    @Override
    public String createEmployee(AnEmployee anEmployee) throws Exception {
        String result=null;
        String sql="INSERT INTO AN_EMPLOYEE(ID,NAME,SURNAME,AGE,JOB_TITLE,HOME_CITY,EXPERIENCE) " +
                " VALUES (AN_EMPLOYEE_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        try (Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,anEmployee.getName());
            ps.setString(2,anEmployee.getSurname());
            ps.setInt(3,anEmployee.getAge());
            ps.setString(4,anEmployee.getJobtitle());
            ps.setString(5,anEmployee.getHomecity());
            ps.setInt(6,anEmployee.getExperience());

            ps.execute();
            result="succes";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }
        return result;

    }

    @Override
    public AnEmployee getAnEmployeeById(long anemployeeId) throws Exception {
        AnEmployee anemployee=new AnEmployee();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ID,NAME,SURNAME,AGE,JOB_TITLE,HOME_CITY,EXPERIENCE FROM AN_EMPLOYEE\n" +
                "WHERE ACTIVE=1 AND ID=?";
        try{

            c=DBHelper.getConnection();
            if (c!=null){
                ps=c.prepareStatement(sql);
                ps.setLong(1,anemployeeId);
                rs=ps.executeQuery();
                while (rs.next()){

                    anemployee.setId(rs.getLong("ID"));
                    anemployee.setName(rs.getString("NAME"));
                    anemployee.setSurname(rs.getString("SURNAME"));
                    anemployee.setAge(rs.getInt("AGE"));
                    anemployee.setJobtitle(rs.getString("JOB_TITLE"));
                    anemployee.setHomecity(rs.getString("HOME_CITY"));
                    anemployee.setExperience(rs.getInt("EXPERIENCE"));

                }
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            JdbcUtility.close(c,ps,rs);
        }
        return anemployee;
    }

    @Override
    public String updateAnEmployee(AnEmployee anEmployee, long anemployeeId) throws Exception {
        String result=null;
        String sql="UPDATE AN_EMPLOYEE SET NAME=?,SURNAME=?,AGE=?,JOB_TITLE=?,HOME_CITY=?,EXPERIENCE=? " +
                " WHERE ID=? ";
        try (Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);){
            ps.setString(1,anEmployee.getName());
            ps.setString(2,anEmployee.getSurname());
            ps.setInt(3,anEmployee.getAge());
            ps.setString(4,anEmployee.getJobtitle());
            ps.setString(5,anEmployee.getHomecity());
            ps.setInt(6,anEmployee.getExperience());
            ps.setLong(7,anemployeeId);
            ps.executeUpdate();
            result="succes";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }
        return result;
    }

    @Override
    public String deleteAnEmployee(long anemployeeId) throws Exception {
        String result=null;
        String sql="UPDATE AN_EMPLOYEE SET ACTIVE=0 " +
                " WHERE ID=? ";
        try (Connection c=DBHelper.getConnection(); PreparedStatement ps=c.prepareStatement(sql);){
            ps.setLong(1,anemployeeId);
            ps.executeUpdate();
            result="succes";

        }catch (Exception ex){
            ex.printStackTrace();
            result="error";
        }
        return result;
    }
}
