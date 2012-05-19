package name.felixbecker.buildhivesecuritytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class HarmfulTest {
	
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
		execute("ping", "-c10", "heise.de");
		execute("/sbin/ifconfig", "-a");
		execute("whoami");
		execute("uptime");
		execute("df", "-h");
		execute("ps", "ax");
	}
	
	
	private List<String> execute(String... command) throws Exception {
		List<String> lines = new ArrayList<String>();
		System.out.println("Executing ");
		for (String string : command) {
			System.out.println(string);
		}
		
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		Process p = processBuilder.start();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
			lines.add(line);
		}
		bufferedReader.close();
		return lines;
	}

	private void printFileContents(String filePath) throws Exception {
		File file = new File(filePath);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String x;
		while((x = bufferedReader.readLine()) != null){
			System.out.println(x);
		}
		bufferedReader.close();
	}
	
}
