package name.felixbecker.buildhivesecuritytest;

import org.junit.Test;

public class NoHupAnyoneTest extends CriminalParent {
	
	@Test // start top in test, expect no termination after jenkins finished! lets try..
	public void nohupWhereAreYouMyFriend() throws Exception{
		execute("file", "/usr/bin/nohup");
		execute("nohup","bash");
		execute("ps", "ax");
	}
}
