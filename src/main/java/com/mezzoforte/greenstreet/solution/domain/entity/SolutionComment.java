package com.mezzoforte.greenstreet.solution.domain.entity;

import com.mezzoforte.greenstreet.user.domain.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "solution_comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolutionComment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 200)
    @Size(max = 200)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "solution")
    private Solution solution;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
