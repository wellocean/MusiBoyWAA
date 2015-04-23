/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import types.User;

/**
 *
 * @author wellocean
 */
@Entity
public class PlaylistEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PlaylistEntity)) {
            return false;
        }
        PlaylistEntity other = (PlaylistEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mum.model.PlaylistEntity[ id=" + id + " ]";
    }
    
    String playlistID;
    String title;
    User user;
    ArrayList<SongEntity> playlist = new ArrayList<SongEntity>();

    public PlaylistEntity(String playlistID, String title, User user) {
        this.playlistID = playlistID;
        this.title = title;
        this.user = user;
    }

    public String getPlaylistID() {
        return playlistID;
    }

    public String getTitle() {
        return title;
    }

    public User getUserID() {
        return user;
    }

    public void setPlaylistID(String playlistID) {
        this.playlistID = playlistID;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUserID(User user) {
        this.user = user;
    }

    public ArrayList<SongEntity> getPlaylist() {
        return playlist;
    }

    public void addPlaylist(SongEntity song) {
        this.playlist.add(song);
    }
    
    
        public PlaylistEntity() {
        this(" ", " ", null);
    }
}
