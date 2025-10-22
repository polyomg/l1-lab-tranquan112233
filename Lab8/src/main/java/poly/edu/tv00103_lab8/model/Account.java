package poly.edu.tv00103_lab8.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private String username;

    private String password;

    private String fullname;

    private String email;

    private String photo;

    private boolean activated;

    private boolean admin;

}
