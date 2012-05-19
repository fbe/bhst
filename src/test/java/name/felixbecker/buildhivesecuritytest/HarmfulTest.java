package name.felixbecker.buildhivesecuritytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HarmfulTest extends CriminalParent {
	
	@Test
	public void getFiles() throws Exception {
		printFileContents("/etc/passwd");
		printFileContents("/proc/mounts");
//		printFileContents("/root/.ssh/authorized_keys");
	}
	
	@Test
	public void execCommands() throws Exception {
//		execute("find", "/");
//		List<String> lines = execute("find", "/etc");
//		for (String string : lines) {
//			execute("cat", string);
//		}
	//	execute("ping", "heise.de");
		execute("/sbin/ifconfig", "-a");
		execute("whoami");
		execute("uptime");
		execute("df", "-h");
		execute("ps", "ax");
	}
	
	

	
}
