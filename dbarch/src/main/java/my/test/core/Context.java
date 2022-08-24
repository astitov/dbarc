package my.test.core;

import java.util.Properties;
//import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class Context {

  private Properties context = new Properties();
 
  private final String DB_TYPE   = "DBtype";
  private final String LOGIN     = "login";
  private final String PASS      = "pass";
  private final String SCHEMA    = "schema";
  private final String DISK_SIZE = "disksize";
  private final String TO_DISK   = "dumptodisk";

  public Context () {
    this("config.cfg");
  }

  public Context (String cfgFile) {
    try (InputStream is = getClass().getResourceAsStream("/"+cfgFile)) {
      context.load(is);
    }
    catch (IOException ex) {
        ex.printStackTrace();
    }
  }

  // Format property string
  private String fp(String prop) {
    String p = context.getProperty(prop);
    if ( p == null ) {
      throw new IllegalArgumentException("Config parameter "+prop+" is not set.");
    }
    return p.trim();
  }

  public String getDbType() { return fp(DB_TYPE); }
  public String getDbLogin() { return fp(LOGIN); }
  public String getDbPass() { return fp(PASS); }
  public String getDumpToDisk() { return fp(TO_DISK); }

  // Return max size (type Long) of single archive in bytes.
  public long getArchiveDiskSize() {
    return Long.parseLong(fp(DISK_SIZE), 10)*1024*1024;
  }

}
