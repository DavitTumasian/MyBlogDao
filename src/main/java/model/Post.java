package model;

import javax.persistence.*;

@Entity
@Table
public class Post {
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private long category_id;
    private String title;
    private String image;
    private String description;
    @Column(name = "time")
    private String timeStamp;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(long category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", category_id='" + category_id + '\'' +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}
