package com.techelevator.controller;

import com.techelevator.dao.DislikesDao;
import com.techelevator.dao.FavoritesDao;
import com.techelevator.dao.LikesDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Dislikes;
import com.techelevator.model.Favorites;
import com.techelevator.model.Likes;
import com.techelevator.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;
@RestController
@PreAuthorize("isAuthenticated()")
public class JoltController {
    private FavoritesDao favoritesDao;
    private LikesDao likesDao;
    private UserDao userDao;
    private DislikesDao dislikesDao;

    public JoltController(FavoritesDao favoritesDao, LikesDao likesDao, UserDao userDao, DislikesDao dislikesDao) {
        this.favoritesDao = favoritesDao;
        this.likesDao = likesDao;
        this.userDao = userDao;
        this.dislikesDao = dislikesDao;

    }

    private int getCurrentUserId(Principal principal) {
        return userDao.getUserByUsername(principal.getName()).getId();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> users() {
        return userDao.getUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/favorites", method = RequestMethod.GET)
    public List<Favorites> getFavorites(Principal principal) {
        int userId = getCurrentUserId(principal);
        return favoritesDao.getFavorites(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/likes", method = RequestMethod.GET)
    public List<Likes> getLikes(Principal principal) {
        int userId = getCurrentUserId(principal);
        return likesDao.getLikes(userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/dislikes", method = RequestMethod.GET)
    public List<Dislikes> getDislikes(Principal principal) {
        int userId = getCurrentUserId(principal);
        return dislikesDao.getDislikes(userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/favorites/", method = RequestMethod.POST)
    public Favorites createFavorites(@Valid @RequestBody Favorites favorites, Principal principal) {
        int userId = getCurrentUserId(principal);
        return favoritesDao.createFavorites(favorites, userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/likes/", method = RequestMethod.POST)
    public Likes createLikes(@Valid @RequestBody Likes likes, Principal principal) {
        int userId = getCurrentUserId(principal);
        return likesDao.createLikes(likes, userId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/dislikes/", method = RequestMethod.POST)
    public Dislikes createDislikes(@Valid @RequestBody Dislikes dislikes, Principal principal) {
        int userId = getCurrentUserId(principal);
        return dislikesDao.createDislikes(dislikes, userId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/favorites/{id}", method = RequestMethod.GET)
    public Favorites getFavoritesById(Principal principal, @PathVariable("id") int favoritesId) {
        int userId = getCurrentUserId(principal);
        return favoritesDao.getFavoritesById(userId, favoritesId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/likes/{id}", method = RequestMethod.GET)
    public Likes getLikesById(Principal principal, @PathVariable("id") int likesId) {
        int userId = getCurrentUserId(principal);
        return likesDao.getLikesById(userId, likesId);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/dislikes/{id}", method = RequestMethod.GET)
    public Dislikes getDislikesById(Principal principal, @PathVariable("id") int dislikesId) {
        int userId = getCurrentUserId(principal);
        return dislikesDao.getDislikesById(userId, dislikesId);
    }
}


