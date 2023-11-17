import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { BlogPost } from "../models/blog-post";

const baseUrl = 'http://localhost:8080/api/blog-posts';

@Injectable({
  providedIn: 'root'
})
export class BlogPostService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<BlogPost[]> {
    return this.http.get<BlogPost[]>(baseUrl);
  }

  get(id: any): Observable<BlogPost> {
    return this.http.get(`$(baseUrl)/${id}`);
  }

  create(data: any):Observable<any> {
    return this.http.post(baseUrl, data);
  }

  update(id: any, data: any): Observable<any> {
    return this.http.put(`${baseUrl}/${id}`, data);
  }

  delete(id: any): Observable<any> {
    return this.http.delete(`${baseUrl}/${id}`);
  }

  deleteAll(): Observable<any> {
    return this.http.delete(baseUrl);
  }

  findByTitle(title: any): Observable<BlogPost[]> {
    return this.http.get<BlogPost[]>(`${baseUrl}?title=${title}`);
  }
}
