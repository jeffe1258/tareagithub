package miu.facci.com.entity;

/**
 * Created by miu
 */

public class User {

    private String login;
    private String public_repos;
    private String followers;
    private String avatar_url;

    public User(){
    }

    public User (String login, String public_repos, String followers, String avatar_url){
        this.login=login;
        this.public_repos=public_repos;
        this.followers=followers;
        this.avatar_url=avatar_url;
    }

    public String getLogin() {
        return login;
    }

    public String getPublic_repos() {
        return public_repos;
    }

    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
