package net.sonhai.bai_15;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;

import antlr.collections.List;
import dao.PersonDAO;
import model.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//      Person p1 = new Person("Nguyen Van Hiep",Date.valueOf("1986-05-19"),null);
//    	
//       Person p2 = new Person("Tran Thi Tuyen",Date.valueOf("1985-06-01"),p1);
//       p1.setSpouse(p2);;
//       PersonDAO.getInstance().insert(p1);
    	
//    	ArrayList<Object[]> lst = (ArrayList<Object[]>) PersonDAO.getInstance().getMarriageList();
//    	for(Object[] o: lst) {
//    		String p1 = o[0] + "";
//    		String p2 = o[1] + "";
//    		String p3 = o[2] + "";
//    		String p4 = o[3] + "";
//    		System.out.println(p1+"("+p2+")"+" get married to "+p3+"("+p4+")");
//    	}
    	
//    	Person p3 = new Person("Song Joong Ki",new Date(System.currentTimeMillis()),null);
//    	Person p4 = new Person("Song Hye Kyo",new Date(System.currentTimeMillis()),p3);
//    	p3.setSpouse(p4);
//    	PersonDAO.getInstance().insert(p3);
    	
    	Person p5 = new Person("Harry Lu",new Date(System.currentTimeMillis()),null);
    	Person p6 = new Person("Midu",new Date(System.currentTimeMillis()),p5);
    	
//    	PersonDAO.getInstance().insert(p6);
    	
    	p5.setId(2);
    	p5.setSpouse(p6);
    	p6.setId(1);
    	PersonDAO.getInstance().update(p5);
    	
    	
    	
    	

      
    	
       
       
       
    }
}
