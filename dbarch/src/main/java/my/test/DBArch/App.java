package my.test.DBArch;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.test.core.*;
import my.test.db.*;
import my.test.zip.*;


public class App {

  private static final String INFILE = "/tmp/image.png"; 
  private static final String OUTFILE = "/tmp/image.zip";

  private static Context context = new Context();

  static final Logger logger = LoggerFactory.getLogger(App.class);

  public static void main( String[] args) {
    context = new Context();

	OracleSchemaDump o = new OracleSchemaDump();
	try { o.exp("irkutsk", "irkutsk.dmp"); } catch(SQLException e) {} catch (IOException ioex) {} 

/*
	Session session = HibernateBootUp.getSessionFactory().openSession();
	List<Record> arr = session.createQuery("from Record").list();
	
	System.out.println("List items: " + arr.size());
	
    Archive a = new Archive(OUTFILE);
    a.open();
    for (int i = 0; i < 1000; i++ ) {
		System.out.println( i + " : " + a.addRecord(arr.get(i)) );
    }
    a.close();
*/
  }
}


