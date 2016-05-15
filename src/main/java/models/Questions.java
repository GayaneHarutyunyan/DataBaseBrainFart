package models;

import javax.persistence.*;
import java.util.*;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity

public class Questions extends Model {
    @Basic
    @Column(name = "content")
    private String content;
    @Basic
    @Column(name = "scores_for_the_question")
    private long scoresForTheQuestion;

    @OneToMany(mappedBy = "questionsByQuestionsId")
    private Set<AnswerOptions> answerOptionsesById;

    @OneToMany(mappedBy = "questionsByQuestionId")
    private Set<QuestionConnections> questionConnectionsesById;


}
