package main.java.com.patrick.algorithm.saprsearr;

import java.io.*;

/**
 * @author PatrickStar
 * @version V1.0
 * @date 2020/5/6 10:12
 */
public class FileUtil {
    public static void saveFile(int[][] old) throws IOException {
        File file = new File("old.txt");
        FileWriter writer = new FileWriter(file);
        for (int[] rows : old) {
            for (int data:rows) {
                writer.write(data+"\t");
            }
            writer.write("\r\n");
        }
        writer.close();
    }

    public static void readFile(int[][] old) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("old.txt"));
        int row = 0;
        String line;
        while ((line = reader.readLine())!=null){
            String[] temp = line.split("\t");
            for (int i=0;i<temp.length;i++){
                old[row][i] = Integer.parseInt(temp[i]);
            }
            row++;
        }
        reader.close();
    }

    public static int getRowsCount() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("old.txt"));
        int rows = 0;
        while (reader.readLine() !=null){
            rows++;
        }
        reader.close();
        return rows;
    }

    public static int getColCount() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("old.txt"));
        int row = 0;
        String[] line = new String[0];
        if(reader.readLine()!=null){
            line = reader.readLine().split("\t");
        }
        reader.close();
        return line.length;
    }
}
