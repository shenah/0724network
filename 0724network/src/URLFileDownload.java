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
			//addr에서 마지막 /이후의 문자열 가져오기
			int idx = addr.lastIndexOf("/");
			//파일 이름 가져오기
			String filename = addr.substring(idx+1);
			//System.out.println(filename);
			
			//파일 이름으로 저장할 파일 경로 만들기
			final String path = "C:\\Users\\503-03\\Documents\\" + filename;
			
			if(new File(path).exists()) {
				System.out.println("이미 존재한 파일입니다");		
			}else {
				System.out.println("파일이 존재하지 않습니다.");
				Thread th =new Thread() {
					public void run() {
						try {
							//
							URL url = new URL(addr);
							//연결 객체 생성
							HttpURLConnection con = (HttpURLConnection)url.openConnection();
							//옵션 설정
							con.setConnectTimeout(20000);
							con.setUseCaches(false);
							
							//byte단위로 다운로드 받기 위한 스트림 생성
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							//데이터를 기록하기 위한 스트림 생성
							PrintStream pw = new PrintStream(path);
							while(true) {
								byte [] b = new byte[512];
								int r = bis.read(b);
								//읽은 데이터 없으면 읽기 중단
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
