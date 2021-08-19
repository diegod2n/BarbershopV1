package com.barber.shop.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.barber.shop.model.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {
	
@Query("Select client from Client client where client.id=:userId")	
Client  finbyIdClient(@Param("userId")Long userId);

@Query("Select client from Client client where client.deleted=:deleted")
List<Client> getByDeleted(Boolean deleted);
/*
@Query("Select client from Client client where client.name like :%nameorsurname% or client.surname like :%nameorsurname%")
List<Client> getByName(String nameorsurname);
*/
@Query("Select client from Client client where client.email=:email")
Client findByEmail(String email);

/*
@Modifying
@Query("update Client client set client.name = :clients where client.id = :clients.id")
Client updateClient(Client clients);
*/

}
