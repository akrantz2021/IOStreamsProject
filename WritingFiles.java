import java.io.*;

public class WritingFiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("src/LocalData.txt");
		String data = "Hello there bob!";
		try {
			writeToFile(file, data);
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	
	public static void writeToFile(File file, String data) throws IOException {
		FileOutputStream output = null;
		try {
			output = new FileOutputStream(file);
			for (int i = 0; i < data.length(); i ++) {
				output.write((byte) data.charAt(i));
			}
		}
		finally {
			if (output != null) {
				output.close();
			}
		}
	}

}
