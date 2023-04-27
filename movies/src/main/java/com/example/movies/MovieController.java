package com.example.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000/")
public class MovieController {

//    @GetMapping
//    public String allMovies() {
//        return "All movies!";
//    }

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{ImdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String ImdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie((ImdbId)), HttpStatus.OK);
    }
}

//any request from the about route will get controlled by this class
//instead of returning a string we can return a response entity



//controller is responsible for getting the request from the user and responding
//it uses service class and delegates all the tasks of fetching all movies from the database

//@PathVariable we are passing the information we got from the url as a path variable
//as a string or as a object

//we let the framework know that what ever we are getting from the path variable to be converted to a particular type




//cors allows a web page to request additional resources into the browser from other domains
//there are two ways to enable cors
//using controller
//either we can enable for specific method or all methods


//@CrossOrigin enables us the cross-origin resource sharing only for specific method or the entire class depends on the placement of crossOrigin resource sharing annotation placement
//by default it allows all origins, all headers, and the HTTP methods

//we can customize that one using the annotation attributes
//origins
//methods
//allowHeaders
//exposedHeaders
//allowCredentials
//maxAge

