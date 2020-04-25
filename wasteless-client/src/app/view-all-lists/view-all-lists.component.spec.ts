import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAllListsComponent } from './view-all-lists.component';

describe('ViewAllListsComponent', () => {
  let component: ViewAllListsComponent;
  let fixture: ComponentFixture<ViewAllListsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewAllListsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAllListsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
