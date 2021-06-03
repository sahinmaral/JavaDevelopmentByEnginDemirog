package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@Entity
@Table(name="verification_code_employers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="verification_code_id",referencedColumnName = "id")
public class VerificationCodeEmployer extends VerificationCode{

    @Column(name="employer_id")
    private int employerId;
}
