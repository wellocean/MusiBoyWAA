/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import mum.model.AuthorEntity;
import mum.model.ChartEntity;
import mum.model.GenreEntity;
import mum.model.SongEntity;
import mum.model.UserEntity;
import types.*;

/**
 *
 * @author Purevsuren
 */
@Named(value = "appManager")
@ManagedBean
@ViewScoped
public class AppManager implements Serializable {

    App app;
    String searchText;
    String chosenGenre;
    ArrayList<Chart> result = new ArrayList<Chart>();
    SongEntity currentPlay;
    String isBrowse;

    /**
     * Creates a new instance of AppManager
     */
    public AppManager() {
        app = new App();
        isBrowse = "hidden";
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public SongEntity getCurrentPlay() {
        return currentPlay;
    }

    public void setCurrentPlay(SongEntity currentPlay) {
        this.currentPlay = currentPlay;
    }

    public ArrayList<Chart> getResult() {
        return result;
    }

    public void setResult(ArrayList<Chart> result) {
        this.result = result;
    }

    public ArrayList<Genre> getGenres() {
        return app.genres;
    }

    public String getChosenGenre() {
        return chosenGenre;
    }

    public void setChosenGenre(String chosenGenre) {
        this.chosenGenre = chosenGenre;
    }

    public String getIsBrowse() {
        return isBrowse;
    }

    public void setIsBrowse(String isBrowse) {
        this.isBrowse = isBrowse;
    }

    public void getResult(String s) {
        if (s.equals("Charts")) {
            this.setIsBrowse("hidden");
            result.clear();
            result.add(app.charts.get(0));
            result.add(app.charts.get(1));
        } else if (s.equals("Browse")) {
            this.setIsBrowse("visible");
            result.clear();
            result.add(new Chart("Browse", app.songs));
        } else if (s.equals("Search")) {
            this.setIsBrowse("hidden");
            ArrayList<SongEntity> searchs = new ArrayList<SongEntity>();
            for (SongEntity so : app.songs) {
                if (so.getTitle().toLowerCase().contains(searchText.toLowerCase())) {
                    searchs.add(so);
                }
            }
            result.clear();
            result.add(new Chart(searchText, searchs));
        } else {
            System.out.println("Getting by genre");
            System.out.println(s);
            ArrayList<SongEntity> searchs = new ArrayList<SongEntity>();
            for (SongEntity so : app.songs) {
                if (so.getGenre().getTitle().equals(s)) {
                    searchs.add(so);
                }
            }
            result.clear();
            result.add(new Chart(s, searchs));
        }
    }

    public void play(SongEntity s) {
        System.out.println(s.getTitle());
        setCurrentPlay(s);
    }

    // Aithour Wellocean
    @EJB //this annotation causes the container to inject this dependency
    private mum.db.SongEntityFacade ejbSongFacade;

    @EJB //this annotation causes the container to inject this dependency
    private mum.db.UserEntityFacade ejbUserFacade;
//    
    @EJB //this annotation causes the container to inject this dependency
    private mum.db.GenreEntityFacade ejbGenreFacade;
//    
    @EJB //this annotation causes the container to inject this dependency
    private mum.db.AuthorEntityFacade ejbAuthorFacade;
//    
    @EJB //this annotation causes the container to inject this dependency
    private mum.db.ChartEntityFacade ejbChartFacade;

    @PostConstruct  //this annotation causes this method to run after the constructor completes
    public void init() { //create a few tea products, place in database, and load into the teaEntities list
        Integer counter = 0;

        ejbUserFacade.create(new UserEntity("User001", "Bill", "gates"));
        ejbGenreFacade.create(new GenreEntity("gen004", "Country music"));
        ejbAuthorFacade.create(new AuthorEntity("aut008", "Brandy"));

        ejbSongFacade.create(new SongEntity("song001", "Gorilla", "resources/img/album/BrunoMars-Gorilla.png", "resources/songs/BrunoMars-Gorilla.mp3", app.authors.get(3), app.genres.get(0)));
        ejbSongFacade.create(new SongEntity("song002", "Uptown Funk", "resources/img/album/BrunoMars-UptownFunk.jpg", "resources/songs/BrunoMars-UptownFunk.mp3", app.authors.get(3), app.genres.get(0)));
        ejbSongFacade.create(new SongEntity("song003", "Every Teardrop is a Waterfall", "resources/img/album/Coldplay-EveryTeardropIsaWaterfall.jpg", "resources/songs/Coldplay-EveryTeardropIsAWaterfall.mp3", app.authors.get(4), app.genres.get(1)));
        ejbSongFacade.create(new SongEntity("song004", "Paradise", "resources/img/album/paradise.jpg", "resources/songs/Coldplay-Paradise.mp3", app.authors.get(4), app.genres.get(1)));
        ejbSongFacade.create(new SongEntity("song006", "Lips of an Angel", "resources/img/album/hinder-lipsOfAngel.jpg", "resources/songs/Hinder-LipsOfAnAngel.mp3", app.authors.get(0), app.genres.get(3)));
        ejbSongFacade.create(new SongEntity("song007", "Use Me", "resources/img/album/hinder-lipsOfAngel.jpg", "resources/songs/Hinder-UseMe.mp3", app.authors.get(0), app.genres.get(3)));
        ejbSongFacade.create(new SongEntity("song008", "La La La", "resources/img/album/La_La_La_cover.png", "resources/songs/NaughtyBoy-LaLaLa.mp3", app.authors.get(2), app.genres.get(0)));
        ejbSongFacade.create(new SongEntity("song009", "Use Me", "resources/img/album/sonreal-onelongday.jpg", "resources/songs/SonReal-LA.mp3", app.authors.get(5), app.genres.get(2)));

        List<SongEntity> SongEntities = ejbSongFacade.findAll();
        for (SongEntity songEnt : SongEntities) {
            app.songs.add(songEnt);
        };

        app.charts.add(new Chart("Global Top 10", app.songs));
        app.charts.add(new Chart("USA Top 10", app.songs));

        //ejbChartFacade.create(new ChartEntity("Fairfiled Top 10", chartSongs));
        app.users.add(new User("user001", "Puujee", "password"));

        app.playlists.add(new Playlist("list001", "Favourites", app.users.get(0)));

        app.playlists.get(0).addPlaylist(app.songs.get(5));
        app.playlists.get(0).addPlaylist(app.songs.get(6));
        app.playlists.get(0).addPlaylist(app.songs.get(2));
        app.playlists.get(0).addPlaylist(app.songs.get(0));
//      Stored Data Implementation

        result.add(app.charts.get(0));
        result.add(app.charts.get(1));

    }

}
