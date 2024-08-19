package dev.fakestore.domain.enumeration;

public enum Sort {
    ASC("asc"),
    DESC("desc");

    private final String sorted;

    // Constructor
    Sort(String sorted) {
        this.sorted = sorted;
    }

    // Method to get the associated message
    public String getSort() {
        return sorted;
    }

}
