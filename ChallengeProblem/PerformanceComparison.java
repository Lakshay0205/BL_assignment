package ChallengeProblem;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PerformanceComparison {

    public static void main(String[] args) throws IOException {
        stringConcatenationBenchmark();
        fileReadingBenchmark();
    }

    public static void stringConcatenationBenchmark() {
        int numStrings = 1000000;
        String baseString = "hello";
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < numStrings; i++) {
            stringList.add(baseString);
        }

        // StringBuffer
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (String str : stringList) {
            stringBuffer.append(str);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        // StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : stringList) {
            stringBuilder.append(str);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        System.out.println("String Concatenation:");
        System.out.println("StringBuffer time: " + stringBufferTime + " ns");
        System.out.println("StringBuilder time: " + stringBuilderTime + " ns");
        System.out.println();

    }



    public static void fileReadingBenchmark() throws IOException {
        String filePath = "large_file.txt"; // Replace with your large file path (100MB)

        // FileReader
        long startTime = System.nanoTime();
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReaderFR = new BufferedReader(fileReader);
        long wordCountFR = countWords(bufferedReaderFR);
        long endTime = System.nanoTime();
        long fileReaderTime = endTime - startTime;
        bufferedReaderFR.close();



        // InputStreamReader
        startTime = System.nanoTime();
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8); // Or appropriate charset
        BufferedReader bufferedReaderISR = new BufferedReader(inputStreamReader);

        long wordCountISR = countWords(bufferedReaderISR);

        endTime = System.nanoTime();
        long inputStreamReaderTime = endTime - startTime;

        bufferedReaderISR.close();

        System.out.println("File Reading:");
        System.out.println("FileReader time: " + fileReaderTime + " ns, Word Count: " + wordCountFR);
        System.out.println("InputStreamReader time: " + inputStreamReaderTime + " ns, Word Count: " + wordCountISR);

    }

    private static long countWords(BufferedReader br) throws IOException {
        long wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.toLowerCase().split("[\\s\\p{Punct}]+");
            wordCount += words.length;
        }
        return wordCount;
    }

}