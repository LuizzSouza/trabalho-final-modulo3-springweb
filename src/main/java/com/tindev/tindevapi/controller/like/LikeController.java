package com.tindev.tindevapi.controller.like;

import com.tindev.tindevapi.dto.like.LikeDTO;
import com.tindev.tindevapi.service.LikeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/like")
@Api(value = "4 - Like API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"4 - Like API"}, description = "Like Controls")
public class LikeController implements LikeAPI{

    @Autowired
    private LikeService likeService;

    @GetMapping
    public ResponseEntity<List<LikeDTO>> listLikes() throws Exception {
        return ResponseEntity.ok(likeService.listAllLikes());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<LikeDTO>> listLikeOfTheUser(@PathVariable("userId")Integer id) throws Exception {
        return ResponseEntity.ok(likeService.listLikesById(id));
    }

    @PostMapping("/{userId}/{likedUserId}")
    public ResponseEntity<LikeDTO> darLike(@PathVariable("userId") Integer userId, @PathVariable("likedUserId") Integer likedUserId) throws Exception {
        return ResponseEntity.ok(likeService.darLike(userId, likedUserId));
    }

    @DeleteMapping("/{likeId}")
    public ResponseEntity<String> deleteLike(@PathVariable("likeId") Integer likeId) throws Exception {
        likeService.deleteLike(likeId);
        return ResponseEntity.ok("Like deleted");
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteLikeByUser(@PathVariable("userId") Integer userId) throws Exception {
        likeService.deleteLikeByUserId(userId);
        return ResponseEntity.ok("Like deleted");
    }


}
