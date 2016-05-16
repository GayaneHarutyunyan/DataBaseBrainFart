package model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


@Entity
@Table(name = "Question_Connections")
public class QuestionConnections implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_id", nullable = false)
    @NotNull
    private Tests testsId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "question_id", nullable = false)
    @NotNull
    private Questions questionId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionConnectionsId")
    private Set<QuestionResults> questionResultses;

    @Override
    public String toString() {
        return "QuestionConnections{" +
                "id=" + id +
                ", testsId=" + testsId +
                ", questionId=" + questionId +
                ", questionResultses=" + questionResultses +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Tests getTestsId() {
        return testsId;
    }

    public void setTestsId(Tests testsId) {
        this.testsId = testsId;
    }

    public Questions getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Questions questionId) {
        this.questionId = questionId;
    }

    public Set<QuestionResults> getQuestionResultses() {
        return questionResultses;
    }

    public void setQuestionResultses(Set<QuestionResults> questionResultses) {
        this.questionResultses = questionResultses;
    }
}
