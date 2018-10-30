package springbootexample6.example;

import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
}
