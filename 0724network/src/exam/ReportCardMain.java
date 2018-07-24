package exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;

public class ReportCardMain {

	public static void main(String[] args) {
		
		ArrayList <ReportCard> list = new ArrayList();
		
		ReportCard rc = new ReportCard();
		rc.setNumber(1001);
		rc.setName("스미스");
		rc.setScore(89);
		rc.setBornday(new Date(91, 6, 26));
		list.add(rc);
		
		rc = new ReportCard();
		rc.setNumber(1002);
		rc.setName("마이클");
		rc.setScore(95);
		rc.setBornday(new Date(92, 7, 8));
		list.add(rc);
		
		rc = new ReportCard();
		rc.setNumber(1003);
		rc.setName("캐슬린");
		rc.setScore(92);
		rc.setBornday(new Date(89, 9, 3));
		list.add(rc);
		
		rc = new ReportCard();
		rc.setNumber(1004);
		rc.setName("마리");
		rc.setScore(83);
		rc.setBornday(new Date(93, 10, 3));
		list.add(rc);
		
		rc = new ReportCard();
		rc.setNumber(1005);
		rc.setName("존");
		rc.setScore(87);
		rc.setBornday(new Date(94, 10, 13));
		list.add(rc);
		
		Comparator <ReportCard> cp = new Comparator() {

			public int compare(Object o1, Object o2) {
				ReportCard first = (ReportCard) o1;
				ReportCard second = (ReportCard) o2;
				return first.getScore() - second.getScore();
			}
			
		};
		
		list.sort(cp);
		for(ReportCard temp : list) {
			System.out.println(temp);
		}

	}

}
