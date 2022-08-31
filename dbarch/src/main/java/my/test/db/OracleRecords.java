package my.test.db;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

import my.test.core.Record;
import java.util.HashSet;

public class OracleRecords {

	private static final DataSource pool = ConnectionPool.create();
	
	public static HashSet<Record> getRecords() throws SQLException {
		HashSet<Record> records = new HashSet<>();
		Connection conn = pool.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select medcode, part_name, rowid from media_file");
		while (rs.next()) {
			records.add( new Record(
					rs.getString(1),
					rs.getString(2),
					rs.getString("rowid"))
			);
		}
		conn.close();
		return records;
	}
	
	public static void setBin(Record r) throws SQLException {
		Connection conn = pool.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select bin from media_file where rowid='" + r.getRowid() + "'");
		rs.next();
		r.setBin(rs.getBytes(1));
		conn.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
