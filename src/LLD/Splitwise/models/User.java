package LLD.Splitwise.models;

public class User {
    String userId;
    String userName;

    public User(String id, String userName) {
        this.userId = id;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

}
