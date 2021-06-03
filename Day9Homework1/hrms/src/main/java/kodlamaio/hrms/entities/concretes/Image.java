package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="images")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","cv"})
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @NotNull
    @NotBlank
    @Column(name="url" , length = 255)
    private String url;

    @NotNull
    @NotBlank
    @Column(name="public_image_id" , length = 50)
    private String publicImageId;

    @Column(name="created_date")
    private LocalDate createdDate = LocalDate.now();

    @OneToOne(mappedBy = "image")
    private Cv cv;
}
