package com.example.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;

    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;
}


//@Document annotation refers to the each document in the mongoDB collection
//Id annotation is added so that the framework knows that the property is identified as unique value, primary key

//instead of writing the getter's and setter's we can us the one lombok provides
//@Data annotation takes care of all getter's setter's and toString methods

//@AllArgsConstructor annotation that takes all private fields as arguments and create a constructor for this class for us automatically
//@NoArgsConstructor annotation so it creates another constructor that takes no arguments


//if there is one to many relationship where one movie can have many reviews
//will cause the database to store only the ID's of the review and reviews will be in a separate collection
//this is called manual reference relationship