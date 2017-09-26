public enum Rules {
    SEPARATOR ("-"), ALL ("All"), ADVANTAGE ("Advantage "), WIN_FOR ("Win for ");
    private String value;

    public String getValue() {
        return value;
    }

    Rules(String value) {
        this.value = value;
    }
}