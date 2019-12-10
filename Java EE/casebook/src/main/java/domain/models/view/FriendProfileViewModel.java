package domain.models.view;

public class FriendProfileViewModel {
    private String id;
    private String username;

    public FriendProfileViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
