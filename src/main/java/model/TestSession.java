package model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "Test_Session")
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@ToString(doNotUseGetters = true)
@EqualsAndHashCode(doNotUseGetters = true)

public class TestSession implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private Users userId;

    @NotNull
    @Column(name = "submit_date")
    private Date submitDate;

    @NotNull
    @Column(name = "test_result")
    private Integer testResult;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testSessionId")
    private List<QuestionResults> questionResultses=new ArrayList<>();
}
