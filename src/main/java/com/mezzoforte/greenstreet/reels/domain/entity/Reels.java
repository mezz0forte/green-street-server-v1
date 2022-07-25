package com.mezzoforte.greenstreet.reels.domain.entity;

import com.mezzoforte.greenstreet.posting.domain.entity.Posting;
import com.mezzoforte.greenstreet.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "reels")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reels {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false)
    private String video;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "posting_id")
    private Posting posting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
