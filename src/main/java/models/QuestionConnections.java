package models;

import javax.persistence.*;
import java.util.*;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "Question_Connections")
public class QuestionConnections extends Model {
    @Basic
    @Column(name = "test_id")
    private Integer testId;
    @Basic
    @Column(name = "question_id")
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Tests testsByTestId;

    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Questions questionsByQuestionId;

    @OneToMany(mappedBy = "questionConnectionsByQcId")
    private Set<QuestionResults> questionResultsesById;


}

