package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Questions")
public class Questions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "scores_for_the_question")
    private long scoresForTheQuestion;

/*
    @OneToMany(mappedBy = "questionsByQuestionsId")
    @Transient
    private Set<AnswerOptions> answerOptionsesById;

    @OneToMany(mappedBy = "questionsByQuestionId")
    @Transient
    private Set<QuestionConnections> questionConnectionsesById;
*/

}
