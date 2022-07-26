package com.buchibanton.fashionblog.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.buchibanton.fashionblog.dto.AdminSignUpDto;
import com.buchibanton.fashionblog.dto.PostDto;
import com.buchibanton.fashionblog.dto.UpdatePostDto;
import com.buchibanton.fashionblog.model.Admin;
import com.buchibanton.fashionblog.model.Post;
import com.buchibanton.fashionblog.model.PostLikes;
import com.buchibanton.fashionblog.model.User;
import com.buchibanton.fashionblog.model.pageCriterias.PostPage;
import com.buchibanton.fashionblog.repository.AdminRepository;
import com.buchibanton.fashionblog.repository.PostCommentsRepository;
import com.buchibanton.fashionblog.repository.PostLikesRepository;
import com.buchibanton.fashionblog.repository.PostRepository;
import com.buchibanton.fashionblog.service.AdminService;
import com.buchibanton.fashionblog.service.serviceImpl.AdminServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {AdminController.class})
@ExtendWith(SpringExtension.class)
class AdminControllerTest {
    @Autowired
    private AdminController adminController;

    @MockBean
    private AdminService adminService;

    /**
     * Method under test: {@link AdminController#adminLogin(AdminSignUpDto)}
     */
    @Test
    void testAdminLogin() throws Exception {
        when(adminService.login((AdminSignUpDto) any())).thenReturn("Login");

        AdminSignUpDto adminSignUpDto = new AdminSignUpDto();
        adminSignUpDto.setEmail("jane.doe@example.org");
        adminSignUpDto.setPassword("iloveyou");
        adminSignUpDto.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(adminSignUpDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/admins/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Login"));
    }

    /**
     * Method under test: {@link AdminController#createPost(PostDto)}
     */
    @Test
    void testCreatePost() {
        Admin admin = new Admin();
        admin.setAdminId(123L);
        admin.setEmail("jane.doe@example.org");
        admin.setFirstName("Jane");
        admin.setLastName("Doe");
        admin.setPassword("iloveyou");
        admin.setPost(new ArrayList<>());
        admin.setUserName("janedoe");

        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        user.setPassword("iloveyou");
        user.setPost(new ArrayList<>());
        user.setPostComments(new ArrayList<>());
        user.setPostLikes(new PostLikes());
        user.setUserId(123L);
        user.setUserName("janedoe");

        Post post = new Post();
        post.setAdmin1(admin);
        post.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
        post.setDeletedDate(LocalDateTime.of(1, 1, 1, 1, 1));
        post.setDescription("The characteristics of someone or something");
        post.setPostId(123L);
        post.setTitle("Dr");
        post.setUpdateDate(LocalDateTime.of(1, 1, 1, 1, 1));
        post.setUser1(user);
        PostRepository postRepository = mock(PostRepository.class);
        when(postRepository.save((Post) any())).thenReturn(post);
        AdminRepository adminRepository = mock(AdminRepository.class);
        PostLikesRepository postLikesRepository = mock(PostLikesRepository.class);
        PostCommentsRepository postCommentsRepository = mock(PostCommentsRepository.class);
        AdminController adminController = new AdminController(new AdminServiceImpl(adminRepository, postRepository,
                postLikesRepository, postCommentsRepository, new MockHttpSession()));

        PostDto postDto = new PostDto();
        postDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        postDto.setDeleted(LocalDateTime.of(1, 1, 1, 1, 1));
        postDto.setDescription("The characteristics of someone or something");
        postDto.setTitle("Dr");
        postDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        ResponseEntity<Post> actualCreatePostResult = adminController.createPost(postDto);
        assertTrue(actualCreatePostResult.hasBody());
        assertTrue(actualCreatePostResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualCreatePostResult.getStatusCode());
        verify(postRepository).save((Post) any());
    }

    /**
     * Method under test: {@link AdminController#createPost(PostDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testCreatePost2() {

//        AdminController adminController = new AdminController(null);
//
//        PostDto postDto = new PostDto();
//        postDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
//        postDto.setDeleted(LocalDateTime.of(1, 1, 1, 1, 1));
//        postDto.setDescription("The characteristics of someone or something");
//        postDto.setTitle("Dr");
//        postDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
//        adminController.createPost(postDto);
    }

    /**
     * Method under test: {@link AdminController#updatePost(UpdatePostDto, Long)}
     */
    @Test
    void testUpdatePost() throws Exception {
//        Admin admin = new Admin();
//        admin.setAdminId(123L);
//        admin.setEmail("jane.doe@example.org");
//        admin.setFirstName("Jane");
//        admin.setLastName("Doe");
//        admin.setPassword("iloveyou");
//        admin.setPost(new ArrayList<>());
//        admin.setUserName("janedoe");
//
//        User user = new User();
//        user.setEmail("jane.doe@example.org");
//        user.setFirstName("Jane");
//        user.setLastName("Doe");
//        user.setPassword("iloveyou");
//        user.setPost(new ArrayList<>());
//        user.setPostComments(new ArrayList<>());
//        user.setPostLikes(new ArrayList<>());
//        user.setUserId(123L);
//        user.setUserName("janedoe");
//
//        Post post = new Post();
//        post.setAdmin1(admin);
//        post.setCreateDate(LocalDateTime.of(1, 1, 1, 1, 1));
//        post.setDeletedDate(LocalDateTime.of(1, 1, 1, 1, 1));
//        post.setDescription("The characteristics of someone or something");
//        post.setPostId(123L);
//        post.setTitle("Dr");
//        post.setUpdateDate(LocalDateTime.of(1, 1, 1, 1, 1));
//        post.setUser1(user);
//        when(adminService.updatePost((UpdatePostDto) any(), (Long) any())).thenReturn(post);
//
//        UpdatePostDto updatePostDto = new UpdatePostDto();
//        updatePostDto.setDescription("The characteristics of someone or something");
//        updatePostDto.setTitle("Dr");
//        String content = (new ObjectMapper()).writeValueAsString(updatePostDto);
//        MockHttpServletRequestBuilder postResult = MockMvcRequestBuilders.post("/admins/updatePost");
//        MockHttpServletRequestBuilder requestBuilder = postResult.param("postId", String.valueOf(1L))
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(content);
//        MockMvcBuilders.standaloneSetup(adminController)
//                .build()
//                .perform(requestBuilder)
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
//                .andExpect(MockMvcResultMatchers.content()
//                        .string(
//                                "{\"postId\":123,\"title\":\"Dr\",\"description\":\"The characteristics of someone or something\",\"createDate\":"
//                                        + "[1,1,1,1,1],\"updateDate\":[1,1,1,1,1],\"deletedDate\":[1,1,1,1,1],\"admin1\":{\"adminId\":123,\"firstName\":"
//                                        + "\"Jane\",\"lastName\":\"Doe\",\"userName\":\"janedoe\",\"email\":\"jane.doe@example.org\",\"password\":\"iloveyou\","
//                                        + "\"post\":[]},\"user1\":{\"userId\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"userName\":\"janedoe\",\"email\":"
//                                        + "\"jane.doe@example.org\",\"password\":\"iloveyou\",\"post\":[],\"postComments\":[],\"postLikes\":[]}}"));
    }

    /**
     * Method under test: {@link AdminController#deletePost(Long)}
     */
    @Test
    void testDeletePost() throws Exception {
        doNothing().when(adminService).deletePost((Long) any());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/admins/deletePost/{id}", 123L);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    /**
     * Method under test: {@link AdminController#deletePost(Long)}
     */
    @Test
    void testDeletePost2() throws Exception {
        doNothing().when(adminService).deletePost((Long) any());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/admins/deletePost/{id}", 123L);
        deleteResult.characterEncoding("Encoding");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(adminController).build().perform(deleteResult);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isAccepted());
    }

    /**
     * Method under test: {@link AdminController#fetchLikes()}
     */
    @Test
    void testFetchLikes() throws Exception {
        when(adminService.fetchLikes()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admins/fetchLikes");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AdminController#fetchLikes()}
     */
    @Test
    void testFetchLikes2() throws Exception {
        when(adminService.fetchLikes()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admins/fetchLikes");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AdminController#fetchComments()}
     */
    @Test
    void testFetchComments() throws Exception {
        when(adminService.fetchComments()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admins/fetchComments");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AdminController#fetchComments()}
     */
    @Test
    void testFetchComments2() throws Exception {
        when(adminService.fetchComments()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/admins/fetchComments");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link AdminController#getAllPost(PostPage)}
     */
    @Test
    void testGetAllPost() throws Exception {
        when(adminService.getAllPost((PostPage) any())).thenReturn(new PageImpl<>(new ArrayList<>()));
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/admins/getAllPost");
        MockMvcBuilders.standaloneSetup(adminController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"content\":[],\"pageable\":\"INSTANCE\",\"totalPages\":1,\"last\":true,\"totalElements\":0,\"size\":0,\"number"
                                        + "\":0,\"sort\":{\"empty\":true,\"sorted\":false,\"unsorted\":true},\"first\":true,\"numberOfElements\":0,\"empty"
                                        + "\":true}"));
    }
}

