package com.webapp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/****
 * 
 * @author yanghongquan
 * @created 2012-1-17
 */
@Entity
@Table(name = "blogarticles")
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer artId;
	private String artSubject;
	private String artContent;
	private String artCatagory;
	private String artAuthor;
	private String artTime;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Integer getArtId() {
		return artId;
	}

	public void setArtId(Integer artId) {
		this.artId = artId;
	}

	@Column(name = "subject")
	public String getArtSubject() {
		return artSubject;
	}

	public void setArtSubject(String artSubject) {
		this.artSubject = artSubject;
	}

	@Column(name = "content")
	public String getArtContent() {
		return artContent;
	}

	public void setArtContent(String artContent) {
		this.artContent = artContent;
	}

	@Column(name = "catagory")
	public String getArtCatagory() {
		return artCatagory;
	}

	public void setArtCatagory(String artCatagory) {
		this.artCatagory = artCatagory;
	}

	@Column(name = "author")
	public String getArtAuthor() {
		return artAuthor;
	}

	public void setArtAuthor(String artAuthor) {
		this.artAuthor = artAuthor;
	}

	@Column(name = "time")
	public String getArtTime() {
		return artTime;
	}

	public void setArtTime(String artTime) {
		this.artTime = artTime;
	}

}
