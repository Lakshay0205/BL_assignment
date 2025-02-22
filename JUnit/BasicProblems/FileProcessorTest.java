package JUnit.BasicProblems;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class FileProcessor {
    public void writeToFile(String filename, String content) throws IOException {
        Files.write(Paths.get(filename), content.getBytes());
    }

    public String readFromFile(String filename) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filename)));
    }
}

public class FileProcessorTest {
    private static final String TEST_FILE = "testfile.txt";
    private static final String TEST_CONTENT = "Hello, JUnit!";

    @Test
    public void testWriteAndRead() throws IOException {
        FileProcessor processor = new FileProcessor();
        processor.writeToFile(TEST_FILE, TEST_CONTENT);
        String readContent = processor.readFromFile(TEST_FILE);
        assertEquals(TEST_CONTENT, readContent);
    }

    @Test
    public void testFileExistsAfterWrite() throws IOException {
        FileProcessor processor = new FileProcessor();
        processor.writeToFile(TEST_FILE, TEST_CONTENT);
        File file = new File(TEST_FILE);
        assertTrue(file.exists());
        file.delete();
    }

    @Test
    public void testReadFromFile_IOException() {
        FileProcessor processor = new FileProcessor();
        assertThrows(IOException.class, () -> processor.readFromFile("nonexistent.txt"));
    }

    @Test
    public void testWriteToFile_IOException() {
        FileProcessor processor = new FileProcessor();
        assertThrows(IOException.class, () -> processor.writeToFile("/root/testfile.txt", "test"));
    }
}