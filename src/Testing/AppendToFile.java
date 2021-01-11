package Testing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {

	private static String FILENAME = "E:\\Master\\";

	public AppendToFile(String FileName) {
		FILENAME += FileName;
	}

	public void Writter(String data) {

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File(FILENAME);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);

			bw.write(data);
			bw.newLine();

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	}

}