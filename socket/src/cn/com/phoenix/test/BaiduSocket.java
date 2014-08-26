package cn.com.phoenix.test;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * BaiduSocket
 * 
 * @author Ktwo
 *
 */
public class BaiduSocket {

	
	String address = null;
	int port = -1;
	String wordKey = "";
	
	/**
	 * 构造方法
	 * @param address
	 * @param port
	 */
	public BaiduSocket(String address,int port){
		this.address= address;
		this.port=port;
	}
	
	public BaiduSocket(String address,int port,String wd){
		this.address= address;
		this.port=port;
		this.wordKey=wd;
	}
	
	public String searchRequest() throws UnknownHostException, IOException{
		
		//拼接字符串
		System.out.println("拼接报文");
		StringBuilder sb = new StringBuilder();
		sb.append("POST /#wd=java");
		//sb.append(wordKey);
		sb.append(" HTTP/1.1\r\n");
		sb.append("User-Agent: MSIE6.0\r\n");
		sb.append("HOST: www.baidu.com\r\n");
		sb.append("Content-Type: application/x-www-form-urlencoded\r\n");
		sb.append("Accept-Encoding: gzip\r\n");
		sb.append("Connection: Keep-Alive\r\n");
		sb.append("\r\n");
		String info = sb.toString();
		
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		try{
			//建立socket
			System.out.println("建立socket");
			socket = new Socket(address,port);
			//向服务器发送消息
			out = new BufferedOutputStream(socket.getOutputStream());
			out.write(info.getBytes("UTF-8"));
			out.flush();
			
			ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
			int len = -1;
			//从服务端读取信息
			byte[] stream = new byte[1024];
			in = new BufferedInputStream(socket.getInputStream());
			System.out.println("从服务端接收数据");
			while((len = in.read(stream))!=-1){
				byteOut.write(stream,0,len);
			}
			byteOut.flush();
			info = byteOut.toString("GB18030");
			System.out.println(info);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(out!=null){
				try{
					out.close();
				}catch(Exception e){
					//do nothing
				}
			}
			if(in!=null){
				try{
					in.close();
				}catch(Exception e){
					//do nothing
				}
			}
			if(socket!=null){
				try{
					socket.close();
				}catch(Exception e){
					//do nothing
				}
			}
		}
		return info;
	}
}
