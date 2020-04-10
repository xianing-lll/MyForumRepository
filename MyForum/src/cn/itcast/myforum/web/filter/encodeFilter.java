package cn.itcast.myforum.web.filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Servlet Filter implementation class EncodingFilter
 */
public class encodeFilter implements Filter {

    /**
     * Default constructor. 
     */
    public encodeFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		
        	//处理请求乱码
    		HttpServletRequest httpServletRequest=(HttpServletRequest)request;
    		HttpServletRequest myRequest=new MyRequest(httpServletRequest);
    		//处理相应乱码
        	response.setContentType("text/html; charset=utf-8"); 
    		chain.doFilter(myRequest, response);
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}



class MyRequest extends HttpServletRequestWrapper{

	private HttpServletRequest request; 
	private boolean hasEncode;
	public MyRequest(HttpServletRequest request) {
		super(request);  //supper
		// TODO Auto-generated constructor stub
		this.request=request;
	}
	//对需要增强的方法进行覆盖
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		Map<String, String[]> parameterMap=getParameterMap();
		String[] values=parameterMap.get(name);
		if (values==null) {
			return null;
		}
		return values[0];
	}
	@Override
	public Map getParameterMap() {
		// TODO Auto-generated method stub
		//先获得请求方式
		String method=request.getMethod();
		if (method.equalsIgnoreCase("post")) {
			//post请求
			try {
				//处理post乱码
				request.setCharacterEncoding("utf-8");  //该方法只对post方法有效
				return request.getParameterMap();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		} else if(method.equalsIgnoreCase("get")){
			//get请求
			Map<String, String[]> parameterMap=request.getParameterMap();
			if(!hasEncode)//确保get手动编码逻辑值运行一次
			{
				for (String parameterName : parameterMap.keySet()) {
					String[] values=parameterMap.get(parameterName);
					if (values!=null) {
						for (int i = 0; i < values.length; i++) {
							try {
								values[i]=new String(values[i].getBytes("ISO-8859-1"), "utf-8");
							} catch (Exception e) {
								// TODO: handle exception
								e.printStackTrace();
							}
						}
					}
				}
				hasEncode=true;
			}
			return parameterMap;
		}
		return super.getParameterMap();
	}
	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		Map<String, String[]> parameterMap=getParameterMap();
		String[] values=parameterMap.get(name);
		return values;
	}
	
	
}

