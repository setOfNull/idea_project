package kg.megalab.demo.dal.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import kg.megalab.demo.dal.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveDto {



    @NotBlank(message = "login.not.empty")
    @Size(min = 5, max = 20, message = "login.size")
    private String login;

    @NotBlank(message = "email.not.empty")
    @Email(message = "email")
    private String email;

    @Size(min = 3, max = 50)
    private String firstname;

    @Size(min = 3, max = 50)
    private String lastname;

    @NotNull(message = "bday.not.empty")
    @Past(message = "only.past.time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate birthDt;


    public UserSaveDto(UserEntity user){
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.birthDt = user.getBirthDt();
    }
}
