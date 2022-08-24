package my.test.core;

import org.junit.*;
import static org.junit.Assert.*;

public class ContextTest {

  private Context ctx;

  @Before
  public void initTest() {
    ctx = new Context();
  }

  @After
  public void afterTest(){
    ctx = null;
  }

  @Test
  public void testDbType() throws Exception {
    System.out.println("getDBtype >>>> "+ctx.getDbType());
  }
  
/*  
  @Test
  public void testDumpToDisk() throws Exception {
    System.out.println("getDumpToDisk >>>>"+ctx.getDumpToDisk());
  }
*/  

  @Test
  public void testDiskSize() throws Exception {
    assertEquals(4096*1024*1024L, ctx.getArchiveDiskSize());
    System.out.println("getArchiveDiskSize >>> "+ctx.getArchiveDiskSize());
  }
}


