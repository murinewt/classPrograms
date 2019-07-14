import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.ssg.hashcode.model.Model;

public class Main {

	public static void main(String[] args) {
		InputStream inputStream = null;
		OutputStream outputStream = null;

		try {
			// read this file into InputStream
			inputStream = new FileInputStream("F:\\Java\\Pizza\\src\\com\\newt\\pizza\\files\\small.in");
			
			File f = new File("F:\\Java\\Pizza\\src\\com\\newt\\pizza\\files\\small.in");
			
			Model m = new Model();
				
			m.buildFromFile(f);
			
			System.out.println(m);

			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(new File("F:\\Java\\Pizza\\src\\com\\newt\\pizza\\files\\out.txt"));

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
