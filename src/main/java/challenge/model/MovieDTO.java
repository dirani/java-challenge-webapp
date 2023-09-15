package challenge.model;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class MovieDTO {
    private UUID id;
    private String title;
}