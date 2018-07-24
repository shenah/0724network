import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {

	public static void main(String[] args) {
		
		try {
			//보내는 멀티캐스트 소켓 만들기
			MulticastSocket ms = new MulticastSocket();
			//보내는 사용자 닉네임 설정
			Scanner sc = new Scanner(System.in);
			System.out.println("닉넴 입력:");
			String nick = sc.nextLine();
			//받을 곳의 주소 
			InetAddress ia = InetAddress.getByName("230.100.50.5");
			//보낼 데이터 입력하기
			while(true) {
				System.out.println("전송자료 입력(종료는 end):");
				String msg = sc.nextLine();
				//데이터 보내기 종료설정
				if(msg.equals("end")) {
					//종료시 보낼 메세지 만들기
					msg = nick + "방에서 나감";
					DatagramPacket dp = new DatagramPacket
							(msg.getBytes(), msg.getBytes().length, ia, 9999);
					//메세지 전송
					ms.send(dp);
					//스캐너, 소켓 닫기
					sc.close();
					ms.close();
					break;
				}
				//보낼 데이터 만들기 
				msg = nick + ":" + msg;
				//보낼 데이터패킷 만들기 (byte데이터, 데이터 길이, 받는 주소, 받는 포트) 
				DatagramPacket dp = new DatagramPacket
						(msg.getBytes(), msg.getBytes().length, ia, 9999);
				ms.send(dp);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
