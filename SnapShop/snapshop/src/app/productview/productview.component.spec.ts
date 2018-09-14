import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductviewComponent } from './productview.component';

describe('ProductviewComponent', () => {
  let component: ProductviewComponent;
  let fixture: ComponentFixture<ProductviewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProductviewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
