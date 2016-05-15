package models;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by mystic on 15.05.2016.
 */
@Entity
@Table(name = "TestAvailability")
@Getter
@Setter
public class TestAvailability {

    @Basic
    @Column(name = "test_id")
    private Integer testId;
    @Basic
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @Column(name = "end_date")
    private Date endDate;
/*
    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Tests testsByTestId;
/*

    @ManyToOne
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    public Tests getTestsByTestId() {
        return testsByTestId;
    }

    public void setTestsByTestId(Tests testsByTestId) {
        this.testsByTestId = testsByTestId;
    }
*/


}
