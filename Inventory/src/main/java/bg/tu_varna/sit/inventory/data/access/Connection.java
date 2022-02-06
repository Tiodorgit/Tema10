package bg.tu_varna.sit.inventory.data.access;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Connection {
    private static final Logger log = Logger.getLogger(Connection.class);
    private static SessionFactory sessionFactory;
    static {
        try{
            Configuration configuration = new Configuration();
            configuration = configuration.configure( "hibernate.cfg.xml" );
            sessionFactory = configuration.buildSessionFactory();
        }catch (Throwable ex){
            log.error("Initial SessionFactory created failed " + ex);
        }
    }

    public static Session openSession(){
        return sessionFactory.openSession();
    }

    public static void openSessionClose(){
        sessionFactory.close();
    }
}