public class LegacyAPI {

    /**
     * @deprecated This method is deprecated and should not be used. Use newFeature() instead.
     */
    @Deprecated
    public void oldFeature() {
        System.out.println("Old feature being used.");
    }

    public void newFeature() {
        System.out.println("New feature being used.");
    }

    public static void main(String[] args) {
        LegacyAPI api = new LegacyAPI();
        api.oldFeature(); // Compiler will issue a deprecation warning
        api.newFeature();
    }
}