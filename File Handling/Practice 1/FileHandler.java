/*
*	Practice 1A - Requirements
*
* 1. A. Create a file containing the following data:
*
*	H.Baker     614 Freeman St.     Orange NJ
*	D.Rosso     83 Chambers St.     Madison NJ
*	K.Tims      891 Ridgewood Rd.   Millburn NJ
*	B.Williams  24 Tremont Ave.     Brooklyn NY
*
*   B. Write a program to read and display the data file created in Practice 1.A using the following output format
*
*		Name:
*	  	Address:
*		City, State
*
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler{
	
	private static final String fileName = "data.txt"; //Name of the file
	private static ArrayList<String> fileContent;
	
	public FileHandler(){
		fileContent = getFileContents(fileName);
	}
	 
	public static void main(String[] args){
		FileHandler handler = new FileHandler();
		System.out.println("\nPRACTICE 1\n");
		displaData();
	}
	
	public static void displaData(){
		String[] tableHead = {"Name","Address","City, State"};
		for(int i=0; i<fileContent.size(); i++){
			String[] array = fileContent.get(i).split(",");
			for(int j = 0; j<array.length; j++){
				System.out.println(tableHead[j]+": "+array[j].trim());
			}
			System.out.println();
		}
	}
	
	/*
	*
	* Reads file and return ArrayList as results 
	*
	*/
	
	public static ArrayList<String> getFileContents(String filePath){
		ArrayList<String> fileContents = new ArrayList<String>();
		try{
			BufferedReader file = new BufferedReader(new FileReader(filePath));
			String line;
			while((line = file.readLine()) != null){
				fileContents.add(line);
			}
			file.close();
		}catch(FileNotFoundException e){
			System.out.println("File not available");
		}catch(IOException e){
			e.printStackTrace();
		}
		return fileContents;
	}
}