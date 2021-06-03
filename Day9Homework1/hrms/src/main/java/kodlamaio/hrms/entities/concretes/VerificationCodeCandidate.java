package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Table(name="verification_code_candidates")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name="verification_code_id",referencedColumnName = "id")
public class VerificationCodeCandidate extends VerificationCode{

    @Column(name="candidate_id")
    private int candidateId;
}
