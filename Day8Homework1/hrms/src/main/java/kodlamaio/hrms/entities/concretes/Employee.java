package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
@EqualsAndHashCode(callSuper = true)
public class Employee extends User {

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

}
