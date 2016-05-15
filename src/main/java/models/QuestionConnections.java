package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Question_Connections")
public class QuestionConnections implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "test_id")
    private Integer testId;
    @Basic
    @Column(name = "question_id")
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @Transient
    private Tests testsByTestId;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @Transient
    private Questions questionsByQuestionId;

    @OneToMany(mappedBy = "questionConnectionsByQcId")
    @Transient
    private Set<QuestionResults> questionResultsesById;


}

