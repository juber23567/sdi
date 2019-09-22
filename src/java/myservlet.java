
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;


public class myservlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1","root","");
            Statement stm=con.createStatement();
            /*stm.executeUpdate("INSERT INTO demo VALUES('soheb' , 'khan')");*/
            ResultSet res=stm.executeQuery("select * from demo");
            
           
            
            
            
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet myservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet myservlet at " + request.getContextPath() + "</h1>");
            out.print("<table border='1'><tr><td>First_name</td><td>Surname</td></tr>");

            while(res.next())
            {
                String name=res.getString("name");
                String surname=res.getString("surname");

                out.print("<tr><td>"+name+"</td>");
                out.print("<td>"+surname+"</td></tr><br>");
            }
          
            out.println("</table></body>");
            out.println("</html>");
        }
    catch(ClassNotFoundException | SQLException e){
    out.println(e);
}
}
}