/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket0;

/**
 *
 * @author root
 */
import java.util.Formatter;
import java.io.*;
import java.net.*;
public class tools 
{
    
    public static int createFile(String file) throws Exception
    {
        
            Formatter yay = new Formatter(file);
            return 0;
    }
    public static void writeFile(String file, byte data[])
    {
        File yay = new File(file);
        if (!(yay.exists()))
        {
            System.out.println("Error while writing file");
            return;
        }
        try{
            
            FileOutputStream wow = new FileOutputStream(yay);
            wow.write(data);
            return;
        }
        catch(Exception err)
        {
            System.out.println("Error while writing file " + String.valueOf(err));
            return;
        }
    }
        public static void writeFile(String file, String data)
    {
        writeFile(file, data.getBytes());
    }
    public static byte[] ReadFile(String file)
    {
        byte to_return[] = {'a'};
        File yay = new File(file);
        
        if (!(yay.exists()))
        {
            System.out.println("file "+ file + " doesn't exists\n");
            return to_return;
        }
        to_return = new byte[(int)yay.length()+1];
        try{
            FileInputStream wow = new FileInputStream(yay);
            wow.read(to_return);
            wow.close();
            return to_return;
        }
        catch(Exception err)
        {
            System.out.println("Erro while reading file " + String.valueOf(err));
            return to_return;
        }
        
        
    }
    public static String ip = "127.0.0.1";
    public static int port = 4321;
    public static void Send(byte data[])
    {
        Socket connection;
        try{
         connection = new Socket(ip, port);
         connection.setReuseAddress(true);
         DataOutputStream writer = new DataOutputStream(connection.getOutputStream());
         writer.write(data);
         connection.close();
        }catch (Exception err)
        {
            
        }
    }
    public static byte[] recv()
    {
        return recv(1024);
    }
    public static byte[] recv(int buff)
    {
        ServerSocket yay;
        byte []buffer = new byte[buff];
        try{
            yay  = new ServerSocket(port);
            yay.setReuseAddress(true);
            Socket clientsocket = yay.accept();
            DataInputStream o = new DataInputStream(clientsocket.getInputStream());
            o.read(buffer);
            o.close();
            yay.close();
            return buffer;
                 
        }
        catch (Exception err){
            System.out.println("Error while Sending " + String.valueOf(err));
            return buffer;
        }
    }
}