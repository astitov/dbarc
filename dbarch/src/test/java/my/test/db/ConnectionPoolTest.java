package my.test.db;

import static org.junit.Assert.*;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

public class ConnectionPoolTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws SQLException {
		DataSource pool = ConnectionPool.create();
		try ( Connection conn = pool.getConnection(); ) {
			assertTrue(conn.isValid(0));
		}
	}

}
