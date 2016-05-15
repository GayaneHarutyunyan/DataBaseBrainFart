package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "TestSession")
@Getter
@Setter
//@NoArgsConstructor
public class TestSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "user_id")
    private Integer userId;
    @Basic
    @Column(name = "test_result")
    private Integer testResult;
    @Basic
    @Column(name = "submit_date")
    private Date submitDate;

    @Transient
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
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
    }
}
