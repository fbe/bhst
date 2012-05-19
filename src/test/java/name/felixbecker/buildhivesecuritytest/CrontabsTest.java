package name.felixbecker.buildhivesecuritytest;

import org.junit.Test;

public class CrontabsTest extends CriminalParent {
	@Test
	public void crontabsAnyone() throws Exception{
		execute("find", "/var/spool/cron/");
	}
}
