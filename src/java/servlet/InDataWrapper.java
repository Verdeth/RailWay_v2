package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
/**
 *
 * @author MSI
 */
public class InDataWrapper {
	private HttpServletRequest request;
	private HttpSession session;
	
	public InDataWrapper(HttpServletRequest request){
		this.request = request;
		this.session = request.getSession(true);
	}
	
	public Object getRequestParametr(String param){
		return request.getParameter(param);
	}
	
	public void setRequestAttribute(String key, Object attr){
		request.setAttribute(key, attr);
	}
        
        public void removeRequestAttribute(String key, Object attr){
		request.removeAttribute(key);
	}
        
	
	public Object getRequestAttribute(String key){
		return request.getAttribute(key);
	}
	
	public void  setSessionAttribute(String key, Object attr){
		session.setAttribute(key, attr);
		
	}
	
	public Object getSessionAttribute(String key){
		return session.getAttribute(key);
	}
	
	public void sessionInvalidate() {
		session.invalidate();
	}
	
}