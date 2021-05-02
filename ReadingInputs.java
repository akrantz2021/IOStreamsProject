import java.io.*;
import java.util.ArrayList;

public class ReadingInputs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src/LocalData.txt");
		try {
			System.out.println(getFileLine(file, 0));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
	
	public static String getInputLine() {
		ArrayList<Character> arr = new ArrayList<Character>();
		String str = "";

		try {
			int i;
			while ((i = System.in.read()) != 10) {
				arr.add((char) i);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			for (int i = 0; i < arr.size(); i++) {
				str += arr.get(i);
			}
 		}
		return str;
	}
	
	public static String getFileData(File file) throws IOException {
		String str = "";
		FileInputStream input = null;
		try {
			input = new FileInputStream(file);
			System.out.println("input size = " + input.available() + " bytes");
			int i;
			while ((i = input.read()) != -1) {
				str += (char) i;
			}
		}
		finally {
			if (input != null) {
				input.close();
			}
		}
		return str;
		
	}
	
	public static String getFileLine(File file, int line) throws IOException{
		String str = null;
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String lineContent;
		int lineCount = 0;
		try {
			while((lineContent = br.readLine()) != null) {
				if (lineCount == line) {
					str = lineContent;
					break;
				} else {
					lineCount++;
				}
			}
		}
		finally {
			fr.close();
			br.close();
		}
		return str;
	}

}
