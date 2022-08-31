package my.test.DBArch;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.test.core.Record;
import my.test.db.*;
import my.test.zip.*;


public class App {

	private static final String OUTFILE = "/tmp/image.zip";

	static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main( String[] args) {
		
		HashSet<Record> hs = new HashSet<>();

		try {
			hs = OracleRecords.getRecords();
		}
		catch (SQLException e) { e.printStackTrace(); }
		
		Archive a = new Archive(OUTFILE);
		a.open();
		
		for (Record r : hs) {
				try {
					OracleRecords.setBin(r);
					logger.info("Free : " + a.addRecord(r));
					// r.setBin(null);
					r = null;
				}
				catch (SQLException e) { e.printStackTrace(); }
		}

		a.close();
	}
}


