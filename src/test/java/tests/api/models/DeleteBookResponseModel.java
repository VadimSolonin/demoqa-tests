package tests.api.models;

import groovyjarjarantlr4.v4.codegen.model.SrcOp;

public class DeleteBookResponseModel {

    public DeleteBookResponseModel(String isbn, String userId) {
        this.isbn = isbn;
        this.userId = userId;
    }
    String isbn, userId;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
