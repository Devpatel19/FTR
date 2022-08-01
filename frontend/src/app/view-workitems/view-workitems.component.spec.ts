import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewWorkitemsComponent } from './view-workitems.component';

describe('ViewWorkitemsComponent', () => {
  let component: ViewWorkitemsComponent;
  let fixture: ComponentFixture<ViewWorkitemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewWorkitemsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewWorkitemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
