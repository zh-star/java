package v2;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: STAR
 * Date: 2019 -12
 * Time: 18:29
 */
public class LoginServlet extends HttpServlet{
    @Override
    public void doGet(Request req, Response resp) {
        String[] group = req.path.split("=");
        if (group.length != 2) {
            resp.setStatus("401 Unauthorized");
            resp.setHeader("Content-Type", "text/html; charset=UTF-8");
            resp.println("<h1>请登陆</h1>");
            return;
        }
        String username = group[1];
        User currentUser = null;
        for (User user : SimpleHttpServer.users) {
            if (user.username.equals(username)) {
                currentUser = user;
            }
        }
        if (currentUser == null) {
            resp.setStatus("401 Unauthorized");
            resp.setHeader("Content-Type", "text/html; charset=UTF-8");
            resp.println("<h1>请登陆</h1>");
            return;
        }

        resp.setStatus("200 OK");
        resp.setHeader("Content-Type", "text/html; charset=UTF-8");
        resp.println("<h1>登陆成功</h1>");
    }
}
