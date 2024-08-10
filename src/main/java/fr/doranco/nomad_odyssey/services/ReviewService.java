package fr.doranco.nomad_odyssey.services;

import fr.doranco.nomad_odyssey.entities.Review;
import fr.doranco.nomad_odyssey.entities.User;
import fr.doranco.nomad_odyssey.exceptions.ProductException;
import fr.doranco.nomad_odyssey.requests.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest request, User user) throws ProductException;
    public List<Review> getAllReview(Long productid);
}
