package pe.edu.bikeswap.inventoryservice.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.bikeswap.inventoryservice.domain.repository.PostRepository;
import pe.edu.bikeswap.inventoryservice.entity.PostEntity;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostEntity> getPostsByBikeId(Long bikeId) {
        return postRepository.findByBikeId(bikeId);
    }

    public List<PostEntity> getActivePostsByBikeId(Long bikeId) {
        return postRepository.findByBikeIdAndActive(bikeId, true);
    }

    public PostEntity createPost(PostEntity post) {
        return postRepository.save(post);
    }

    public PostEntity updatePost(PostEntity post) {
        return postRepository.save(post);
    }

    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }

    public List<PostEntity> getAllPosts() {
        return postRepository.findAll();
    }

    public PostEntity getPostById(Long postId) {
        return postRepository.findById(postId).orElse(null);
    }

    public List<PostEntity> getActivePosts() {
        return postRepository.isActive(true);
    }

    public List<PostEntity> getInactivePosts() {
        return postRepository.isActive(false);
    }

    public void deletePostsByBikeId(Long bikeId) {
        List<PostEntity> posts = postRepository.findByBikeId(bikeId);
        postRepository.deleteAll(posts);
    }

    public void deleteActivePostsByBikeId(Long bikeId) {
        List<PostEntity> posts = postRepository.findByBikeIdAndActive(bikeId, true);
        postRepository.deleteAll(posts);
    }

    public void deleteInactivePostsByBikeId(Long bikeId) {
        List<PostEntity> posts = postRepository.findByBikeIdAndActive(bikeId, false);
        postRepository.deleteAll(posts);
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }
}
