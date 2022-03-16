package Design;

import java.io.*;
import java.util.Scanner;

public class FileOperations {

    public static String read(String fileName) throws IOException{

        String res = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedReader bufferedReader = null;

        try{
             inputStream = new FileInputStream(fileName);
             inputStreamReader = new InputStreamReader(inputStream, "UTF-8");

            int c  = inputStream.read();
            System.out.println(c);
            int ch = inputStreamReader.read();
            System.out.println(ch);

             bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] iarr = new byte[1024];
                    bufferedInputStream.read(iarr, 0, 1024);

            System.out.println(iarr);

             bufferedReader = new BufferedReader(inputStreamReader);
             String line = bufferedReader.readLine();

            File file = new File(fileName);
            long size = file.length();
            System.out.println("size in kbs " + size);
            long partSize  = size / 4 ;

             FileReader fileReader =  new FileReader(file);
             BufferedReader bufferedReader1 = new BufferedReader(fileReader);

            int offeset = 0 , bufferSize = (int)partSize, partN0 =0;
            char[] cbuf = new char[bufferSize];
            while(partN0 < 4 ){
                bufferedReader1.read(cbuf, offeset, bufferSize);
                FileWriter fileWriter = new FileWriter("/Users/m655222/jmeter"+ partN0 +".log");
                partN0++;
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(cbuf, offeset, bufferSize);
                bufferedWriter.flush();
                bufferedWriter.close();
                //offeset = partN0 * bufferSize;

            }
            //Scanner scanner = new Scanner(bufferedReader1.readLine());

            bufferedReader1.close();
             bufferedInputStream.close();
             bufferedReader.close();

            System.out.println(line);

            return line;

        }catch (FileNotFoundException fne){
            System.out.println(fne);
            return res;
        }catch (IOException io){
            System.out.println(io);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(bufferedInputStream != null)
                bufferedInputStream.close();
            if(inputStream != null)
                inputStream.close();
        }

        return res;
    }

    public static void main(String[] args) {

        try {
            read("/Users/m655222/jmeter.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter q to quit : ");
        String line = scanner.nextLine();

        do{
            System.out.println(line);
            line = scanner.nextLine();
            //if(line.length() ==0)
                //System.out.println("null");
        }while(!line.equals("q"));


    }
}
