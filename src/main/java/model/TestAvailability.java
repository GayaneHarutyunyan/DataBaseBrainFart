package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;


@Entity
@Table(name = "Test_Availability")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)

public class TestAvailability implements Serializable {

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
}
