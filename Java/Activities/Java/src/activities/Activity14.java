package activities;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;

public class Activity14 {

	public static void main(String[] args) throws IOException {
		
		String filePath = "newfile.txt";
		boolean fileStatus = false;
		File file = new File(filePath);
		if (!file.exists()) {   
			file.createNewFile();   
			fileStatus = true;
		}

		if(fileStatus)
		{
			System.out.println("File has been created successfully.");
		}
		else
		{
			System.out.println("File alreay exists.");
		}		

		String sentence = "This sentence will be written in the file";

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);

		bw.write(sentence);
		bw.close();

		BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
		System.out.println("The file contains text: "+br.readLine());

		File fileUtil = FileUtils.getFile(filePath);
	
		System.out.println("Data in file: " + FileUtils.readFileToString(fileUtil, "UTF8"));

		File dir = new File("resources");

		FileUtils.copyFileToDirectory(file, dir);

		File newFile = FileUtils.getFile(dir, "newfile.txt");

		String newData = FileUtils.readFileToString(newFile, "UTF8");
		
		System.out.println("Data from new file :"+newData);
		
	}

}
