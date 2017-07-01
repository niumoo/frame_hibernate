package me.imniu.po; 
/** 
 * 标签类实体
 * @author niu
 * @data   2017年6月20日 下午11:02:31
 */
public class Tag {
	private Integer id;
	private String tagName;
	private Integer postId;
	public Tag() {
		super();
	}
	public Tag(Integer id, String tagName, Integer postId) {
		super();
		this.id = id;
		this.tagName = tagName;
		this.postId = postId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagName=" + tagName + ", postId=" + postId + "]";
	}
	
	

}
