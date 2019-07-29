package config;

import beans.Competitor;
import beans.User;

import java.io.Serializable;

public class Config implements Serializable {


    private User  user;
    private Competitor [] competitors;

    public Config(){

    }
    public Config(User user){
        this.user = user;
    }

    public void setUser(User user){
        this.user = user;
        Initilization.refreshConfig();
    }
    public User getUser(){
        return user;

    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void setCompetitors(Competitor[] competitors) {
        this.competitors = competitors;
        Initilization.refreshConfig();
    }
}
