
package com.mycompany.titanproj;


public class TitanUReview {
    private String reviewText;
    private int rating;

    public TitanUReview(String reviewText, int rating) {
        this.reviewText = reviewText;
        this.rating = rating;
    }

    public String getReviewText() {
        return reviewText;
    }

    public int getRating() {
        return rating;
    }
}