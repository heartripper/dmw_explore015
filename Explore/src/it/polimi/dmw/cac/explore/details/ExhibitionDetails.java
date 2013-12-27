package it.polimi.dmw.cac.explore.details;

import it.polimi.dmw.cac.explore.controller.Queries;
import it.polimi.dmw.cac.explore.model.Exhibition;
import it.polimi.dmw.cac.explore.model.User;

import javax.xml.bind.annotation.XmlElement;

import com.google.appengine.api.datastore.KeyFactory;

public class ExhibitionDetails extends Details {

    private String id;
    private String name;
    private String description;
    private String photoUrl;
    private int grade;
    private boolean reviewable;
    private Boolean visited;

    public ExhibitionDetails(Exhibition exhibition, User requestor) {
        id = KeyFactory.keyToString(exhibition.getKey());
        name = exhibition.getName();
        description = exhibition.getDescription();
        photoUrl = exhibition.getPhotoUrl();
        visited =
            requestor == null ? false : Queries.hasUserVisited(
                requestor,
                exhibition);
        reviewable =
            requestor == null ? false : !Queries.hasUserReviewed(
                requestor,
                exhibition);
    }

    @XmlElement(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "photoUrl")
    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @XmlElement(name = "grade")
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @XmlElement(name = "reviewable")
    public boolean isReviewable() {
        return reviewable;
    }

    public void setReviewable(boolean reviewable) {
        this.reviewable = reviewable;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}