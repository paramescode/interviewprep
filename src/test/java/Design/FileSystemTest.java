package Design;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    FileSystem fs = new FileSystem();
    @org.junit.jupiter.api.Test
    //Test for ls on empty root dir
    void lsForEmptyRootTest() {

        assertTrue(fs.ls("/").size() ==0  );
        assertTrue(fs.ls("/abc").size() ==0  );

    }

    @org.junit.jupiter.api.Test
    void mkdirTest() {
        fs.mkdir("/abc");
        assertTrue(fs.ls("/").size() == 1 );
        assertTrue(fs.ls("/").get(0).equalsIgnoreCase("abc"));
        fs.mkdir("/abc/edf/ghi");

        assertTrue(fs.ls("/abc").size() == 1 );
        assertTrue(fs.ls("/abc").get(0).equalsIgnoreCase("edf"));

    }

    @org.junit.jupiter.api.Test
    void mkdirForEmptyPath() {

        assertThrows(IllegalArgumentException.class, () -> {     fs.mkdir("");   });


    }

    @org.junit.jupiter.api.Test
    void mkdirForNullPath() {
        assertThrows(IllegalArgumentException.class, () -> {     fs.mkdir(null);   });


    }

    @org.junit.jupiter.api.Test
    void addContentToFile() {

    }

    @org.junit.jupiter.api.Test
    void readContentFromFile() {
    }
}