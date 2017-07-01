package me.imniu.po;

import java.util.Date;

/**
 * POST 实体类
 * 
 * @author Niu
 * @data 2017年6月20日 下午1:07:39
 */
public class Post {
	private Integer id;
	private String title;
	private String subhead;
	private String summary;
	private String markdown;
	private String htmlContent;
	private String path;
	private Date createTime;
	private Date updateTime;
	private Integer readCount;
	private Integer status;
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Post(Integer id, String title, String subhead, String summary, String markdown, String htmlContent,
			String path, Date createTime, Date updateTime, Integer readCount, Integer status) {
		super();
		this.id = id;
		this.title = title;
		this.subhead = subhead;
		this.summary = summary;
		this.markdown = markdown;
		this.htmlContent = htmlContent;
		this.path = path;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.readCount = readCount;
		this.status = status;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubhead() {
		return subhead;
	}
	public void setSubhead(String subhead) {
		this.subhead = subhead;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getMarkdown() {
		return markdown;
	}
	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}
	public String getHtmlContent() {
		return htmlContent;
	}
	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getReadCount() {
		return readCount;
	}
	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}

	

}
