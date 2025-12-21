/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package t7q1;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.EOFException;
import java.io.IOException;

        
// import java.io.*;

import java.util.Scanner;


public class T7Q1 {


    public static void main(String[] args) {
        
        
    try {
        ObjectOutputStream out = 
            new ObjectOutputStream(new FileOutputStream("coursename.dat"));
            
               /// for binary file, we use writeUTF() to write String & ObjectOutputStream       
        out.writeUTF("WXES1116");
        out.writeUTF("Pragramming");
        
        out.writeUTF("WXES1115");
        out.writeUTF("Data Structure");
        
        out.writeUTF("WXES1110");
        out.writeUTF("Operating System");
        
        out.writeUTF("WXES1112");
        out.writeUTF("Computing Mathematics I");

        out.close();
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter course code");
        String inputCode = sc.nextLine();
        
        ObjectInputStream in = 
                new ObjectInputStream(new FileInputStream("coursename.dat"));
        
        boolean found = false;
        
        try{
            while (true){
                String code = in.readUTF();
                String name = in.readUTF();
                
                if (code.equals(inputCode)){
                    System.out.println("Course Name" + name);
                    found = true;
                }
            } 
        }catch (EOFException e){
        
        }
        
        in.close();
        
        if(!found){
            System.out.println("Course code not found");
        }
    }catch (IOException e){
        System.out.println("ID Error");
    }
           
           }
       }



