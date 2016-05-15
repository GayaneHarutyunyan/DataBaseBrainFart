package model;

import org.springframework.context.annotation.Lazy;

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


    @Lob
    @Basic(fetch = FetchType.LAZY)
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
