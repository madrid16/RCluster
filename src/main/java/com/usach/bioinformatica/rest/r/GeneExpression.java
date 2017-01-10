package com.usach.bioinformatica.rest.r;

import com.github.rcaller.rStuff.RCaller;
import com.github.rcaller.rStuff.RCode;
import com.github.rcaller.util.Globals;

import java.util.ArrayList;
import java.util.List;

public class GeneExpression {

    public List<String> kmeans(String fileName){
        List<String> kmeans = new ArrayList<>();

        RCaller caller = new RCaller();
        Globals.detect_current_rscript();
        caller.setRscriptExecutable("/usr/local/bin/Rscript");
        RCode code = new RCode();

//        code.addRCode("library(amap)");
        code.addRCode("data <- read.csv(file = '" + fileName + "', header=TRUE, row.names = 1)");
            code.addRCode("expresion_matrix <- as.matrix(data)");
            code.addRCode("expresion_matrix <- na.omit(expresion_matrix)");
//            code.addRCode("result <- Kmeans(x = expresion_matrix, centers=2, method = 'euclidean',iter.max = 100, nstart = 1)");

        code.addRCode("write.csv(expresion_matrix, file = '" + System.getProperty("user.dir") + "/foo.csv'" + ", fileEncoding = 'UTF-8')");

        System.out.println(fileName);

        caller.setRCode(code);

        System.out.println(caller.getRCode());

        caller.runOnly();


        return kmeans;
    }

}
