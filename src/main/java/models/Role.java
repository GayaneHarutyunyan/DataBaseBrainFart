package models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "role")
@AllArgsConstructor
@Getter
@Setter
public class Role extends Model {

    @NotNull
    @Min(value = 4)
    @Column(name = "title", length = 40,insertable = false, updatable = false)
    private RoleList title;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "position")
    private String position;

    @OneToMany(mappedBy = "roleId", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Admin> admin = new HashSet<>();

    public Role() {
        super();
    }

    public Role(Long id) {
        super(id);
    }
}
