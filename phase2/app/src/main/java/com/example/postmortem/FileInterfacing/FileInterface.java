package com.example.postmortem.FileInterfacing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileInterface {

    private File file;

    public FileInterface(String filepath){
        openFile(filepath);
    }

    private void openFile(String filePath){
        file = new File(filePath);
        try{

            file.createNewFile();

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Gets the data written in the file as a list of the lines of the file
     *
     * @return The data stored in the file
     */
    public List<String> readFile() throws IOException{
        try{

            Scanner scan = tryOpenReader();
            return readDataFromFile(scan);

        } catch (IOException e){
            throw e;
        }
    }

    private Scanner tryOpenReader() throws IOException{
        Scanner scan;

        try {

            scan = new Scanner(new FileInputStream(file));

        } catch (IOException e){
            throw e;
        }

        return scan;
    }

    private List<String> readDataFromFile(Scanner scan){

        LinkedList<String> data = new LinkedList<>();

        while(scan.hasNextLine()){
            data.addLast(scan.nextLine());
        }

        return data;

    }

    /**
     * Overwrites the previous information in the file with the new information
     *
     * @param data the information to be written to the file
     * @throws IOException
     */
    public void writeToFile(String data) throws IOException{

        try(BufferedWriter out = new BufferedWriter(new FileWriter(file))){
            out.write(data);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

}
