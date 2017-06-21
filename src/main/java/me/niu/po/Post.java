package me.niu.po;

import java.util.Date;

/**
 * POST 实体类
 * 
 * @author Niu
 * @data 2017年6月20日 下午1:07:39
 */
public class Post {
	private int id;
	private String title;
	private String subhead;
	private String summary;
	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	private String markdown;
	private String htmlContent;
	private Date createTime;
	private Date updateTime;
	private int readCount;
	private int status;


	public Post(int id, String title, String subhead, String summary, String markdown, String htmlContent,
			Date createTime, Date updateTime, int readCount, int status) {
		super();
		this.id = id;
		this.title = title;
		this.subhead = subhead;
		this.summary = summary;
		this.markdown = markdown;
		this.htmlContent = htmlContent;
		this.createTime = createTime;
		this.updateTime = updateTime;
		this.readCount = readCount;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Post() {
	}

}
