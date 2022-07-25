package com.mezzoforte.greenstreet.posting.domain.entity;

import com.mezzoforte.greenstreet.posting.domain.enums.PostingStatus;
import com.mezzoforte.greenstreet.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "posting")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Posting {

    @Id @GeneratedValue
    private long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    private String content;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Enumerated(value = EnumType.STRING)
    private PostingStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
