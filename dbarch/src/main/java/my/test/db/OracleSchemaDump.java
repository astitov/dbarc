/*
 * Oracle datapump as a collable stored procedure.
 * 
 * Dump file is *always* created on  *DB server* side,
 * which can be a *remote* machine.
 * 
 * https://rolfje.wordpress.com/2015/01/02/importexport-an-oracle-schema-using-jdbc/
 * https://docs.oracle.com/database/121/ARPLS/d_datpmp.htm#ARPLS356 
 * 
 */

package my.test.db;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;

public class OracleSchemaDump {

	private static final String EXPORT_DIR = "C:\\";
	private static final DataSource pool = ConnectionPool.create();
		 
	public void exp(String schema, String fileName) 
				throws SQLException, IOException {
	  String sql = getFileContents("export.sql");
	  Connection conn = pool.getConnection();

	  PreparedStatement pStmt = conn.prepareStatement(sql);
	  pStmt.setString(1, schema.toUpperCase());
	  pStmt.setString(2, EXPORT_DIR);
	  pStmt.setString(3, fileName);
	  pStmt.execute();
	}
/*	 
	public void imp(String schema, String fileName) 
				throws IOException, SQLException {
	  String sql = getFileContents("import.sql");
	  PreparedStatement pStmt = pool
					.getConnection()
					.prepareStatement(sql);
	  pStmt.setString(1, schema.toUpperCase());
	  pStmt.setString(2, EXPORT_DIR);
	  pStmt.setString(3, fileName);
	  pStmt.execute();
	}
*/	 
	private String getFileContents(String fileName) 
				   throws IOException {
	  InputStream in = this.getClass()
					   .getResourceAsStream("/"+fileName);
	  return IOUtils.toString(in, "UTF-8");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
