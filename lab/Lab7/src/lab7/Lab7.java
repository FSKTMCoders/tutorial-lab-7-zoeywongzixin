/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7;

import java.util.Scanner;
import java.net.URL;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.io.IOException;


public class Lab7 {


    public static void main(String[] args) {
 
        
        try{
            URL u = new URL("https://www.fsktm.um.edu.my");
            URLConnection cnn = u.openConnection();
            InputStream stream = cnn.getInputStream();
            Scanner in = new Scanner(stream);
            
            PrintWriter out = new PrintWriter("index.htm");
            
            while(in.hasNextLine()){
                String line = in.nextLine();
                out.println(line);
            
            }
            
            in.close();
            out.close();
            
            System.out.println("Web page saved to index.htm");
       
        }
        
        catch (IOException e){
            System.out.println("IO Error:" + e.getMessage());
        
        }
        
    
    }
    
}
