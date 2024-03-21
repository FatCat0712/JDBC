package sonhai.net.bai_14;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import model.Dog;
import util.HibernateUtils;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
	
    public static void main( String[] args )
    {
    	//Transient
//    	Dog dog1 = new Dog();
//    	dog1.setId(5);
    	
//    	Dog dog2 = new Dog("Bully","US",60);
    	Dog dog3 = new Dog();
    	dog3.setId(14);
    	
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        try {
        	if(sessionFactory != null) {
        		Session session = sessionFactory.openSession();
        		Transaction tr = session.beginTransaction();
        		//Persistent
        		//dog1 = session.find(Dog.class, dog1.getId());
        		//session.saveOrUpdate(dog2);
        		//Detach => Persistent
        		//dog2.setOrigin("France");
        		session.remove(dog3);
        		tr.commit();
        		session.close();
        		
        	}
        }catch (Exception e) {
			e.printStackTrace();
		}
        
        
        System.out.println(dog3);
    }
}
