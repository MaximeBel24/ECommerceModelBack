package fr.doranco.nomad_odyssey.services;

import fr.doranco.nomad_odyssey.entities.Rating;
import fr.doranco.nomad_odyssey.entities.User;
import fr.doranco.nomad_odyssey.exceptions.ProductException;
import fr.doranco.nomad_odyssey.request.RatingRequest;

import java.util.List;

public interface RatingService {

    public Rating createRating(RatingRequest request, User user) throws ProductException;

    public List<Rating> getProductsRating(Long productId);
}
