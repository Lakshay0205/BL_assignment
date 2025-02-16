package StringBuffer;
public class StringConcatenationBenchmark {

    public static void main(String[] args) {
        int numStrings = 1000000;
        String baseString = "hello";

        // StringBuffer
        long startTime = System.nanoTime();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < numStrings; i++) {
            stringBuffer.append(baseString);
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;

        // StringBuilder
        startTime = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numStrings; i++) {
            stringBuilder.append(baseString);
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;

        System.out.println("StringBuffer time: " + stringBufferTime + " ns");
        System.out.println("StringBuilder time: " + stringBuilderTime + " ns");
    }
}