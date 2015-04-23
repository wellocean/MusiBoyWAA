/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author wellocean
 */
@Entity
public class GenreEntity implements Serializable {
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
        if (!(object instanceof GenreEntity)) {
            return false;
        }
        GenreEntity other = (GenreEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mum.model.GenreEntity[ id=" + id + " ]";
    }
    
        String genreID;
    String title;

    public GenreEntity(String genreID, String title) {
        this.genreID = genreID;
        this.title = title;
    }

    public String getGenreID() {
        return genreID;
    }

    public String getTitle() {
        return title;
    }

    public void setGenreID(String genreID) {
        this.genreID = genreID;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public GenreEntity() { this("",""); }
    
}
