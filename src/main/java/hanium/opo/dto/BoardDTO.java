package hanium.opo.dto;

import java.util.List;

public class BoardDTO {
	private Integer boardNum;
	private String subject;
	private String userId;
	private String userName;
	private String content;
	private String password;
	private String writeDay;
	private Integer readNum;
	private List<ReplyDTO> reply;
	
	
	public List<ReplyDTO> getReply() {
		return reply;
	}
	public void setReply(List<ReplyDTO> reply) {
		this.reply = reply;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public String getSubject() {
		return subject;
	}
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getContent() {
		return content;
	}
	public String getPassword() {
		return password;
	}
	public String getWriteDay() {
		return writeDay;
	}
	public int getReadNum() {
		return readNum;
	}
	public void setBoardNum(Integer boardNum) {
		this.boardNum = boardNum;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}
	public void setReadNum(Integer readNum) {
		this.readNum = readNum;
	}
	@Override
	public String toString() {
		return "BoardDTO [boardNum=" + boardNum + ", subject=" + subject + ", userId=" + userId + ", userName="
				+ userName + ", content=" + content + ", password=" + password + ", writeDay=" + writeDay + ", readNum="
				+ readNum + ", reply=" + reply + "]";
	}

}
