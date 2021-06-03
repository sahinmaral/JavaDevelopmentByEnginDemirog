package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name="verification_codes")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class VerificationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code" , length = 500)
    private String code;

    @Column(name="is_verified")
    private boolean isVerified;

    @Column(name="verified_date")
    private Date verifiedDate;

    @Column(name="created_date")
    private LocalDate createdDate = LocalDate.now();

}
