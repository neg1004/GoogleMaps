package sru.edu.luczak.GoogleMaps.repository;

import org.springframework.data.repository.CrudRepository;

import sru.edu.luczak.GoogleMaps.domain.PickupPoint;

/*
 * Spring Data JPA allows one to implement JPA-based repositories (DAO (Data Access Object) pattern).
 * Spring Data JPA makes it easy to add CRUD functionality through a powerful later of abstraction 
 * placed on top of a JPA implementation. The abstraction later allows us to access the persistence layer
 * without having to provide our own DAO implementation from scratch.
 * 
 * Extending the CrudRepository interface provides the application with basic CRUD functionality on User objects.
 */

public interface PickupPointRepository extends CrudRepository<PickupPoint, Long> {}