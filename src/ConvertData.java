import java.io.UnsupportedEncodingException;

public class ConvertData {

    // String -> byte[]
    public static byte[] stringToByte (String packet) throws UnsupportedEncodingException {

        byte[] byteArr = packet.getBytes("EUC-KR");

        return byteArr;
    }

    // byte[] -> hex
    public static String byteToHex (byte[] byteArr) {

        StringBuilder sb = new StringBuilder();

        for (byte b : byteArr){
            sb.append(String.format("%02X", b&0xff));
        }
        return sb.toString().toLowerCase();
    }
    // hex -> byte[]
    public static byte[] hexToByte(String hex){

        int byteLen = hex.length();

        byte[] data = new byte[byteLen/2];

        for(int i = 0 ; i < byteLen ; i+=2){

            data[i/2] = (byte) ((Character.digit(hex.charAt(i),16) <<4 ) + Character.digit(hex.charAt(i+1),16));

        }
        return data;
    }
    // byte[] -> String
    public static  String byteToString(byte[] byteArr) throws UnsupportedEncodingException {

        return new String(byteArr, "EUC-KR");
    }


}
