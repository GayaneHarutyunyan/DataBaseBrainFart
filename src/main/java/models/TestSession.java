package models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;


@Entity
@Table(name = "test_session")

public class TestSession implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Transient
    private Users userById;

    @OneToMany(mappedBy = "test_result")
    @Transient
    private Set<QuestionResults> testResult;

    @Basic
    @Column(name = "submit_date")
    private Date submitDate;

}
