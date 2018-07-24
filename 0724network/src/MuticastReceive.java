import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MuticastReceive {

	public static void main(String[] args) {
		try {
			//�޴� ��Ƽĳ��Ʈ ���� ����� 
			MulticastSocket ms = new MulticastSocket(9999);
			//�׷쿡 ����-244.0.0.0 ���� 239.255.255.255
			ms.joinGroup(InetAddress.getByName("230.100.50.5"));
			// ���� �ݺ��ؼ� �޽��� �ޱ�
			while(true) {
				//����Ʈ �迭 ����
				byte[]msg = new byte[512];
				//�޴� ��������Ŷ �����
				DatagramPacket data = new DatagramPacket(msg, msg.length);
				//������ �ޱ�
				ms.receive(data);
				//���� ������ ���
				String str = new String(msg).trim();
				System.out.println(str);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
