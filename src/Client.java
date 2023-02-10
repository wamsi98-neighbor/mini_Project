import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

            ConvertData cd = new ConvertData();

            String SERVER_IP = "211.189.132.233";

            System.out.println("서버에 연결 중입니다. 서버 IP : " + SERVER_IP);

            // 1. Socket 생성 및 IP와 Port 할당
            try {
                Socket socket = new Socket(SERVER_IP, 4444);
        /*
        2. getOuputSream()은 Socket 반대편 프로그램으로 Data를 쓰기 위한 OutputStream을 반환해준다. 그래서 OutputStream 타입 변수에 대입
        3. 그리고 이 Stream을 사용하기 전에 OutputStream 클래스를 확장하는 DataOutputStream과 연결
        3-1. DataOutputStream에는 Data type별로 출력하는 별도의 메소드들이 있고, 기본 데이터를 매개변수로 호출함
        3-2. 기존 OutputStream은 byte단위 입출력이지만, DataOutputSteam은 Primitive type을 입력하기 알맞은 클래스이다.
        3-3. DataOutputStream는 생성자에서 OutputStream을 받아들인다.
        3-4. 생성자의 argument값으로 OutputStream을 받아들인다는 것은, 즉 그 하위 클래스들도 받아들인다는 의미? --> Socket을 말하는 건가
         */
                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                String name = InputData.inputName();
                String packet = cd.byteToHex(cd.stringToByte(name));

                // 4. writeUTF(String str)을 사용
                dos.writeUTF(packet);
                System.out.println("패킷을 전송합니다.");

                dos.close();
                socket.close();

            } catch (ConnectException ce) {
                ce.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

}