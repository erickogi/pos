package iteration_one;

import java.sql.ResultSet;
import javax.swing.table.TableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author kimani kogi
 */
public class User_2 {

    static TableModel resultSetToTableModel(ResultSet result) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    private int id;
    private String fname;
    private String lname;
    private int age;
    private String updated_at;

    //To change body of generated methods, choose Tools | Templates.
    
    
    
    public User_2(int Id,String Fname,String Lname,int Age,String Updated_at)
    {
        this.id = Id;
        this.fname = Fname;
        this.lname = Lname;
        this.age = Age;
        this.updated_at=Updated_at;
    }
    
    public int getId()
    {
        return id;
    }
    
    public String getFname()
    {
        return fname;
    }
    
    public String getLname()
    {
        return lname;
    }
    
    public int getAge()
    {
        return age;
        
    }
    public String getUpdated_at()
    {
        return updated_at;
    }

}
