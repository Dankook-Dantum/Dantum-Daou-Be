package com.dantum.daou.vote;

import com.dantum.daou.user.User;
import com.dantum.daou.voteValue.VoteValue;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_idx")
    private Long voteIdx;

    @Column(name = "title")
    private String title;

    @CreationTimestamp
    @Column(name="created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="user_idx")
    private User user;

    @OneToMany(mappedBy = "vote", cascade = CascadeType.ALL)
    private List<VoteValue> voteValueList = new ArrayList<VoteValue>();

    @Builder
    public Vote(String title, User user){
        this.title = title;
        this.user = user;
    }
}
