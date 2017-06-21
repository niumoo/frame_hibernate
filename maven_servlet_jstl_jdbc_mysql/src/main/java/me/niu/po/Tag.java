package me.niu.po; 
/** 
 * 标签类实体
 * @author niu
 * @data   2017年6月20日 下午11:02:31
 */
public class Tag {
	private int id;
	private String tagName;
	private int postId;
	public Tag(int id, String tagName, int postId) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.postId = postId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}

}
