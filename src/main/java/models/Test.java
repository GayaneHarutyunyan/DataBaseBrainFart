package models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;


@Entity
@Table(name = "test")
@Getter
@Setter
@AllArgsConstructor
public class Test extends Model {

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subjectId;

    @Lob
    @NotNull
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "publicity")
    private boolean publicity;

    @Lob
    @Column(name = "img")
    private String img;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    private Admin adminId;

    @OneToMany(mappedBy = "testsId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<QuestionConnection> questionConnectionses = new HashSet<>();

    @OneToMany(mappedBy = "testsId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TestAvailability> testAvailabilityes = new HashSet<>();

    @OneToMany(mappedBy = "testsId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TestSession> testSessions = new HashSet<>();

    public Test() {
        super();
    }

    public Test(Long id) {
        super(id);
    }
}
