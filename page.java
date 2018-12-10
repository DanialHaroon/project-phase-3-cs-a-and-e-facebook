/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.List;

/**
 *
 * @author vostro 14
 */
public class page extends collection{
    
   public page(){
    
    }
    public page(int id,String name, String adminid,String desc, List<post> a,List<accounthandler> m,String imgpath){
        super( id, name,  adminid, desc,  a,imgpath);
        super.setmembers(m);
    }
    @Override
    public  void addpost(String content, int userid, int collectionid ){
         dbconnection db=new dbconnection();
         db.addpost(content, userid);
         //as this is a group post
         db.addpostgroup(collectionid, userid);
    }
    @Override
    public void createcollection(String name, int userid, String desc,String imgpath){
        dbconnection db=new dbconnection();
        db.addpage(userid, desc, name,imgpath);
    }
}
