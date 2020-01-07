package v2;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 14:54
 */
public class User implements Serializable {
    String id;
    String username;
    String avatarUrl;
    String show;

    User(String username, String avatarUrl, String show) {
        this.id = UUID.randomUUID().toString();
        this.username = username;
        this.avatarUrl = avatarUrl;
        this.show = show;
    }
}
