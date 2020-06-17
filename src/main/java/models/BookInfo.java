package models;

import javax.persistence.Embeddable;

@Embeddable
public class BookInfo {
	private String reviewScore;
	private int revision;
	
	public BookInfo() {}

	public String getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(String reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

}
