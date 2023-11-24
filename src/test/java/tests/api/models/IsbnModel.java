package tests.api.models;

public class IsbnModel {

    public IsbnModel(String isbn) {
        this.isbn = isbn;
    }
    private String isbn;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
