package my.test.DBArch;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

  public void start(BundleContext context) throws Exception {
    System.out.println("Starting activator");
    new App();
  }

  public void stop(BundleContext context) throws Exception {
    System.out.println("Stopping activator");
  }
 
}


