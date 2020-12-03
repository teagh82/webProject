package model;

public class ClassVO {
	private int classIdx = 0;
	private int categoryIdx = 0;
	private int classRegionIdx = 0;
	private String name = null;
	private String date = null;
	private String time = null;
	private String place = null;
	private int price = 0;
	private String level = null;
	private int people = 0;
	private int applyPeople = 0;
	private String content = null;
	private String image = null;
	private String teacherInfo = null;
	private int userIdx = 0;
	private int isClosed = 0;
	
	public ClassVO() {}
	public ClassVO(int classIdx, int categoryIdx, int classRegionIdx, String name, String date, String time, 
			String place, int price, String level, int people, int applyPeople, String content, String image, String teacherInfo) {
		
		this.classIdx = classIdx;
		this.categoryIdx = categoryIdx;
		this.classRegionIdx = classRegionIdx;
		this.name = name;
		this.date = date;
		this.time = time;
		this.place = place;
		this.price = price;
		this.level = level;
		this.people = people;
		this.applyPeople = applyPeople;
		this.content = content;
		this.teacherInfo = teacherInfo;
	}
	
	public int getClassIdx() {
		return classIdx;
	}
	public void setClassIdx(int classIdx) {
		this.classIdx = classIdx;
	}
	public int getCategoryIdx() {
		return categoryIdx;
	}
	public void setCategoryIdx(int categoryIdx) {
		this.categoryIdx = categoryIdx;
	}
	public int getClassRegionIdx() {
		return classRegionIdx;
	}
	public void setClassRegionIdx(int classRegionIdx) {
		this.classRegionIdx = classRegionIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getApplyPeople() {
		return applyPeople;
	}
	public void setApplyPeople(int applyPeople) {
		this.applyPeople = applyPeople;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTeacherInfo() {
		return teacherInfo;
	}
	public void setTeacherInfo(String teacherInfo) {
		this.teacherInfo = teacherInfo;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(int isClosed) {
		this.isClosed = isClosed;
	}
	
}
