package org.dheeraj.exception;

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            long K = Long.parseLong(br.readLine().trim());
            String[] arr_A = br.readLine().split(" ");
            int[] A = new int[N];
            for(int i_A = 0; i_A < arr_A.length; i_A++)
            {
                A[i_A] = Integer.parseInt(arr_A[i_A]);
            }
            int[][] Edges = new int[N-1][2];
            for(int i_Edges = 0; i_Edges < N-1; i_Edges++)
            {
                String[] arr_Edges = br.readLine().split(" ");
                for(int j_Edges = 0; j_Edges < arr_Edges.length; j_Edges++)
                {
                    Edges[i_Edges][j_Edges] = Integer.parseInt(arr_Edges[j_Edges]);
                }
            }

            int out_ = solve(N, K, A, Edges);
           // System.out.println("*****************************************************");
            System.out.println(out_);

        }

        wr.close();
        br.close();
    }

    static int solve(int N, long K, int[] A, int[][] Edges){
        // write your code here
        int result = 0;
        long money = K;
      //  System.out.println("edge length "+Edges.length);
        int tempResult = 0;
        // find if starts from node 1;
        if(A[0] < K){
            tempResult++;
        }
        result = tempResult;


            for (int j = 2; j <= N; j++) {
                tempResult = 0;
                K = money;
                if(A[j-1] <= K){
                    tempResult++;
                    K = K - A[j-1];
                }else {
                    continue;
                }
                int m = j;
                    for (int i = 0; i < Edges.length && m != 1 && K > 0; i++){
                //        System.out.println("edge between "+Edges[i][0] +"and "+Edges[i][1]);

                        if(Edges[i][0] > Edges[i][1]){
                            int temp = Edges[i][0];
                            Edges[i][0] = Edges[i][1];
                            Edges[i][1] = temp;
                        }



                        if(Edges[i][1] == m){
                            m = Edges[i][0];
                            i = -1;
                            if(A[m-1] <= K){
                                tempResult++;
                                K = K - A[m-1];
                            }
                        }
                    }





                if(tempResult > result){
                    result = tempResult;
                }
            }





        //System.out.println("********");


        return result;

    }
}