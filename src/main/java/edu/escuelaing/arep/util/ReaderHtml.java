package edu.escuelaing.arep.util;
import java.io.*;
import java.net.Socket;

public class ReaderHtml implements Reader {

    public void reader(String path, Socket clientSocket){
        String fpath = pathA+"/"+ path;
        String temp="";
        String cadena="";
        File f = new File(fpath);
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            BufferedReader bf = new BufferedReader(fr);
            while((cadena=bf.readLine())!=null) {
                temp= temp + cadena;
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println(validOkHttpHeader()+temp);
        } catch (FileNotFoundException e) {
            error(clientSocket);
        } catch (IOException e) {
            error(clientSocket);
        }




    }

    private String validOkHttpHeader() {
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
    }
}
