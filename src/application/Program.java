package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner fileScanner = null;
		
		System.out.print("Enter the file path: ");
		String strPath = sc.nextLine();

		// /home/felipe/temp/java_products/products.csv
		
		File readedFile = new File(strPath);
		boolean sumaryFolder = new File(readedFile.getParent()+"/out").mkdir();
		
		String sumaryFilePath = readedFile.getParent() + "/out/sumary.csv";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(sumaryFilePath))){
			fileScanner = new Scanner(readedFile);
			
			while (fileScanner.hasNextLine()) {
				String[] product = fileScanner.nextLine().split(",");
				String name = product[0];
				Double totalAmount = Double.parseDouble(product[1]) * Integer.parseInt(product[2]);
				
				bw.write(name + "," + totalAmount);
				bw.newLine();
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}

}
