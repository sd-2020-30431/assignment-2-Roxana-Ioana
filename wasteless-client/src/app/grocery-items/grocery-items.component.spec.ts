import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GroceryItemsComponent } from './grocery-items.component';

describe('GroceryItemsComponent', () => {
  let component: GroceryItemsComponent;
  let fixture: ComponentFixture<GroceryItemsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GroceryItemsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GroceryItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
