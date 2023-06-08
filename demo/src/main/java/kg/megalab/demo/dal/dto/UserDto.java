package kg.megalab.demo.dal.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import kg.megalab.demo.dal.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Size(min = 5, max = 20)
    @NotBlank(message = "login.not.empty")
    private String login;

    @Email(message = "email")
    @NotBlank(message = "email.not.empty")
    private String email;

    @Size(min = 3, max = 50)
    private String firstname;

    @Size(min = 3, max = 50)
    private String lastname;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createdDt;

    @NotNull(message = "bday.not.empty")
    @Past(message = "only.past.time")
    @JsonFormat(shape = JsonFormat.Shape.STRING,  pattern = "yyyy-MM-dd")
    private LocalDate birthDt;

    private List<IdeaDto> ideas;


    public UserDto(UserEntity user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.email = user.getEmail();
        this.firstname = user.getFirstname();
        this.lastname = user.getLastname();
        this.createdDt = LocalDateTime.now();
        this.birthDt = user.getBirthDt();
        this.ideas = user.getIdeas().stream()
                .map(IdeaDto::new)
                .collect(Collectors.toList());
    }


}
