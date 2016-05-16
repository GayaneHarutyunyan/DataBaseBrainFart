package model;

import javax.persistence.*;
import javax.validation.constraints.*;
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

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @NotNull
    @Column(name = "content")
    private String content;

    @Basic
    @NotNull
    @Column(name = "correctness")
    private boolean correctness;

    @Override
    public String toString() {
        return "AnswerOptions{" +
                "id=" + id +
                ", questionsId=" + questionsId +
                ", content='" + content + '\'' +
                ", correctness=" + correctness +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Questions getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Questions questionsId) {
        this.questionsId = questionsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrectness() {
        return correctness;
    }

    public void setCorrectness(boolean correctness) {
        this.correctness = correctness;
    }
}
