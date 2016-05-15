package model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "Test_Availability")
public class TestAvailability implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_id", nullable = false)
    @NotNull
    private Tests testId;


    @Basic
    @NotNull
    @Column(name = "start_date")
    private Date startDate;
    @Basic
    @NotNull
    @Column(name = "end_date")
    private Date endDate;


}
