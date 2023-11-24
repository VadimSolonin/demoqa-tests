package tests.api.models;

import java.util.List;

public class AddBooksListModel {
    String userId;
    List<IsbnModel> collectionOfIsbns;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<IsbnModel> getCollectionOfIsbns() {
        return collectionOfIsbns;
    }

    public void setCollectionOfIsbns(List<IsbnModel> collectionOfIsbns) {
        this.collectionOfIsbns = collectionOfIsbns;
    }
}
