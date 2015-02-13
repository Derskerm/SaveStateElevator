import java.io.*;
import java.util.Scanner;

public class FileIO {
	
	private String lineSeparator;
	
	public FileIO() {
		lineSeparator = System.getProperty("line.separator");
	}
	
	public String readFile(String filename) {
		BufferedReader breader = null;
		FileReader reader;
		String fileData = null;
		Scanner in = null;
		try {
			reader = new FileReader(filename);
			breader = new BufferedReader(reader);
			in = new Scanner(breader);
			StringBuffer changingFileData = new StringBuffer();
			while (in.hasNextLine()) {
				String input = in.nextLine();
				changingFileData.append(input);
				changingFileData.append(lineSeparator);
			}
			fileData = changingFileData.toString();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null)
				in.close();
		}
		return fileData;
	}
	
	public void writeFile(String filename, String data) {
		BufferedWriter bwriter = null;
		FileWriter writer = null;
		try {
			writer = new FileWriter(filename);
			bwriter = new BufferedWriter(writer);
			bwriter.write(data);
			bwriter.flush();
		} catch (FileNotFoundException e) {
//			Better reaction than printing a stack trace
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bwriter != null) {
				try {
					bwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public Object readObject(String filename) {
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		Object data = null;
		try {
			fis = new FileInputStream(filename);
			ois = new ObjectInputStream(fis);
			data = ois.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
//			Better reaction than printing a stack trace
		} catch (FileNotFoundException e) {
			e.printStackTrace();
//			Better reaction than printing a stack trace
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return data;
	}
	
	public void writeObject(String filename, Object data) {
		ObjectOutputStream oos = null;
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(filename);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.flush();
		} catch (FileNotFoundException e) {
//			Better reaction than printing a stack trace
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
}
