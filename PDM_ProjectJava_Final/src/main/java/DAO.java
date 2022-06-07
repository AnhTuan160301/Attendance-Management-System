
import com.mycompany.pdm_project_final.connectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author A.TUAN
 */
public class DAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Statement st = null;
    
    public ArrayList<Student> getListStudent(String classID){
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select s.studentID, s.stuName from Student as s"
                +",Class as c where c.classID = ? and c.studentID = s.studentID";
        try {
            conn = new connectDB().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, classID);
            rs = ps.executeQuery();
            while (rs.next()){
                Student s = new Student(rs.getString(1),rs.getString(2));
                list.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();   
        }
        
        return list;    
    }
    public boolean insertAbsenceStudent(String classID, String studentID, Date absenceDate){
        String sql = "Insert into Absence values (?,?,?)";
        try {
            conn = new connectDB().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, classID);
            ps.setString(2, studentID);
            ps.setDate(3, (java.sql.Date) absenceDate);
            
            return ps.executeUpdate()>0;
        } catch (Exception e) {
        }
        return false;
        
    }
    public ArrayList<Student> getAbsenceStudent(String classID,String studentID){
        ArrayList<Student> list = new ArrayList<>();
        String sql = "Select s.studentID,s.stuName,a.absenceDate from Student as s, "
                + "Absence as a where a.classID = ? and s.studentID = ? and a.studentID = s.studentID";
        try {
            conn = new connectDB().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, classID);
            ps.setString(2, studentID);
            rs = ps.executeQuery();
            while(rs.next()){
                Student s = new Student(rs.getString(1),rs.getString(2), rs.getDate(3));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;    
    }
    
    public ResultSet getQueryResultSet(String query){
        try {
            conn = new connectDB().getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(query);   
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }
    
}
