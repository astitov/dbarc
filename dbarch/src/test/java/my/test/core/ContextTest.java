package my.test.core;

import org.junit.*;
import static org.junit.Assert.*;

public class ContextTest {

  private Context ctx = new Context();

  @Before
  public void initTest() {
//    ctx = Context.read();
  }

  @After
  public void afterTest(){
    ctx = null;
  }

  @Test
  public void testDbType() throws Exception {
    System.out.println("getDBtype >>>> "+ctx.getDbType());
    assertEquals("oracle", ctx.getDbType());
  }
  
  @Test
  public void testMediaDir() throws Exception {
    System.out.println("getMediaDir >>>>"+ctx.getMediaDir());
    assertEquals("/tmp/media", ctx.getMediaDir());
  }

  @Test
  public void testDiskSize() throws Exception {
    assertEquals(4096*1024*1024L, ctx.getArchiveDiskSize());
    System.out.println("getArchiveDiskSize >>> "+ctx.getArchiveDiskSize());
  }
}


