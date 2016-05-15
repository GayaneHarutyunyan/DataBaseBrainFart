package models;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "Answer_Options")
public class AnswerOptions implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "questions_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    private Questions questionsByQuestionsId;

    @Basic
    @Column(name = "content")
    private String content;

    @Basic
    @Column(name = "correctness")
    private boolean correctness;

}
