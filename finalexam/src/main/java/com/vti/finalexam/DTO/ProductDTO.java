package com.vti.finalexam.DTO;

public class ProductDTO {
    private int id;
    private String name;
    private String description;
    private String image_url;
    private float price;
    private String type_name;
    private float sale_percent;
    private String gender_for;

    public ProductDTO(int id, String name, String description, String image_url, float price, String type_name, String gender_for) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_url = image_url;
        this.price = price;
        this.type_name = type_name;
        this.gender_for = gender_for;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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



    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }


    public float getSale_percent() {
        return sale_percent;
    }

    public void setSale_percent(float sale_percent) {
        this.sale_percent = sale_percent;
    }

    public String getGender_for() {
        return gender_for;
    }

    public void setGender_for(String gender_for) {
        this.gender_for = gender_for;
    }

    public ProductDTO(int id, String name, String description, String image_url, float price, String type_name, float sale_percent, String gender_for) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image_url = image_url;
        this.price = price;
        this.type_name = type_name;
        this.sale_percent = sale_percent;
        this.gender_for = gender_for;
    }
}
