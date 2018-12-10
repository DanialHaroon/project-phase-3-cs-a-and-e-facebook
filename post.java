/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author vostro 14
 */
public class post {
    int postid; //unique
    int userid; //id of a user who added it
    String details;
    
    public post(){
    
    }
    public post(int a , int b, String c)
    {
        this.postid= a;
        this.userid=b;
        this.details=c;
    }
     public List<post> returallpost(int userid){
         dbconnection db=new dbconnection();
         List<post> allposts = new ArrayList<post>();
         try{
           ResultSet ab= db.returnuserposts(userid);
         while (ab.next()) {
                 int x=  ab.getInt("postid");
                 int y= ab.getInt("userid");
                 String z= ab.getString("content");
                 
                  post temp = new post(x,y,z);
                  allposts.add(temp);
            }
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
            
        }
         return allposts;
     }
    
}
