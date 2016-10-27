package cn.lxh.exception;
/**
* <p>Title: RequestLimitException</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-17
*/
public class RequestLimitException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RequestLimitException() {
		
		super("HTTP请求超出设定的限制");
		// TODO Auto-generated constructor stub
	}
	
	public RequestLimitException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
