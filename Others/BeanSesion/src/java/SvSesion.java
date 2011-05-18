import com.prueba.sesion.*;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author Pepe
 */
public class SvSesion extends HttpServlet{

    @EJB
    private BeanSesion sesion;

    public void service(HttpServletRequest request,
                        HttpServletResponse response)
                        throws ServletException, java.io.IOException{
        response.getWriter().println(sesion.getHola());
    }

}
