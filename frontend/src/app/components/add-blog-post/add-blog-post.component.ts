import { Component, OnInit } from '@angular/core';
import { BlogPost } from "../../models/blog-post";
import { BlogPostService } from "../../services/blog-post.service";
import {error} from "@angular/compiler-cli/src/transformers/util";

@Component({
  selector: 'app-add-blog-post',
  templateUrl: './add-blog-post.component.html',
  styleUrls: ['./add-blog-post.component.css']
})
export class AddBlogPostComponent {

  blogPost: BlogPost = {
    title: '',
    body: '',
    published: false
  };
  submitted = false;

  constructor(private blogPostService: BlogPostService) { }

  saveBlogPost(): void {
    const data = {
      title: this.blogPost.title,
      body: this.blogPost.body
    };

    this.blogPostService.create(data)
    .subscribe({
        next: (res) => {
          console.log(res);
          this.submitted = true;
        },
      error: (err) => console.error(err)
      });
  }

  newBlogPost(): void {
    this.submitted = false;
    this.blogPost = {
        title: '',
        body: '',
        published: false
    };
  }
}
