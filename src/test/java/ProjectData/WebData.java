package ProjectData;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WebData {
    String name;
    String email;
    String phone;
    String subject;
    String description;
}
