import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class BroadCastSend {

	public static void main(String[] args) {
		
		try {
			//데이터 전송 소켓 생성
			DatagramSocket ds = new DatagramSocket();
			//보내는 사용자 닉네임 설정
			Scanner sc = new Scanner(System.in);
			System.out.println("닉넴 입력:");
			String nick = sc.nextLine();
			String msg = nick + "전송 준비 완료";
			
			DatagramPacket dp = new DatagramPacket
					(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
			//전송할 데이터 입력
			while(true) {
				System.out.println("전송할 데이터 입력:");
				msg = sc.nextLine();
				dp = new DatagramPacket
						(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
			}

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
