package Design;


import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ImageCache {

    class Element{
        String url;


        Element(String url){
            this.url = url;


        }
    }

    Element e;

    ImageCache(String URL){
        this.e = new Element(URL);
    }

    public static void main(String[] args) throws IOException{
        ImageCache cache = new ImageCache("https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png");
        System.out.println(cache);

        /*System.out.println("Enter cahce size in bytes:");
        Scanner scanner = new Scanner(System.in);
        long caccheSize = Long.parseLong(scanner.nextLine());
        System.out.println("Enter nunber of urls:");

        long noOFurls = Long.parseLong(scanner.nextLine());
        System.out.println("Enter url:");
        List<String> urls = new ArrayList<>();
        String url = scanner.nextLine();
        urls.add(url);
        do{
            url = scanner.nextLine();
            //System.out.println(url);
            if(!url.equals("q"))
            urls.add(url);
        }while(!url.equals("q"));

        for(String u : urls){
            System.out.println(u);
        } */

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);
        System.out.println("Enter cahce size in bytes:");
        String cacheSize = bufferedReader.readLine();
        System.out.println("No of urls:");
        String noOfurls = bufferedReader.readLine();
        List<String> urls = new ArrayList<>();
        String url ;
        while((url = bufferedReader.readLine()) != null ){
            urls.add(url);
            if(urls.size() == Integer.parseInt(noOfurls))
                break;
        }

        for(String u : urls)
            System.out.println(u);

        LinkedList<byte[]> list = new LinkedList<>();
        list.remove(new byte[1]);

        byte[] res = read();
        System.out.println(res.length);
    }

    private static byte[] read() throws  IOException{

        BufferedInputStream bis = null;
        ByteArrayOutputStream baos = null;
        byte[] res = null;
        try{

            String u = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
            URL url = new URL(u);
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            InputStream inputStream = connection.getInputStream();
            bis = new BufferedInputStream(inputStream);
            baos = new ByteArrayOutputStream();
            byte[] bytes = new byte[1024];
            int n =0;
            while((n = bis.read(bytes, 0, 1024)) != -1){
                baos.write(bytes, 0, n);
                System.out.println("read--->" + n);
            }
            res = baos.toByteArray();

            bis.close();
            baos.close();

        }catch (MalformedURLException mae){
            mae.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(bis != null)
                bis.close();
            if(baos != null)
                baos.close();
        }

        return res;

    }
}
