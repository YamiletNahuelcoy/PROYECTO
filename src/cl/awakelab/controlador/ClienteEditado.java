package cl.awakelab.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.awakelab.modelo.Cliente;
import cl.wakelab.implementacion.UsuariosImpl;

/**
 * Servlet implementation class ClienteEditado
 */
@WebServlet("/ClienteEditado")
public class ClienteEditado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteEditado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		String RutCliente = request.getParameter("txtrutcliente");
		String clienombres = request.getParameter("txtnomcliente");
		String cliapellidos = request.getParameter("txtapecliente");
		String clitelefono = request.getParameter("txttelcliente");
		String cliafp = request.getParameter("txtafpcliente");
		int clisistemasalud = Integer.parseInt(request.getParameter("sisSalud"));
		String clidireccion = request.getParameter("txtdirecccliente");
		String clicomuna = request.getParameter("txtcomcliente");
		int CliEdad = Integer.parseInt(request.getParameter("txtedadcliente"));
		int usuario_idusuario = Integer.parseInt(request.getParameter("txtidclieuser"));
		

		Cliente us = new Cliente();
		us.setCliente_idusuario(usuario_idusuario);
		us.setRutCliente(RutCliente);
		us.setClienombres(clienombres);
		us.setCliapellidos(cliapellidos);
		us.setClitelefono(clitelefono);
		us.setCliafp(cliafp);
		us.setClisistemasalud(clisistemasalud);
		us.setClidireccion(clidireccion);
		us.setClicomuna(clicomuna);
		us.setCliEdad(CliEdad);
		
		

		UsuariosImpl userimpl = new UsuariosImpl();
		boolean res = userimpl.editarCliente(us);
		String msg = "";

		if (res) {
			msg = "El cliente se edit� exitosamente";
		} else {
			msg = "El cliente no se pudo editar porque ocurri� un error";
		}

		request.setAttribute("mensaje", msg);
		request.getRequestDispatcher("msgcreacion.jsp").forward(request, response);

	}

}
