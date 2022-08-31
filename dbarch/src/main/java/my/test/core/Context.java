package my.test.core;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Context {
	private static final Logger logger = LoggerFactory.getLogger(Context.class);

	private final String DB_TYPE   = "DBtype";
	private final String LOGIN     = "login";
	private final String PASS      = "pass";
	private final String SCHEMA    = "schema";
	private final String DISK_SIZE = "disksize";
	private final String TO_DISK   = "dumptodisk";
	private final String MEDIA_DIR = "mediadir";
	private final String DUMP_DIR = "dumpdir";
		
	private static Properties ctx;

	public Context() { this("config.cfg"); }
	public Context(String cfg) { load(cfg); }

	private void load(String cfgFile) {
		if (ctx == null) {
			logger.info("(Re)loading context.");
			ctx = new Properties();
			try (InputStream is = Context.class.getResourceAsStream("/"+cfgFile)) {
			  ctx.load(is);
			}
			catch (IOException ex) { ex.printStackTrace(); }
		}
	}

	// Format property string:
	private String fp(String prop) {
		String p = ctx.getProperty(prop);
		if ( p == null ) {
		  throw new IllegalArgumentException("Config parameter "+prop+" is not set.");
		}
		return p.toLowerCase().trim();
	}

	  public String getDbType() { return fp(DB_TYPE); }
	  public String getDbLogin() { return fp(LOGIN); }
	  public String getDbPass() { return fp(PASS); }
	  public String getDumpToDisk() { return fp(TO_DISK); }
	  public String getDumpDir() { return fp(DUMP_DIR); }
	  public String getMediaDir() { return fp(MEDIA_DIR); }
	  // Return max size (type Long) of single archive in bytes:
	  public long getArchiveDiskSize() {
		return Long.parseLong(fp(DISK_SIZE), 10)*1024*1024;
	  }

}
