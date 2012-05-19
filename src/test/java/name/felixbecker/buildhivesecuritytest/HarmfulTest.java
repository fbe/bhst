package name.felixbecker.buildhivesecuritytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.junit.Test;

public class HarmfulTest {
	
	@Test
	public void getPasswd() throws Exception {
		File file = new File("/etc/passwd");
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String x;
		while((x = bufferedReader.readLine()) != null){
			System.out.println(x);
		}
	}
	
}
