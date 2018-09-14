import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MiddlepaageComponent } from './middlepaage.component';

describe('MiddlepaageComponent', () => {
  let component: MiddlepaageComponent;
  let fixture: ComponentFixture<MiddlepaageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MiddlepaageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MiddlepaageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
