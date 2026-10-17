package com.challenge.ToolShare.dto;

public class ToolResponse {

    private Long id;
    private String name;
    private String description;
    private String category;
    private String dailyRate;
    private String owner;
    private boolean available;

    public ToolResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

    public String getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(String dailyRate){
        this.dailyRate = dailyRate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner){
        this.owner = owner;
    }

    public boolean  getAvailable() {
        return available;
    }

    public void setAvailable(boolean available){
        this.available = available;
    }

}
