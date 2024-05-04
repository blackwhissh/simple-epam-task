package com.epam.task1.service;

import com.epam.task1.models.Post;
import com.epam.task1.repositories.PostRepository;
import com.epam.task1.services.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;

@SpringBootTest
public class PostServiceTest {

    @InjectMocks
    private PostService postService;

    @Mock
    private PostRepository postRepository;

    @Test
    public void testSavePost() {
        Post post = new Post();
        post.setTitle("test");

        postService.savePost(post);

        verify(postRepository, times(1)).save(post);
    }

    @Test
    public void testGetPosts() {
        postService.getPosts();

        verify(postRepository, times(1)).findAll();
    }
}
