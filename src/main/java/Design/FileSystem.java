package Design;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.*;
import java.util.HashMap;
import java.util.Map;


public class FileSystem {


        class File{
            boolean isFile ;
            Map<String, File> files = new HashMap<>();
            String content;

        }
        File root;

        public FileSystem() {
            root = new File();
        }

        public List<String> ls(String path) {
            List<String> res = new ArrayList<>();;
            File t = root;
            if(!path.equals("/")){
                String[] paths = path.split("/");
                for(int i =1; i < paths.length; i++){
                    t = t.files.get(paths[i]);
                    if(t.isFile){
                        System.out.println("ls----" + paths[i] + " " + t.isFile);
                        res.add(paths[i]);
                        return res;
                    }

                }
            }

            for(String key : t.files.keySet()){
                res.add(key);
            }

            Collections.sort(res, new Comparator<String>(){
                public int compare(String s1, String s2){
                    return s1.compareTo(s2);
                }
            });
            return res;
        }

        public void mkdir(String path) throws IllegalArgumentException{
            if(path == null || path.length() ==0)
                throw new IllegalArgumentException("Path cannot be empty or null");

            File t = root;
            String[] paths = path.split("/");
            //System.out.println(paths.length);
            for(int i =1; i < paths.length;i++){
                if(!t.files.containsKey(paths[i])){
                    t.files.put(paths[i], new File());
                }
                t = t.files.get(paths[i]);
                //System.out.println(paths[i]);
            }

        }

        public void addContentToFile(String filePath, String content) {
            File t = root;
            String [] paths = filePath.split("/");
            for(int i=1;i < paths.length; i++){
                if(!t.files.containsKey(paths[i])){
                    t.files.put(paths[i], new File());
                    System.out.println("add---"+ paths[i]);
                }
                t = t.files.get(paths[i]);
                //System.out.println("add---"+ paths[i]);
            }
            t.isFile = true;
            if(t.content != null)
                t.content +=  content;
            else
                t.content = content;

        }

        public String readContentFromFile(String filePath) {
            File t = root;
            String [] paths = filePath.split("/");
            for(int i=1;i < paths.length; i++){
                t = t.files.get(paths[i]);
                //System.out.println(paths[i]);
            }

            return t.content;
        }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/goowmfn");
        fileSystem.ls("/goowmfn");
        fileSystem.ls("/");
        fileSystem.mkdir("/z");
        fileSystem.ls("/");
        fileSystem.ls("/");
        fileSystem.addContentToFile("/goowmfn/c", "fuckthis");
        fileSystem.ls("/z");
        fileSystem.ls("/goowmfn/c");
        fileSystem.ls("/goowmfn");

    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

