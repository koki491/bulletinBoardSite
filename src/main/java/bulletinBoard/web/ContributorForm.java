package bulletinBoard.web;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContributorForm {
    @NotNull
    @Size(min=1, max=16)
    private String username;
}
