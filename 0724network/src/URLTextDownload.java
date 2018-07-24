import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTextDownload {

	public static void main(String[] args) {
		try {
			//1. �ٿ�ε� ���� �ּ� �����
			//-�ѱ��� ���Ե� ����� URLEncoder.encode �޼ҵ带 �̿�
			String addr = "https://www.daum.net";
			
			//2. �ּҸ� ������ URL ��ü�� ����
			URL url = new URL(addr);
			
			//3. URL���� ��ü ����
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//4. �ɼ� ����
			//���� �ȵǸ� 30�ʱ��� �õ�
			con.setConnectTimeout(30000);
			//������ ���� �����Ͱ� �־ ������� �ʵ��� ����
			con.setUseCaches(false);
			
			//5. �ٿ�ε� ���� ��Ʈ�� ����
			BufferedReader br = new BufferedReader
					(new InputStreamReader(con.getInputStream(), "utf-8"));
			
			//6. �����͸� �о String���� �����
			StringBuilder sb = new StringBuilder();
			while(true) {
				//������ ���ڿ��� �б� 
				String line = br.readLine();
				//���� �� ������ �б� �ߴ�
				if(line == null) {
					break;
				}
				//���� �����͸� sb�� �߰�
				sb.append(line);
				
			}
			//���� �����͸� ����ȯ�ϱ� 
			String html = sb.toString();
			//ȭ�鿡 ���
			System.out.println(html);
			
			br.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
