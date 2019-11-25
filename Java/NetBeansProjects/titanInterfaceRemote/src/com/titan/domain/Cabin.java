/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.titan.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Thiago
 */
@Entity
@Table(name = "cabin")
public class Cabin implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    private int id;
    private String name;
    private int deckLevel;
    private int shipId;
    private int bedCount;
    
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "deck_level")
    public int getDeckLevel() {
        return deckLevel;
    }

    public void setDeckLevel(int deckLevel) {
        this.deckLevel = deckLevel;
    }

    @Column(name = "ship_id")
    public int getShipId() {
        return shipId;
    }

    public void setShipId(int shipId) {
        this.shipId = shipId;
    }

    @Column(name = "bed_count")
    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    
}
