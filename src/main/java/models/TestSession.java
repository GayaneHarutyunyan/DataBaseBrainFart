package models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;


@Entity
@Table(name = "test_session")
@Getter
@Setter
public class TestSession extends Model {
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "test_result")
    private Integer testResult;
    @Basic
    @Column(name = "submit_date")
    private Date submitDate;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id", insertable=false, updatable=false)
    private Users usersByUserId;


    // private Collection<QuestionResults> questionResultsesById;

/*
    @Transient
    @OneToMany(mappedBy = "testSessionByTestSessionId")
    private Set<QuestionResults> questionResultsesById=new HashSet<>();



    @OneToMany(mappedBy = "testSessionByTestSessionId")
    public Collection<QuestionResults> getQuestionResultsesById() {
        return questionResultsesById;
    }

    public void setQuestionResultsesById(Collection<QuestionResults> questionResultsesById) {
        this.questionResultsesById = questionResultsesById;
    }
*/


    public TestSession(Integer userId, Integer testResult, Date submitDate) {
        this.userId = userId;
        this.testResult = testResult;
        this.submitDate = submitDate;
    }


    public TestSession() {
        super();
    }

    public TestSession(Integer id) {
        super(id);
    }
}
