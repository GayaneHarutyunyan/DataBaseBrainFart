package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;


@Entity
@Table(name = "Test_Session")
public class TestSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private Users userId;

    @Basic
    @NotNull
    @Column(name = "test_result")
    private int testResult;

    @Basic
    @NotNull
    @Column(name = "submit_date")
    private Date submitDate;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testSessionId")
    private Set<QuestionResults> questionResultses;
}
