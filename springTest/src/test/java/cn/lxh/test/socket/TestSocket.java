package cn.lxh.test.socket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
* <p>Title: TestSocket</p>
* <p>Description: </p>
* <p>Company: zhph</p> 
* @author liaoxinghan
* @date 2016-10-17
*/
public class TestSocket {

	public static void connect() {
		Socket socket = null;
		BufferedWriter bw = null;
		InputStream inputStream = null;
		BufferedReader br = null;
		try {
			socket = new Socket("127.0.0.1", 8080);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			for (int i = 0; i < 15; i++) {
				bw.write("GET /springTest/view/index HTTP/1.1\r\n");
				bw.write("Host: 127.0.0.1\r\n");
				bw.write("\r\n");
				bw.flush();
				String line = null;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
					if (line.contains("</html>")) {
						break;
					}
				}
			}
//			inputStream = socket.getInputStream();
//			byte[] bs = new byte[1024];
//			while (inputStream.read(bs) != -1) {
//				System.out.println(bs);
//			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		connect();
	}
}
