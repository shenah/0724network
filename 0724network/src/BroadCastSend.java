import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class BroadCastSend {

	public static void main(String[] args) {
		
		try {
			//������ ���� ���� ����
			DatagramSocket ds = new DatagramSocket();
			//������ ����� �г��� ����
			Scanner sc = new Scanner(System.in);
			System.out.println("�г� �Է�:");
			String nick = sc.nextLine();
			String msg = nick + "���� �غ� �Ϸ�";
			
			DatagramPacket dp = new DatagramPacket
					(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"), 7777);
			//������ ������ �Է�
			while(true) {
				System.out.println("������ ������ �Է�:");
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
