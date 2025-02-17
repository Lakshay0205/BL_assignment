public class StringConcatenation {
    public static void main(String[] args) {
        int n = 10000;

        // String (Inefficient)
        long start = System.nanoTime();
        String s = "";
        for (int i = 0; i < n; i++) {
            s += "a";
        }
        System.out.println("String: " + (System.nanoTime() - start) / 1e6 + " ms");

        // StringBuilder (Efficient)
        start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        System.out.println("StringBuilder: " + (System.nanoTime() - start) / 1e6 + " ms");

        // StringBuffer (Thread-safe, slightly slower)
        start = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < n; i++) {
            sbf.append("a");
        }
        System.out.println("StringBuffer: " + (System.nanoTime() - start) / 1e6 + " ms");
    }
}
