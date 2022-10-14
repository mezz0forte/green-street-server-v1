package com.mezzoforte.greenstreet.domain.posting.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "posting_photo")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostingPhoto {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private int sequence;

    @Column(nullable = false)
    private String imageUrl;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_posting_id")
    private Posting posting;

    @Builder
    public PostingPhoto(int sequence, String imageUrl, Posting posting) {
        this.sequence = sequence;
        this.imageUrl = imageUrl;
        this.posting = posting;
    }
}
