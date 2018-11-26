package com.veeresh.b37_recyclervieweg1;

/**
 * Created by skillgun on 24/08/2017.
 */
//bean class - pojo class

public class Movie {
    private int sno;
    private String actor_name, movie_name;

    public Movie(int sno, String actor_name, String movie_name) {
        this.sno = sno;
        this.actor_name = actor_name;
        this.movie_name = movie_name;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getActor_name() {
        return actor_name;
    }

    public void setActor_name(String actor_name) {
        this.actor_name = actor_name;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }
}
