package com.mezzoforte.greenstreet.domain.posting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mezzoforte.greenstreet.domain.posting.type.PostingStatus;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "posting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posting {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, length = 50)
    @Size(max = 50)
    private String title;

    @Lob
    private String content;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Enumerated(value = EnumType.STRING)
    private PostingStatus status;

    @Column(nullable = false)
    private long sympathyCount;

    @JsonIgnore
    @OneToMany(mappedBy = "posting", fetch = FetchType.EAGER)
    private List<PostingPhoto> photoList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    public void modifyTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void increaseSympathyCount() {
        this.sympathyCount += 1;
    }

    public void decreaseSympathyCount() {
        this.sympathyCount -= 1;
    }

    @Builder
    public Posting(String title, String content, double latitude, double longitude, PostingStatus status, User user) {
        this.title = title;
        this.content = content;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.user = user;
        this.sympathyCount = 0;
    }
}
