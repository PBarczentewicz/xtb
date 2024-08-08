package ProjectData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MessagesBody {

public int id;
public String name;
public String subject;
public boolean read;

}


