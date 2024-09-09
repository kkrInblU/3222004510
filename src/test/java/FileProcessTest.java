import org.testng.annotations.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author 刘宇婷.CN
 */
public class FileProcessTest {

    @Test
    public void testReadFile() throws IOException {
        File tempFile = File.createTempFile("testRead", ".txt");
        try (PrintWriter writer = new PrintWriter(new FileWriter(tempFile))) {
            writer.println("This is a test file.");
        }

        String content = FileProcess.readFile(tempFile.getAbsolutePath());
        assertEquals("This is a test file.\n", content);

        tempFile.deleteOnExit();
    }

    @Test
    public void testWriteResult() throws IOException {
        File resultFile = File.createTempFile("testResult", ".txt");

        FileProcess.writeResult(resultFile.getAbsolutePath(), 0.85);

        try (BufferedReader reader = new BufferedReader(new FileReader(resultFile))) {
            String line = reader.readLine();
            assertNotNull(line);
            assertEquals("0.85", line);
        }

        resultFile.deleteOnExit();
    }

    @Test
    public void testMain() throws IOException {
        File origFile = File.createTempFile("orig", ".txt");
        File plagFile = File.createTempFile("plag", ".txt");
        File resultFile = File.createTempFile("result", ".txt");

        try (PrintWriter writer = new PrintWriter(new FileWriter(origFile))) {
            writer.println("This is the original text.");
        }
        try (PrintWriter writer = new PrintWriter(new FileWriter(plagFile))) {
            writer.println("This is the plagiarized text.");
        }

        String[] args = {origFile.getAbsolutePath(), plagFile.getAbsolutePath(), resultFile.getAbsolutePath()};
        DulcateCheckerMain.main(args);

        try (BufferedReader reader = new BufferedReader(new FileReader(resultFile))) {
            String line = reader.readLine();
            assertNotNull(line);
            assertTrue(line.matches("\\d+\\.\\d+"));
        }

        origFile.deleteOnExit();
        plagFile.deleteOnExit();
        resultFile.deleteOnExit();
    }
}
