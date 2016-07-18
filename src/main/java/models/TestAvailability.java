package models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;


@Entity
@Table(name = "test_availability")
@AllArgsConstructor
@Getter
@Setter
public class TestAvailability extends Model {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="test_id", referencedColumnName = "id")
    private Test testId;

    @NotNull
    @Column(name = "start_date")
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    public TestAvailability() {
        super();
    }

    public TestAvailability(Long id) {
        super(id);
    }

}
