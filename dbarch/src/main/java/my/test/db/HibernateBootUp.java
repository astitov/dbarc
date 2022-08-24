package my.test.db;

import my.test.core.Record;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import antlr.collections.List;
// import org.hibernate.boot.Environment;

public class HibernateBootUp {
	private static StandardServiceRegistry reg;
	private static SessionFactory sf;
	
	public static SessionFactory getSessionFactory() {
		if (sf == null) {
			try {
				StandardServiceRegistryBuilder regBuilder = 
						new StandardServiceRegistryBuilder();
				Map<String, Object> settings = new HashMap<>();
				
				settings.put(Environment.DRIVER, "oracle.jdbc.OracleDriver");
				settings.put(Environment.URL, "jdbc:oracle:thin:@10.1.10.27:1521:orcl");
				settings.put(Environment.USER, "irkutsk_image");
				settings.put(Environment.PASS, "i");
				
				regBuilder.applySettings(settings);
				reg = regBuilder.build();
				MetadataSources sources = new MetadataSources(reg).addAnnotatedClass(Record.class);
				Metadata metadata = sources.getMetadataBuilder().build();
				sf = metadata.getSessionFactoryBuilder().build();
			} catch (Exception ex) {
				if (reg != null) {
					StandardServiceRegistryBuilder.destroy(reg);
				}
				ex.printStackTrace();
			}
		}
		return sf;
	}
}
