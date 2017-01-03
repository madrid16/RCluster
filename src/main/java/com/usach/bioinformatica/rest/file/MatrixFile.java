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

    public List<String> getColumnName(String pathFile){
        List<String> column = new ArrayList<>();
        String line;
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(pathFile));
            while ((line = buffer.readLine()) != null) {
                String[] matrix = line.split(",");
                if(!matrix[0].isEmpty()){
                    column.add(matrix[0]);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        return column;
    }

    public List<String> getHeaderName(String pathFile){
        List<String> header = new ArrayList<>();
        String line;
        try {
            BufferedReader buffer = new BufferedReader(new FileReader(pathFile));
            line = buffer.readLine();
            String[] matrix = line.split(",");
            for(String cell : matrix){
                if(!cell.isEmpty()){
                    header.add(cell);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return header;
    }

    public boolean isMatrixExpression(List<String> column, List<String> header){
        return column != header;
    }

    public boolean isEuclideanDistance(List<String> column, List<String> header){
        return column.equals(header);
    }

}
