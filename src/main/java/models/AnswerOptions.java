package models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
public class AnswerOptions {
    private long id;
    private Serializable questionsId;
    private String content;
    private Questions questionsByQuestionsId;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "questions_id")
    public Serializable getQuestionsId() {
        return questionsId;
    }

    public void setQuestionsId(Serializable questionsId) {
        this.questionsId = questionsId;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnswerOptions that = (AnswerOptions) o;

        if (id != that.id) return false;
        if (questionsId != null ? !questionsId.equals(that.questionsId) : that.questionsId != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (questionsId != null ? questionsId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
/*
    @ManyToOne
    @JoinColumn(name = "questions_id", referencedColumnName = "id", nullable = false)
    public Questions getQuestionsByQuestionsId() {
        return questionsByQuestionsId;
    }
*/
    public void setQuestionsByQuestionsId(Questions questionsByQuestionsId) {
        this.questionsByQuestionsId = questionsByQuestionsId;
    }
}
