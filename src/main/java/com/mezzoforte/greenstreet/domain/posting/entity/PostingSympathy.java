package com.mezzoforte.greenstreet.domain.posting.entity;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "posting_sympathy")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostingSympathy {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_posting_id")
    private Posting posting;

    @Builder
    public PostingSympathy(User user, Posting posting) {
        this.user = user;
        this.posting = posting;
    }
}
