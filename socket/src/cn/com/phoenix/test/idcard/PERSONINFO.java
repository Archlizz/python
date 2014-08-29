package cn.com.phoenix.test.idcard;
import com.sun.jna.Structure;


public class PERSONINFO extends Structure{
	public byte[ ]name       = new byte[ 32 ];
	public byte[ ]sex        = new byte[ 4  ];
	public byte[ ]nation     = new byte[ 20 ];
	public byte[ ]birthday   = new byte[ 12 ];
	public byte[ ]address    = new byte[ 72 ];
	public byte[ ]cardId     = new byte[ 20 ];
	public byte[ ]police     = new byte[ 32 ];
	public byte[ ]validStart = new byte[ 12 ];
	public byte[ ]validEnd   = new byte[ 12 ];
	public byte[ ]sexCode    = new byte[ 4  ];
	public byte[ ]nationCode = new byte[ 4  ];
	public byte[ ]appendMsg  = new byte[ 72 ];
}
