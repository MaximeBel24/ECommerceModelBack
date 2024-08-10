package fr.doranco.nomad_odyssey.services;

import fr.doranco.nomad_odyssey.entities.Cart;
import fr.doranco.nomad_odyssey.entities.CartItem;
import fr.doranco.nomad_odyssey.entities.Product;
import fr.doranco.nomad_odyssey.exceptions.CartItemException;
import fr.doranco.nomad_odyssey.exceptions.UserException;

public interface CartItemService {

    public CartItem createCartItem(CartItem cartItem);

    public CartItem updateCartItem(Long userId, Long id, CartItem cartItem) throws CartItemException, UserException;

    public CartItem isCartItemExist(Cart cart, Product product, String size, Long userId);

    public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

    public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
