package miu.facci.com.client;

import android.app.Application;
import android.content.res.Configuration;

import miu.facci.com.entity.Follower;
import miu.facci.com.entity.User;

import java.util.List;


public class GlobalData extends Application {

    private User user;
    private List<Follower> followerList;

    public String getLogin() {
        return this.getUser().getLogin();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Follower> getFollowerList() {
        return followerList;
    }

    public void setFollowerList(List<Follower> followerList) {
        this.followerList = followerList;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

}
