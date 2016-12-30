package com.usach.bioinformatica.rest.file;


import com.sun.jersey.core.header.FormDataContentDisposition;

import java.io.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MatrixFile {

    public String saveFile(FormDataContentDisposition fileInputDetails, InputStream fileInputString){
        String fileLocation =  System.getProperty("user.dir") + "/" + fileInputDetails.getFileName();
        NumberFormat myFormat = NumberFormat.getInstance();
        myFormat.setGroupingUsed(true);

        try {
            OutputStream out = new FileOutputStream(new File(fileLocation));
            byte[] buffer = new byte[1024];
            int bytes = 0;
            while ((bytes = fileInputString.read(buffer)) != -1) {
                out.write(buffer, 0, bytes);
            }
            out.flush();
            out.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return fileLocation;
    }

    public List<String> responseFile(String pathFile){
        List<String> gens = new ArrayList<>();
        String line = "";
        try (BufferedReader buffer = new BufferedReader(new FileReader(pathFile))) {
            while ((line = buffer.readLine()) != null) {
                String[] matrix = line.split(",");
                if(!matrix[0].isEmpty()){
                    gens.add(matrix[0]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gens;
    }
}
