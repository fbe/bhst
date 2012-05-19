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
	
	
	private void printFileContents(String filePath) throws Exception {
		File file = new File(filePath);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String x;
		while((x = bufferedReader.readLine()) != null){
			System.out.println(x);
		}
	}
	
}
