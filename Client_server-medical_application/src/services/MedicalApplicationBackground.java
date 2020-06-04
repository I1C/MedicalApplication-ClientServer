package services;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class MedicalApplicationBackground {

    // initialize socket and input output streams
    private Socket           socket = null;
    private BufferedReader   input  = null;
    private DataInputStream  in     = null;
    private DataOutputStream out    = null;

    // constructor to put ip address and port

    public MedicalApplicationBackground(String address, int port) {

        // establish a connection

        try
        {
            socket = new Socket(address, port);
            System.out.println("\033[0;31m"+"Successful connection"+"\n"+"\033[0;31m");

            // takes input from terminal
            input  = new BufferedReader(new InputStreamReader(System.in));

            in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            // sends output to the socket
            out    = new DataOutputStream(socket.getOutputStream());
        }
        catch(UnknownHostException u)
        {
            System.out.println(u);
        }
        catch(IOException i)
        {
            System.out.println(i);
        }

        // string to read message from input

        String line = "";
        String returnLine = "";

        // keep reading until "Over" is input

        while (!line.equals("Over"))
        {
            try
            {
                System.out.println("\u001B[32m"+"Enter the keyword:");
                System.out.println("\033[0;37m"+""+"\033[0;37m");

                line = input.readLine();
                out.writeUTF(line);
                returnLine = in.readUTF();
                if(returnLine.equals(line) && !returnLine.equals("Over"))
                    returnLine = ("\033[0;31m"+"\n"+"'" + line +"' is not a keyword, or the patient '" + line +"' doesn't exist in the hospital database!"+"\n"+"\033[0;31m"+"Please try again!"+"\n");
                if(returnLine.equals("Over"))
                    returnLine = ("\033[0;31m"+"\n"+"Connection ended"+"\033[0;31m");

                System.out.println(returnLine);
            }
            catch(IOException i)
            {
                System.out.println(i);
            }
        }

        // close the connection

        try
        {
            input.close();
            out.close();
            socket.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }

}
