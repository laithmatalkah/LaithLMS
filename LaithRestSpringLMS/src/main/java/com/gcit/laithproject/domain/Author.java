package com.gcit.laithproject.domain;

import java.io.Serializable;
import java.util.List;

public class Author implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -238828352390847154L;
	private String authorName;
	private Integer authorId;
	private List<Book> books;
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	/**
	 * @return the authorId
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	/**
	 * @return the books
	 */
	public List<Book> getBooks() {
		return books;
	}
	/**
	 * @param books the books to set
	 */
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
		result = prime * result + ((books == null) ? 0 : books.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Author other = (Author) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		if (books == null) {
			if (other.books != null)
				return false;
		} else if (!books.equals(other.books))
			return false;
		return true;
	}
}
