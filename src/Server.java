import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void ServerOn(){

        ConvertData cd = new ConvertData();
        String SERVER_IP = "211.189.132.233";
        // 1. Server프로그램에서 사용하는 소켓, Port를 통해 연결 요청이 오기를 대기
        ServerSocket serverSocket = null;

        // 2. 특정 Port를 열어놓은 상태에서 대기, 접속 요청이 온다면 새로운 소켓으로 연결처리
        try{
            serverSocket = new ServerSocket(4444);
        }catch (IOException e){
            System.out.println("이미 존재하는 포트입니다.");
        }

        while (true){

            System.out.println("연결 요청을 기다리는 중입니다.");

            // 3. accept() 메소드 호출. Client로부터 요청이 올 때까지 Blocking 상태
            // 4. Connection 요청이 들어오면 새로운 Socket을 생성하여, Client와 한쌍을 이루고 연결됨
            try {
                Socket socket = serverSocket.accept();

                Socket socket2 = new Socket(SERVER_IP, 5555);

                System.out.println("접속자 IP : "+ socket.getInetAddress());
                //Client.Client_On();
                // 5. getInputStream은 inputStream 객체를 반환하기 때문에 InputStream type 변수에 대입
                // 6. DataOutput 주석과 동일
                InputStream in = socket.getInputStream();
                DataInputStream dis = new DataInputStream(in);

                // 7. readUTF()로 받은 메세지를 UTF-8 인코딩을 통해서 읽어들임
                String packet = dis.readUTF();
                String name = cd.byteToString(cd.hexToByte(packet));
                System.out.println("[Server 출력] 받은 메세지 : "+name);

                // ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ DB전송?
                OutputStream out = socket2.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF(packet);
                System.out.println("[Server -> DB]패킷을 전송합니다.");

                dis.close();
                socket.close();
                System.out.println("연결을 종료했습니다.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
