package my.test.zip;

import my.test.core.*;
import my.test.core.Record;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.io.IOException;
import java.io.ByteArrayInputStream;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.outputstream.ZipOutputStream;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionMethod;


public class Archive
{
  private final Path file;
  private static long maxSize = 10*1024*1024;
  private long currentSize = 0;
  private ZipFile zout;

  public Archive (Path file) {
    this.file = file;
  }

  public Archive (String file) {
    this(Paths.get(file));
  }


  public void open()
  {
    if (Files.isRegularFile(file))
    {
     try { currentSize = Files.size(file); }
     catch(IOException ex) {}
    }
    zout = new ZipFile(file.toFile());
  }


  public long addRecord (Record r)
  {
    ZipParameters zp = new ZipParameters();

    zp.setFileNameInZip(r.getMedcode() + "/" + r.getPartname()); 
    zp.setCompressionMethod(CompressionMethod.STORE);
    zp.setEntrySize(r.getSize());

    try {
      zout.addStream(new ByteArrayInputStream(r.getBin()), zp);
    } catch(ZipException zex) {}

    currentSize += r.getSize();
    return maxSize - currentSize;
  }


  public void close()
  { 
    try {
      zout.close();
    }
    catch (IOException ex){ ex.printStackTrace(); }
  }

}


