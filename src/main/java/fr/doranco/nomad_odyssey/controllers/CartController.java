package fr.doranco.nomad_odyssey.controllers;

import fr.doranco.nomad_odyssey.entities.Cart;
import fr.doranco.nomad_odyssey.entities.User;
import fr.doranco.nomad_odyssey.exceptions.ProductException;
import fr.doranco.nomad_odyssey.exceptions.UserException;
import fr.doranco.nomad_odyssey.requests.AddItemRequest;
import fr.doranco.nomad_odyssey.responses.ApiResponse;
import fr.doranco.nomad_odyssey.services.CartService;
import fr.doranco.nomad_odyssey.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization")String jwt) throws UserException{
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findUserCart(user.getId());

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity<ApiResponse>addItemToCart(
            @RequestBody AddItemRequest request,
            @RequestHeader("Authorization")String jwt) throws UserException, ProductException {

        User user = userService.findUserProfileByJwt(jwt);

        cartService.addCartItem(user.getId(), request);

        ApiResponse response = new ApiResponse();
        response.setMessage("Item added to cart");
        response.setStatus(true);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
