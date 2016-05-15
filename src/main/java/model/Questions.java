package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Questions")
public class Questions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Basic
    @NotNull
    @Column(name = "content")
    private String content;
    @Basic
    @NotNull
    @Column(name = "value")
    private int value;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
    private Set<QuestionConnections> questionConnectionses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionsId")
    private Set<AnswerOptions> answerOptionses;
}
