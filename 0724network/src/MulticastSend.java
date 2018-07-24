import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {

	public static void main(String[] args) {
		
		try {
			//������ ��Ƽĳ��Ʈ ���� �����
			MulticastSocket ms = new MulticastSocket();
			//������ ����� �г��� ����
			Scanner sc = new Scanner(System.in);
			System.out.println("�г� �Է�:");
			String nick = sc.nextLine();
			//���� ���� �ּ� 
			InetAddress ia = InetAddress.getByName("230.100.50.5");
			//���� ������ �Է��ϱ�
			while(true) {
				System.out.println("�����ڷ� �Է�(����� end):");
				String msg = sc.nextLine();
				//������ ������ ���ἳ��
				if(msg.equals("end")) {
					//����� ���� �޼��� �����
					msg = nick + "�濡�� ����";
					DatagramPacket dp = new DatagramPacket
							(msg.getBytes(), msg.getBytes().length, ia, 9999);
					//�޼��� ����
					ms.send(dp);
					//��ĳ��, ���� �ݱ�
					sc.close();
					ms.close();
					break;
				}
				//���� ������ ����� 
				msg = nick + ":" + msg;
				//���� ��������Ŷ ����� (byte������, ������ ����, �޴� �ּ�, �޴� ��Ʈ) 
				DatagramPacket dp = new DatagramPacket
						(msg.getBytes(), msg.getBytes().length, ia, 9999);
				ms.send(dp);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
