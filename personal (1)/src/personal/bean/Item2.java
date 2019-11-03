package personal.bean;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Item2 {

	private int id2;
	private String title2;
	private String body2;
	private String userId2;
	private Date created2;
	private String file2;
	
	
	
public int getId2() {
		return id2;
	}



	public void setId2(int id2) {
		this.id2 = id2;
	}



	public String getTitle2() {
		return title2;
	}



	public void setTitle2(String title2) {
		this.title2 = title2;
	}



	public String getBody2() {
		return body2;
	}



	public void setBody2(String body2) {
		this.body2 = body2;
	}



	public String getUserId2() {
		return userId2;
	}



	public void setUserId2(String userId2) {
		this.userId2 = userId2;
	}



	public Date getCreated2() {
		return created2;
	}



	public void setCreated2(Date created2) {
		this.created2 = created2;
	}



	public String getFile2() {
		return file2;
	}



	public void setFile2(String file2) {
		this.file2 = file2;
	}



public String getTimeAgo() {
		
		LocalDateTime old = LocalDateTime.ofInstant(created2.toInstant(), ZoneOffset.UTC);
		LocalDateTime now = LocalDateTime.now(ZoneOffset.UTC);

		long years = ChronoUnit.YEARS.between(old, now);
		long months = ChronoUnit.MONTHS.between(old, now);
		long weeks = ChronoUnit.WEEKS.between(old, now);
		long days = ChronoUnit.DAYS.between(old, now);
		long hours = ChronoUnit.HOURS.between(old, now);
		long minutes = ChronoUnit.MINUTES.between(old, now);
		long seconds = ChronoUnit.SECONDS.between(old, now);
		
		if (years > 0) return years + "년 전";
		if (months > 0) return months + "개월 전";
		if (weeks > 0) return weeks + "주 전";
		if (days > 0) return days + "일 전";
		if (hours > 0) return hours + "시간 전";
		if (minutes > 0) return minutes + "분 전";
		
		return "방금 전";
	
	
}
	
}
