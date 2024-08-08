package ProjectData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class MesssageBodyResponse {

    @Getter
    @Setter
    @AllArgsConstructor
    public class MessageBodyResponse {
        public String id;
        public String name;
        public String subject;
        public boolean read;

    }
}
