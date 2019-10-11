package com.micro.pbecommerceproductapi.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.micro.pbecommerceproductapi.dm.Product;

@Repository
public interface ProductDaoRepository extends JpaRepository<Product, Long> {

	// old monolith:
	// List<Product> findAll();
	
}



//	@Query("SELECT b FROM Basket b join b.contactDetails cd join cd.user u WHERE u.userName = :userName and b.open is true")
//	Optional<Basket> findOpenBasketForUser(@Param("userName") String userName);
