import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BlogPostDetailsComponent } from './blog-post-details.component';

describe('BlogPostDetailsComponent', () => {
  let component: BlogPostDetailsComponent;
  let fixture: ComponentFixture<BlogPostDetailsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BlogPostDetailsComponent]
    });
    fixture = TestBed.createComponent(BlogPostDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
