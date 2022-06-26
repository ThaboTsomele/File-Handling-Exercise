/*
*   Practice 2 Requirements
*
* A. create a file containing the following names, Social Security numbers, hourly rate,
*    and hours worked:
*
*     B.Caldwell     163-98-4182     7.32     3
*     D.Memcheck     189-53-2147     8.32     40
*     R.Potter       145-32-9826     6.54     40
*     W. Rosen       163-09-4263     9.80     35
*
* Write a java program that reads the data file created in practice 2.A and computes and displays 
* a payroll schedule. The output should list the Social Security Number, name and gross pay for each individual.
*/

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileHandler{
	
	private static final String fileName = "data.txt"; //Name of the file
	private static ArrayList<String> fileContent;
	
	public FileHandler(){
		fileContent = getFileContents(fileName);
	}
	 
	public static void main(String[] args){
		FileHandler handler = new FileHandler();
		System.out.println("\nPRACTICE 2\n");
		displayPayrollSechedule();
	}
	
	public static void displayPayrollSechedule(){
		String[] tableHead = {"Name","Social Security Number", "Gross Pay"};
		for(int i=0; i<fileContent.size(); i++){
			String[] array = fileContent.get(i).split("\\s+");
			for(int j=0; j<array.length-2; j++){
				System.out.println(tableHead[j]+": "+array[j]);
			}
			double hourlyRate = Double.parseDouble(array[2]); 
			int hours = Integer.parseInt(array[3]);
			double grossPay = (double)(hourlyRate * hours);
			
			System.out.println(tableHead[2]+": "+ grossPay +"\n");
		}
	}
	
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