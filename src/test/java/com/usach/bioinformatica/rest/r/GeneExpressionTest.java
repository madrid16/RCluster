package com.usach.bioinformatica.rest.r;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneExpressionTest {

    GeneExpression r = new GeneExpression();

    @Before
    public void setUp() throws Exception {
        this.generateMatrixExpressionCSV();
    }

    @After
    public void tearDown() throws Exception {
        this.deleteMatrixExpressionCSV();
    }

    @Test
    public void kmeans() throws Exception {
        File file = new File("MatrixExpression.csv");
        r.kmeans(file.getAbsolutePath());

    }


    private void generateMatrixExpressionCSV() throws IOException {

        FileWriter writer = new FileWriter("MatrixExpression.csv");
        writer.append(",A1,A2,A3\n");
        writer.append("Gen1,1,2,3\n");
        writer.append("Gen2,1,2,3\n");
        writer.append("Gen3,1,2,3\n");
        writer.flush();
        writer.close();

    }

    private void generateEuclideanDistanceCSV() throws IOException {

        FileWriter writer = new FileWriter("EuclideanDistance.csv");
        writer.append(",Gen1,Gen2,Gen3\n");
        writer.append("Gen1,0,2,3\n");
        writer.append("Gen2,2,0,3\n");
        writer.append("Gen3,3,3,0\n");
        writer.flush();
        writer.close();

    }

    private void deleteMatrixExpressionCSV(){
        new File("MatrixExpression.csv").delete();
    }

    private void deleteEuclideanDistanceCSV(){
        new File("EuclideanDistance.csv").delete();
    }

}