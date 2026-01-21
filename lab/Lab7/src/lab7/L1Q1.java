/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class L1Q1 {
    public static void main(String[] args){
        //String[] codes = {"WXES1116","WXES1115","WXES1110","WXES1112"};
        //String[] names = {"Programming I", "Data Structure", "Operating System", "Computing Mathematics I"};         
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("coursename.dat"));
            outputStream.writeUTF("WXES1116");
            outputStream.writeUTF("Programming I");

            outputStream.writeUTF("WXES1115");
            outputStream.writeUTF("Data Structure");

            outputStream.writeUTF("WXES1110");
            outputStream.writeUTF("Operating System");

            outputStream.writeUTF("WXES1112");
            outputStream.writeUTF("Computing Mathematics I");
            
            outputStream.close();
        }catch (IOException e){
            System.out.println("Problem with file output");
        }
        
        

        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("coursename.dat"));
            Scanner sc = new Scanner(System.in);
            System.out.print("Course code:");
            String inputCode = sc.nextLine();
            
            boolean found = false;
            while (true){
                String codeFromFile = inputStream.readUTF(); 
                String nameFromFile = inputStream.readUTF();
                
                if(codeFromFile.equalsIgnoreCase(inputCode)){
                    System.out.printf("The course name is: %s\n",nameFromFile);
                    found = true;
                    break;
                }   
            }

            inputStream.close();
        }catch(EOFException e){
            System.out.println("The course code was not found");
        }catch(IOException e){
            System.out.println("Problem with file input");
        }
    }
    
}
