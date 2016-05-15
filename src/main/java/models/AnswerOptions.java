package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "Answer_Options")
public class AnswerOptions extends Model {

    @Basic
    @Column(name = "questions_id")
    private Integer questionsId;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "correctness")
    private boolean correctness;

    @ManyToOne
    @JoinColumn(name = "questions_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private Questions questionsByQuestionsId;

}
