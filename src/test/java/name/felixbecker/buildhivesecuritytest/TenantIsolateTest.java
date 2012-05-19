package name.felixbecker.buildhivesecuritytest;

import org.junit.Test;

public class TenantIsolateTest extends CriminalParent {
	
	@Test
	public void whatIsThat() throws Exception{
		printFileContents("/usr/bin/tenant-isolate");
	}
}
