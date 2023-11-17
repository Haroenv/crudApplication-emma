import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { FormsModule} from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { AddBlogPostComponent } from './components/add-blog-post/add-blog-post.component';
import { BlogPostDetailsComponent } from './components/blog-post-details/blog-post-details.component';
import { BlogPostsListComponent } from './components/blog-posts-list/blog-posts-list.component';

@NgModule({
  declarations: [
    AppComponent,
    AddBlogPostComponent,
    BlogPostDetailsComponent,
    BlogPostsListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
