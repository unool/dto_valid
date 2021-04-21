package com.january.dto_valid.dto;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Setter
@Getter
public class MemberDTO {

    @Size(min = 2, max = 20)
    @NotEmpty(message = "id는 빈값 일 수 없습니다")
    @NotNull(message = "id는 Null 일 수 없습니다")
    private String id;

    @Size(min = 8, max = 12)
    @NotEmpty(message = "비밀번호는 빈값 일 수 없습니다")
    @NotNull(message = "비밀번호는 Null 일 수 없습니다")
    private String password;

    @Size(min = 2, max = 8)
    @NotEmpty(message = "이름은 빈값 일 수 없습니다")
    @NotNull(message = "이름은 Null 일 수 없습니다")
    private String name;


    @Email
    @Size(min = 12, max = 20)
    @NotEmpty(message = "이메일은 빈값 일 수 없습니다")
    @NotNull(message = "이메일은 Null 일 수 없습니다")
    private String email;

}
