package com.usach.bioinformatica.rest.file;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.Rserve.RConnection;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MatrixFileTest {

    private MatrixFile uploadFile = new MatrixFile();

    @Before
    public void setUp() throws Exception {
        this.generateMatrixExpressionCSV();
        this.generateEuclideanDistanceCSV();
    }

    @After
    public void tearDown() throws Exception{
        this.deleteMatrixExpressionCSV();
        this.deleteEuclideanDistanceCSV();
    }

    @Test
    public void saveFile() throws Exception {

    }

    @Test
    public void getColumnName() throws Exception {
        List<String> list = new ArrayList<>(Arrays.asList("Gen1", "Gen2", "Gen3"));
        Assert.assertEquals(uploadFile.getColumnName("MatrixExpression.csv"), list);
    }

    @Test
    public void getHeaderName() throws Exception {
        List<String> list = new ArrayList<>(Arrays.asList("A1", "A2", "A3"));
        Assert.assertEquals(uploadFile.getHeaderName("MatrixExpression.csv"), list);
    }

    @Test
    public void isMatrixExpression() throws Exception{
        List<String> columnMatrixExpression = uploadFile.getColumnName("MatrixExpression.csv");
        List<String> headerMatrixExpression = uploadFile.getHeaderName("MatrixExpression.csv");
        Assert.assertTrue(uploadFile.isMatrixExpression(columnMatrixExpression, headerMatrixExpression));
    }

    @Test
    public void isEuclideanDistance() throws Exception{
        List<String> columnEuclideanDistance = uploadFile.getColumnName("EuclideanDistance.csv");
        List<String> headerEuclideanDistance = uploadFile.getHeaderName("EuclideanDistance.csv");
        Assert.assertTrue(uploadFile.isEuclideanDistance(columnEuclideanDistance, headerEuclideanDistance));
    }

    @Test
    public void R() throws Exception{
        RConnection re = new RConnection();

        String javaVector = "c(1,2,3,4,5)";

        REXP result;

        result = re.eval("rVector=" + javaVector);

        System.out.println(re.parseAndEval("rVector"));

        String[] output = result.asStrings();
        System.out.println(Arrays.toString(output));
        //Calculate MEAN of vector using R syntax.
        re.eval("meanVal=mean(rVector)");

        //Retrieve MEAN value
        double mean = re.eval("meanVal").asDouble();

        //Print output values
        System.out.println("Mean of given vector is=" + mean);

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