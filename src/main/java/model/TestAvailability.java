package model;

import lombok.*;
import lombok.experimental.Accessors;
import org.apache.log4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "Test_Availability")
//@Data
//@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@ToString(doNotUseGetters = true)
//@EqualsAndHashCode(doNotUseGetters = true)

public class TestAvailability implements Serializable {
    private static Logger log = Logger.getLogger(TestSession.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_id", nullable = false)
    @NotNull
    private Tests testId;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    public TestAvailability(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        log.trace("Timing of the test operation");
    }
}
