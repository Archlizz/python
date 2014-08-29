package cn.com.phoenix.test.idcard;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;


public class CardReader {
		
	private String[] GetErrMsg( int nRet )
	{
		String[] strMsg = new String[ 2 ];
		
		Arrays.fill(strMsg, "" );
		
		switch( nRet )
		{
		case 0:
			strMsg[0] = "0";
			strMsg[1] = "成功";
			break;
		case -1:
			strMsg[0] = "1";
			strMsg[1] = "打开串口失败";
			break;
		case -2:
			strMsg[0] = "2";
			strMsg[1] = "向串口发送数据错误";
			break;
		case -4:
			strMsg[0] = "4";
			strMsg[1] = "接收到的数据错误";
			break;
		case -5:
			strMsg[0] = "5";
			strMsg[1] = "无二代证或超时";
			break;
		case -6:
			strMsg[0] = "6";
			strMsg[1] = "读卡操作失败";
			break;
		case -7:
			strMsg[0] = "7";
			strMsg[1] = "解析头像错误";
			break;
		case -100:
			strMsg[0] = "8";
			strMsg[1] = "其他错误";
			break;	
		}
		
		return strMsg;
	}
	
	public String[] getIDCardInfo( String strPort, String strBaud, String strTimeout )
	{
		PERSONINFO pInfo    = new PERSONINFO();
		String[]   strRet   = new String[ 9 ];
		int       dwBaud   = Integer.parseInt(strBaud); 
		int       nTimeOut = Integer.parseInt(strTimeout); 
		int        nPort    = Integer.parseInt(strPort.substring(3));
		int       nRet     = 0;
		
		Arrays.fill(pInfo.name,       (byte)0 );
		Arrays.fill(pInfo.sex,        (byte)0 );
		Arrays.fill(pInfo.nation,     (byte)0 );
		Arrays.fill(pInfo.birthday,   (byte)0 );
		Arrays.fill(pInfo.address,    (byte)0 );
		Arrays.fill(pInfo.cardId,     (byte)0 );
		Arrays.fill(pInfo.police,     (byte)0 );
		Arrays.fill(pInfo.validStart, (byte)0 );
		Arrays.fill(pInfo.validEnd,   (byte)0 );
		Arrays.fill(pInfo.sexCode,    (byte)0 );
		Arrays.fill(pInfo.nationCode, (byte)0 );
		Arrays.fill(pInfo.appendMsg,  (byte)0 );
		Arrays.fill(strRet,           ""      );
		
		nRet = IDCard.instanceDll.CT_ReadIDCard( nPort, null, dwBaud, nTimeOut, null, pInfo );
		if( nRet == 0 )
		{
			strRet[ 0 ] = GetErrMsg( (int)nRet )[0];
			strRet[ 1 ] = (new String( pInfo.name       )).trim();
			strRet[ 2 ] = (new String( pInfo.sex        )).trim();
			strRet[ 3 ] = (new String( pInfo.nation     )).trim();
			strRet[ 4 ] = (new String( pInfo.birthday   )).trim();
			strRet[ 5 ] = (new String( pInfo.address    )).trim();
			strRet[ 6 ] = (new String( pInfo.cardId     )).trim();
			strRet[ 7 ] = (new String( pInfo.police     )).trim();
			strRet[ 8 ] = (new String( pInfo.validStart )).trim()+(new String(pInfo.validEnd)).trim();
		}
		else
		{
			strRet[ 0 ] = GetErrMsg( nRet )[0];
			strRet[ 1 ] = GetErrMsg( nRet )[1];
		}
		
		return strRet;
	}
	
	public String[] getPicInfo( String strPhotoPath, String strFullPath, String strPort, String strBaud, String strTimeout )
	{
		PERSONINFO pInfo    = new PERSONINFO();
		String[]   strRet   = new String[ 3 ];
		int        dwBaud   = Integer.parseInt(strBaud); 
		int        nTimeOut = Integer.parseInt(strTimeout); 
		int        nPort    = Integer.parseInt(strPort.substring(3));
		int        nRet     = 0;
		
		Arrays.fill(pInfo.name,       (byte)0 );
		Arrays.fill(pInfo.sex,        (byte)0 );
		Arrays.fill(pInfo.nation,     (byte)0 );
		Arrays.fill(pInfo.birthday,   (byte)0 );
		Arrays.fill(pInfo.address,    (byte)0 );
		Arrays.fill(pInfo.cardId,     (byte)0 );
		Arrays.fill(pInfo.police,     (byte)0 );
		Arrays.fill(pInfo.validStart, (byte)0 );
		Arrays.fill(pInfo.validEnd,   (byte)0 );
		Arrays.fill(pInfo.sexCode,    (byte)0 );
		Arrays.fill(pInfo.nationCode, (byte)0 );
		Arrays.fill(pInfo.appendMsg,  (byte)0 );
		Arrays.fill(strRet,           ""      );
		
		nRet = IDCard.instanceDll.CT_ReadIDCard( nPort, null, dwBaud, nTimeOut, strPhotoPath.getBytes(), pInfo );
		if( nRet == 0 )
		{
			nRet = IDCard.instanceDll.CT_SaveCardImg(pInfo, strFullPath.getBytes() );
		}
			
		if( nRet == 0 )
		{
			strRet[ 0 ] = GetErrMsg( nRet )[0];
			strRet[ 1 ] = strPhotoPath;
			strRet[ 2 ] = strFullPath;
		}
		else
		{
			strRet[ 0 ] = GetErrMsg( nRet )[0];
			strRet[ 1 ] = GetErrMsg( nRet )[1];
		}
		return strRet;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(System.getProperty("java.io.tmpdir"));
		CardReader idcard = new CardReader();
		String[]   strRet = null;
		strRet = idcard.getIDCardInfo( "COM3", "115200", "20" );
		//strRet = idcard.getPicInfo( "D:\\img.bmp", "D:\\card.bmp", "COM1", "9600", "40" );
		System.out.println("strRet[0]："+strRet[0]);
		System.out.println("strRet[1]："+strRet[1]);
		System.out.println("strRet[2]："+strRet[2]);
		System.out.println("strRet[3]："+strRet[3]);
		System.out.println("strRet[4]："+strRet[4]);
		System.out.println("strRet[5]："+strRet[5]);
		System.out.println("strRet[6]："+strRet[6]);
		System.out.println("strRet[7]："+strRet[7]);
		System.out.println("strRet[8]："+strRet[8]);
	}
}
