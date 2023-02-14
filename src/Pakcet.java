public class Pakcet {
    public static void main(String[] args) {
        
        String packet = "1010C01001000b1e8c1f8b0c7";        // 업무코드 10, 세부코드10, 메뉴코드 C01, 가격001000, 이름 b1e8c1f8b0c7

        String[] inter = {"업무코드", "세부코드", "메뉴코드", "가격", "이름"};  // 인터페이스상 속성명
        int[] pckArr = {2,2,3,6,12};                        // 인터페이스상 패킷의 길이 저장

        // int rs = Character.getNumericValue(packet.charAt(0));   // 0번째 문자열 가져오기



        
        // 필요한거 0. 시작지점 임시변수 1. 시작지점을 어떻게 가져올건지, 2. 어떻게 끊을건지, 3. 시작지점을 계속 갱신해줘야함
        int temp = 0;                                       // 시작지점을 잡아줄 임시변수
        for (int i = 0; i<pckArr.length; i++){
            System.out.println("현재 시작 지점 " + temp + " / 끝나는 지점" + (temp+pckArr[i]));
            System.out.println(inter[i] + " : "+ packet.substring(temp, temp+pckArr[i]));
//            System.out.println(temp);                     // 시작지점 확인
            temp = temp+pckArr[i];                          // 시작지점 갱신
        }
    }
}
