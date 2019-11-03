package personal.bean;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Comment2 {
	private int id2;
	private String comment2;
	private int itemId2;
	private String userId2;
	private Date created2;
	private String nickName2;
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public String getComment2() {
		return comment2;
	}
	public void setComment2(String comment2) {
		this.comment2 = comment2;
	}
	public int getItemId2() {
		return itemId2;
	}
	public void setItemId2(int itemId2) {
		this.itemId2 = itemId2;
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
	public String getNickName2() {
		return nickName2;
	}
	public void setNickName2(String nickName2) {
		this.nickName2 = nickName2;
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
		if (seconds > 0) return seconds + "초 전";
		return "방금 전";
	
}}
