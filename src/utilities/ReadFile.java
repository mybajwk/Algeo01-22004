package utilities;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ReadFile {
    static double[][] datatoMatrix(String[] tempData, int rowMat, int colMat){
        double[][] ans;
        ans = new double[rowMat][colMat];
        int ind_col; // index kolom matrix
        for(int i = 0; i < rowMat; i++){
            // tiap baris
            ind_col = 0;
            String tempString = tempData[i];
            String tempIsi = "";
            for(int j = 0; j < tempData[i].length(); j++){
                if(tempString.charAt(j) == ' '){
                    ans[i][ind_col] = Double.valueOf(tempIsi);
                    tempIsi = "";
                    ind_col +=1;
                }else{
                    tempIsi += tempString.charAt(j);
                }
            }
            // karakter terakhir
            ans[i][ind_col] = Double.valueOf(tempIsi);
        }
        return ans;
    }

    public static void readFileSPL() {
        try{
            String[] tempData;
            tempData = new String[1000];

            Scanner myPath = new Scanner(System.in);
            System.out.println("Input your file path : ");
            String path = myPath.nextLine();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            int rowMat = 0, colMat = 0;

            // baca file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tempData[rowMat] = data;
                rowMat++;
            }
            
            //hitung jumlah kolom
            for(int i = 0; i < tempData[0].length(); i++){
                if(tempData[0].charAt(i) == ' '){
                    colMat++;
                }
            }
            colMat++;

            // convert ke matrix
            double mtrx[][] = datatoMatrix(tempData, rowMat, colMat); 

            for(int i = 0; i < rowMat; i++){
                for(int j = 0; j < colMat; j++){
                    System.out.print(mtrx[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            myPath.close();
            myReader.close();
        } catch(FileNotFoundException e){
            System.out.println("Your file is wrong.");
            e.printStackTrace();
        }
    }

    public static void readFileInterpolasi(){
        try{
            String[] tempData;
            tempData = new String[1000];

            Scanner myPath = new Scanner(System.in);
            System.out.println("Input your file path : ");
            String path = myPath.nextLine();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            int rowMat = 0, colMat = 2;

            // baca file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tempData[rowMat] = data;
                rowMat++;
            }

            // convert ke matrix
            // mtrx berbentuk rowMat x 2
            double mtrx[][] = datatoMatrix(tempData, rowMat, colMat); 

            // for(int i = 0; i < rowMat; i++){
            //     for(int j = 0; j < colMat; j++){
            //         System.out.print(mtrx[i][j]);
            //         System.out.print(" ");
            //     }
            //     System.out.println();
            // }

            // menggunakan bentuk Ax = B, cari matrix x

            // convert ke matrix A
            double[][] A;
            A = new double[rowMat][rowMat];
            for(int i = 0; i < rowMat; i++){
                for(int j = 0; j < rowMat; j++){
                    A[i][j] = Math.pow(mtrx[i][0], j);
                }
            }

            for(int i = 0; i < rowMat; i++){
                for(int j = 0; j < rowMat; j++){
                    System.out.print(A[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            // convert ke matrix B
            double[][] B;
            B = new double[rowMat][1];
            for(int i = 0; i < rowMat; i++){
                B[i][0] = mtrx[i][1];
            }
            for(int i = 0; i < rowMat; i++){
                for(int j = 0; j < 1; j++){
                    System.out.print(B[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            myPath.close();
            myReader.close();
        } catch(FileNotFoundException e){
            System.out.println("Your file is wrong.");
            e.printStackTrace();
        }
    }

    public static void readFileBicubicInterpolasi(){
        try{
            String[] tempData;
            tempData = new String[1000];

            Scanner myPath = new Scanner(System.in);
            System.out.println("Input your file path : ");
            String path = myPath.nextLine();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            int rowMat = 0, colMat = 4;

            // baca file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tempData[rowMat] = data;
                rowMat++;
            }

            // convert baris terakhir tempData ke a dan b
            double a, b;
            double[] tempAB;
            tempAB = new double[2];
            int ind_tempAB = 0;
            String tempIsi = "";
            for(int i = 0; i < tempData[rowMat-1].length(); i++){
                if(tempData[rowMat-1].charAt(i) == ' '){
                    tempAB[ind_tempAB] = Double.valueOf(tempIsi);
                    tempIsi = "";
                    ind_tempAB +=1;
                }else{
                    tempIsi += tempData[rowMat-1].charAt(i);
                }
            }
            a = tempAB[0];
            b = Double.valueOf(tempIsi);
            
            // convert ke matrix
            // mtrx berbentuk 4x4
            double mtrx[][] = datatoMatrix(tempData, 4, 4); 

            // menggunakan bentuk y = Xa, cari matrix a
            // convert ke matrix y
            double[][] y;
            y = new double[16][1];
            int ind_y = 0;
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){
                    y[ind_y][0] = mtrx[i][j];
                    ind_y++;
                }
            }

            // convert ke matrix X;
            double[][] X;
            X = new double[16][16];
            double xX = 0, yX = 0;

            // f
            int indRow = 0;
            for( ; indRow < 4; indRow++){
                if(indRow%4 == 0){
                    xX = 0;
                    yX = 0;
                }else if(indRow%4 == 1){
                    xX = 1;
                    yX = 0;
                }else if(indRow%4 == 2){
                    xX = 0;
                    yX = 1;
                }else{
                    xX = 1;
                    yX = 1;
                }
                double suku1 = 0, suku2 = 0;

                int indCol = 0;
                for(int i = 0; i <= 3; i++){
                    for(int j = 0; j <= 3; j++){
                        if(xX == 0 && j == 0){
                            suku1 = 1;
                        }else{
                            suku1 = Math.pow(xX, j);
                        }

                        if(yX == 0 && i == 0){
                            suku2 = 1;
                        }else{
                            suku2 = Math.pow(yX, i);
                        }

                        X[indRow][indCol] = suku1*suku2;
                        indCol++;
                    }
                }
            }

            // fx
            for( ; indRow < 8; indRow++){
                if(indRow%4 == 0){
                    xX = 0;
                    yX = 0;
                }else if(indRow%4 == 1){
                    xX = 1;
                    yX = 0;
                }else if(indRow%4 == 2){
                    xX = 0;
                    yX = 1;
                }else{
                    xX = 1;
                    yX = 1;
                }

                double suku1 = 0, suku2 = 0;

                int indCol = 0;
                for(int j = 0; j < 4; j++){
                    for(int i = 0; i < 4; i++){
                        if(i == 0){
                            X[indRow][indCol] = 0;
                            indCol++;
                        }else{
                            if(xX == 0 && (i-1) <= 0){
                                suku1 = 1;
                            }else{
                                suku1 = Math.pow(xX, i-1);
                            }
                            
                            if(yX == 0 && j <= 0){
                                suku2 = 1;
                            }else{
                                suku2 = Math.pow(yX, j);
                            }
                    
                            X[indRow][indCol] = i*suku1*suku2;
                            indCol++;
                        }
                    }
                }
            }

            // fx
            for( ; indRow < 12; indRow++){
                if(indRow%4 == 0){
                    xX = 0;
                    yX = 0;
                }else if(indRow%4 == 1){
                    xX = 1;
                    yX = 0;
                }else if(indRow%4 == 2){
                    xX = 0;
                    yX = 1;
                }else{
                    xX = 1;
                    yX = 1;
                }

                double suku1 = 0, suku2 = 0;

                int indCol = 0;
                for(int j = 0; j < 4; j++){
                    for(int i = 0; i < 4; i++){
                        if(j == 0){
                            X[indRow][indCol] = 0;
                            indCol++;
                        }else{
                            if(xX == 0 && i <= 0){
                                suku1 = 1;
                            }else{
                                suku1 = Math.pow(xX, i);
                            }
                            
                            if(yX == 0 && (j-1) <= 0){
                                suku2 = 1;
                            }else{
                                suku2 = Math.pow(yX, j-1);
                            }
                    
                            X[indRow][indCol] = j*suku1*suku2;
                            indCol++;
                        }
                    }
                }
            }

            // fxy
            for( ; indRow < 16; indRow++){
                if(indRow%4 == 0){
                    xX = 0;
                    yX = 0;
                }else if(indRow%4 == 1){
                    xX = 1;
                    yX = 0;
                }else if(indRow%4 == 2){
                    xX = 0;
                    yX = 1;
                }else{
                    xX = 1;
                    yX = 1;
                }

                double suku1 = 0, suku2 = 0;

                int indCol = 0;
                for(int j = 0; j < 4; j++){
                    for(int i = 0; i < 4; i++){
                        if(xX == 0 && (i-1) <= 0){
                            suku1 = 1;
                        }else{
                            suku1 = Math.pow(xX, i-1);
                        }
                            
                        if(yX == 0 && (j-1) <= 0){
                            suku2 = 1;
                        }else{
                            suku2 = Math.pow(yX, j-1);
                        }
                    
                        X[indRow][indCol] = i*j*suku1*suku2;
                        indCol++;
                    }
                }
            }

            for(int i = 0; i < 16; i++){
                for(int j = 0; j < 16; j++){
                    System.out.print(X[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            // for(int i = 0; i < 16; i++){
            //     System.out.println(y[i][0]);
            // }


            myPath.close();
            myReader.close();
        } catch(FileNotFoundException e){
            System.out.println("Your file is wrong.");
            e.printStackTrace();
        }
    }

    public static void readFileRegresi(){
        try{
            String[] tempData;
            tempData = new String[1000];

            Scanner myPath = new Scanner(System.in);
            System.out.println("Input your file path : ");
            String path = myPath.nextLine();
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj);

            int rowMat = 0, colMat = 0;

            // baca file
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                tempData[rowMat] = data;
                rowMat++;
            }

            //hitung jumlah kolom
            for(int i = 0; i < tempData[0].length(); i++){
                if(tempData[0].charAt(i) == ' '){
                    colMat++;
                }
            }
            colMat++;

            double mtrx[][] = datatoMatrix(tempData, rowMat, colMat);

            int n = rowMat; // banyak sampel
            int k = colMat-1; // banyak parameter

            // persamaan berbentuk y = bX, cari b

            // matiks y
            double[][] y = new double[colMat][1];
            for(int ind = 0; ind < colMat; ind++){
                y[ind][0] = 0;
                for(int i = 0; i < n; i++){
                    if(ind == 0){
                        // jumlah yi aja
                        y[ind][0] += mtrx[i][colMat-1];
                    }else{
                        y[ind][0] += mtrx[i][colMat-1]*mtrx[i][ind-1];
                    }
                }
            }

            // matriks X
            double [][] X = new double[colMat][colMat];
            for(int ind = 0; ind < colMat; ind++){
                for(int j = 0; j < colMat; j++){
                    X[ind][j] = 0;
                    if(j >= ind){
                        // koordinat 0,0
                        if(ind == 0 && j == 0){
                            X[ind][j] = n;
                        }else{
                            // inisiasi nilai 0
                            X[ind][j] = 0;
                            // masuk ke sigma
                            for(int i = 0; i < n; i++){
                                // baris 0
                                if(ind == 0 && j > 0){
                                    X[ind][j] += mtrx[i][j-1];
                                }else if(ind > 0){
                                    // baris selain 0
                                    X[ind][j] += (mtrx[i][j-1])*(mtrx[i][ind-1]);
                                }
                            }
                        }
                    }else{
                        X[ind][j] = X[j][ind];
                    }
                    
                }
            }
            
            for(int i = 0; i < colMat; i++){
                for(int j = 0; j < colMat; j++){
                    System.out.print(X[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            for(int i = 0; i < colMat; i++){
                for(int j = 0; j < 1; j++){
                    System.out.print(y[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }

            myPath.close();
            myReader.close();
        } catch(FileNotFoundException e){
            System.out.println("Your file is wrong.");
            e.printStackTrace();
        }
    }
}
