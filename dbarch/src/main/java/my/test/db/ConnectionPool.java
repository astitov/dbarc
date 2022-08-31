package my.test.db;

import com.zaxxer.hikari.HikariDataSource;

import my.test.DBArch.App;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Level;

public class ConnectionPool {
	
	// Turn off Hikari DEBUG logging.
	static final ch.qos.logback.classic.Logger hikariLogger = 
			(ch.qos.logback.classic.Logger) LoggerFactory.getLogger("com.zaxxer.hikari");
	
	public static DataSource create() {
		hikariLogger.setLevel(Level.INFO);
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@10.1.10.27:1521:orcl");
		ds.setUsername("irkutsk_image");
		ds.setPassword("i");
		ds.setPoolName("OracleCP");
		return ds;
	}
}
