package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String ImdbId) {
        return movieRepository.findMovieByImdbId(ImdbId);
    }


}


//inside this class we write the database access methods
//autoWired to let the framework know

//service class is where most of our business logic will goes

//id may not exist in that case it may return null in that case we have to do an optional to prevent exceptions
