package com.mezzoforte.greenstreet.reels.domain.entity;

import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import com.mezzoforte.greenstreet.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "reels")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reels {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String video;

    @OneToOne
    @JoinColumn(name = "posting_id")
    private Posting posting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Reels(String video, Posting posting, User user) {
        this.video = video;
        this.posting = posting;
        this.user = user;
    }
}
