package mx.ipn.escom.wad.servlets.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class Ejemplo8
 */
public class Ejemplo8 implements Filter {

	private Integer parametro1;
	
    /**
     * Default constructor. 
     */
    public Ejemplo8() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Finalizando filtro...");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Ejemplo8: Filtrando petición..."+parametro1);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("Inicializando filtro...");
		parametro1 = Integer.valueOf(fConfig.getInitParameter("parametro1"));
	}

	public Integer getParametro1() {
		return parametro1;
	}

	public void setParametro1(Integer parametro1) {
		this.parametro1 = parametro1;
	}
}
