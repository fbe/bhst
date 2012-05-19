package name.felixbecker.buildhivesecuritytest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 ______ _                  __  __ _   _               __   ___  
|  ____(_)                |  \/  (_) (_)             /_ | / _ \ 
| |__   _  ___  ___  ___  | \  / | ___  _ __  _ __    | || | | |
|  __| | |/ _ \/ __|/ _ \ | |\/| |/ _ \| '_ \| '_ \   | || | | |
| |    | |  __/\__ \  __/ | |  | | (_) | |_) | |_) |  | || |_| |
|_|    |_|\___||___/\___| |_|  |_|\___/| .__/| .__/   |_(_)___/ 
                                       | |   | |                
                                       |_|   |_|                

 */
public abstract class CriminalParent {
	
	protected List<String> execute(String... command) throws Exception {
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
	
	protected void executeNonBlocking(String... command) throws IOException{
		ProcessBuilder processBuilder = new ProcessBuilder(command);
		Process p = processBuilder.start();
	}

	protected void printFileContents(String filePath) throws Exception {
		File file = new File(filePath);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String x;
		while((x = bufferedReader.readLine()) != null){
			System.out.println(x);
		}
		bufferedReader.close();
	}
}
