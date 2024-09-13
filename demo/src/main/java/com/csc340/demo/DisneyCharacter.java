package com.csc340.demo;

public class DisneyCharacter {
    public String name;
    public String films;
    public String tvShows;

    public DisneyCharacter(String name, String films, String tvShows)
    {
        this.name = name;
        this.films = films;
        this.tvShows = tvShows;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getFilms()
    {
        return films;
    }

    public void setFilms(String films)
    {
        this.films = films;
    }

    public String getTvShows()
    {
        return tvShows;
    }

    public void setTvShows(String tvShows)
    {
        this.tvShows = this.tvShows;
    }
}
