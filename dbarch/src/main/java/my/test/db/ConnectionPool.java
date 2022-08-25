package my.test.db;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;

public class ConnectionPool {
	public static DataSource create() {
		HikariDataSource ds = new HikariDataSource();
		ds.setJdbcUrl("jdbc:oracle:thin:@10.1.10.27:1521:orcl");
		ds.setUsername("i");
		ds.setPassword("i");
		return ds;
	}
}
