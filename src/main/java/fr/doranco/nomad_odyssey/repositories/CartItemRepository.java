package fr.doranco.nomad_odyssey.repositories;

import fr.doranco.nomad_odyssey.entities.Cart;
import fr.doranco.nomad_odyssey.entities.CartItem;
import fr.doranco.nomad_odyssey.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT ci From CartItem ci Where ci.cart=:cart And ci.product=:product And ci.size=:size And ci.userId=:userId")
    public CartItem isCartItemExist(@Param("cart") Cart cart, @Param("product")Product product,
                                    @Param("size") String size, @Param("userId")Long userId);

}
