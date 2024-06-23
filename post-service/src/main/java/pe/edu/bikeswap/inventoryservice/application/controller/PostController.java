package pe.edu.bikeswap.inventoryservice.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.bikeswap.inventoryservice.domain.service.PostService;
import pe.edu.bikeswap.inventoryservice.entity.PostEntity;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    // URL: http://localhost:8080/api/v1/posts
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/{postId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/{postId}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable(name = "postId") Long postId) {
        PostEntity post = postService.getPostById(postId);
        return new ResponseEntity<PostEntity>(post, HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts
    // Method: POST
    @Transactional
    @PostMapping
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        PostEntity savedPost = postService.createPost(post);
        return new ResponseEntity<PostEntity>(savedPost, HttpStatus.CREATED);
    }

    // URL: http://localhost:8080/api/v1/posts/{postId}
    // Method: PUT
    @Transactional
    @PutMapping("/{postId}")
    public ResponseEntity<PostEntity> updatePost(@PathVariable(name = "postId") Long postId, @RequestBody PostEntity post) {
        PostEntity updatedPost = postService.updatePost(post);
        return new ResponseEntity<PostEntity>(updatedPost, HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/{postId}
    // Method: DELETE
    @Transactional
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable(name = "postId") Long postId) {
        postService.deletePost(postId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

    // URL: http://localhost:8080/api/v1/posts/active
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/active")
    public ResponseEntity<List<PostEntity>> getAllActivePosts() {
        return new ResponseEntity<List<PostEntity>>(postService.getActivePosts(), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/bikes/{bikeId}
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/bikes/{bikeId}")
    public ResponseEntity<List<PostEntity>> getAllPostsByBikeId(@PathVariable(name = "bikeId") Long bikeId) {
        return new ResponseEntity<List<PostEntity>>(postService.getPostsByBikeId(bikeId), HttpStatus.OK);
    }

    // URL: http://localhost:8080/api/v1/posts/bikes/{bikeId}/active
    // Method: GET
    @Transactional(readOnly = true)
    @GetMapping("/bikes/{bikeId}/active")
    public ResponseEntity<List<PostEntity>> getAllActivePostsByBikeId(@PathVariable(name = "bikeId") Long bikeId) {
        return new ResponseEntity<List<PostEntity>>(postService.getActivePostsByBikeId(bikeId), HttpStatus.OK);
    }
}
