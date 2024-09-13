package com.csc340.demo;

public class Games {
    public String title;
    public String genre;
    public String platform;

    public Games(String title, String genre, String platform)
    {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getPlatform()
    {
        return platform;
    }

    public void setPlatform(String platform)
    {
        this.platform = platform;
    }
}

