package AdvancedProblems;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeCSVInChunks {
    public static void main(String[] args) {
        String filePath = "large_students.csv";
        readCSVInChunks(filePath, 100);
    }

    private static void readCSVInChunks(String filePath, int chunkSize) {
        int totalRecordsProcessed = 0;
        int currentChunkCount = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }
                currentChunkCount++;
                totalRecordsProcessed++;

                if (currentChunkCount == chunkSize) {
                    System.out.println("Processed " + totalRecordsProcessed + " records so far.");
                    currentChunkCount = 0;
                }
            }

            if (currentChunkCount > 0) {
                System.out.println("Processed " + totalRecordsProcessed + " records in total.");
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}