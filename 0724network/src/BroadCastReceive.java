import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadCastReceive {

	public static void main(String[] args) {
		try {
			//�޴� ���� �����
			DatagramSocket ds = new DatagramSocket(7777);
			//
			while(true) {
				//�����͸� ������ byte �迭 ����
				byte [] b = new byte[512];
				//�����͸� ������  DatagramPacket ����
				DatagramPacket dp = new DatagramPacket(b, b.length);
				//������ �ޱ�
				ds.receive(dp);
				
				String str = new String(b).trim();
				System.out.println(str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
