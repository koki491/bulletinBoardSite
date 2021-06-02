package bulletinBoard.domain;

//import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//@Entity
//@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String message;
//    @Column(name= "dt")
    private String dt;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(nullable = true, name = "username", insertable = false, updatable = false)
    private User user;

}
