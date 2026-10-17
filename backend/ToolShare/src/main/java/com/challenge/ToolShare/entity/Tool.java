package com.challenge.ToolShare.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

@Entity
@Table(name = "tools")
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable=false)
    private String category;

    @Column(nullable=false)
    private String dailyRate;

    @Column(nullable=false)
    private String owner;

    @Column
    private boolean available;

    public Tool() {}

    public Tool(Long id, String name, String description, String category, String dailyRate, String owner, boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.dailyRate = dailyRate;
        this.owner = owner;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDailyRate(){
        return dailyRate;
    }

    public void setDailyRate(String dailyRate) {
        this.dailyRate = dailyRate;
    }

    public String getOwner(){
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public boolean getAvailable(){
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }



}
