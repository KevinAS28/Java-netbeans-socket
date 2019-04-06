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

public class Socket0 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String file = "/root/programming/python_saya/RPL/profile_pictures/1017007684.jpg";
        tools.Send(tools.ReadFile(file));
        System.out.println("Done");
    }
}
