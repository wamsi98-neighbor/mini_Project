import java.io.UnsupportedEncodingException;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {

        /*
        0. 메인 (실행)
        1. 입력부 (-> 2)
        2. 변환부
        3. 송신부
        4. 수신부
        5. 파싱부
        7. 출력부
        8. DB 커넥트부
        9. DB저장부

        0. 메인에서 Server On
        1. Client On
        2. 입력 메소드 실행
        3. 입력 패킷 Convert
        4. Convert된 패킷을 Stream에 담아서 Server로 전송
        5. Server에서 패킷 검증? 길이 맞나 검증해야하나, 형식을 검증해야하나?
        6. 패킷 파싱 (어떻게 구분할지, 자를지 생각)
        7. 패킷 중 필요한 건 Convert 수행
        8. Server에서 출력
        9. JDBC 커넥트 요청
        10. DB 삽입 및 조회까지?

         */
        Server.ServerOn();

    }
}