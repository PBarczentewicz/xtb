package ProjectData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.nio.file.FileStore;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class MessageBody {
public String id;
public String name;
public String subject;
public boolean read;


}
