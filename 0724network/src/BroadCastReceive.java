import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadCastReceive {

	public static void main(String[] args) {
		try {
			//받는 소켓 만들기
			DatagramSocket ds = new DatagramSocket(7777);
			//
			while(true) {
				//데이터를 저장할 byte 배열 생성
				byte [] b = new byte[512];
				//데이터를 저장할  DatagramPacket 생성
				DatagramPacket dp = new DatagramPacket(b, b.length);
				//데이터 받기
				ds.receive(dp);
				
				String str = new String(b).trim();
				System.out.println(str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
