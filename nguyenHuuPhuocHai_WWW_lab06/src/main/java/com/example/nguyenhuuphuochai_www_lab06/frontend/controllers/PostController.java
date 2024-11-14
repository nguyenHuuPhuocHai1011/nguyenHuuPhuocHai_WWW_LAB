package com.example.nguyenhuuphuochai_www_lab06.frontend.controllers;

import com.example.nguyenhuuphuochai_www_lab06.backend.models.Post;
import com.example.nguyenhuuphuochai_www_lab06.backend.repositories.PostCommentRepository;
import com.example.nguyenhuuphuochai_www_lab06.backend.repositories.PostRepository;
import com.example.nguyenhuuphuochai_www_lab06.backend.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class PostController {
    private PostService postService;
    private PostRepository postRepository;
    private PostCommentRepository postCommentRepository;

    @GetMapping("/posts")
    public String showPostListPaging(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(2);
        Page<Post> postPage = postService.findPaginated(PageRequest.of(currentPage - 1, pageSize));

        model.addAttribute("postPage", postPage);
        model.addAttribute("currentPage", postPage.getNumber() + 1);
        model.addAttribute("pageSize", size);
        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "post/post-page";
    }

    @GetMapping("/blog")
    public String showBlogs(Model model, @RequestParam("page") Optional<Integer> page, @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);
        Page<Post> blogPage = postService.findPaginated(PageRequest.of(currentPage -1, pageSize));
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("currentPage", blogPage.getNumber() + 1);
        model.addAttribute("pageSize", pageSize);
        int totalPages = blogPage.getTotalPages();
        if(totalPages > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "post/blog-page";
    }
}
