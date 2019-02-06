package com.inc.domain;

public class Image {
	/*
	create table image(
	    collection varchar2(30),
	    thumbnails varchar2(50),
	    display_sitename varchar2(50) not null,
	    contents varchar2(50)
	); 
	 */
	
	private String collection, thumbnails, display_sitename, contents;

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getThumbnails() {
		return thumbnails;
	}

	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}

	public String getDisplay_sitename() {
		return display_sitename;
	}

	public void setDisplay_sitename(String display_sitename) {
		this.display_sitename = display_sitename;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	
}
