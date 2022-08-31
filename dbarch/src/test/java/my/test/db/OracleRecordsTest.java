package my.test.db;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import my.test.core.Record;

public class OracleRecordsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetRecords() {
		try {
			HashSet<Record> hs = OracleRecords.getRecords();
			System.out.println("HS size >>>> " + hs.size());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
