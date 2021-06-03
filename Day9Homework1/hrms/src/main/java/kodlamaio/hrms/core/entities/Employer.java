package kodlamaio.hrms.core.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.concretes.JobAdvert;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employers")
@EqualsAndHashCode(callSuper = true)
public class Employer extends User {

    @NotEmpty
    @Column(name = "company_name")
    private String companyName;

    @NotEmpty
    @Pattern(regexp = "^https?://[^/]+/([^/]+)/.*$")
    @Column(name = "web_site")
    private String webSite;

    // +90 (212) 123 12 12
    @Pattern(regexp = "^\\+(\\d{2})\\s\\((\\d{3})\\)\\s(\\d{3})\\s(\\d{2})\\s(\\d{2})")
    @Column(name = "phone_number" , length = 11)
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "employers")
    private List<JobAdvert> jobadvert;

}
