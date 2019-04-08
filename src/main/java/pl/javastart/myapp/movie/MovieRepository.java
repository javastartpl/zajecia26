package pl.javastart.myapp.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {


    @Query("SELECT m FROM Movie m " +
            " WHERE 1=1 " +
            " AND (:title IS NULL OR m.title LIKE CONCAT('%', :title, '%'))" +
            " AND (:targetAudience IS NULL OR m.targetAudience = :targetAudience)"
    )
    List<Movie> findUsingFilters(@Param("title") String title,
                                 @Param("targetAudience") TargetAudience targetAudience);

}
