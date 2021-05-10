package kodlamaio.hrms.entities.concretes;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Data
@Table(name="job_positions")
public class JobPosition{

    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;


    @Column(name="name")
    private String name;


}
