import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MuticastReceive {

	public static void main(String[] args) {
		try {
			//받는 멀티캐스트 소켓 만들기 
			MulticastSocket ms = new MulticastSocket(9999);
			//그룹에 참여-244.0.0.0 부터 239.255.255.255
			ms.joinGroup(InetAddress.getByName("230.100.50.5"));
			// 무한 반복해서 메시지 받기
			while(true) {
				//바이트 배열 생성
				byte[]msg = new byte[512];
				//받는 데이터패킷 만들기
				DatagramPacket data = new DatagramPacket(msg, msg.length);
				//데이터 받기
				ms.receive(data);
				//받은 데이터 출력
				String str = new String(msg).trim();
				System.out.println(str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
