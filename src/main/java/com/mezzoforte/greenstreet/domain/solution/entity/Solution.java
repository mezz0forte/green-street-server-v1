package com.mezzoforte.greenstreet.domain.solution.entity;

import com.mezzoforte.greenstreet.domain.solution.type.SolutionType;
import com.mezzoforte.greenstreet.domain.posting.entity.Posting;
import com.mezzoforte.greenstreet.domain.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "solution")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Solution {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 1000)
    @Size(max = 1000)
    private String url;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private SolutionType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solver")
    private User solver;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posting")
    private Posting posting;

    @Column(nullable = false)
    private long likeCount;

    @OneToMany(mappedBy = "solution")
    private List<SolutionComment> commentList = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdAt;
}
