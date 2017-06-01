package hanium.opo.page;

public class PageMaker {
	private int totalPage;
	private int currentPage;
	private int lastPage;
	private int startPage;
	private boolean next;
	private boolean previous;
	public PageMaker(int currentPage, int totalPage){
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.next = false;
		this.previous = true;
	}
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrevious() {
		return previous;
	}

	public void setPrevious(boolean previous) {
		this.previous = previous;
	}

	public void start(){
		startPage = ((currentPage-1)/10) * 10 + 1;
		lastPage = ((currentPage-1)/10) * 10 + 10;
		if(lastPage > totalPage) lastPage = totalPage;
		if(lastPage < totalPage) next = true;
		if(lastPage <= 10) previous = false;
		System.out.println(lastPage);
		System.out.println(startPage);
		System.out.println(currentPage);
		System.out.println(previous);
		System.out.println(next);
	}
}
