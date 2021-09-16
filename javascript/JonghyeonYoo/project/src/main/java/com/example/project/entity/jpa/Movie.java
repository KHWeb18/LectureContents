package com.example.project.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_no")
    private Long movieNo;

    @Column(length = 64, nullable = false)
    private String movieTitle;

    @Column(length = 150, nullable = false)
    private String movieInfo;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    /* Join Column 파트 */
    @OneToMany
    @JoinColumn(name = "actor_no")
    private List<Actor> actorList = new ArrayList<>();


    @OneToMany
    @JoinColumn(name = "likeCount_no")
    private List<LikeCount> likeCountList = new ArrayList<>();

    public Movie(String movieTitle, String movieInfo) {
        this.movieInfo = movieInfo;
        this.movieTitle = movieTitle;

    }

    public void addActor(Actor actor) {
        actorList.add(actor);
    }
    public void clearActorList () {
        actorList.clear();
    }

    public void addLikeCount(LikeCount likeCount) {
        likeCountList.add(likeCount);
    }
    public void clearLikeCountList () {
        likeCountList.clear();
    }

}

