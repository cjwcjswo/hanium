package hanium.opo.dto;

public class ReplyDTO {
	private int replyNum;
	private int boardNum;
	private String userId;
	private String userName;
	private String content;
	private String writeDay;
	
	@Override
	public String toString() {
		return "ReplyDTO [replyNum=" + replyNum + ", boardNum=" + boardNum + ", userId=" + userId + ", userName="
				+ userName + ", content=" + content + ", writeDay=" + writeDay + "]";
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDay() {
		return writeDay;
	}
	public void setWriteDay(String writeDay) {
		this.writeDay = writeDay;
	}
	
	
}
