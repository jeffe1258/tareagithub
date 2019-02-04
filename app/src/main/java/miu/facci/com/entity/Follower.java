package miu.facci.com.entity;

/**
 * Created by miu
 */

public class Follower {

    private String login;
    private String avatar_url;

    private Follower(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
