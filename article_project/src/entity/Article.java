package entity;

import java.util.ArrayList;
import java.util.List;

import common.CommonField;

public class Article extends CommonField{
	private Long id;
	private String name;
	private String title;
	private String content;
	private List<Comment> commentLists = new ArrayList<Comment>(); // 하나의 게시글이 댓글리스트를 가질 수 있게 하는 모양새
	
	

	public List<Comment> getCommentLists() {
		return commentLists;
	}
	public void setCommentLists(List<Comment> commentLists) {
		this.commentLists = commentLists;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
