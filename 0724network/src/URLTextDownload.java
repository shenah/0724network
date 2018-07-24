import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTextDownload {

	public static void main(String[] args) {
		try {
			//1. 다운로들 받을 주소 만들기
			//-한글이 포함된 경우라면 URLEncoder.encode 메소드를 이용
			String addr = "https://www.daum.net";
			
			//2. 주소를 가지고 URL 객체를 생성
			URL url = new URL(addr);
			
			//3. URL연결 객체 생성
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//4. 옵션 설정
			//연결 안되면 30초까지 시도
			con.setConnectTimeout(30000);
			//이전에 받은 데이터가 있어도 사용하지 않도록 설정
			con.setUseCaches(false);
			
			//5. 다운로드 받을 스트림 생성
			BufferedReader br = new BufferedReader
					(new InputStreamReader(con.getInputStream(), "utf-8"));
			
			//6. 데이터를 읽어서 String으로 만들기
			StringBuilder sb = new StringBuilder();
			while(true) {
				//한줄의 문자열을 읽기 
				String line = br.readLine();
				//읽은 게 없으면 읽기 중단
				if(line == null) {
					break;
				}
				//읽은 데이터를 sb에 추가
				sb.append(line);
				
			}
			//읽은 데이터를 형변환하기 
			String html = sb.toString();
			//화면에 출력
			System.out.println(html);
			
			br.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
