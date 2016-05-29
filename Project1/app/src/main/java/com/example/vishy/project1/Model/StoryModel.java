package com.example.vishy.project1.Model;

/**
 * Created by vishy on 28-05-2016.
 */
public class StoryModel {


   /* @SerializedName("title")
    @Expose*/
    private String title;
    /*@SerializedName("storyContent")
    @Expose*/
    private int  iconId;

    private String story;

    private int imageId;

    public StoryModel(String title, int iconId, int imageId, String story) {
        this.title = title;
        this.iconId = iconId;
        this.imageId = imageId;
        this.story = story;
    }


    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public int getImageId() {
        return this.imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getIconId() {
        return this.iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getStory() {
        return this.story;
    }

    public void setStory(String story) {
        this.story = story;
    }

}
/*
public class ItemObject {

    private String name;
    private int photo;

    public ItemObject(String name, int photo) {
        this.name = name;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}*/
