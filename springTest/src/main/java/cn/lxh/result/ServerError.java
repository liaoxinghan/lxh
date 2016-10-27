package cn.lxh.result;
/**
* <p>Title: Error</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-17
*/
public class ServerError {

	public enum errorCode{
		
		ACCESS_RESTRICTIONS("666","访问限制");

		private String code;
		
		private String msg;
		
		private errorCode(String code, String msg) {
			// TODO Auto-generated constructor stub
			this.code = code;
			this.msg = msg;
					
		}

		public String getCode() {
			return code;
		}

		public void setCode(String code) {
			this.code = code;
		}

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		
	}
}
