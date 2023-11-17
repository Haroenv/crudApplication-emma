import { Component, OnInit } from '@angular/core';
import { BlogPost } from "../../models/blog-post";
import { BlogPostService } from "../../services/blog-post.service";

@Component({
  selector: 'app-blog-posts-list',
  templateUrl: './blog-posts-list.component.html',
  styleUrls: ['./blog-posts-list.component.css']
})
export class BlogPostsListComponent implements OnInit {
  blogPosts?: BlogPost[];
  currentBlogPost: BlogPost = {};
  currentIndex = -1;
  title = '';

  constructor(private blogPostService: BlogPostService) { }

  ngOnInit(): void {
    this.retrieveBlogPosts();
  }

  retrieveBlogPosts(): void {
    this.blogPostService.getAll()
    .subscribe({
      next: (data) => {
        this.blogPosts = data;
        console.log(data);
      },
      error: (err) => console.error(err)
    });
  }

  refreshList(): void {
    this.retrieveBlogPosts();
    this.currentBlogPost = {};
    this.currentIndex = -1;
  }

  setActiveBlogPost(blogPost: BlogPost, index: number): void {
    this.currentBlogPost = blogPost;
    this.currentIndex = index;
  }

  removeAllBlogPosts(): void {
    this.blogPostService.deleteAll()
      .subscribe({
        next: (res) => {
          console.log(res);
          this.refreshList();
        },
        error: (err) => console.error(err)
      });
  }

  searchTitle(): void {
    this.currentBlogPost = {};
    this.currentIndex = -1;

    this.blogPostService.findByTitle(this.title)
      .subscribe({
        next: (data) => {
          this.blogPosts = data;
          console.log(data);
        },
        error: (err) => console.error(err)
      });
  }

}
