import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddBlogPostComponent } from './add-blog-post.component';

describe('AddBlogPostComponent', () => {
  let component: AddBlogPostComponent;
  let fixture: ComponentFixture<AddBlogPostComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AddBlogPostComponent]
    });
    fixture = TestBed.createComponent(AddBlogPostComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
