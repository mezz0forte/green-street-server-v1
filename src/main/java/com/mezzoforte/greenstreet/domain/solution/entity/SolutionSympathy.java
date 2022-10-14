package com.mezzoforte.greenstreet.domain.solution.entity;

import com.mezzoforte.greenstreet.domain.user.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "solution_sympathy")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SolutionSympathy {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_solution_id")
    private Solution solution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_user_id")
    private User user;

    @Builder
    public SolutionSympathy(Solution solution, User user) {
        this.solution = solution;
        this.user = user;
    }
}
