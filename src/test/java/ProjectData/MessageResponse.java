package ProjectData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse {
    public String messageid;
    public String name;
    public String email;
    public String phone;
    public String subject;
    public String description;
}
