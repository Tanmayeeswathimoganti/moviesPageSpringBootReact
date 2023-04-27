package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String ImdbId);
}

//repository acts as a data access layer for our api
//it talks to the database and gets our data back

//we can search the data in mongoDB by objectID so MongoRepository has the in built method
//to search using some other criteria we have to build custom methods by ourselves

//by specifying the arugment spring MongoDB can understand criteria