package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Entity
@Table(name = "Answer_Options")
public class AnswerOptions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "questions_id", nullable = false)
    @NotNull
    private Questions questionsId;

    @Basic
    @NotNull
    @Column(name = "content")
    private String content;

    @Basic
    @NotNull
    @Column(name = "correctness")
    private boolean correctness;

}
