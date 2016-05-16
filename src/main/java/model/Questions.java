package model;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.*;


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
    private Integer value;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionId")
    private Set<QuestionConnections> questionConnectionses;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "questionsId")
    private Set<AnswerOptions> answerOptionses;

    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", value=" + value +
                ", questionConnectionses=" + questionConnectionses +
                ", answerOptionses=" + answerOptionses +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Set<AnswerOptions> getAnswerOptionses() {
        return answerOptionses;
    }

    public void setAnswerOptionses(Set<AnswerOptions> answerOptionses) {
        this.answerOptionses = answerOptionses;
    }

    public Set<QuestionConnections> getQuestionConnectionses() {
        return questionConnectionses;
    }

    public void setQuestionConnectionses(Set<QuestionConnections> questionConnectionses) {
        this.questionConnectionses = questionConnectionses;
    }
}
