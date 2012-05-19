package name.felixbecker.buildhivesecuritytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class HarmfulTest {
	
	@Test
	public void getFiles() throws Exception {
		printFileContents("/etc/passwd");
		printFileContents("/proc/mounts");
	}
	
	@Test
	public void execCommands() throws Exception {
		execute("find", "/");
	}
	
	
	private void execute(String... command) throws Exception {
		System.out.println("Executing " + command);
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		Process p = processBuilder.start();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while((line = bufferedReader.readLine()) != null){
			System.out.println(line);
		}
		bufferedReader.close();
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
