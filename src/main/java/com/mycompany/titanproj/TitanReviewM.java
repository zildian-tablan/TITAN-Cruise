
package com.mycompany.titanproj;

import java.util.ArrayList;
import java.util.List;

public class TitanReviewM {
    private static TitanReviewM instance;
    private List<TitanUReview> reviews;

    private TitanReviewM() {
        reviews = new ArrayList<>();
    }

    public static TitanReviewM getInstance() {
        if (instance == null) {
            instance = new TitanReviewM();
        }
        return instance;
    }

    public void addTitanUReview(String reviewText, int rating) {
        TitanUReview review = new TitanUReview(reviewText, rating);
        reviews.add(review);
    }

    public List<TitanUReview> getAllReviews() {
        return new ArrayList<>(reviews); // Return a copy to prevent external modification
    }
}
