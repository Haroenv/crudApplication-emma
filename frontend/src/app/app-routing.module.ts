import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BlogPostsListComponent } from './components/blog-posts-list/blog-posts-list.component';
import { BlogPostDetailsComponent } from "./components/blog-post-details/blog-post-details.component";
import { AddBlogPostComponent } from "./components/add-blog-post/add-blog-post.component";

const routes: Routes = [
  { path: '', redirectTo: 'blog-posts', pathMatch: 'full' },
  { path: 'blog-posts', component: BlogPostsListComponent },
  { path: 'blog-posts/:id', component: BlogPostDetailsComponent },
  { path: 'add', component: AddBlogPostComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
