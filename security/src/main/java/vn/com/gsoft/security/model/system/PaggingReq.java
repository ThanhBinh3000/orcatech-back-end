package vn.com.gsoft.security.model.system;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class PaggingReq {
    @NotNull(message = "Must not be empty!")
    Integer limit;
    @NotNull(message = "Must not be empty!")
    @PositiveOrZero(message = "Search page must be >= 1!")
    Integer page;
}