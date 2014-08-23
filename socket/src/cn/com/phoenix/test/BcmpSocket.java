package cn.com.phoenix.test;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 * BcmpSocket
 * 
 * @author Ktwo
 *
 */
public class BcmpSocket {

			//数据
			String param = "theAction=updateClientStatus";
			
			
			
			//拼接HTTP 
			static StringBuilder sb = new StringBuilder();
			
			public static boolean send(String address,int port) throws Exception{
				//拼接字符串
				sb.append("POST /bcmp/bcmp/imitateclient.do?theAction=updateClientStatus&id=0002&sourceIp=11.0.160.164&stateCode=normal&lastMessage=tre HTTP/1.1\r\n");
				sb.append("User-Agent: MSIE6.0\r\n");
				sb.append("HOST: www.phoenix.com\r\n");
				sb.append("Content-Type: text/html;charset=UTF-8\r\n");
				sb.append("Accept-Encoding: gzip\r\n");
				sb.append("Connection: Keep-Alive\r\n");
				sb.append("\r\n");
				String info = sb.toString();
	
				byte[] stream = info.getBytes();
				
				//socket
				Socket socket = null;
				
				OutputStream out = null;
				
				InputStream in = null;
				
				
				try{
					socket = new Socket(address,port);
					out = new BufferedOutputStream(socket.getOutputStream());
					out.write(stream);
					out.flush();
					
//					ByteArrayOutputStream byteOut=new ByteArrayOutputStream();
//					int len=-1;
//					byte[] buffer=new byte[1024];
//					
//					in=new BufferedInputStream(socket.getInputStream());
//					while((len=in.read(buffer))!=-1){
//						byteOut.write(buffer,0,len);
//					}
//					
//					String s=byteOut.toString("UTF-8");
//					String[] items=s.split("\r\n");
//					for(String item:items){
//						System.err.println(item);
//					}
					
					BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
					
					
					String line="";
					do{
						line=reader.readLine();
					}while(line!=null&&line.length()>0);
					
					char[] chars = new char[4];
					int expectLen=4;
					
					int n=0;
					while(n<expectLen){
						int m=reader.read(chars,n,(expectLen-n));
						n+=m;
					}
					String s = new String(chars);
					if(s.equals("true")){
						return true;
					}	
				}catch(Exception e){
					e.printStackTrace();
				}
				finally{
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
				return false;
			}
			
}
