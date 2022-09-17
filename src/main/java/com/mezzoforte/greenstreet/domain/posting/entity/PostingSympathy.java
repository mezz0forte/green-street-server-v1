package com.mezzoforte.greenstreet.domain.posting.entity;

import com.mezzoforte.greenstreet.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "sympathy")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostingSympathy {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posting_id")
    private Posting posting;
}
