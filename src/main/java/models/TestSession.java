package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "test_session")
@Getter
@Setter
@AllArgsConstructor
public class TestSession extends Model {

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "test_id", referencedColumnName = "id")
    private Test testId;

    @NotNull
    @Column(name = "test_result")
    private Integer testResult;

    @NotNull
    @Column(name = "submit_date")
    private Date submitDate;

    @OneToMany(mappedBy = "testSessionId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionResult> questionResultses = new HashSet<>();

    public TestSession() {
        super();
    }

    public TestSession(Long id) {
        super(id);
    }

}
