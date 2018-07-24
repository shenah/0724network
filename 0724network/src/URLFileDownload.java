import java.io.BufferedInputStream;
import java.io.File;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLFileDownload {

	public static void main(String[] args) {
		
		try {
			final String addr =
					"http://www.onlifezone.com/files/attach/images/962811/376/321/005/2.jpg";
			//addr���� ������ /������ ���ڿ� ��������
			int idx = addr.lastIndexOf("/");
			//���� �̸� ��������
			String filename = addr.substring(idx+1);
			//System.out.println(filename);
			
			//���� �̸����� ������ ���� ��� �����
			final String path = "C:\\Users\\503-03\\Documents\\" + filename;
			
			if(new File(path).exists()) {
				System.out.println("�̹� ������ �����Դϴ�");		
			}else {
				System.out.println("������ �������� �ʽ��ϴ�.");
				Thread th =new Thread() {
					public void run() {
						try {
							//
							URL url = new URL(addr);
							//���� ��ü ����
							HttpURLConnection con = (HttpURLConnection)url.openConnection();
							//�ɼ� ����
							con.setConnectTimeout(20000);
							con.setUseCaches(false);
							
							//byte������ �ٿ�ε� �ޱ� ���� ��Ʈ�� ����
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							//�����͸� ����ϱ� ���� ��Ʈ�� ����
							PrintStream pw = new PrintStream(path);
							while(true) {
								byte [] b = new byte[512];
								int r = bis.read(b);
								//���� ������ ������ �б� �ߴ�
								if(r<=0) {
									break;
								}
								pw.write(b, 0, r);
							}
							bis.close();
							pw.close();
						}catch(Exception e) {
							System.out.println(e.getMessage());
						}
						
						
					}
				};
				th.start();
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
