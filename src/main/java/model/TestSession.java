package model;

import lombok.*;
import org.apache.log4j.Logger;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "Test_Session")
//@Data
//@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ToString(doNotUseGetters = true)
//@EqualsAndHashCode(doNotUseGetters = true)

public class TestSession implements Serializable {
    private static Logger log = Logger.getLogger(TestSession.class.getName());

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "user_id", nullable = false)
    @NotNull
    private Users userId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "test_id", nullable = false)
    @NotNull
    private Tests testsId;

    @NotNull
    @Column(name = "test_result")
    private Integer testResult;

    @NotNull
    @Column(name = "submit_date")
    private Date submitDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "testSessionId")
    private Set<QuestionResults> questionResultses = new HashSet<>();
}
