package models;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
public class Questions {
    private long id;
    private String content;
    private long scoresForTheQuestion;
    private Collection<AnswerOptions> answerOptionsesById;
    private Collection<QuestionConnections> questionConnectionsesById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "scores_for_the_question")
    public long getScoresForTheQuestion() {
        return scoresForTheQuestion;
    }

    public void setScoresForTheQuestion(long scoresForTheQuestion) {
        this.scoresForTheQuestion = scoresForTheQuestion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Questions questions = (Questions) o;

        if (id != questions.id) return false;
        if (scoresForTheQuestion != questions.scoresForTheQuestion) return false;
        if (content != null ? !content.equals(questions.content) : questions.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (int) (scoresForTheQuestion ^ (scoresForTheQuestion >>> 32));
        return result;
    }

    @OneToMany(mappedBy = "questionsByQuestionsId")
    public Collection<AnswerOptions> getAnswerOptionsesById() {
        return answerOptionsesById;
    }

    public void setAnswerOptionsesById(Collection<AnswerOptions> answerOptionsesById) {
        this.answerOptionsesById = answerOptionsesById;
    }

    @OneToMany(mappedBy = "questionsByQuestionId")
    public Collection<QuestionConnections> getQuestionConnectionsesById() {
        return questionConnectionsesById;
    }

    public void setQuestionConnectionsesById(Collection<QuestionConnections> questionConnectionsesById) {
        this.questionConnectionsesById = questionConnectionsesById;
    }
}
