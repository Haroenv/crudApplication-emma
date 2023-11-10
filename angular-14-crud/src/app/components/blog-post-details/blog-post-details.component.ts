import { Component, Input, OnInit } from '@angular/core';
import { BlogPostService } from "../../services/blog-post.service";
import { ActivatedRoute, Router } from "@angular/router";
import { BlogPost } from "../../models/blog-post";

@Component({
  selector: 'app-blog-post-details',
  templateUrl: './blog-post-details.component.html',
  styleUrls: ['./blog-post-details.component.css']
})
export class BlogPostDetailsComponent implements OnInit {
  @Input() viewMode = false;

  @Input() currentBlogPost: BlogPost = {
    title: '',
    body: '',
    published: false
  };

  message = '';

  constructor(
      private blogPostService: BlogPostService,
      private route: ActivatedRoute,
      private router: Router) { }

  ngOnInit(): void {
    if (!this.viewMode) {
      this.message = '';
      this.getBlogPost(this.route.snapshot.params["id"]);
    }
  }

  getBlogPost(id: string): void {
    this.blogPostService.get(id)
      .subscribe({
        next: (data) => {
          this.currentBlogPost = data;
          console.log(data);
        },
        error: (err) => console.error(err)
      });
  }

  updatePublished(status: boolean): void {
    const data = {
      title: this.currentBlogPost.title,
      body: this.currentBlogPost.body,
      published: status
    };

    this.message = '';

    this.blogPostService.update(this.currentBlogPost.id, data)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.currentBlogPost.published = status;
          this.message = res.message ? res.message : 'The status was updated successfully!';
        },
        error: (err) => console.error(err)
      });
  }

  updateBlogPost(): void {
    this.message = '';

    this.blogPostService.update(this.currentBlogPost.id, this.currentBlogPost)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.message = res.message ? res.message : 'This blog post was updated successfully!';
        },
        error: (err) => console.error(err)
      });
  }

  deleteBlogPost(): void {
    this.blogPostService.delete(this.currentBlogPost.id)
      .subscribe({
        next: (res) => {
          console.log(res);
          this.router.navigate(['/blog-posts']);
        },
        error: (err) => console.error(err)
      });
  }

}
