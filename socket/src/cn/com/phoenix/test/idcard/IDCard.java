package cn.com.phoenix.test.idcard;
import com.sun.jna.Library;  
import com.sun.jna.Native;  

public interface IDCard extends Library{
	IDCard instanceDll  = (IDCard)Native.loadLibrary("../lib/CENT_IDReader.dll",IDCard.class);  
	public int CT_ReadIDCard( int nPort, byte[]szBpNo, int dwBaud, int nTimeOut, byte[]zPhotoImg, PERSONINFO pInfo );
    public int CT_SaveCardImg(PERSONINFO pInfo, byte[]szCardImg );
}
