package com.mezzoforte.greenstreet.posting.domain.entity;

import com.mezzoforte.greenstreet.posting.domain.enums.PostingStatus;
import com.mezzoforte.greenstreet.user.domain.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "posting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posting {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Setter
    @Column(nullable = false, length = 50)
    private String title;

    @Setter
    @Lob
    private String content;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Enumerated(value = EnumType.STRING)
    private PostingStatus status;

    @Column(nullable = false)
    private long likeCount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

//    @OneToMany(mappedBy = "posting")
//    private List<Photo> photos = new ArrayList<>();

    @Builder
    public Posting(String title, String content, double latitude, double longitude, PostingStatus status, User user) {
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.user = user;
    }
}
